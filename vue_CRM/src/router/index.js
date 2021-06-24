import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/pages/Login'
import Register from '@/pages/Register'
import index from '@/pages/index'
import manageCus from '@/pages/Customer/manageCus'
import addCustomer from '@/pages/Customer/addCustomer'
import b from '@/pages/b'

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
          path: '/index/addCustomer',
          name: 'addCustomer',
          component: addCustomer,
          meta: {
            title: "添加客户"
          }
        },
        {
          path: '/index/manageCus',
          name: 'manageCus',
          component: manageCus,
        
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
