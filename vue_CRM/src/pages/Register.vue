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
        <el-form-item prop="usertype"
                      label="用 户 身 份 :">
          <el-radio-group v-model="USERTYPE">
            <el-radio v-for="(item) in usertypes"
                      :key="item.num"
                      :value="item.num"
                      :label="item.type"
                      @change="chooseType(item.num)"></el-radio>

          </el-radio-group>
        </el-form-item>
        <el-form-item v-if="form.usertype === 3"
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
          <el-button plain
                     @click="cancel()">Cancel</el-button>
        </el-form-item>
      </el-form>
    </div>
    <!--<Tabs></Tabs>-->
  </div>

</template>

<script>
import { userSend } from "@/api/user";
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
        usertype: '',
        email: '',
        usertype: '',

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
        usertype: { required: true, message: '请选择用户身份', trigger: 'blur' }
      }
    }
  },
  methods: {
    submitForm (form) {
      this.$refs[form].validate((valid) => {
        if (valid) {
          let fd = new FormData({
            username: this.form.username,
            password: this.form.password,
            email: this.form.email,
            usertypes: this.form.usertype

          })
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
      console.log(this.$refs.email)

      if (this.form.email != '') {

        let fd = new FormData();
        fd.append('email', this.form.email)
        // test:2466921236@qq.com
        this.$message.info('获取验证码中....')
        userSend(fd).then(success => {
          if (success.data.status === 200) {
            this.$message.success(success.data.msg)
          } else {
            this.$message.info('获取失败...')
          }
        }).catch(error => {
          this.$message.info('获取失败...')
          this.$message.error(error)
        })
        // console.log(this.form.email)
      } else {
        this.$message.error('请输入邮箱')
        return false;
      }

    },
    chooseType (num) {
      console.log(num)
      this.form.usertype = num
      // this.USERTYPE = num
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
  width: 450px;
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
