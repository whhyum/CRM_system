<template>
  <div class="out">

    <div>
      <NavMenu></NavMenu>
    </div>
    <div class="main">

      <div style="display:flex;flex-direction:column">

        <!-- <el-card class="top-card"> -->
        <NavTop class="main_top"></NavTop>
      </div>

      <!-- </el-card> -->
      <el-card class="box-card">

      </el-card>

    </div>

  </div>
</template>

<script>
import Tabs from "@/components/Tabs";
import NavTop from "@/components/NavTop"
import NavMenu from "@/components/NavMenu"
export default {
  components: { Tabs, NavTop, NavMenu }
}
</script>

<style>
.out {
  display: flex;
  height: 100vh;
  background-color: white;
}

head {
  text-align: right;

  /* flex: 1; */
}
.main {
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 100%;
  /* margin-left: -1px; */
}

.main_content {
  /* margin: 10px; */
  background-color: white;
}
.box-card {
  margin: 20px;
  flex: 1;
}
.top-card {
  /* margin-top: -15px; */
  padding: 0px;
  margin-bottom: 10px;
}
</style>
