<template>
  <div>
    <el-container style="height:100%">
      <el-aside style="height:100vh;width:250px;margin-right:0px;">
        <el-menu :default-active='$route.path'
                 class="el-menu-vertical-demo"
                 @open="handleOpen"
                 @close="handleClose"
                 router
                 style="height:100%">
          <div style="width:250px;text-align:center;height:120px">
            <img src="../assets/MainLogo.png"
                 class="Main_img">
          </div>
          <h2 style="margin:20px auto;text-align:center;color:white">CRM管理系统</h2>
          <el-submenu index="1"
                      v-for="(items,index) in menu"
                      :key=index>
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>{{ items.title }}</span>
            </template>
            <el-menu-item v-for="(item,index) in items.menuItem"
                          :key="index"
                          :index="item.index">
              <!-- <router-link to="/a"></router-link> -->
              {{ item.name }}
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>

    </el-container>
  </div>

</template>

<script>
// import Tabs from "@/components/Tabs";
// import NavTop from "@/components/NavTop"
// import Tabs from './Tabs.vue';

export default {
  name: "NavMenu",
  data () {
    return {
      sidebarItem: '',
      menu: [
        {
          title: '客户管理',
          menuItem: [
            {
              name: '添加客户',
              index: '/main/a'
            },
            {
              name: '客户管理',
              index: '/main/b'
            },
          ]
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

<style scoped>
html,
body {
  height: 100%;
}
.page-title {
  background-color: white;
}
menu {
  width: 1000px;
}
.Main_img {
  width: 150px;
  text-align: center;
  margin: 10 auto;
}
</style>
