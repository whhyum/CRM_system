import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/pages/Login'
import Register from '@/pages/Register'
import NavMenu from "@/components/NavMenu";
import Main_m from '@/components/Main_Module'
import Tabs from "@/components/Tabs";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/main',
      name: 'Main',
      component: Main_m
    },
    // {
    //   path: '/ta',
    //   name: 'Tabs',
    //   component: Tabs
    // },
    {
      path: '/',
      name: 'Login',
      component: Login,
      hidden: true
    },
    {
      path: '/regs',
      name: 'Register',
      component: Register,
    }
  ]
})
