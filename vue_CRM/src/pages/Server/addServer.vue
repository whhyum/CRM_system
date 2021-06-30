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
      <el-select v-model="form.trace_type"
                 placeholder="请选择服务方式">
        <el-option label="潜在开发计划"
                   value="潜在开发计划"></el-option>
        <el-option label="客户跟进历史"
                   value="客户跟进历史"></el-option>
        <el-option label="其他"
                   value="其他"></el-option>
      </el-select>
      <!-- <el-input v-model="form.trace_type"></el-input> -->
    </el-form-item>

    <el-form-item label="服务进度">
      <el-select v-model="form.process_status"
                 placeholder="请选择服务进度">
        <el-option label="客户交接中"
                   value="1"></el-option>
        <el-option label="制定需求计划"
                   value="2"></el-option>
        <el-option label="签订合同"
                   value="3"></el-option>
        <el-option label="完成服务"
                   value="4"></el-option>
      </el-select>
      <!-- <el-input v-model="form.trace_type"></el-input> -->
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
    <el-form-item>
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
      fd.append('traceDetails', this.form.trace_details);
      fd.append('traceType', this.form.trace_type);
      fd.append('traceResult', this.form.trace_result);
      fd.append('customerName', this.form.customer_name);
      fd.append('processStatus', this.form.process_status);
      fd.append('processType', this.form.process_type);
      //时间
      let nowDate = new Date();
      let date = {
        year: nowDate.getFullYear(),
        month: nowDate.getMonth() + 1,
        day: nowDate.getDate(),
      }
      console.log(date);
      let systemDate = date.year + '-' + (date.month >= 10 ? date.month : '0' + date.month) + '-' + (date.day >= 10 ? date.day : '0' + date.day)
      fd.append('traceTime', systemDate);//
      //改动
      fd.append('inputUser', this.form.input_user);//
      fd.append('status', this.form.status);
      fd.append('type', this.form.type);

      serverAdd(fd).then((success) => {
        if (success.data.status === 200) {

          this.$message.success(success.data.message);
          // this.$set(this.tableData, this.tableData., this.tableData)
          // console.log(this.form.length(), 'ssssssssssss');
          this.$router.go(0);
          location.reload()
          // this.$set(this.tableData, indexs, item);
          // this.$set(this.tableData, Object.keys(this.tableData).length, newVal)
          this.resetForm()
        } else {
          this.$message.info(success.data.message);
        }
        // console.log("jljklhklh" + this.ruleForm.username);
      }).catch(error => {
        // this.$message.error('出错了，请联系管理员');
      })


    },
    resetForm () {
      this.$refs.form.resetFields();
    }

  }
}
</script>

<style>
</style>