<template>
  <div class="container">
    <div class="box">
      <h1 style="text-align: center">客户关系管理系统注册</h1>
      <el-form ref="form"
               :model="form"
               label-width="120px"
               :rules="rules">
        <el-form-item prop="username"
                      label="用 户 名 :">
          <el-input v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item prop="password"
                      label="用 户 密 码 :">
          <el-input v-model="form.password"
                    type="password"></el-input>
        </el-form-item>
        <el-form-item prop="role_id"
                      label="用 户 身 份 :">
          <el-radio-group v-model="USERTYPE">
            <el-radio v-for="(item) in usertypes"
                      :key="item.num"
                      :label="item.num"
                      @change="chooseType(item.num)">{{item.type }}</el-radio>
            <!-- :value="item.num" -->

          </el-radio-group>
        </el-form-item>
        <el-form-item v-if="form.role_id === 3"
                      prop="user_id"
                      label="身 份 码 :">
          <el-input v-model="form.user_id"></el-input>
        </el-form-item>
        <el-form-item prop="email"
                      label="用 户 邮 箱 :">
          <el-input ref="email"
                    v-model="form.email"></el-input>
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
                         :disabled="canClick"
                         @click="sendCode()">{{ captcha }}</el-button>
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
          <el-button plain
                     @click="cancel()">Cancel</el-button>
        </el-form-item>
      </el-form>
    </div>
    <!--<Tabs></Tabs>-->
  </div>

</template>

<script>

import { userSend, userReg } from "@/api/user";
export default {
  name: "Register",
  data () {
    return {
      USERTYPE: '',
      usertypes: [
        {
          num: 1,
          type: '客户'
        },
        {
          num: 2,
          type: '员工'
        },
        {
          num: 3,
          type: '经理'
        }],
      form: {
        username: '',
        password: '',
        // usertype: '',
        email: '2466921236@qq.com',
        role_id: '',
        user_id: ''

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
        role_id: { required: true, message: '请选择用户身份', trigger: 'blur' }
      },
      captcha: "获取验证码",
      totalTime: 60,
      canClick: false,    // 节流
      clockTimer: null, // 定时器
    }
  },
  methods: {
    submitForm (form) {
      console.log(this.USERTYPE);
      this.$refs[form].validate((valid) => {
        if (valid) {
          let fd = new FormData()
          fd.append('username', this.form.username)
          fd.append('password', this.form.password)
          fd.append('email', this.form.email)
          fd.append('code', this.form.code)
          fd.append('role_id', this.USERTYPE)
          // fd.append('username',this.form.username)
          // this.$qs.stringify({
          //   username: this.form.username,
          //   password: this.form.password,
          //   email: this.form.email,
          //   code:this.form.code,
          //   role_id: this.form.usertype

          // })
          userReg(fd).then((success) => {
            if (success.data.status === 200) {
              this.$message.success(success.data.message)
              this.$router.replace({ path: '/' })
              this.$message.success('请登录...')
            } else {
              this.$message.info(success.data.message)
            }
          }).catch(error => {
            this.$message.error('出错了，请联系管理员');
          })
          // alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm (formName) {
      this.$refs[formName].resetFields();
      this.USERTYPE = ''
    },
    sendCode () {
      console.log(this.form.email)

      if (this.form.email != '') {

        let fd = new FormData();
        fd.append('email', this.form.email)
        // test:2466921236@qq.com
        this.$message.info('获取验证码中....')

        userSend(fd).then(success => {
          if (success.data.status === 200) {
            this.$message.success(success.data.message)
            this.check();
          } else {
            this.$message.error('获取失败...')
          }
        }).catch(error => {
          console.log(error)
          // this.$message.error('获取失败.23..')
          this.$message.error(error.message)
        })


        // console.log(this.form.email)
      } else {
        this.$message.error('请输入邮箱')
        return false;
      }

    },
    check () {
      if (this.canClick) return  // 节流 防止频繁访问接口
      this.canClick = true
      console.log('进入倒计时...')
      this.captcha = this.totalTime + 's 后重新发送'
      let that = this
      that.clockTimer = window.setInterval(() => {
        that.totalTime--
        that.captcha = that.totalTime + 's后重新发送'
        if (that.totalTime < 0) {
          window.clearInterval(that.clockTimer)
          that.captcha = '重新发送验证码'
          that.totalTime = 60
          that.canClick = false
        }
      }, 1000)
    },
    chooseType (num) {
      // console.log(this.form.role_id)
      // this.USERTYPE = num

      // this.form.role_id = num

      // console.log(this.form.role_id)
      // this.USERTYPE = num
      console.log(this.USERTYPE)
      this.form.role_id = this.USERTYPE

      console.log(this.form.role_id)

    },
    cancel () {
      this.$router.replace({ path: '/' })
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
  width: 600px;
  /*background-color: #D1E8D4;*/
}
form {
  padding-top: 30px;
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
