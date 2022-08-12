import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: ()=> import("../views/Home")
  }, 
  {
    path: '/login',
    name: 'Login',
    component: ()=> import("../views/Login")
  }, 
  {
    path:'/student',
    name: 'Student',
    component: ()=> import("../views/student/Student"),  
    children: [
      {
        path:'/student/info',
        name:'StudentInfo',
        component: ()=> import("../views/student/StudentInfo")
      },
      {
        path:'/student/course',
        name:'StudentCourse',
        component: ()=> import("../views/student/StudentCourse")
      },
      {
        path:'/student/credit',
        name:'StudentCredit',
        component: ()=> import("../views/student/StudentCredit")
      },
      {
        path:'/student/apply',
        name:'StudentApply',
        component: ()=> import("../views/student/StudentApply")
      },
      {
        path:'/student/container',
        name:'CourseContainer',
        component: ()=> import("../views/student/CourseContainer")
      },
      {
        path:'/student/container/courses',
        name:'Coursessss',
        component: ()=> import("../views/student/Coursessss")
      },
    ]  
  }
]


const router = new VueRouter({
  routes,
  mode: 'history',             /*这两行用来消去URL中的 # */
  base: process.env.BASE_URL,
})

router.beforeEach((to, from, next) => {
  if(to.path.startsWith('/student')) 
    document.title = '学生系统'
  else 
    document.title = '首页'

  next()
})

export default router
