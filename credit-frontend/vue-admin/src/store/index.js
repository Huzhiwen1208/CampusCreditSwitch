import Vue from 'vue'
import Vuex from 'vuex'
import menus from './modules/menus'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    token: '',      //区分用户标识

    appliers:0,     //未受理的个数
    applierList: [], //数组
  },
  getters: {
  },
  mutations: {
    SET_TOKEN: (state,val) => {
      state.token = val;
      localStorage.setItem('token',val);
    }, 
    CLEAR_STATE: (state,val) => {
      state.token = ''
    },
    SET_APPLIERS: (state,val) => {
      state.appliers = val
    },
    SET_APPLIERLIST: (state,val) =>{
      state.applierList = val
    }
  },
  actions: {
  },
  modules: {
    menus
  }
})
