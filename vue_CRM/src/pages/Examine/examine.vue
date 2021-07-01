<template>
  <el-card>
    <div style="display:flex;flex-direction:row;">
      <div style="display:flex;flex-direction:column;padding-right:10px;width:800px;height:auto">
        <!-- 员工列表 -->
        <h1>员工列表</h1>
        <el-table :data="tableData.filter(data => !search || data.username.toLowerCase().includes(search.toLowerCase()))">
          <el-table-column type="expand">
            <template slot-scope="props">
              <!-- 


                员工信息


               -->
              <el-form label-position="left"
                       inline
                       :model="form"
                       class="demo-table-expand">
                <el-form-item label="员工姓名">
                  <el-input v-model="props.row.username"></el-input>
                </el-form-item>
                <el-form-item label="所属部门">
                  <el-input v-model="props.row.department"></el-input>
                </el-form-item>
                <el-form-item label="员工邮箱">
                  <el-input v-model="props.row.email"></el-input>
                </el-form-item>
                <el-form-item label="员工性别">
                  <el-input v-model="props.row.gender"></el-input>
                </el-form-item>

                <el-form-item>
                  <el-button type="primary"
                             @click="onSubmit(props.row)">立即修改</el-button>
                  <!-- <el-button>取消</el-button> -->
                </el-form-item>
              </el-form>
            </template>
          </el-table-column>
          <el-table-column label="入职时间"
                           prop="hireDate">
          </el-table-column>
          <el-table-column label="员工姓名"
                           prop="username">
          </el-table-column>
          <el-table-column label="所属部门"
                           prop="department">
          </el-table-column>
          <!-- <el-table-column prop="tag"
                           label="标签"
                           width="100"
                           :filters="[{ text: '家', value: '家' }, { text: '公司', value: '公司' }]"
                           :filter-method="filterTag"
                           filter-placement="bottom-end">
            <template slot-scope="scope">
              <el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'"
                      disable-transitions>{{scope.row.tag}}</el-tag>
            </template>
          </el-table-column> -->

          <el-table-column align="right">
            <template slot="header"
                      slot-scope="scope">
              <el-input v-model="search"
                        size="mini"
                        placeholder="输入员工姓名" />
            </template>
            <template slot-scope="scope">
              <el-button size="mini"
                         @click="handleEdit(scope.$index, scope.row)">考核</el-button>
              <!-- :disabled='exstatus' -->
              <el-button size="mini"
                         type="danger"
                         @click="handleDelete(scope.$index, scope.row)">移除</el-button>
            </template>
          </el-table-column>

        </el-table>
        <div style="margin-top:10px;width:100%;text-align:center">

          <el-pagination background
                         @current-change="handleCurrentChange"
                         :current-page="currentPage"
                         layout="prev, pager, next"
                         :total="total">
          </el-pagination>
        </div>

      </div>

      <!-- 考核


表单 -->

      <el-card style="width:600px">
        <h1>考核表单</h1>
        <el-form :model="exForm"
                 :rules="rules"
                 ref="exForm"
                 class="demo-exForm">

          <el-form-item label="考核时间"
                        label-width="">
            {{ exForm.judge_time }}
          </el-form-item>
          <el-form-item label="考核员工"
                        label-width="">
            {{ exForm.judged_people }}
          </el-form-item>
          <el-form-item label="考核分数"
                        label-width="">
            {{ exForm.performance }}
          </el-form-item>

          <el-form-item label="工作能力[40%]1-10分"
                        prop=""
                        label-width="">
            <el-input v-if="!exStatus"
                      v-model="exForm.working_ability"
                      placeholder="请输入工作能力分值"></el-input>
            <span v-else>{{ exForm.working_ability }}</span>
          </el-form-item>
          <el-form-item label="工作态度[20%]1-10分"
                        prop=""
                        label-width="">
            <el-input v-if="!exStatus"
                      v-model="exForm.working_atitude"
                      placeholder="请输入工作能力分值"></el-input>
            <span v-else>{{exForm.working_atitude}}</span>
          </el-form-item>
          <el-form-item label="环境行为[10%]1-10分"
                        prop=""
                        label-width="">
            <el-input v-if="!exStatus"
                      v-model="exForm.environmental_behavior"
                      placeholder="请输入工作能力分值"></el-input>
            <span v-else>{{exForm.environmental_behavior}}</span>
          </el-form-item>

          <el-form-item label="纪律[10%]1-10分"
                        prop=""
                        label-width="">
            <el-input v-if="!exStatus"
                      v-model="exForm.discipline"
                      placeholder="请输入工作能力分值"></el-input>
            <span v-else>{{exForm.discipline}}</span>
          </el-form-item>
          <!-- discipline: '',
        bonus_point: '',
        deduct_point: '',
        judge_time: '',//judge_time
        juage_people: window.sessionStorage.getItem("username"),//juage_people,
        judged_people: '',//judged_people -->

          <el-form-item label="加分项[20%]1-10分"
                        label-width="">
            <el-input v-if="!exStatus"
                      v-model="exForm.bonus_point"
                      placeholder="请输入工作能力分值"></el-input>
            <span v-else>{{ exForm.bonus_point }}</span>
          </el-form-item>
          <el-form-item label="扣分项[10%]1-10分"
                        label-width="">
            <el-input v-if="!exStatus"
                      v-model="exForm.deduct_point"
                      placeholder="请输入工作能力分值"></el-input>
            <span v-else>{{exForm.deduct_point}}</span>
          </el-form-item>

          <el-form-item label="备注">
            <el-input type="textarea"
                      v-model="exForm.desc"></el-input>
          </el-form-item>

          <el-form-item label="考核经理"
                        label-width="">
            {{ exForm.juage_people }}
          </el-form-item>

          <el-form-item>
            <el-button type="primary"
                       @click="submitForm('exForm')">提交考核</el-button>
            <el-button @click="resetForm(exForm)">重置</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </div>
  </el-card>
</template>

<script>

import { } from '../../api/server'
import { exNow, exNum, exAdd, employeeDel, exUp, exCheck } from '@/api/ex'

export default {
  created () {
    exNum().then((success) => {
      if (success.data.status === 200) {

        // this.$message.success(success.data.message);
        console.log('获取考核员工总信息', success.data.message);
        this.total = success.data.data
      } else {
        this.$message.info(success.data.message);
      }
      // console.log("jljklhklh" + this.ruleForm.username);
    }).catch(error => {
      // this.$message.error('出错了，请联系管理员');

    })
    this.getExData()


    // tableData
    this.handleCurrentChange()




  },
  mounted () {

    let nowDate = new Date();
    let date = {
      year: nowDate.getFullYear(),
      month: nowDate.getMonth() + 1,
      date: nowDate.getDate(),
    }
    console.log(date);
    let systemDate = date.year + '-' + (date.month >= 10 ? date.month : '0' + date.month) + '-' + (date.date >= 10 ? date.date : '0' + date.date);
    this.exForm.judge_time = systemDate
  },
  data () {
    return {
      exStatus: false, //考核状态 = > 未考核false ；考核true
      currentPage: 1,
      total: 100,
      form: {
        username: '',
        department: '',
        email: '',
        gender: '',
        resource: '',
        desc: ''
      },
      exForm: {
        working_ability: '',
        working_atitude: '',
        environmental_behavior: '',
        discipline: '',
        bonus_point: '',
        deduct_point: '',
        judge_time: '',//judge_time
        juage_people: window.sessionStorage.getItem("username"),//juage_people,
        judged_people: '',//judged_people

      },
      rules: {
        workingNumber: [
          { required: true, message: '请输入对应分值', trigger: 'blur' },
          {
            pattern: /^(([1-9]{1}\d*)|(0{1}))(\.\d{1,2})?$/,
            message: "请输入合法的分值，最多两位小数",
            trigger: "blur"
          }
        ],
        name: [
          { required: true, message: '请输入活动名称', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        desc: [
          { required: true, message: '请填写活动形式', trigger: 'blur' }
        ]
      },
      tableData: [{
        hireDate: '2016-05-02',
        username: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      },],
      search: ''
    }
  },
  methods: {
    handleCurrentChange (e) {
      if (isNaN(parseInt(e))) {
        e = 1
      }
      let key = this.keyword
      let fd = new FormData()
      this.currentPage = e
      this.pageNo = this.currentPage
      console.log(typeof (e));
      console.log(parseInt(e));
      fd.append('keyWord', key)
      fd.append('pageNo', parseInt(e))
      fd.append('pageSize', 10)
      exNow(fd).then(success => {
        if (success.data.status === 200) {
          this.$message.success(success.data.message)
          console.log('test员工', success.data.data)
          this.tableData = success.data.data

        } else {
          this.$message.error(success.data.message)
        }
      }).catch(error => {
        // this.$message.error('出错了，请联系管理员');
      })


    },
    onSubmit (row) {
      let fd = new FormData()
      fd.append('id', row.id)
      fd.append('username', row.username)
      fd.append('email', row.email)
      fd.append('gender', row.gender)
      fd.append('department', row.department)
      exUp(fd).then(success => {
        if (success.data.status === 200) {
          this.$message.success(success.data.message)
          console.log('test客户' + success.data.data)


        } else {
          this.$message.error(success.data.message)

        }
      }).catch(error => {
        // this.$message.error('出错了，请联系管理员');
      })


    },
    handleEdit (index, row) {
      console.log(row.username);

      let nowDate = new Date();
      let date = {
        year: nowDate.getFullYear(),
        month: nowDate.getMonth() + 1,
        date: nowDate.getDate(),
      }
      console.log(date);
      let systemDate = date.year + '-' + (date.month >= 10 ? date.month : '0' + date.month) + '-' + (date.date >= 10 ? date.date : '0' + date.date);



      let fd = new FormData()
      fd.append('judged_people', row.username)
      fd.append('judge_time', systemDate)

      exCheck(fd).then((success) => {
        if (success.data.status === 200) {

          // this.$message.success(success.data.message);
          console.log('获取考核信息', success.data.message, success.data.data);
          if (success.data.data.performance == 0) {
            this.exForm.judged_people = row.username
            this.exStatus = false
          } else {
            this.exStatus = true
            this.exForm = success.data.data
            // performance
          }

        } else {
          this.$message.info(success.data.message);
        }
        // console.log("jljklhklh" + this.ruleForm.username);
      }).catch(error => {
        this.$message.error('出错了，请联系管理员');

      })







    },
    handleDelete (index, row) {
      // console.log(index, row);
      this.$confirm('此操作将移除该员工, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let fd = new FormData()
        fd.append('id', row.id);
        employeeDel(fd).then((success) => {
          if (success.data.status === 200) {

            this.$message.success(success.data.message);
            console.log('删除', success.data.message);
            this.tableData.splice(index, 1)
            // this.tableData = success.data.data
            this.$message({
              type: 'success',
              message: '移除员工' + row.username + '成功!'
            });
          } else {
            this.$message.info(success.data.message);
          }
          // console.log("jljklhklh" + this.ruleForm.username);
        }).catch(error => {
          // this.$message.error('出错了，请联系管理员');

        })



      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消移除操作'
        });
      });

    },
    getExData () {

    },
    resetDateFilter () {
      this.$refs.filterTable.clearFilter('date');
    },
    clearFilter () {
      this.$refs.filterTable.clearFilter();
    },
    formatter (row, column) {
      return row.address;
    },
    filterTag (value, row) {
      return row.tag === value;
    },
    filterHandler (value, row, column) {
      const property = column['property'];
      return row[property] === value;
    },
    submitForm (formName) {

      this.$refs[formName].validate((valid) => {
        if (valid) {

          let fd = new FormData();

          //  working_ability: '',
          //   working_atitude: '',
          //   environmental_behavior: '',
          //   discipline: '',
          //   bonus_point: '',
          //   deduct_point: '',
          //   judge_time: '',//judge_time
          //   juage_people: window.sessionStorage.getItem("username"),//juage_people,
          //   judged_people: '',//judged_people
          fd.append('working_ability', this.exForm.working_ability);
          fd.append('working_atitude', this.exForm.working_atitude);
          fd.append('environmental_behavior', this.exForm.environmental_behavior);
          fd.append('discipline', this.exForm.discipline);
          fd.append('bonus_point', this.exForm.bonus_point);
          fd.append('deduct_point', this.exForm.deduct_point);
          fd.append('judge_time', this.exForm.judge_time);
          fd.append('juage_people', this.exForm.juage_people);
          fd.append('judged_people', this.exForm.judged_people);

          exAdd(fd).then((success) => {
            if (success.data.status === 200) {

              // this.$message.success(success.data.message);
              console.log('考核', success.data.message);
              this.$message.success(success.data.message);
              this.$refs.exForm.clearFilter('date');
              this.exForm = ''
              // this.tableData = success.data.data
            } else {
              this.$message.info(success.data.message);
            }
            // console.log("jljklhklh" + this.ruleForm.username);
          }).catch(error => {
            // this.$message.error('出错了，请联系管理员');

          })





          // alert('submit!');
        } else {
          console.log('错误提交');
          return false;
        }
      });
    },
    resetForm () {
      this.$refs.exForm.resetFields();
    },

  },
}
</script>

<style>
</style>