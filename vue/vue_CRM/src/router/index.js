import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Login from '@/pages/Login'
import NavMenu from "../components/NavMenu";
import Tabs from "../components/Tabs";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/na',
      name: 'NavMenu',
      component: NavMenu
    },
    {
      path: '/ta',
      name: 'Tabs',
      component: Tabs
    },
    {
      path: '/',
      name: 'Login',
      component: Login,
      hidden: true
    }
  ]
})
