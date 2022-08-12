<template>
  <div class="index">
    <el-container>
      <!-- 侧边导航菜单 -->
      <el-aside width="200px">
        <el-col :span="24">
          <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            active-text-color="#ffd04b"
            style="font-weight: bold; background:url(http://zsjyc.ncst.edu.cn/tpl/1589185379807/images/bg.png) repeat-x;"
          >
            <router-link to="/student/info">
              <el-menu-item index="1">
                <template slot="title">
                  <i class="el-icon-s-custom"></i>
                  <span>个人信息</span>
                </template>
              </el-menu-item>
            </router-link>
            <!-- <el-submenu index="2"> -->
              <!-- <template slot="title">
                <i class="el-icon-circle-plus"></i>
                <span>课程学习</span>
              </template> -->
              <router-link to="/student/course">
                <el-menu-item index="2">
                  <i class="el-icon-info"></i>
                  <span slot="title">我的课程</span>
                </el-menu-item>
              </router-link>
              <router-link to="/student/container">
              <el-menu-item index="3">
                <i class="el-icon-s-unfold"></i>
                <span slot="title">课程库</span>
              </el-menu-item>
              </router-link>
            <!-- </el-submenu> -->
            <router-link to="/student/credit">
              <el-menu-item index="4">
                <i class="el-icon-s-opportunity"></i>
                <span slot="title">我的学分</span>
              </el-menu-item>
            </router-link>
            <router-link to="/student/apply">
              <el-menu-item index="5">
                <i class="el-icon-success"></i>
                <span slot="title">提交申请</span>
              </el-menu-item>
            </router-link>
          </el-menu>
        </el-col>
      </el-aside>
      <el-container>
        <!-- 头部欢迎内容 -->
        <el-header>
          <!-- <strong>学分认证后台管理系统</strong> -->
          <img src="../../assets/logo1.png" style="width:250px;" /> 
          <!-- 管理員信息（头像，昵称等） -->
          <div class="admin">
            <!-- <el-avatar src="/猕猴桃.png"></el-avatar> -->
            <el-dropdown>
              <span class="el-dropdown-link" >
                王丽 20191514<i class="el-icon-arrow-down el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item @click.native="toIndex()"
                  >返回首页</el-dropdown-item
                >
                <el-dropdown-item @click.native="logout()"
                  >注销</el-dropdown-item
                >
              </el-dropdown-menu>
            </el-dropdown>
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
export default {
  name: "Student",
  methods: {
    toIndex() {
      this.$router.push('/')
    }
  }
};
</script>

<style scoped>
.index{
  background:url('@/assets/嫩绿.jpg') no-repeat repeat-x;
  z-index:1000;
}
a,
a.active {
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
  color: #494448;
  font-size: 18px;;
}

.el-header {
  color: #fff;
  text-align: center;
  line-height: 60px;
  border-bottom: 1px solid rgb(216, 216, 216);
}

.el-aside {
  line-height: 200px;
  height:100vh;
}

/* .el-main { */
  /* background-color: #e9eef3; */
  /* color: #333; */
/* } */
.el-aside {
  height: 100vh;
}
.el-menu {
  height: 100vh;
}
</style>