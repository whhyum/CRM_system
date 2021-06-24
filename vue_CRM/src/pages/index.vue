<template>
  <el-card class="out">
    <div>
      <el-container>
        <el-aside style="width:200px">
          <el-menu class="el-menu-vertical-demo"
                   @open="handleOpen"
                   @close="handleClose"
                   router>
            <h1 style="width:200px;text-align:center">CRM_System</h1>
            <el-menu-item v-for="(item,index) in menu"
                          :key=index
                          :index="item.index">
              <i class="el-icon-menu"></i>
              <span slot="title">{{ item.name }}</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main>
          <div class="main box-card">
            <router-view></router-view>
          </div>
        </el-main>
      </el-container>
    </div>

  </el-card>
</template>

<script>

// import Main from '../pages/Main.vue'
export default {
  // components: { Main },
  data () {
    return {
      sidebarItem: '',
      menu: [
        {
          name: '客户管理',
          index: '/index/manageCus'
        },
        {
          name: '服务管理',
          index: '/index/addCustomer'
        },
        {
          name: '合同管理',
          index: '/index/addCustomer'
        },
        {
          name: '计划日程',
          index: '/index/addCustomer'
        },
        {
          name: '业绩考核',
          index: '/index/addCustomer'
        },
        {
          name: '访谈记录（待定）',
          index: '/index/addCustomer'
        },
        {
          name: '客户投诉',
          index: '/index/addCustomer'
        },
      ]
    }
  },
  methods: {
    c () {
      console.log('aaaaaaaaaa')
    },
    handleOpen (key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath);
    },
    goBack () {
      console.log('go back');
    }
  }
}
</script>

<style>
.out {
  /* display: flex; */
  border-radius: 20px;
  /* justify-content: flex-start;
  align-items: center; */
  margin: 20px;
  height: 100%;
  /* overflow: hidden; */
  /* height: 80%; */
  /* background-color: #abccc1; */
}

head {
  text-align: right;
}
.main {
  display: flex;
  flex-direction: column;
  width: 98%;
  height: inherit;
  /* overflow: hidden; */
  /* margin-left: -1px; */
}

.top-card {
  padding: 0px;
  margin-bottom: 10px;
}
.mm {
  padding-top: 30px;
}
</style>
