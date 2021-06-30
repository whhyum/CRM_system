<template>
  <el-card style="width:98%;margin:auto;border-radius:8px">
    <h1>客户投诉</h1>
    <el-form :model="ruleForm"
             :rules="rules"
             ref="ruleForm"
             label-width="100px"
             class="demo-ruleForm">
      <el-form-item label="投诉对象"
                    prop="username">
        <el-select v-model="ruleForm.username"
                   placeholder="请选择投诉对象">
          <el-option v-for="(item,index) in employee"
                     :label="item"
                     :key="index"
                     :value="item"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="投诉内容"
                    prop="desc">
        <el-input type="textarea"
                  :rows="10"
                  v-model="ruleForm.desc">
        </el-input>
      </el-form-item>

      <el-form-item label="分数"
                    prop="rate">
        <el-select v-model="ruleForm.rate"
                   placeholder="请选择投诉分值">
          <el-option label=-1
                     value=-1></el-option>
          <el-option label=-2
                     value=-2></el-option>
          <el-option label=-3
                     value=-3></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary"
                   @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<style>
</style>
<script>
import { userComplainA, userComplainB } from "@/api/user"

export default {

  data () {
    return {
      employee: '',
      value: null,
      iconClasses: ['icon-rate-face-1', 'icon-rate-face-2', 'icon-rate-face-3'],
      ruleForm: {
        username: '',
        rate: '',
        desc: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入活动名称', trigger: 'blur' },
        ],
        username: [
          { required: true, message: '请选择投诉对象', trigger: 'blur' },

        ],
        rate: [
          { required: true, message: '请选择分数', trigger: 'blur' },
        ],
        desc: [
          { required: true, message: '请填写投诉内容', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // alert('submit!');
          let fd = new FormData();
          fd.append('input_use', this.ruleForm.username);
          fd.append('core', parseInt(this.ruleForm.rate));
          fd.append('context', this.ruleForm.desc);
          userComplainB(fd).then((success) => {
            if (success.data.status === 200) {

              // this.$message.success(success.data.message);
              console.log('投诉', success.data.message);
              this.$message.success(success.data.message);
              // this.tableData = success.data.data
            } else {
              this.$message.info(success.data.message);
            }
            // console.log("jljklhklh" + this.ruleForm.username);
          }).catch(error => {
            this.$message.error('出错了，请联系管理员');

          })



        } else {
          this.$message.error('请填写正确的信息');
          return false;
        }
      });
    },
    resetForm (formName) {
      this.$refs[formName].resetFields();
    }
  },
  created () {
    let fd = new FormData();
    fd.append('username', window.sessionStorage.getItem("username"));

    userComplainA(fd).then((success) => {

      if (success.data.status === 200) {

        // this.$message.success(success.data.message);
        console.log('获取投诉对象信息', success.data.message);
        this.employee = success.data.data
        this.$message.success(success.data.message, '选择投诉对象');
      } else {
        this.$message.info(success.data.message);
      }
      // console.log("jljklhklh" + this.ruleForm.username);
    }).catch(error => {
      this.$message.error('出错了，请联系管理员');

    })
  }
}
</script>