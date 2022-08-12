<template>
  <div class="teacher">
    <!-- 搜索删除新增行为 -->
    <el-form :inline="true"class="demo-form-inline">
      <el-form-item>
          <el-input v-model="teacherName" placeholder="教师姓名"></el-input>
      </el-form-item>
      <el-button type="primary" @click="searchTeacher">查询</el-button>
      <el-button type="primary" @click="addTeacher">新增</el-button>
      <el-button type="danger" @click="deleteMany">批量删除</el-button>
    </el-form>
    <!-- 表格 cell-style,header-cell-style 这两行实现单元格的居中对齐 -->
    <el-table
      :cell-style="rowStyle"
      :header-cell-style="headerRowStyle"
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      border
      stripe
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column type="index" label="序号"></el-table-column>
      <el-table-column prop="name" label="姓名"> </el-table-column>
      <el-table-column prop="id" label="工号"> </el-table-column>
      <el-table-column prop="major" label="所管辖专业"> </el-table-column>
      <el-table-column prop="mail" label="邮箱"> </el-table-column>
      <el-table-column label="查看旗下学生列表"> 
          <template slot-scope="scope">
            <el-button
            size="mini"
            type="primary"
            @click="showStudents(scope.$index, scope.row)">查看</el-button>
        </template>
      </el-table-column>
      <el-table-column label="查看旗下课程列表"> 
          <template slot-scope="scope">
            <el-button
            size="mini"
            type="primary"
            @click="showCourses(scope.$index, scope.row)">查看</el-button>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="150px"> 
          <template slot-scope="scope">
            <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
    </el-table-column>
      </el-table-column>
    </el-table>

    <!-- 编辑此行教师信息 -->
    <el-dialog
    title="编辑"
    :visible.sync="dialogVisible4Edit"
    width="30%">
        <el-form ref="form" :model="teacherInfoEdit" label-width="80px">
        <el-form-item label="教师姓名">
            <el-input v-model="teacherInfoEdit.name"></el-input>
        </el-form-item>
        <el-form-item label="教师工号">
            <el-input v-model="teacherInfoEdit.id"></el-input>
        </el-form-item>
        </el-form-item>
        <el-form-item label="联系邮箱">
            <el-input v-model="teacherInfoEdit.mail"></el-input>
        </el-form-item>
        <el-form-item label="所管辖专业">
            <el-input v-model="teacherInfoEdit.major"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input v-model="teacherInfoEdit.password"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="concreteEdit">确认修改</el-button>
            <el-button @click="cancelEdit">取消</el-button>
        </el-form-item>
        </el-form>
    </el-dialog>

    <!-- 新增教师信息 -->
    <el-dialog
    title="新增"
    :visible.sync="dialogVisible4Add"
    width="30%">
        <el-form ref="form" :model="teacherInfoAdd" label-width="80px">
        <el-form-item label="教师姓名">
            <el-input v-model="teacherInfoAdd.name"></el-input>
        </el-form-item>
        <el-form-item label="教师工号">
            <el-input v-model="teacherInfoAdd.id"></el-input>
        </el-form-item>
        <el-form-item label="联系邮箱">
            <el-input v-model="teacherInfoAdd.mail"></el-input>
        </el-form-item>
        <el-form-item label="所管辖专业">
            <el-input v-model="teacherInfoAdd.major"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input v-model="teacherInfoAdd.password"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="concreteAdd">确认添加</el-button>
            <el-button @click="cancelAdd">取消</el-button>
        </el-form-item>
        </el-form>
    </el-dialog>

    <!-- 教师的修读课程表 -->
    <el-dialog
      title="正在管理的课程"
      :visible.sync="dialogVisible4Info"
      >
      <!-- 插入表格 -->

        <el-form :inline="true"class="demo-form-inline">
          <el-button type="primary" @click="addCourse">新增课程</el-button>
        </el-form>

        <el-table
          :data="tableData4Info"
          style="width: 100%"
           :row-class-name="tableRowClassName">
          <el-table-column
            prop="id"
            label="课程号">
          </el-table-column>
          <el-table-column
            prop="chineseName"
            label="中文名">
          </el-table-column>
          <el-table-column
            prop="englishName"
            label="英文名">
          </el-table-column>
          <el-table-column
            prop="credits"
            label="所含学分">
          </el-table-column>
        </el-table>

      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible4Info = false">确 定</el-button>
      </span>
    </el-dialog>


  </div>
</template>

<script>
export default {
  name: "Teacher",
  mounted() {
    this.getAll();
  },
  watch: {
    teacherName: {
      handler(newVal, oldVal) {
        this.searchTeacher();
      },
    },
  },
  data() {
    return {
      dialogVisible4Edit: false,
      dialogVisible4Add: false,
      dialogVisible4Info: false,
      teacherInfoEdit: {
        id: null,
        name: "",
        major: "",
        mail: "",
        password: "",
      },
      teacherInfoAdd: {
        id: null,
        name: "",
        major: "",
        mail: "",
        password: "",
      },
      teacherName: "",
      tableData: [],
      multipleSelection: [],
      tableData4Info: [],
      tableData4InfoFOOL:[
        {
        url: "/os.png",
        detail: "在计算机中，操作系统是其最基本也是最为重要的基础性系统软件。从计算机用户的角度来说，计算机操作系统体现为其提供的各项服务；从程序员的角度来说，其主要是指用户登录的界面或者接口；如果从设计人员的角度来说，就是指各式各样模块和单元之间的联系。事实上，全新操作系统的设计和改良的关键工作就是对体系结构的设计，经过几十年以来的发展，计算机操作系统已经由一开始的简单控制循环体发展成为较为复杂的分布式操作系统，再加上计算机用户需求的愈发多样化，计算机操作系统已经成为既复杂而又庞大的计算机软件系统之一。 ",
        credits: "2",
        id: "HBKJ10010",
        teacher:'李士勇',
        englishName:'operating system',
        chineseName: "操作系统",
      },
      {
        url: "/cn.png",
        detail: "计算机网络也称计算机通信网。关于计算机网络的最简单定义是：一些相互连接的、以共享资源为目的的、自治的计算机的集合。若按此定义，则早期的面向终端的网络都不能算是计算机网络，而只能称为联机系统（因为那时的许多终端不能算是自治的计算机）。但随着硬件价格的下降，许多终端都具有一定的智能，因而“终端”和“自治的计算机”逐渐失去了严格的界限。若用微型计算机作为终端使用，按上述定义，则早期的那种面向终端的网络也可称为计算机网络。 ",
        credits: "2",
        id: "HBKJ10001",
        chineseName: "计算机网络",
        teacher:'李士勇',
        englishName:'computer network',
      },
      {
        url: "/linux.png",
        detail: "ososos",
        credits: "2",
        id: "HBKJ10231",
        chineseName: "Linux系统",
        teacher:'李士勇',
        englishName:'Linux operating system',
      },
      {
        url: "/ds.png",
        detail: "ososos",
        credits: "2",
        id: "HBKJ10888",
        chineseName: "数据结构",
        teacher:'李士勇',
        englishName:'data structure'
      },
      {
        url: "/cp.png",
        detail: "ososos",
        credits: "2",
        id: "HBKJ10056",
        chineseName: "计算机原理",
        teacher:'李士勇',
        englishName:'computer theory'
      },

      ],
    };
  },

  methods: {
    getAll() {
      this.$axios.get("http://localhost:8081/teachers").then((res) => {
        this.tableData = res.data.data;
      });
    },

    tableRowClassName({row, rowIndex}) {
        if (rowIndex === 1) {
          return 'warning-row';
        } else if (rowIndex === 3) {
          return 'success-row';
        }
        return '';
      },
    toggleSelection(rows) {
      if (rows) {
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },

    handleSelectionChange(val) {
      this.multipleSelection = val;
    },

    searchTeacher() {
      //查询
      this.$axios.get('http://localhost:8081/teachers/'+this.teacherName).then(res=>{

        this.tableData = res.data.data;

      })
    },

    rowStyle() {
      return "text-align:center";
    },
    headerRowStyle() {
      return "text-align: center";
    },

    handleEdit(idx, row) {
      //编辑此行数据
      this.teacherInfoEdit = this.tableData[idx];
      this.dialogVisible4Edit = true;
    },
    //确认编辑结果
    concreteEdit() {
      this.$axios.put("http://localhost:8081/teachers", this.teacherInfoEdit).then((res) => {
        this.$message.success(res.data.msg);
        this.dialogVisible4Edit = false;
      });
    },
    //取消编辑结果
    cancelEdit() {
      this.getAll();
      this.dialogVisible4Edit = false;
    },

    concreteAdd() {
      //确认添加
      //添加操作
      this.$axios.post("http://localhost:8081/teachers", this.teacherInfoAdd).then(res=>{
        if(res.data.code === 200){
          this.dialogVisible4Add = false;
          this.$message.success('添加成功')
          this.getAll();
        }else{
          this.$message.error('添加失败！')
        }
      })
      
    },
    cancelAdd() {
      //取消操作
      this.dialogVisible4Add = false;
      this.$message.info("取消添加操作");
    },

    handleDelete(idx, row) {
      //删除此行数据，idx为表格序号0———，row为行对象
      this.$confirm("确定删除此人信息？", "警示", "{type: warning}")
        .then(() => {
          //确定删除
          this.$axios.delete("http://localhost:8081/teachers",{data: row}).then(res=>{
            console.log(res);
            if(res.data.code === 200) {
              this.$message.success(`删除成功`)
              this.tableData = res.data.data
            }else {
              this.$message.error('操作失败')
            }
          })
        })
        .catch(() => {
          //取消
          this.$message.info("删除操作取消");
        });
    },

    addTeacher() {
      this.teacherInfoAdd = {
        id: null,
        name: "",
        grade: "",
        mail: "",
        academy: "",
        major: "",
        card: "",
        password: "",
      };
      this.dialogVisible4Add = true;
    },

    deleteMany() {
      if (this.multipleSelection.length > 0) {
        for (let teacher of this.multipleSelection) {
          //删除每个选中的教师
          this.$axios.delete("http://localhost:8081/teachers",{data: teacher}).then(res=>{
            
          })
        }
        this.$message.success("批量删除成功！");
        this.getAll();
      } else {
        this.$message.error("未选中任何数据！");
      }
    },
    showCourses(idx,row){
      console.log(idx);
      console.log(row);
      //查看已修读课程详情
      this.dialogVisible4Info = true;
      // this.$axios.get('http://localhost:8081/courses/'+row.id).then(res=>{
      //   this.tableData4Info = res.data.data;
      // })
      this.tableData4Info = this.tableData4InfoFOOL;
    }
  },
};
</script>
<style scoped>
 .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>