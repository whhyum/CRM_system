<template>
  <el-form ref="form"
           :model="form"
           label-width="80px">

    <el-form-item label="客户名称">

      <el-input v-model="form.customer_name"></el-input>
    </el-form-item>
    <el-form-item label="客户类型">

      <el-select v-model="form.status"
                 placeholder="请选择客户类型">
        <el-option label="流失"
                   value="流失"></el-option>
        <el-option label="开发失败"
                   value="开发失败"></el-option>
        <el-option label="潜在客户"
                   value="潜在客户"></el-option>
        <el-option label="正式客户"
                   value="正式客户"></el-option>
        <el-option label="资源池客户"
                   value="资源池客户"></el-option>
      </el-select>
    </el-form-item>

    <el-form-item label="服务方式">
      <el-select v-model="form.type"
                 placeholder="请选择沟通方式">
        <el-option label="邮件"
                   value="邮件"></el-option>
        <el-option label="电话"
                   value="电话"></el-option>
        <el-option label="QQ"
                   value="QQ"></el-option>
        <el-option label="微信"
                   value="微信"></el-option>
        <el-option label="面议"
                   value="面议"></el-option>
        <el-option label="其他"
                   value="其他"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="服务效果">
      <el-radio-group v-model="form.trace_result">
        <el-radio label="优"></el-radio>
        <el-radio label="中"></el-radio>
        <el-radio label="差"></el-radio>
      </el-radio-group>
    </el-form-item>

    <el-form-item label="服务类型">
      <el-input v-model="form.trace_type"></el-input>
    </el-form-item>

    <el-form-item label="服务内容">
      <el-input type="textarea"
                v-model="form.trace_details"></el-input>
    </el-form-item>

    <!-- <el-form-item label="活动形式">
      <el-input type="textarea"
                v-model="form.desc"></el-input>
    </el-form-item>
    <el-form-item> -->
    <el-button type="primary"
               @click="onSubmit">立即创建</el-button>
    <el-button>取消</el-button>
    </el-form-item>
  </el-form>

</template>

<script>
import { serverAdd } from "@/api/server";
export default {
  data () {
    return {
      form: {
        trace_details: '',
        trace_type: '',
        trace_result: '',//优中差
        customer_name: '',
        process_status: '',
        process_type: '',
        input_user: window.sessionStorage.getItem("username"),
        status: '', //正式员工啥的 
        type: ''
      }
    }
  },
  methods: {
    onSubmit () {
      console.log('submit!');
      let fd = new FormData()
      fd.append('trace_details', this.form.trace_details);
      fd.append('trace_type', this.form.trace_type);
      fd.append('trace_result', this.form.trace_result);
      fd.append('customer_name', this.form.customer_name);
      fd.append('process_status', this.form.process_status);
      fd.append('process_type', this.form.process_type);
      fd.append('input_user', this.form.input_user);
      fd.append('status', this.form.status);
      fd.append('type', this.form.type);

      serverAdd(fd).then((success) => {
        if (success.data.status === 200) {

          this.$message.success(success.data.message);
        } else {
          this.$message.info(success.data.message);
        }
        // console.log("jljklhklh" + this.ruleForm.username);
      }).catch(error => {
        this.$message.error('出错了，请联系管理员');
      })


    },

  }
}
</script>

<style>
</style>