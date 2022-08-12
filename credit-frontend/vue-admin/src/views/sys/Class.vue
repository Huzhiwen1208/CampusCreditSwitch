<template>
  <div class="grade">
      <!-- 搜索删除新增行为 -->
    <el-form :inline="true"class="demo-form-inline">
      <el-form-item>
          <el-input v-model="courseName" placeholder="课程名"></el-input>
      </el-form-item>
      <el-button type="primary" @click="searchCourse">查询</el-button>
      <el-button type="primary" @click="addCourse">新增</el-button>
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
      <el-table-column prop="id" label="课程号"> </el-table-column>
      <el-table-column prop="chineseName" label="中文名"> </el-table-column>
      <el-table-column prop="englishName" label="英文名"> </el-table-column>
      <el-table-column prop="credits" label="所含学分"> </el-table-column>
      <el-table-column label="查看详细信息"> 
          <template slot-scope="scope">
            <el-button
            size="mini"
            type="primary"
            @click="showDetail(scope.$index, scope.row)">查看</el-button>
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

     <el-dialog
    title="编辑"
    :visible.sync="dialogVisible4Edit"
    width="30%">
        <el-form ref="form" :model="courseInfoEdit" label-width="90px">
        <el-form-item label="课程号">
            <el-input v-model="courseInfoEdit.id"></el-input>
        </el-form-item>
        <el-form-item label="课程中文名">
            <el-input v-model="courseInfoEdit.chineseName"></el-input>
        </el-form-item>
        <el-form-item label="课程英文名">
            <el-input v-model="courseInfoEdit.englishName"></el-input>
        </el-form-item>
        <el-form-item label="所含学分">
            <el-input v-model="courseInfoEdit.credits"></el-input>
        </el-form-item>
        <el-form-item label="详细信息">
            <el-input v-model="courseInfoEdit.detail" type="textarea" :rows="6"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="concreteEdit">确认修改</el-button>
            <el-button @click="cancelEdit">取消</el-button>
        </el-form-item>
        </el-form>
    </el-dialog>

    <!-- 新增课程信息 -->
    <el-dialog
    title="新增"
    :visible.sync="dialogVisible4Add"
    width="30%">
        <el-form ref="form" :model="courseInfoAdd" label-width="80px">
        <el-form-item label="课程号">
            <el-input v-model="courseInfoAdd.id"></el-input>
        </el-form-item>
        <el-form-item label="课程中文名">
            <el-input v-model="courseInfoAdd.chineseName"></el-input>
        </el-form-item>
        <el-form-item label="课程英文名">
            <el-input v-model="courseInfoAdd.englishName"></el-input>
        </el-form-item>
        <el-form-item label="所含学分">
            <el-input v-model="courseInfoAdd.credits"></el-input>
        </el-form-item>
        <el-form-item label="详细信息">
            <el-input v-model="courseInfoAdd.detail"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="concreteAdd">确认添加</el-button>
            <el-button @click="cancelAdd">取消</el-button>
        </el-form-item>
        </el-form>
    </el-dialog>

  </div>
</template>

<script>
export default {
  name: "Class",
  mounted() {
    this.getAll();
  },
  watch: {
    courseName: {
      handler(newVal, oldVal) {
        this.searchCourse();
      },
    },
  },
  data() {
    return {
      dialogVisible4Edit: false,
      dialogVisible4Add: false,
      dialogVisible4Info: false,
      courseInfoEdit: {
        id: "",
        chineseName: "",
        englishName: "",
        detail: "",
        credits: "",
      },
      courseInfoAdd: {
        id: "",
        chineseName: "",
        englishName: "",
        detail: "",
        credits: "",
      },
      courseName: "",
      tableData: [],
      multipleSelection: [],
    };
  },

  methods: {
    getAll() {
      this.$axios.get("http://localhost:8081/courses").then((res) => {
        this.tableData = res.data.data;
      });
    },

    tableRowClassName({ row, rowIndex }) {
      if (rowIndex === 1) {
        return "warning-row";
      } else if (rowIndex === 3) {
        return "success-row";
      }
      return "";
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

    searchCourse() {
      this.$axios
        .get("http://localhost:8081/courses/" + this.courseName)
        .then((res) => {
          this.tableData = res.data.data;
        });
    },

    rowStyle() {
      return "text-align:center";
    },
    headerRowStyle() {
      return "text-align: center";
    },

    handleEdit(idx, row) {
      //编辑此行数据
      this.courseInfoEdit = this.tableData[idx];
      this.dialogVisible4Edit = true;
    },
    //确认编辑结果
    concreteEdit() {
      this.$axios
        .put("http://localhost:8081/courses", this.courseInfoEdit)
        .then((res) => {
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
      this.$axios
        .post("http://localhost:8081/courses", this.courseInfoAdd)
        .then((res) => {
          if (res.data.code === 200) {
            this.dialogVisible4Add = false;
            this.$message.success("添加成功");
            this.getAll();
          } else {
            this.$message.error("添加失败！");
          }
        });
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
          this.$axios
            .delete("http://localhost:8081/courses", { data: row })
            .then((res) => {
              console.log(res);
              if (res.data.code === 200) {
                this.$message.success(`删除成功`);
                this.tableData = res.data.data;
              } else {
                this.$message.error("操作失败");
              }
            });
        })
        .catch(() => {
          //取消
          this.$message.info("删除操作取消");
        });
    },

    addCourse() {
      this.courseInfoAdd = {
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
        for (let course of this.multipleSelection) {
          //删除每个选中的教师
          this.$axios
            .delete("http://localhost:8081/courses", { data: course })
            .then((res) => {});
        }
        this.$message.success("批量删除成功！");
        this.getAll();
      } else {
        this.$message.error("未选中任何数据！");
      }
    },
    showCourses(idx, row) {
      console.log(idx);
      console.log(row);
      //查看已修读课程详情
      this.dialogVisible4Info = true;
      this.$axios.get("http://localhost:8081/courses/" + row.id).then((res) => {
        this.tableData4Info = res.data.data;
      });
    },
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