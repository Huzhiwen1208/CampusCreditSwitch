<template>
  <div>
    <el-col :span="7" @click.native="toStudent">
      <el-card :body-style="{ padding: '0px' }" header="学生管理">
        <img
          src="@/assets/xuexi.jpg"
          class="image"
        />
        <div style="padding: 14px">
          <span>点击进入学生管理</span>
          
        </div>
      </el-card>
    </el-col>
    <el-col :span="7" @click.native="toTeacher">
      <el-card :body-style="{ padding: '0px' }" header="教师管理">
        <img
          src="@/assets/teacher.jpg"
          class="image"
        />
        <div style="padding: 14px">
          <span>点击进入教师管理</span>
          
        </div>
      </el-card>
    </el-col>
    <el-col :span="7" @click.native="toAdmin">
      <el-card :body-style="{ padding: '0px' }" header="管理员信息">
        <img
          src="@/assets/admin.jpg"
          class="image"
        />
        <div style="padding: 14px">
          <span>点击查看系统管理员信息</span>
        </div>
      </el-card>
    </el-col>
  </div>
</template>

<script>
export default {
  name: "User",
  data() {
    return {
      
    };
  },
  methods: {
    toStudent() {
      this.$router.push("/students")
    },
    toTeacher() {
      this.$router.push("/teachers")
    },
    toAdmin() {
      this.$router.push("/admins")
    }
  }
};
</script>

<style>
.card {
  background-color: #ccc;
}
.image{
  height: 230px;
  /* width: 300px; */
}
.el-col {
  margin: 20px;
  cursor: pointer;
}
</style>