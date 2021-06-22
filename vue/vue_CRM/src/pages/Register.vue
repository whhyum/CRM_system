<template>
  <div class="container">
    <div class="box">
      <h1 style="text-align: center">客户关系管理系统</h1>
      <el-form ref="form"
               :model="form"
               label-width="120px"
               :rules="rules">
        <h3 class="login_title"
            style="text-align: center">系统注册</h3>
        <el-form-item prop="username"
                      label="用 户 名 :">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item prop="password"
                      label="用 户 密 码 :">
          <el-input v-model="form.password"
                    type="password"></el-input>
        </el-form-item>
        <el-form-item ref="email"
                      prop="email"
                      label="用 户 邮 箱 :">
          <el-input v-model="form.email"></el-input>
        </el-form-item>

        <el-row>
          <el-col :span="13">
            <el-form-item prop="code"
                          label="验 证 码 :"
                          style="width: 130%">
              <el-input v-model="form.code"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="1">
            <el-form-item prop="">
              <el-button type="primary"
                         plain
                         @click="sendCode()"
                         style="margin-left: -3vw">获取验证码</el-button>
            </el-form-item>
          </el-col>
        </el-row>

        <el-form-item>
          <el-button type="primary"
                     plain
                     @click="resetForm('form')">重置</el-button>
          <el-button type="primary"
                     plain
                     @click="submitForm('form')">注册</el-button>
          <el-button plain>Cancel</el-button>
        </el-form-item>
      </el-form>
    </div>
    <!--<Tabs></Tabs>-->
  </div>

</template>

<script>

export default {
  name: "Register",
  data () {
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
        code: ''
      },
      dynamicValidateForm: {
        domains: [{
          key: 1,
          value: ''
        }],
        email: ''
      },
      rules: {
        username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
        password: [{ required: true, message: '请输入用户密码', trigger: 'blur' }],
        email: [{ required: true, message: '请输入用户邮箱', trigger: 'blur' },
        { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }],
        code: { required: true, message: '请输入验证码', trigger: 'blur' },

      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm (formName) {
      this.$refs[formName].resetFields();
    },
    sendCode () {
      console.log()
      if (this.form.email != null) {
        this.$message.success('获取验证码')
        console.log(this.form.email)
      } else {
        this.$message.error('请输入邮箱')
        return false;
      }

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
.box {
  margin-top: 8vh;
  /*padding: 30px;*/
  width: 450px;
  /*background-color: #D1E8D4;*/
}
form {
  background-color: white;
  border: 1px black solid;
  border-radius: 5px;
  padding-right: 40px;
  /* padding-left: 10px; */
}
/*template{*/
/*  position:fixed;*/
/*  background-size:100% 100%;*/

/*}*/
</style>
