<template>
  <div style="width:100%;height:inherit;">
    <!-- <h2>添加客户</h2> -->
    <div class="add">
      <el-card style="width:50%;margin-right:10px;flex:1">
        <AddPage></AddPage>
      </el-card>
      <div style="height:875px">
        <el-card style="flex:1;margin-bottom:10px">

          <img src="../../assets/aa.png"
               style="width:180px;margin-left:180px" />
        </el-card>
        <el-card style="flex:1">
          <StarCus></StarCus>
          <!-- {{userName}} -->
        </el-card>
      </div>

    </div>

    <el-card style="width:100%;height:auto;border-radius: 10px;">
      <h1 style="margin-left:10px">客户管理</h1>

      <el-input placeholder="请输入关键字"
                prefix-icon="el-icon-search"
                v-model="keyword"
                class="search_input unit">

      </el-input>
      <el-button @click="search"
                 icon="el-icon-search"></el-button>
      <el-button @click="clearFilter"
                 style="margin-bottom:10px">清除所有过滤器</el-button>
      <el-table :data.sync="tableData"
                border
                ref="filterTable"
                class="unit"
                style="width: 100%;height:auto">
        <el-table-column fixed
                         sortable
                         prop="inputTime"
                         label="交接时间">
        </el-table-column>
        <el-table-column prop="id"
                         label="ID"
                         width="60px">
        </el-table-column>
        <el-table-column prop="username"
                         label="姓名"
                         width="80px">
        </el-table-column>
        <el-table-column prop="area"
                         label="地区"
                         width="">
        </el-table-column>
        <el-table-column prop="job"
                         label="行业"
                         width="80px">
        </el-table-column>

        <el-table-column prop="email"
                         label="邮箱"
                         width="200px">
          <el-input v-if="edit===true"
                    type="text"></el-input>
        </el-table-column>

        <el-table-column prop="inputUser"
                         label="交接员工"
                         width="130px">
        </el-table-column>
        <!-- <el-table-column prop="source"
                         label="来源"
                         width="">
        </el-table-column> -->
        <el-table-column prop="status"
                         label="客户状态"
                         width=""
                         :filters="[{ text: '正式客户', value: '正式客户' }, 
                         { text: '流失', value: '流失' },
                         { text: '潜在客户', value: '潜在客户' },
                         { text: '资源池客户', value: '资源池客户' },
                         { text: '开发失败', value: '开发失败' }]"
                         :filter-method="filterTag"
                         filter-placement="bottom-end">
          <template slot-scope="scope">
            <el-tag :type="scope.row.status === '正式客户' ? 'success' : 'primary'"
                    disable-transitions
                    style="width:100px">{{scope.row.status}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column fixed="right"
                         label="操作"
                         width="">
          <template slot-scope="scope">

            <el-button @click="handleClick(scope.$index, scope.row)"
                       type="text"
                       size="small">编辑</el-button>

            <el-button @click="handleDel(scope.$index, scope.row)"
                       type="text"
                       size="small">删除</el-button>

          </template>
          <!-- 
          <el-button type="text"
                     @click="dialogFormVisible = true">打开嵌套表单的 Dialog</el-button> -->

        </el-table-column>
      </el-table>

      <el-dialog title="修改客户信息"
                 :visible.sync="dialogFormVisible"
                 style="">
        <el-form>
          <el-form-item label="客户名称"
                        prop="username">
            <el-input style="width:80%"
                      v-model="customerForm.username"></el-input>
          </el-form-item>
          <el-form-item label="客户邮箱"
                        prop="email">
            <el-input v-model="customerForm.email"
                      style="width:80%"></el-input>
          </el-form-item>
          <el-form-item label="交接员工"
                        prop="seller">
            <el-input v-model="customerForm.seller"
                      style="width:80%"></el-input>
          </el-form-item>
          <el-form-item label="客户行业"
                        prop="job">
            <el-select v-model="customerForm.job"
                       placeholder="请选择客户所属行业"
                       style="width:80%">
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
                        prop="area"
                        style="width:80%">
            <el-cascader v-model="customerForm.area"
                         :options="options"></el-cascader>
          </el-form-item>
          <el-form-item label="客户状态"
                        prop="status"
                        style="width:80%">
            <el-select v-model="customerForm.status"
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

          <el-form-item label="星标客户"
                        prop="star">
            <el-switch v-model="customerForm.star"></el-switch>
          </el-form-item>

          <el-form-item label="备注"
                        prop=""
                        style="width:">
            <el-input type="textarea"
                      v-model="customerForm.desc"
                      rows="5"></el-input>
          </el-form-item>

        </el-form>

        <div slot="footer"
             class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary"
                     @click="update">确 定</el-button>
        </div>
      </el-dialog>

      <el-pagination class="bottom"
                     background
                     @current-change="handleCurrentChange"
                     :current-page="currentPage"
                     layout="prev, pager, next"
                     :total="total">
      </el-pagination>
    </el-card>
  </div>
</template>

<script>
import AddPage from '@/pages/Customer/addCustomer.vue'
import StarCus from '@/pages/Customer/StarCustomer.vue'
import Calendar from '@/components/Calendar.vue'

import { userSeach, userDel, userUp, userNum } from "@/api/user";
export default {
  created () {

    //获取页码
    userNum({}).then((success) => {
      if (success.data.status === 200) {

        // this.$message.success(success.data.message);
        // dialogFormVisible = false
        this.total = success.data.data

        console.log('页码', data);

      } else {
        this.$message.info(success.data.message);
      }
      // console.log("jljklhklh" + this.ruleForm.username);
    }).catch(error => {
      // this.$message.error('出错了，请联系管理员');

    }),


      this.handleCurrentChange()



  },
  computed: {
    //获取页码

  },
  methods: {
    update () {
      let fd = new FormData()
      fd.append('username', this.customerForm.username);
      fd.append('email', this.customerForm.email);
      fd.append('job', this.customerForm.job);
      fd.append('status', this.customerForm.status);
      fd.append('source', this.customerForm.source);
      fd.append('area', this.customerForm.area[0] + '-' + this.customerForm.area[1]);
      fd.append('star', this.customerForm.star);
      // fd.append('inputTime', this.customerForm.value1);
      fd.append('seller', this.customerForm.seller);
      userUp(fd).then((success) => {
        if (success.data.status === 200) {

          this.$message.success(success.data.message);
          this.dialogFormVisible = false
        } else {
          this.$message.info(success.data.message);
        }
        // console.log("jljklhklh" + this.ruleForm.username);
      }).catch(error => {
        console.log(error);
        this.$message.error(error.message);

      })


      // fd.append('seller', this.current);
    },
    handleDel (index, row) {
      console.log(row);
      let fd = new FormData()
      fd.append('id', row.id)
      console.log('aaaaa', row.id);

      this.$confirm('此操作将移除该客户, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        userDel(fd).then((success) => {
          if (success.data.status === 200) {

            this.$message.success(success.data.message);
            this.$forceUpdate()
            this.tableData.splice(index, 1)
            // this.resetForm()
          } else {
            this.$message.info(success.data.message);
          }
          // console.log("jljklhklh" + this.ruleForm.username);
        }).catch(error => {
          this.$message.error('出错了，请联系管理员 ');

        })


        this.$message({
          type: 'success',
          message: '移除' + row.username + '成功!'
        });

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消移除操作'
        });
      });

    },
    search (e) {
      this.currentPage = parseInt(e)
      console.log(e);
      let key = this.keyword
      let fd = new FormData()
      fd.append('keyword', key)
      fd.append('pageNo', 1)
      fd.append('pageSize', 10)
      userSeach(fd).then(success => {
        if (success.data.status === 200) {
          this.$message.success(success.data.message)
          console.log('test客户' + success.data.data)
          this.tableData = success.data.data
          this.currentPage = 1
        } else {
          this.$message.error(success.data.message)

        }
      }).catch(error => {
        this.$message.error('出错了，请联系管理员');
      })

    },

    //编辑选中行
    handleClick (index, row) {
      console.log(row);
      // this.currentItem = row;
      // row.edit = true
      this.customerForm = row
      this.dialogFormVisible = true
      // this.customerForm.username = row.username
      // this.customerForm.area = row.area
      // this.customerForm.status = row.status
      // this.customerForm.job = row.job
      // this.customerForm.source = row.source
      // this.customerForm.desc = row.desc
      // this.customerForm.email = row.email
      // this.customerForm.seller = row.seller
      // this.customerForm.star = row.star
      // this.customerForm.area = row.username,

    },
    resetDateFilter () {
      this.$refs.filterTable.clearFilter('date');
    },
    clearFilter () {
      this.$refs.filterTable.clearFilter();
    },
    filterTag (value, row) {
      return row.status === value;
    },
    filterHandler (value, row, column) {
      const property = column['property'];
      return row[property] === value;
    },
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
      userSeach(fd).then(success => {
        if (success.data.status === 200) {
          this.$message.success(success.data.message)
          console.log('test客户', success.data.data)
          this.tableData = success.data.data

        } else {
          this.$message.error(success.data.message)
        }
      }).catch(error => {
        this.$message.error('出错了，请联系管理员');
      })
    },
    cancelForm () {
      this.loading = false;
      this.dialog = false;
      clearTimeout(this.timer);
    }


  },
  components: { Calendar, AddPage, StarCus },
  data () {
    return {
      total: 100,
      dialogVisible: false,
      visible: false,
      currentPage: 1,
      keyword: '',
      pageNo: 1,

      tableData: [{
        id: 1,
        username: 'test1',
        seller: 'sss',
        star: true
      },
      {
        username: 'test2'
      }],
      table: false,
      dialog: false,
      loading: false,
      edit: false,
      formLabelWidth: '80px',
      timer: null,
      dialogTableVisible: false,
      dialogFormVisible: false,
      customerForm: {
        username: '',
        area: '',
        job: '',
        source: '',
        desc: '',
        email: '',
        status: '',
        star: false,
        value1: '',
        input_name: '',
        seller: '',
      },
      formLabelWidth: '120px',
      rules: {
        username: [
          { required: true, message: '请输入客户名称', trigger: 'blur' },
          { min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur' }
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
    }
  }
}
</script>

<style>
.unit {
  margin-bottom: 10px;
}
.tag {
  margin-right: 10px;
}
.bottom {
  /* position: absolute; */
  margin-top: 6px;
  margin-left: 30%;
}
.add {
  margin-bottom: 10px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}
</style>