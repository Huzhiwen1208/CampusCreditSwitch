<template>
  <el-menu
    default-active="User"
    class="el-menu-vertical-demo"
    background-color="#545c64"
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
        </template>
      </el-menu-item>
    </router-link>
  </el-menu>
</template>

<script>
export default {
  name: "AsideMenu",
  data() {
    return {
      // menuListHaveSub:[],
      // menuListNoSub:[],
    }
  },
  computed: {
    menuListHaveSub(){
      // console.log('子导航：',this.$store.state.menus.menuListHaveSub);
      //state.menus.**   state下的模块访问路径
      return this.$store.state.menus.menuListHaveSub
    },
    menuListNoSub(){
      return this.$store.state.menus.menuListHaveNoSub
    }
  },
  methods: {
   
  }
};
</script>

<style scoped>
a {
  text-decoration: none;
  color:white;
}
.el-menu-vertical-demo {
  height: 100%;
}
</style>