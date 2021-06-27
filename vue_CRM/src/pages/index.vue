<template>
  <el-card class="out">
    <div>
      <el-container>
        <el-aside style="width:200px;height:auto">
          <el-menu class="el-menu-vertical-demo"
                   @open="handleOpen"
                   @close="handleClose"
                   default-active=0
                   router
                   style="height:100%;width:auto">
            <el-avatar shape="square"
                       style="margin-left:30%;text-align:center"
                       :size="80"
                       fit="fit"
                       :src="url"
                       @click="drawer = true"></el-avatar>
            <el-drawer title="我是标题"
                       :visible.sync="drawer"
                       :with-header="false">
              <span>我来啦!</span>
            </el-drawer>
            <h1 style="width:200px;text-align:center">CRM_System</h1>
            <div v-for="(item,index) in menu"
                 :key=index>
              <el-menu-item :index="item.index"
                            v-if="item.limit===userLimit||item.limit<userLimit">
                <i class="el-icon-menu"></i>
                <span slot="title">{{ item.name }}</span>
              </el-menu-item>
            </div>
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
      drawer: false,
      sidebarItem: '',
      userLimit: 3,
      menu: [
        {
          name: '欢迎使用',
          index: '/index/welcome',
          limit: 2
        },
        {
          name: '客户管理',
          index: '/index/manageCus',
          limit: 2
        },
        {
          name: '服务管理',
          index: '/index/server',
          limit: 2
        },
        {
          name: '合同管理',
          index: '/index/contract',
          limit: 2
        },
        {
          name: '计划日程',
          index: '/index/plan',
          limit: 2
        },
        {
          name: '业绩考核',
          index: '/index/examine',
          limit: 2
        },
        {
          name: '季度分析',
          index: '/index/analyse',
          limit: 3
        },
        {
          name: '客户投诉',
          index: '/index/complain',
          limit: 1
        },
      ],
      url: '',

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
  min-height: 93vh;
  margin: 20px;
  height: 100%;
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
.el-menu-vertical-demo {
  height: auto;
}
</style>
