// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
import axios from 'axios';
import qs from 'qs'
import fullCalendar from 'vue-fullcalendar'
Vue.component('full-calendar', fullCalendar)

// Vue.use(FullCalendar)
// var axios = require('axios')
// axios.defaults.baseURL = "http://cbd277c00321.ngrok.io/api"

Vue.prototype.$axios = axios
// 跨域 1
// Vue.prototype.HOME = 'api' 
// Vue.use(VueResource)
Vue.use(ElementUI)
Vue.prototype.$qs = qs
Vue.config.productionTip = false
//
// import {getRequest} from "./utils/api";
// import {postRequest} from "./utils/api";
// import {deleteRequest} from "./utils/api";
// import {putRequest} from "./utils/api";
//
// Vue.prototype.getRequest = getRequest;
// Vue.prototype.postRequest = postRequest;
// Vue.prototype.deleteRequest = deleteRequest;
// Vue.prototype.putRequest = putRequest;


//钩子函数，访问路由前调用
router.beforeEach((to, from, next) => {
  //路由需要认证
  if (to.meta.requireAuth) {
    //判断store里是否有token
    if (store.state.token) {
      next()
    } else {
      next({
        path: 'login',
        query: { redirect: to.fullPath }
      })
    }
  } else {
    next()
  }
}
)

new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
