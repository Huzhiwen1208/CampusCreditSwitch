<template>
  <div class="data-admin">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="姓名">
        <el-input v-model="form.name" class = "ipt1" :disabled="ok1"></el-input>
        <el-button type="primary" style="margin-left:20px;" @click="concrete1(ok1,ok1_content)">{{ok1_content}}</el-button>
      </el-form-item>
      <el-form-item label="学号">
        <el-input v-model="form.id" class = "ipt1" :disabled="true"></el-input>
        <el-button type="primary" style="margin-left:20px;">修改</el-button>
      </el-form-item>
      <el-form-item label="所在学院">
        <el-input v-model="form.academy" class = "ipt1" :disabled="true"></el-input>
        <el-button type="primary" style="margin-left:20px;">修改</el-button>
      </el-form-item>
      <el-form-item label="专业班级">
        <el-input v-model="form.major" class = "ipt1" :disabled="true"></el-input>
        <el-button type="primary" style="margin-left:20px;">修改</el-button>
      </el-form-item>
      <el-form-item label="身份证号">
        <el-input v-model="form.card" class = "ipt1" :disabled="true"></el-input>
        <el-button type="primary" style="margin-left:20px;">修改</el-button>
      </el-form-item>
      <el-form-item label="性别">
        <el-input v-model="form.gender" class = "ipt1" :disabled="ok2"></el-input>
        <el-button type="primary" style="margin-left:20px;">修改</el-button>
      </el-form-item>
      <el-form-item label="年龄">
        <el-input v-model="form.age" class = "ipt1" :disabled="true"></el-input>
        <el-button type="primary" style="margin-left:20px;">修改</el-button>
      </el-form-item>
      <el-form-item label="电子邮件">
        <el-input v-model="form.mail" class = "ipt1" :disabled="true"></el-input>
        <el-button type="primary" style="margin-left:20px;">修改</el-button>
      </el-form-item>
      <el-form-item label="QQ号">
        <el-input v-model="form.qq" class = "ipt1" :disabled="true"></el-input>
        <el-button type="primary" style="margin-left:20px;">修改</el-button>
      </el-form-item>
      <el-form-item label="手机">
        <el-input v-model="form.tel" class = "ipt1" :disabled="true"></el-input>
        <el-button type="primary" style="margin-left:20px;">修改</el-button>
      </el-form-item>
      <el-form-item label="邮编">
        <el-input v-model="form.postcode" class = "ipt1" :disabled="true"></el-input>
        <el-button type="primary" style="margin-left:20px;">修改</el-button>
      </el-form-item>
      <el-form-item label="密码">
        <el-input type="password" v-model="form.password" class = "ipt1" :disabled="true"></el-input>
        <el-button type="primary" style="margin-left:20px;">修改</el-button>
      </el-form-item>
      
    </el-form>
  </div>
</template>

<script>
export default {
  name: "StudentInfo",
  data() {
    return {
      form: {
        name: "王丽",
        gender: "女",
        age: "18",
        mail: "wlxj@163.com",
        qq: "123456789",
        tel: '15617158312',
        postcode: "476700",
        password: "20001208Wl#",
        academy:'信息工程学院',
        major:'计算机科学与技术',
        id:'20191514',
        card:'411423200012085533'
      },
      ok1:true,
      ok1_content:'修改',
      ok2:true,
    };
  },
  methods: {
      concrete1(ok1,ok1_content) {
          console.log(ok1,ok1_content);
          this.ok1 = ok1 === true?false:true;
          this.ok1_content = ok1_content === '修改'?'确定':'修改';
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