<template>
  <div class="container">
    <div class="box">
      <h1 style="text-align: center">客户关系管理系统登录</h1>
      <el-form ref="form"
               :model="form"
               label-width="120px"
               :rules="rules">
        <div style="width:500px;text-align:center;">
          <img src="../assets/MainLogo.png"
               class="Main_img">
        </div>
        <el-form-item prop="username"
                      label="用 户 名 :">
          <el-input v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item prop="password"
                      label="用 户 密 码 :">
          <el-input v-model="form.password"
                    type="password"></el-input>
        </el-form-item>

        <el-form-item style="text-align:right;margin-right:20px">

          <el-button type="primary"
                     plain
                     @click="submitForm('form')">登录</el-button>
          <el-button type="primary"
                     plain
                     @click="regsForm()">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>

</template>

<script>
import { userLogin } from "@/api/user";
export default {
  name: "Login",
  data () {
    return {
      form: {
        username: 'whh',
        password: 123456,
        region: '',
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

      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let _that = this
          console.log(this.form.username)
          userLogin({
            username: _that.form.username,
            password: _that.form.password,
            status: 2
          }).then((successResponse) => {
            let code = successResponse.data.status;
            if (code === 200) {
              let data = successResponse.data.data;
              let token = successResponse.data.token;
              let user = successResponse.data.employee;
              //存储token
              _this.$store.commit('SET_TOKENN', token);
              //存储user，优雅一点的做法是token和user分开获取
              _this.$store.commit('SET_USER', user);
              console.log(_this.$store.state.token);
              var path = this.$route.query.redirect
              this.$router.replace({ path: path === '/index/manageCus' || path === undefined ? '/' : path })
            }

          })






          // console.log(this.form.username);
          // this.$axios.post('api/login', this.$qs.stringify({
          //   username: this.form.username,
          //   password: this.form.password
          // })).then(successResponse => {
          //   console.log(2);
          //   if (successResponse.data.code === 200) {
          //     this.$router.replace({ path: '/main' })
          //     this.$message(successResponse.data.message)
          //     console.log(successResponse.data.message)
          //   } else {
          //     this.$message(successResponse.data.message)
          //   }

          // }).catch(failResponse => {
          //   alert('登录出错')
          // })


          // alert('submit!');
        } else {
          alert('error submit!!');
          return false;
        }
      });
    },
    regsForm () {
      // this.$refs[formName].resetFields();
      this.$router.replace({ path: '/regs' })
    },
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
  margin-top: 15vh;
  /*padding: 30px;*/

  width: 500px;
  /*background-color: #D1E8D4;*/
}
form {
  height: 350px;
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

.Main_img {
  width: 150px;
}
botton {
  width: 300px;
}
</style>
