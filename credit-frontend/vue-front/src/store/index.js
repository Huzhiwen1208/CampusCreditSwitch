import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    studentId:'', //学生学号
    teacherId:'', //教师工号

    major:'', 
    applyer:{},

    appliers:1,
    appNew : '',

    books: [
      {
        url: "/os.png",
        detail: "在计算机中，操作系统是其最基本也是最为重要的基础性系统软件。从计算机用户的角度来说，计算机操作系统体现为其提供的各项服务；从程序员的角度来说，其主要是指用户登录的界面或者接口；如果从设计人员的角度来说，就是指各式各样模块和单元之间的联系。事实上，全新操作系统的设计和改良的关键工作就是对体系结构的设计，经过几十年以来的发展，计算机操作系统已经由一开始的简单控制循环体发展成为较为复杂的分布式操作系统，再加上计算机用户需求的愈发多样化，计算机操作系统已经成为既复杂而又庞大的计算机软件系统之一。 ",
        credit: "2",
        id: "HBKJ10010",
        teacher:'李士勇',
        englishName:'operating system',
        description: "操作系统",
      },
      {
        url: "/cn.png",
        detail: "计算机网络也称计算机通信网。关于计算机网络的最简单定义是：一些相互连接的、以共享资源为目的的、自治的计算机的集合。若按此定义，则早期的面向终端的网络都不能算是计算机网络，而只能称为联机系统（因为那时的许多终端不能算是自治的计算机）。但随着硬件价格的下降，许多终端都具有一定的智能，因而“终端”和“自治的计算机”逐渐失去了严格的界限。若用微型计算机作为终端使用，按上述定义，则早期的那种面向终端的网络也可称为计算机网络。 ",
        credit: "2",
        id: "HBKJ10001",
        description: "计算机网络",
        teacher:'李士勇',
        englishName:'computer network',
      },
      {
        url: "/linux.png",
        detail: "ososos",
        credit: "2",
        id: "HBKJ10231",
        description: "Linux系统",
        teacher:'李士勇',
        englishName:'Linux operating system',
      },
      {
        url: "/ds.png",
        detail: "ososos",
        credit: "2",
        id: "HBKJ10888",
        description: "数据结构",
        teacher:'李士勇',
        englishName:'data structure'
      },
      {
        url: "/cp.png",
        detail: "ososos",
        credit: "2",
        id: "HBKJ10056",
        description: "计算机原理",
        teacher:'李士勇',
        englishName:'computer theory'
      },
    ],
  },
  getters: {
  },
  mutations: {
    SET_STUDENT_ID: (state,value) =>{
      state.studentId = value;
    },
    SET_TEACHER_ID: (state,value) =>{
      state.teacherId = value;
    },
    SET_MAJOR: (state,value) =>{
      state.major = value;
    },
    SET_APPLYER: (state,value) =>{
      state.applyer = value;
    },
    SET_APPLIERS: (state,value) =>{
      state.appliers = value;
    },
    SET_APPNEW: (state,value) =>{
      state.appNew = value;
    },


    ADDONE: (state,value) =>{
      state.books.push(value)
    }
  },
  actions: {
  },
  modules: {
  }
})
