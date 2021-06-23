<template>
  <div>
    <el-container style="height:100%">
      <el-aside style="height:100vh;width:250px;margin-right:0px;">
        <el-menu default-active="2"
                 class="el-menu-vertical-demo"
                 @open="handleOpen"
                 @close="handleClose"
                 background-color="#545c64"
                 text-color="#fff"
                 active-text-color="#ffd04b"
                 style="height:100%">
          <div style="width:250px;text-align:center;height:120px">
            <img src="../assets/MainLogo.png"
                 class="Main_img">
          </div>
          <h2 style="margin:20px auto;text-align:center;color:white">CRM管理系统</h2>
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>客户管理</span>
            </template>
            <!-- <el-menu-item-group title="分组2"> -->
            <el-menu-item index="1-1">添加客户</el-menu-item>
            <el-menu-item index="1-2">用户管理</el-menu-item>
            <!-- </el-menu-item-group> -->
          </el-submenu>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
          </el-menu-item>
          <el-menu-item index="3"
                        disabled>
            <i class="el-icon-document"></i>
            <span slot="title">导航三</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-setting"></i>
            <span slot="title">导航四</span>
          </el-menu-item>
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
  methods: {
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
