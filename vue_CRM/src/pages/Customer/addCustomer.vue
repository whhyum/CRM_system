<template>
  <div>
    <h1>创建客户</h1>
    <el-form :model="ruleForm"
             :rules="rules"
             ref="ruleForm"
             label-width="100px"
             class="demo-ruleForm"
             style="width:auto;">
      <el-form-item label="创建人"
                    prop="">
        <span>{{current}}</span>
        <!-- <el-input v-model="current"></el-input> -->
      </el-form-item>
      <el-form-item label="客户名称"
                    prop="username">
        <el-input style="width:50%"
                  v-model="ruleForm.username"></el-input>
      </el-form-item>
      <el-form-item label="客户行业"
                    prop="job">
        <el-select v-model="ruleForm.job"
                   placeholder="请选择客户所属行业">
          <el-option label="互联网"
                     value="互联网"></el-option>
          <el-option label="金融业"
                     value="金融业"></el-option>
          <el-option label="教育业"
                     value="教育业"></el-option>
          <el-option label="服务业"
                     value="服务业"></el-option>
          <el-option label="餐饮业"
                     value="餐饮业"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="客户区域"
                    prop="area">
        <el-cascader v-model="ruleForm.area"
                     :options="options"
                     @change="handleChange"></el-cascader>
      </el-form-item>
      <el-form-item label="客户状态"
                    prop="status">
        <el-select v-model="ruleForm.status"
                   placeholder="请选择客户状态">
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
      <el-form-item label="创建时间"
                    required>
        <el-date-picker v-model="ruleForm.value1"
                        type="date"
                        placeholder="选择日期">
        </el-date-picker>

      </el-form-item>

      <el-form-item label="客户邮箱"
                    prop="email">
        <el-input v-model="ruleForm.email"
                  style="width:50%"></el-input>
      </el-form-item>
      <el-form-item label="星标客户"
                    prop="star">
        <el-switch v-model="ruleForm.star"></el-switch>
      </el-form-item>

      <el-form-item label="客户来源"
                    prop="source">
        <el-radio-group v-model="ruleForm.source">
          <el-radio label="线上网站"
                    name="type"></el-radio>
          <el-radio label="线下活动"
                    name="type"></el-radio>
          <el-radio label="朋友推荐"
                    name="type"></el-radio>
          <el-radio label="其他"
                    name="type"></el-radio>
        </el-radio-group>
      </el-form-item>
      <!-- 
      <el-form-item label="特殊资源"
                    prop="resource">
        <el-radio-group v-model="ruleForm.resource">
          <el-radio label="线上品牌商赞助"></el-radio>
          <el-radio label="线下场地免费"></el-radio>
        </el-radio-group>
      </el-form-item> -->
      <el-form-item label="备注"
                    prop="">
        <el-input type="textarea"
                  v-model="ruleForm.desc"
                  rows="5"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary"
                   @click="submitForm('ruleForm')">立即创建</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { userAdd } from "@/api/user";
export default {
  created () {
    console.log(this.$store.state.user.username);
    console.log(this.$store.state.user);
  },

  data () {
    return {
      // current: this.$store.state.user.username,
      current: window.sessionStorage.getItem("username"),
      value: [],
      options: [{
        value: '华北地区',
        label: '华北地区',
        children: [{
          value: '北京',
          label: '北京',
        },
        {
          value: '天津',
          label: '天津',
        }, {
          value: '河北',
          label: '河北',
        }],
      }, {
        value: '东北地区',
        label: '东北地区',
        children: [{
          value: '辽宁',
          label: '辽宁',
        },
        {
          value: '吉林',
          label: '吉林',
        }, {
          value: '黑龙江',
          label: '黑龙江',
        }],

      }, {
        value: '华东地区',
        label: '华东地区',
        children: [{
          value: '上海',
          label: '上海',
        },
        {
          value: '江苏',
          label: '江苏',
        }, {
          value: '浙江',
          label: '浙江',
        }],

      }, {
        value: '中南地区',
        label: '中南地区',
        children: [{
          value: '广东',
          label: '广东',
        },
        {
          value: '广西',
          label: '广西',
        }, {
          value: '湖南',
          label: '湖南',
        }, {
          value: '深圳',
          label: '深圳',
        }],
      }, {
        value: '西南地区',
        label: '西南地区',
        children: [{
          value: '重庆',
          label: '重庆',
        },
        {
          value: '四川',
          label: '四川',
        }, {
          value: '贵州',
          label: '贵州',
        }],
      }, {
        value: '西北地区',
        label: '西北地区',
        children: [{
          value: '陕西',
          label: '陕西',
        },
        {
          value: '甘肃',
          label: '甘肃',
        }, {
          value: '宁夏',
          label: '宁夏',
        }],
      }


      ],
      ruleForm: {
        username: '',
        area: '',
        job: '',
        source: '',
        desc: '',
        email: '',
        star: false,
        value1: '',
        input_name: '',
        seller: '',
        input_name: ''

      },
      rules: {
        username: [
          { required: true, message: '请输入客户名称', trigger: 'blur' },
          { min: 2, max: 15, message: '长度在 2 到 15 个字符', trigger: 'blur' }
        ],
        email: [{ required: true, message: '请输入用户邮箱', trigger: 'blur' }],
        area: [
          { required: true, message: '请选择客户区域', trigger: 'change' }
        ],
        date1: [
          { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
        ],
        job: [
          { required: true, message: '请选择客户行业', trigger: 'blur' }
        ],
        status: [
          { required: true, message: '请选择客户状态', trigger: 'change' }
        ],
        type: [
          { type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }
        ],
        resource: [
          { required: true, message: '请选择活动资源', trigger: 'change' }
        ],
        desc: [
          { required: true, message: '请填写活动形式', trigger: 'blur' }
        ]
      },
      pickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick (picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '最近一个月',
          onClick (picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '最近三个月',
          onClick (picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
            picker.$emit('pick', [start, end]);
          }
        }]
      },
      value1: '',
      value2: ''
    };
  },
  methods: {
    submitForm (formName) {

      this.$refs[formName].validate((valid) => {

        let fd = new FormData();
        fd.append('username', this.ruleForm.username);
        fd.append('email', this.ruleForm.email);
        fd.append('job', this.ruleForm.job);
        fd.append('source', this.ruleForm.source);
        fd.append('area', this.ruleForm.area[0] + '-' + this.ruleForm.area[1]);
        fd.append('star', this.ruleForm.star);
        fd.append('inputTime', this.ruleForm.value1);
        fd.append('seller', this.current);
        fd.append('inputUser', this.current);
        console.log(fd);
        // fd.append('password', this.ruleForm.password);
        // fd.append('role_id', this.ruleForm.usertype);

        if (valid) {
          // let data = this.$qs.stringify({
          //   age: '',
          //   gender: '',
          //   username: this.ruleForm.username,
          //   tel: '',
          //   email: this.ruleForm.email,
          //   job: this.ruleForm.job,
          //   source: this.ruleForm.source,
          //   area: this.ruleForm.area[0] + this.ruleForm.area[1],
          //   star: false,
          //   inputTime: this.ruleForm.value1,
          //   inputUser: this.current,
          //   seller: this.current,
          // })
          // console.log(data);
          // alert('submit!');
          userAdd(fd).then((success) => {
            if (success.data.status === 200) {

              this.$message.success(success.data.message);
              this.resetForm()
            } else {
              this.$message.info(success.data.message);
            }
            // console.log("jljklhklh" + this.ruleForm.username);
          }).catch(error => {
            this.$message.error('出错了，请联系管理员: ' + error.response.status);

          })

        } else {
          this.$message.error('请检查表单信息');
          return false;
        }
      });
    },
    resetForm () {
      this.$refs.ruleForm.resetFields();
    },
    handleChange (value) {
      console.log(value);
    }
  }
}
</script>

<style>
</style>
