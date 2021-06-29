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
        <el-form-item prop="usertype"
                      label="用 户 身 份 :">
          <el-radio-group v-model="USERTYPE"
                          style="padding-left:20px">
            <el-radio v-for="(item) in usertypes"
                      :key="item.num"
                      :value="item.num"
                      :label="item.type"
                      @change="chooseType(item.num)"></el-radio>

          </el-radio-group>
        </el-form-item>
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
import { userLogin, userSend, userReg } from "@/api/user";
export default {
  name: "Login",
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
        username: 'whh',
        password: '123456',
        region: '',
        delivery: false,
        type: [],
        resource: '',
        desc: '',
        status: '',
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
        usertype: { required: true, message: '请选择用户身份', trigger: 'blur' }

      }
    }
  },
  methods: {
    submitForm (formName) {
      var _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let fd = new FormData();
          fd.append('username', this.form.username);
          fd.append('password', this.form.password);
          fd.append('role_id', this.form.usertype);
          userLogin(fd).then((success) => {
            let code = success.data.status;
            if (code === 200) {
              // let data = success.data.data;
              let token = success.data.token;
              let user = success.data.data;
              _this.$store.commit('SET_TOKENN', token);
              _this.$store.commit('SET_USER', {
                username: user.username,
                role_id: user.roleId
              });
              // _this.$store.commit('SET_USERNAME', user.username);
              // _this.$store.commit('SET_USERSTATUS', user.status);
              sessionStorage.setItem('username', user.username)
              sessionStorage.setItem('role_id', user.roleId)
              console.log(_this.$store.state.token);
              console.log(_this.$store.state.user.status);
              this.$router.replace({ path: '/index/welcome' })
            } else {
              console.log(success.data.msg);
              this.$message({
                message: success.data.msg,
                type: 'warning'
              });
            }

          }).catch(error => {
            this.$message.error('出错了，请联系管理员');
          })

        } else {
          this.$message.error('提交失败，请提交所有信息');
          return false;
        }
      });
    },
    regsForm () {
      // this.$refs[formName].resetFields();
      this.$router.replace({ path: '/regs' })
    },
    chooseType (num) {
      console.log(num)
      this.form.usertype = num
      // this.USERTYPE = num
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
  margin-top: 15vh;
  /*padding: 30px;*/

  width: 500px;
  /*background-color: #D1E8D4;*/
}
form {
  height: auto;
  background-color: white;
  border: 1px black solid;
  border-radius: 5px;
  padding-right: 40px;
  /* padding-left: 10px; */
}

.Main_img {
  width: 150px;
}
botton {
  width: 300px;
}
</style>
