<template>
  <div class="top">
    <span style="margin-right:750px">页面</span>
    <!-- <span></span> -->
    <el-input placeholder="请输入任务编号"
              prefix-icon="el-icon-search"
              v-model="input2"
              class="search">
    </el-input>
    <el-avatar shape="square"
               size="medium"
               class="avatar"
               :src="squareUrl"></el-avatar>
    <a style="margin-right:30px;"
       to='/'>用户名</a>
  </div>
</template>

<script>
import Login from '@/pages/Login.vue'
export default {
  components: [Login]
}
</script>

<style>
.top {
  width: 100%;
  height: 70px;
  background-color: white;
  text-align: right;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: flex-end;
}
.search {
  width: 300px;
  margin-right: 40px;
}
.avatar {
  margin-right: 10px;
}
</style>