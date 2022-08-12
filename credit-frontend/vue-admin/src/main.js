import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
//引入element
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
//引入axios
import axios from 'axios'

require('./mock')

//使用element
Vue.use(ElementUI)
//使用axios
Vue.prototype.$axios = axios

Vue.config.productionTip = false

new Vue({
  el:"#app",
  router,
  store,
  render: h => h(App)
})
