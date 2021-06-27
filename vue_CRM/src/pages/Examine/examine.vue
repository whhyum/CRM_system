<template>
  <el-card>
    <div style="display:flex;flex-direction:row;">
      <div style="display:flex;flex-direction:column;padding-right:10px;width:800px;height:auto">
        <!-- 员工列表 -->
        <h1>员工列表</h1>
        <el-table :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))">
          <el-table-column type="expand">
            <template slot-scope="props">
              <el-form label-position="left"
                       inline
                       class="demo-table-expand">
                <el-form-item label="员工姓名">
                  <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="所属部门">
                  <el-input v-model="props.row.name"></el-input>
                </el-form-item>
                <el-form-item label="活动名称">
                  <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="商品名称">

                  <span>{{ props.row.name }}</span>
                </el-form-item>
                <el-form-item label="所属店铺">
                  <span>{{ props.row.shop }}</span>
                </el-form-item>
                <el-form-item label="商品 ID">
                  <span>{{ props.row.id }}</span>
                </el-form-item>
                <el-form-item label="店铺 ID">
                  <span>{{ props.row.shopId }}</span>
                </el-form-item>
                <el-form-item label="商品分类">
                  <span>{{ props.row.category }}</span>
                </el-form-item>
                <el-form-item label="店铺地址">
                  <span>{{ props.row.address }}</span>
                </el-form-item>
                <el-form-item label="商品描述">
                  <span>{{ props.row.desc }}</span>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary"
                             @click="onSubmit">立即创建</el-button>
                  <el-button>取消</el-button>
                </el-form-item>
              </el-form>
            </template>
          </el-table-column>
          <el-table-column label="Date"
                           prop="date">
          </el-table-column>
          <el-table-column label="Name"
                           prop="name">
          </el-table-column>

          <el-table-column prop="tag"
                           label="标签"
                           width="100"
                           :filters="[{ text: '家', value: '家' }, { text: '公司', value: '公司' }]"
                           :filter-method="filterTag"
                           filter-placement="bottom-end">
            <template slot-scope="scope">
              <el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'"
                      disable-transitions>{{scope.row.tag}}</el-tag>
            </template>
          </el-table-column>

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
              <el-button size="mini"
                         type="danger"
                         @click="handleDelete(scope.$index, scope.row)">移除</el-button>
            </template>
          </el-table-column>

        </el-table>
        <div style="margin-top:10px;width:100%;text-align:center">

          <el-pagination background
                         layout="prev, pager, next"
                         :total="1000">
          </el-pagination>
        </div>

      </div>
      <el-card>
        <h1>考核表单</h1>1111
        <el-form :model="ruleForm"
                 :rules="rules"
                 ref="ruleForm"
                 label-width="100px"
                 class="demo-ruleForm">
          <el-form-item label="活动名称"
                        prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
          <el-form-item label="活动区域"
                        prop="region">
            <el-select v-model="ruleForm.region"
                       placeholder="请选择活动区域">
              <el-option label="区域一"
                         value="shanghai"></el-option>
              <el-option label="区域二"
                         value="beijing"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="活动时间"
                        required>
            <el-col :span="11">
              <el-form-item prop="date1">
                <el-date-picker type="date"
                                placeholder="选择日期"
                                v-model="ruleForm.date1"
                                style="width: 100%;"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col class="line"
                    :span="2">-</el-col>
            <el-col :span="11">
              <el-form-item prop="date2">
                <el-time-picker placeholder="选择时间"
                                v-model="ruleForm.date2"
                                style="width: 100%;"></el-time-picker>
              </el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item label="即时配送"
                        prop="delivery">
            <el-switch v-model="ruleForm.delivery"></el-switch>
          </el-form-item>
          <el-form-item label="活动性质"
                        prop="type">
            <el-checkbox-group v-model="ruleForm.type">
              <el-checkbox label="美食/餐厅线上活动"
                           name="type"></el-checkbox>
              <el-checkbox label="地推活动"
                           name="type"></el-checkbox>
              <el-checkbox label="线下主题活动"
                           name="type"></el-checkbox>
              <el-checkbox label="单纯品牌曝光"
                           name="type"></el-checkbox>
            </el-checkbox-group>
          </el-form-item>
          <el-form-item label="特殊资源"
                        prop="resource">
            <el-radio-group v-model="ruleForm.resource">
              <el-radio label="线上品牌商赞助"></el-radio>
              <el-radio label="线下场地免费"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="活动形式"
                        prop="desc">
            <el-input type="textarea"
                      v-model="ruleForm.desc"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary"
                       @click="submitForm('ruleForm')">立即创建</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </div>
  </el-card>
</template>

<script>
export default {
  data () {
    return {
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      ruleForm: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入活动名称', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        region: [
          { required: true, message: '请选择活动区域', trigger: 'change' }
        ],
        date1: [
          { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
        ],
        date2: [
          { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
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
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1517 弄'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1519 弄'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1516 弄'
      }],
      search: ''
    }
  },
  methods: {
    handleEdit (index, row) {
      console.log(row.name);
      console.log(this.$refs.ruleForm);
      console.log(this.$refs.ruleForm.name);
      this.ruleForm.name = row.name
    },
    handleDelete (index, row) {
      // console.log(index, row);
      this.$confirm('此操作将移除该员工, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '移除员工' + row.name + '成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消移除操作'
        });
      });

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
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm (formName) {
      this.$refs[formName].resetFields();
    }

  },
}
</script>

<style>
</style>