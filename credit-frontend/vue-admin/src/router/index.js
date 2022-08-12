import Vue from 'vue'
import VueRouter from 'vue-router'
import axios from 'axios'
import store from '@/store'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import("../views/Home"),

    children: [
      {
        path: '/index',
        name: 'Index',
        component: () => import("../views/Index")
      },
      {
        path: '/users',
        name: 'User',
        component: () => import("../views/sys/User")
      },
      {
        path: '/students',
        name: 'Student',
        component: () => import("../views/opacity/Student")
      },
      {
        path: '/teachers',
        name: 'Teacher',
        component: () => import("../views/opacity/Teacher")
      },
      {
        path: '/admins',
        name: 'Admin',
        component: () => import("../views/opacity/Admin")
      },
      {
        path: '/userContent',
        name: 'UserContent',
        component: () => import("../views/sys/UserContent")
      },
      // {
      //   path: '/classes',
      //   name:'Class',
      //   component: ()=> import("../views/sys/Class")
      // }, 
      // {
      //   path: '/infos',
      //   name:'Info',
      //   component: ()=> import("../views/sys/Info")
      // }, 
      // {
      //   path: '/roles',
      //   name:'Role',
      //   component: ()=> import("../views/sys/Role")
      // }, 
    ]
  },
  // {
  //   path: '/kep',
  //   name:'Kep',
  //   component: ()=> import("../views/Kep")
  // }, 
  {
    path: '/login',
    name: 'Login',
    component: () => import("../views/Login")
  },
  {
    path: '/teacher',
    name: 'TeacherAdmin',
    component: () => import("../views/TeacherAdmin"),
    children: [
      {
        path: '/teacher/info',
        name: 'TeacherSelf',
        component: () => import("../views/sys/TeacherSelf")
      },
      {
        path: '/teacher/classes',
        name: 'TeacherClass',
        component: () => import("../views/sys/TeacherClass")
      },
      {
        path: '/teacher/students',
        name: 'TeacherStudent',
        component: () => import("../views/sys/TeacherStudent")
      },
      {
        path: '/teacher/apply',
        name: 'Apply',
        component: () => import("../views/sys/Apply")
      },
    ]
  },
]

const router = new VueRouter({
  mode: 'history',             /*这两行用来消去URL中的 # */
  base: process.env.BASE_URL,
  routes
})

//路由转发前beforeEach,路由转发后afterEach
//路由转发前，注册路由路径
router.beforeEach((to, from, next) => {
  if (to.path.startsWith('/teacher')) {
    document.title = '教师系统'
  } else {
    document.title = '管理员系统'
  }
  //路由转发前判断是否有路由信息，从后端获取
  axios.get('/users/menus', {
    headers: {
      Authorization: localStorage.getItem('token')
    }
  }).then(res => {
    console.log(res.data);
    //将后端获取的导航信息，进行vuex保存
    store.commit('SET_MENU_LIST_SUB', res.data.data.navSub)
    store.commit('SET_MENU_LIST_NO_SUB', res.data.data.navNoSub)
    //将后端获取的权限信息，进行vuex保存
    store.commit('SET_PERM_LIST', res.data.data.perm)
    //生成路由
    res.data.data.navSub.forEach(menu => {
      menu.children.forEach(item => {
        let route = {
          path: item.path,
          name: item.name,
          component: () => import("../views" + item.component)
        }
        // console.log(route);
        routes[0].children.push(route)
        // console.log(routes);
      })
    })
    res.data.data.navNoSub.forEach(menu => {
      let route = {
        path: menu.path,
        name: menu.name,
        component: () => import("../views" + menu.component)
      }
      routes[0].children.push(route)
    })

    //添加到路由中去，少了这一步不行
    router.addRoutes(routes)
  })
  next()
})

export default router
