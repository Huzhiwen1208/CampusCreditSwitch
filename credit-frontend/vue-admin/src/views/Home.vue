<template>
  <div class="index">
    <el-container>
      <!-- 侧边导航菜单 -->
      <el-aside width="200px">
        <AsideMenu></AsideMenu>
      </el-aside>
      <el-container>
        <!-- 头部欢迎内容 -->
        <el-header>
          <strong>学分认证后台管理系统</strong>
          <!-- 管理員信息（头像，昵称等） -->
          <div class="admin">
            <el-avatar
              :src="userInfo.avatar"
            ></el-avatar>
            <el-dropdown>
              <span class="el-dropdown-link">
                {{userInfo.username}}<i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item>
                  <router-link to="/userContent">个人中心</router-link>
                </el-dropdown-item>
                <el-dropdown-item>
                  <router-link to="/index">主页</router-link>
                </el-dropdown-item>
                <el-dropdown-item @click.native="logout()">注销</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
            <el-link href="" :underline="false">链接1</el-link>
            <el-link href="" :underline="false">链接2</el-link>
          </div>
        </el-header>
        <!-- 主内容 -->
        <el-main>
          <!-- 动态标签 -->
          <!-- <HeadMenu/>  -->
          <router-view />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import AsideMenu from "./inc/AsideMenu.vue";
import HeadMenu from "./inc/HeadMenu.vue";

export default {
  name: "Index",
  components: {
    AsideMenu,HeadMenu
  },
  mounted() {
    this.$axios({
      method: "get",
      url: "/user/Admin"
    }).then(res=>{
      console.log(res.data.data);
      this.userInfo = res.data.data;
      console.log(this.userInfo);
    })
  },
  data() {
    return {
      userInfo: {
        id:'',
        username:'',
        password:'',
        avatar:''
      },
    }
  },
  methods: {
    logout() {
      console.log('退出');

      this.$axios.post('/logout',this.userInfo).then(res=>{
        localStorage.clear()
        sessionStorage.clear()
        //处理state内容
        this.$store.commit('CLEAR_STATE')
        //返回登录界面
        this.$router.push('/login')
      })
    }
  },
};
</script>

<style scoped>
a,a.active {
  text-decoration: none;
  /* color: #000; */
	}
.index {
  height: 100vh;
}

.el-container {
  /* margin:0;
    padding:0; */
  height: 100vh;
}
.admin {
  width: 220px;
  float: right;
  display: flex;
  align-items: center;
  justify-content: space-around;
}
.el-dropdown-link {
  cursor: pointer;
  color: #f357d1;
}

.el-header {
  background-color: #545c64;
  color: #fff;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  line-height: 200px;
}

.el-main {
  background-color: #e9eef3;
  /* color: #333; */
}
</style>