import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default {
  state: {
    menuListHaveSub: [],
    menuListHaveNoSub: [],
    permList: [],

    editableTabsValue: 'Index',
    editableTabs: [
      {
        title:'首页',
        name:'Index'
      }
    ]
  },
  getters: {

  },
  mutations: {
    SET_MENU_LIST_SUB(state,val){
        state.menuListHaveSub = val;
    },
    SET_MENU_LIST_NO_SUB(state,val){
        state.menuListHaveNoSub = val;
    },
    SET_PERM_LIST(state,val){
        state.permList = val;
    }
  },
  actions: {

  },
}
