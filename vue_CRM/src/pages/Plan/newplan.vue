<template>
  <div>
    <h1>新建需求计划日程</h1>
    <el-alert :title="'选择服务：'+server"
              type="warning"
              style="margin-bottom:10px"
              :closable="false">
    </el-alert>
    <el-form ref="form"
             :model="form"
             label-width="80px">
      <el-form-item label="客户名称">
        <el-input v-model="form.servserName  "></el-input>
      </el-form-item>
      <el-form-item label="沟通方式">
        <el-input v-model="form.conmmunicateWay"></el-input>
      </el-form-item>

      <el-form-item label="需求概要">
        <el-input v-model="form.title"></el-input>
      </el-form-item>

      <el-form-item label="详细计划">
        <el-input v-model="form.detail  "></el-input>
      </el-form-item>

      <el-form-item label="截止时间">
        <div class="block">
          <!-- <span class="demonstration">默认</span> -->

          <el-date-picker v-model="form.end"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择日期">
          </el-date-picker>
        </div>
      </el-form-item>

      <el-form-item>
        <el-button type="primary"
                   @click="onSubmit">立即创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { addPlan } from '@/api/plan'

export default {
  name: 'newplan',
  props: ['server'],
  mounted () {
    console.log('testserver' + this.$props.server);
    this.serverId = this.$props.server
  },

  watch: {
    // server (val) {
    //   this.server = val
    // }
  },
  data () {
    return {
      serverId: '4444',
      form: {
        servserName: '',
        title: '',
        conmmunicateWay: '',
        detail: '',
        delivery: false,
        type: [],
        end: '',
        tractId: '',
        color: '#B8D6DE',
      },
    }
  },
  methods: {
    onSubmit () {
      // alert(this.$props.server)
      // console.log(this.choosedserver);
      // console.log(choosedserver);
      let fd = new FormData();

      // servserName  title  conmmunicateWay  detail  end  tractId

      fd.append('servserName', this.form.servserName);
      fd.append('title', this.form.title);
      fd.append('conmmunicateWay', this.form.conmmunicateWay);
      fd.append('detail', this.form.detail);
      fd.append('end', this.form.end);
      console.log('test服务id', this.serverId);
      fd.append('tract_id', this.serverId);
      fd.append('color', this.form.color);


      addPlan(fd).then((success) => {
        if (success.data.status === 200) {

          // this.$message.success(success.data.message);
          console.log('获取服务信息', success.data.message);
          this.$message.success('新建计划成功');
        } else {
          this.$message.info(success.data.message);
        }
        // console.log("jljklhklh" + this.ruleForm.username);
      }).catch(error => {
        this.$message.error('出错了，请联系管理员');

      })


    },
    getParams () {
      console.log(this.server);
      //   const serverId = this.$route.query.serverId
      //   console.log(serverId);
      //   this.serverId = serverId
    },
  }

}
</script>

<style>
</style>