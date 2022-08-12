<template>
  <el-menu
    default-active="个人信息"
    class="el-menu-vertical-demo"
    background-color="#065d64"
    text-color="#fff"
    active-text-color="#ffd04b"
  >
    <!-- <router-link to="/index"> -->
      <el-menu-item index="0" class="child">
        <template slot="title">
          <i class="el-icon-menu"></i>
          <span slot="title"><a href="http://localhost:8082/">首页</a></span>
        </template>
      </el-menu-item>
    <!-- </router-link> -->

    <el-submenu
      :index="menu.name"
      v-for="menu in menuListHaveSub"
      :key="menu.name"
    >
      <template slot="title">
        <i :class="menu.icon"></i>
        <span slot="title">{{ menu.title }}</span>
      </template>
      <!-- <el-submenu index="1-1"> -->
      <router-link
        :to="item.path"
        v-for="item in menu.children"
        :key="item.name"
      >
      <!-- 带有二级导航的菜单项  menuListHaveSub-->
        <el-menu-item :index="item.name" class="child">
          <template slot="title">
            <i :class="item.icon"></i>
            <span slot="title">{{ item.title }}</span>
          </template>
        </el-menu-item>
      </router-link>
    </el-submenu>
    <!-- 只有单个导航的菜单项 menuListNoSub-->
    <router-link :to="menu.path" v-for="menu in menuListNoSub" :key="menu.name">
      <el-menu-item :index="menu.name">
        <template slot="title">
          <i :class="menu.icon"></i>
          <span slot="title">{{ menu.title }}</span>
          <el-badge style="margin-left:40px;" v-if="menu.title === '申请管理'" :value="appNew" class="item">
          </el-badge>
        </template>
      </el-menu-item>
    </router-link>
  </el-menu>
</template>

<script>
export default {
  name: "AsideMenu",
  mounted() {
    this.getAppliers();
  },
  data() {
    return {
      applers:1,
      appNew:'new',
      menuListHaveSub: [
            
          ],
        menuListNoSub:[
            {
              title: "个人信息",
              name: "个人信息",
              path: "/teacher/info",
              component:'/sys/TeacherSelf',
              icon: "el-icon-s-custom",
              children:[]
            },
            {
              title: "课程管理",
              name: "课程管理",
              path: "/teacher/classes",
              component:'/sys/TeacherClass',
              icon: "el-icon-s-custom",
              children:[]
            },
            {
              title: "学生管理",
              name: "学生管理",
              path: "/teacher/students",
              component:'/sys/TeacherStudent',
              icon: "el-icon-s-custom",
              children:[]
            },
            {
              title: "申请管理",
              name: "申请管理",
              path: "/teacher/apply",
              component:'/sys/Apply',
              icon: "el-icon-s-custom",
              children:[]
            },
        ],
    }
  },
  methods: {
   getAppliers() {
    //  this.$axios.get('http://localhost:8081/appliers').then(res=>{
    //    this.applers = res.data;
    //  })
    console.log(this.applers);
    this.applers = this.$store.state.appliers
    console.log(this.applers);
    // this.appliers = 0
    // let applierList = this.$store.state.applierList
    // console.log('申请');
    // console.log(applierList);
    // for(let i = 0;i<applierList.length;i++){
    //   console.log(applierList[i].status);
    //   if(applierList[i].status == 0)
    //     this.appliers ++
    // }
   }
  }
};
</script>

<style scoped>
a {
  text-decoration: none;
  color:white;
  color: rgb(6, 94, 100);
}
.el-menu-vertical-demo {
  height: 100%;
}
</style>