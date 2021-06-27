<template>
  <el-card style="width:100%;text-align:center">
    <h1>
      本月日程
    </h1>
    <Calendar></Calendar>
  </el-card>

  <!-- <div></div> -->
</template>

<script>

import Calendar from '../../components/aa.vue'
export default {
  data () {
    return {

    }
  },
  components: { Calendar }
}
</script>

<style>
</style>