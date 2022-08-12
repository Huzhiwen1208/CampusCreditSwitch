<template>
  <div class="data-admin">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="姓名">
        <el-input v-model="form.name" class = "ipt1"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-input v-model="form.gender" class = "ipt1"></el-input>
      </el-form-item>
      <el-form-item label="管辖专业">
        <el-input v-model="form.major" class = "ipt1"></el-input>
      </el-form-item>
      <el-form-item label="电子邮件">
        <el-input v-model="form.mail" class = "ipt1"></el-input>
      </el-form-item>
      <el-form-item label="手机">
        <el-input v-model="form.tel" class = "ipt1"></el-input>
      </el-form-item>
      <el-form-item label="邮编">
        <el-input v-model="form.postcode" class = "ipt1"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input type="password" v-model="form.password" class = "ipt1"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-button type="primary" @click="alertPassword" style="margin-left: 100px;">修改密码</el-button>
      </el-form-item>
      
    </el-form>
  </div>
</template>

<script>
export default {
  name: "Admin",
  data() {
    return {
      form: {
        name: "李士勇",
        gender: "男",
        mail: "lsy@163.com",
        tel: '15617158312',
        postcode: "476700",
        password: "20001208Wl#",
        major:'计算机科学与技术'
      },
    };
  },
  methods: {
    alertPassword() {
      alert('功能待补充')
    }
  },
};
</script>

<style>
.data-admin {
  display: flex;
  align-items: center;
  justify-content: space-around;
}
.ipt1 {
  width: 300px;
}
</style>