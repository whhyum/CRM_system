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
import Welcome from '@/pages/Welcome'
import Choose from '@/pages/Plan/chooseserver'
import New from '@/pages/Plan/newplan'
import ok from '@/components/ok'
import back from '@/components/back'
// import aa from '@/component/Welcome'
import Analyse from '@/pages/achievement/analyse.vue'

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
          path:'/index/welcome',
          name:'Welcome',
          component:Welcome,
          meta:{
            title: '欢迎使用'
          }
        },
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
          },
          children:[
            {
              path: '/index/choose',
              name: 'Choose',
              component: Choose,
              meta:{
                title: '选择服务'
              },
            },{
              path: '/index/new',
              name: 'New',
              component: New,
              meta:{
                title: '新建计划'
              },
            },{
              path: '/index/ok',
              name: 'ok',
              component: ok,
              meta:{
                title: '添加成功'
              }
            },
            
          ]
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
          path: '/index/analyse',
          name: 'Analyse',
          component: Analyse,
          meta:{
            title: '季度分析'
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
        },
        {
          path: '/index/back',
          name: 'back',
          component: back,
          meta:{
            title: '注销登录'
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
