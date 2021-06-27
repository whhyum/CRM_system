<template>
  <div >
    <el-card style="margin-bottom:10px;height:auto">
      <div style="flex:1;display:flex;flex-direction:row">
        <div style="height: auto;">

          <div style="height:500px">

            <el-steps direction="vertical"
                      :active="active"
                      finish-status="success"
                      style="margin-right:30px">
              <el-step title="选择服务"
                       description="选择对应的服务"></el-step>
              <el-step title="新建计划"
                       description="为选中的服务分配计划"></el-step>
              <el-step title="完成更新"
                       description="在日程中建立该计划"></el-step>
            </el-steps>
          </div>
          <el-button style="margin-top: 20px;"
                     @click="prev">上一步</el-button>
          <el-button style="margin-top: 20px;"
                     @click="next">下一步</el-button>

        </div>
        <div style="flex:1;margin-left:20px;margin-right:20px">
          <div v-if="active === 0">
            <!-- 服务 -->
            <choose @choose='change($event)'></choose>
          </div>
          <div v-if="active === 1">
            <!-- 计划 -->
            <newplan :server='server'></newplan>
          </div>
          <div v-if="active === 2">
            <!-- ok -->
            <ok></ok>
          </div>
        </div>

      </div>

    </el-card>
    <el-card style="width:100%;text-align:center">
      <h1>
        本月日程
      </h1>
      <Calendar></Calendar>
    </el-card>
  </div>

  <!-- <div></div> -->
</template>

<script>
import Calendar from '../../components/aa.vue'
import choose from './chooseserver.vue'
import newplan from './newplan.vue'
import ok from '../../components/ok.vue'
export default {
  data () {
    return {
      active: 0,

      server: '选择服务',
      pages: [
        '/index/chooseserver', '/index/newplan', '/index/ok'],

      // activities: [{
      //   content: '活动按期开始',
      //   timestamp: '2018-04-15'
      // }, {
      //   content: '通过审核',
      //   timestamp: '2018-04-13'
      // }, {
      //   content: '创建成功',
      //   timestamp: '2018-04-11'
      // }]

    }
  },
  components: {
    choose, newplan, ok, Calendar
  },
  // components: { Calendar, Newplan },
  methods: {
    onSubmit () {
      console.log('submit!');
    },
    next () {

      if (this.active++ > 2) {
        this.active = 0;

      }
      console.log(this.server);
      console.log(this.active);

    },
    change (data) {
      this.server = data
      console.log('zhzsafgsgasg' + data);
    },
    prev () {

      if (this.active-- < 0) {
        this.active = 0;
      }
      console.log(this.server);
      console.log(this.active);

    },

  }
}
</script>

<style>
</style>