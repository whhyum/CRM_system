<template>
  <div class="container">
    <div class="box">
      <h1>ZHKU客户关系管理系统</h1>
      <el-form ref="form" :model="form" label-width="120px">
        <h3 class="login_title">系统登录</h3>
        <el-form-item
          prop="name"
          label="用 户 名 :"
          :rules="[
        { required: true, message: '请输入用户名', trigger: 'blur' }
      ]">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item
          prop="password"
          label="用 户 密 码 :"
          :rules="[
        { required: true, message: '请输入用户密码', trigger: 'blur' }
      ]">
          <el-input v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item
          prop="email"
          label="用 户 邮 箱 :"
          :rules="[
        { required: true, message: '请输入用户邮箱', trigger: 'blur' },
        { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
      ]"
        >
          <el-input v-model="form.email"></el-input>
        </el-form-item>

        <el-form-item
          :inline="true"
          prop="num"
          label="验 证 码 :"
          :rules="[
        { required: true, message: '请输入验证码', trigger: 'blur' },
        { type: 'num', message: '请输入正确的验证码', trigger: ['blur', 'change'] }
      ]"
        >
          <el-input v-model="form.num"></el-input>
          <el-button type="primary" @click="checkInfo('form')">获取验证码</el-button>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="resetForm('form')">重置</el-button>
          <el-button type="primary" @click="submitForm('form')">提交</el-button>
          <el-button>Cancel</el-button>
        </el-form-item>
      </el-form>
    </div>

  </div>

</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      form: {
        name: '',
        password: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: '',
        num: ''
      },
      dynamicValidateForm: {
        domains: [{
          key: 1,
          value: ''
        }],
        email: ''
      }
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    checkInfo(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    }
  }
}
</script>

<style scoped>

.container {
  display: flex;
  justify-content: center;
  align-items: center;

}
.box{
  /*padding: 30px;*/
  width: 560px;
}
form{
  border: 1px black solid;
  border-radius: 5px;
  padding-right: 30px;
  padding-left: 10px;
}
button{

}

</style>
