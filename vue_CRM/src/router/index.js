import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/pages/Login'
import Register from '@/pages/Register'
import index from '@/pages/index'
import manageCus from '@/pages/Customer/manageCus'
import Server from '@/pages/Server/server'
import Contract from '@/pages/contract/contract'
import Plan from '@/pages/Plan/plan'
import Examine from '@/pages/Examine/examine'
import seeMore from '@/pages/Server/seeMore'
import Complain from '@/pages/Complain/complain'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/index',
      name: 'index',
      component: index,
      meta: {
        requireAuth: true
      },
      children:[
        {
          path: '/index/manageCus',
          name: 'manageCus',
          component: manageCus,
          meta:{
            title: '客户管理'
          }
        },
        {
          path: '/index/server',
          name: 'Server',
          component: Server,
          meta:{
            title: '服务管理'
          }
        },
        {
          path: '/index/contract',
          name: 'Contract',
          component: Contract,
          meta:{
            title: '合同管理'
          }
        },
        {
          path: '/index/plan',
          name: 'Plan',
          component: Plan,
          meta:{
            title: '计划日程'
          }
        },
        {
          path: '/index/examine',
          name: 'Examine',
          component: Examine,
          meta:{
            title: '业绩考核'
          }
        },
        {
          path: '/index/complain',
          name: 'Complain',
          component: Complain,
          meta:{
            title: '客户投诉'
          }
        },
        {
         path: '/index/seeMore',
          name: 'seeMore',
          component: seeMore,
          meta:{
            title: '查看服务'
          }
        }
      ]
    },
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
