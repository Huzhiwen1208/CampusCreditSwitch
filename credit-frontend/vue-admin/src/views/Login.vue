<template>
  <div class="login">
        <!-- <el-col :xl="6" :lg="7">
            
            <el-image :src="require('@/assets/Login.png')"></el-image>
            <p>加群访问更多资源</p>
        </el-col>
        <el-col :span="1">
            <el-divider direction="vertical"></el-divider>
        </el-col> -->
          <div class="head"><h2 style="margin-bottom:100px;margin-left:30px;">欢迎访问学分认证管理系统</h2></div>
            <div class="form">
              <el-form :model="loginForm" :rules="rules" ref="loginForm" label-width="100px" class="demo-loginForm">
                <el-form-item label="用户名" prop="username" style="width:380px;">
                    <el-input v-model="loginForm.username"></el-input>
                </el-form-item>
                 <el-form-item label="" prop="password" style="width:380px;">
                     <label slot="label">密&nbsp;&nbsp;&nbsp; 码</label>
                    <el-input type="password" v-model="loginForm.password"></el-input>
                </el-form-item>
                 <el-form-item label="验证码" prop="code" style="width:380px;">
                    <el-input v-model="loginForm.code" style="width:162px;float:left;"></el-input>
                    <el-image style="cursor: pointer;" @click = "getCodeImgPath" :src="codeImgPath" class = "codeImg"></el-image>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('loginForm')" style="width:130px;">登录</el-button>
                    <el-button type="primary" @click="resetForm('loginForm')" style="width:130px;">注册</el-button>
                </el-form-item>
            </el-form>
            </div>
  </div>
</template>

<script>
export default {
    name:'Login', 
    mounted() {
        this.getCodeImgPath();
    },
    data() {
      return {
        loginForm: {
          username:'', 
          password: '',
          code:'',
          token:''       //key Redis中的类似session
        },
        codeImgPath: null,  //验证码图片路径
        rules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
          ],
          code: [
            { required: true, message: '请输入正确的验证码', trigger: 'blur' },
            { min: 5, max: 5, message: '长度为 5 个字符', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
        getCodeImgPath(){
            this.$axios({
                method:'get',
                url: '/codepath',
            }).then(res=>{
                console.log(res);
                this.loginForm.token = res.data.data.token;
                this.codeImgPath = res.data.data.codeImgPath;
            })
        },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
              //登录验证通过后，检测数据库数据
                this.$axios({
                    method: 'post',
                    url: '/login',
                    data: this.loginForm
                }).then((response) => {
                    //存储JSON WEB TOKEN到当地并更新vuex
                    const jwt = response.headers['authorization'];
                    this.$store.commit('SET_TOKEN',jwt);
                    //路由跳转
                    if(this.loginForm.username === 'admin')
                      this.$router.push('/users');
                    else
                      this.$router.push('/teacher/info')
                })
            // alert('submit!');
          } else {
           //检验不通过
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style>
    .login{
        background-color: #fafafa;
        height: 690px;
    }
    .el-image {
        height: 180px;
        width: 180px;
    }
    .el-divider {
        height:200px;
    }
    .codeImg {
        float: left;
        width: 110px;
        height: 44px;
        border-radius: 4px;
        margin-left: 8px;
    }
    .form {
      margin-left: 550px;;
    }
    .head {
      text-align: center;
      margin-top: 50px;;
    }
</style>