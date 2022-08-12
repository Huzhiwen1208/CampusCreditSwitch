<template>
  <div>
       <!-- 搜索删除新增行为 -->
    <el-form :inline="true"class="demo-form-inline">
      <el-form-item>
          <el-input v-model="noticeName" placeholder="公告主题"></el-input>
      </el-form-item>
      <el-button type="primary" @click="searchNotice">查询</el-button>
      <el-button type="primary" @click="addNotice">新增</el-button>
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
      <el-table-column prop="date" label="公告日期"> </el-table-column>
      <el-table-column prop="head" label="公告标题"> </el-table-column>
      <el-table-column label="查看公告内容"> 
          <template slot-scope="scope">
            <el-button
            size="mini"
            type="primary"
            @click="showNotices(scope.$index, scope.row)">查看</el-button>
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

    <!-- 编辑此行学生信息 -->
    <el-dialog
    title="编辑"
    :visible.sync="dialogVisible4Edit"
    width="30%">
        <el-form ref="form" :model="noticeInfoEdit" label-width="80px">
        <el-form-item label="学生姓名">
            <el-input v-model="noticeInfoEdit.name"></el-input>
        </el-form-item>
        <el-form-item label="学生学号">
            <el-input v-model="noticeInfoEdit.id"></el-input>
        </el-form-item>
        <el-form-item label="学生校届选择">
            <el-select v-model="noticeInfoEdit.grade" placeholder="请选择校届">
            <el-option label="大一" value="大一"></el-option>
            <el-option label="大二" value="大二"></el-option>
            <el-option label="大三" value="大三"></el-option>
            <el-option label="大四" value="大四"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="联系邮箱">
            <el-input v-model="noticeInfoEdit.mail"></el-input>
        </el-form-item>
        <el-form-item label="所在学院">
            <el-input v-model="noticeInfoEdit.academy"></el-input>
        </el-form-item>
        <el-form-item label="专业班级">
            <el-input v-model="noticeInfoEdit.major"></el-input>
        </el-form-item>
        <el-form-item label="身份证号">
            <el-input v-model="noticeInfoEdit.card"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input v-model="noticeInfoEdit.password"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="concreteEdit">确认修改</el-button>
            <el-button @click="cancelEdit">取消</el-button>
        </el-form-item>
        </el-form>
    </el-dialog>

    <!-- 新增学生信息 -->
    <el-dialog
    title="新增"
    :visible.sync="dialogVisible4Add"
    width="30%">
        <el-form ref="form" :model="noticeInfoAdd" label-width="80px">
        <el-form-item label="学生姓名">
            <el-input v-model="noticeInfoAdd.name"></el-input>
        </el-form-item>
        <el-form-item label="学生学号">
            <el-input v-model="noticeInfoAdd.id"></el-input>
        </el-form-item>
        <el-form-item label="学生校届选择">
            <el-select v-model="noticeInfoAdd.grade" placeholder="请选择校届">
            <el-option label="大一" value="大一"></el-option>
            <el-option label="大二" value="大二"></el-option>
            <el-option label="大三" value="大三"></el-option>
            <el-option label="大四" value="大四"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="联系邮箱">
            <el-input v-model="noticeInfoAdd.mail"></el-input>
        </el-form-item>
        <el-form-item label="所在学院">
            <el-input v-model="noticeInfoAdd.academy"></el-input>
        </el-form-item>
        <el-form-item label="专业班级">
            <el-input v-model="noticeInfoAdd.major"></el-input>
        </el-form-item>
        <el-form-item label="身份证号">
            <el-input v-model="noticeInfoAdd.card"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input v-model="noticeInfoAdd.password"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="concreteAdd">确认添加</el-button>
            <el-button @click="cancelAdd">取消</el-button>
        </el-form-item>
        </el-form>
    </el-dialog>

<el-dialog
    title="编辑"
    :visible.sync="dialogVisible4Show"
    width="30%">
    {{notice}}
<div style="margin-left:177px;margin-top:60px;">
  <el-button type="primary" @click="dialogVisible4Show = false">确定</el-button>
</div>
</el-dialog>
  </div>
</template>


<script>
export default {
  name: "Info",
  mounted() {
    this.getAll();
  },
  watch: {
    noticeName: {
      handler(newVal, oldVal) {
        this.searchNotice();
      },
    },
  },
  data() {
    return {
      dialogVisible4Edit: false,
      dialogVisible4Add: false,
      dialogVisible4Info: false,
      dialogVisible4Show:false,
      notice:'',
      noticeInfoEdit: {
        id: null,
        name: "",
        grade: "",
        mail: "",
        academy: "",
        major: "",
        card: "",
        password: "",
      },
      noticeInfoAdd: {
        id: null,
        name: "",
        grade: "",
        mail: "",
        academy: "",
        major: "",
        card: "",
        password: "",
      },
      noticeName: "",
      tableData: [],
      multipleSelection: [],
      tableData4Info: []
    };
  },

  methods: {
    getAll() {
      this.$axios.get("http://localhost:8081/notices").then((res) => {
        console.log('访问公告');
        this.tableData = res.data.data;
        for(let i = 0; i < this.tableData.length; i++){
          this.tableData[i].date = this.tableData[i].date.slice(0,10)
        }
        console.log(this.tableData);
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

    searchNotice() {
      // alert('用姓名查询信息')
      //待完成
      // this.$axios({
      //   method: "post",
      //   url: "/notices",
      //   data: this.noticeName,
      // }).then((res) => {
      //   console.log("res.data.data");
      //   console.log(res.data.data);
      //   this.tableData = res.data.data;
      // });
      this.$axios.get('http://localhost:8081/notices/'+this.noticeName).then(res=>{

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
      this.noticeInfoEdit = this.tableData[idx];
      this.dialogVisible4Edit = true;
    },
    //确认编辑结果
    concreteEdit() {
      this.$axios.put("http://localhost:8081/notices", this.noticeInfoEdit).then((res) => {
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
      this.$axios.post("http://localhost:8081/notices", this.noticeInfoAdd).then(res=>{
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
          this.$axios.delete("http://localhost:8081/notices",{data: row}).then(res=>{
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

    addNotice() {
      this.noticeInfoAdd = {
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
        for (let notice of this.multipleSelection) {
          //删除每个选中的学生
          this.$axios.delete("http://localhost:8081/notices",{data: notice}).then(res=>{
            
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
      this.$axios.get('http://localhost:8081/courses/'+row.id).then(res=>{
        this.tableData4Info = res.data.data;
      })
    },
    showNotices(idx,row){
      this.dialogVisible4Show = true;
      this.notice = row.content
    }
  },
};
</script>
<style scoped>