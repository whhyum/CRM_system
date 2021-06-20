// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

// import axios from 'axios'
// Vue.prototype.$http = axios
// axios.default.baseURI = "http://localhost:9090"

Vue.use(ElementUI)

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



/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
