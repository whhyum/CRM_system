<template>
  <div style="display:flex;flex-direction:row;width:auto;">

    <div>
      <h1>新增服务记录</h1>
      <addServer style="width:500px"></addServer>
    </div>
    <div style="margin-left:30px">
      <el-card style="border-radius:10px;height:auto；padding-left:20px;width:50vw">
        <h1>客户状态</h1>
        <div style="display:flex;flex-direction:column;text-align:center;width:auto;margin-left：20px">
          <div style="display:flex;margin-bottom:10px">
            <span>&nbsp;&nbsp;&nbsp;潜在客户</span>
            <el-progress :text-inside="true"
                         :stroke-width="24"
                         style="margin-left:20px;width:60%"
                         :percentage="userType.潜在客户"></el-progress>
          </div>
          <div style="display:flex;margin-bottom:10px">
            <span>&nbsp;&nbsp;&nbsp;正式客户</span>
            <el-progress :text-inside="true"
                         :stroke-width="24"
                         style="margin-left:20px;width:60%"
                         :percentage="userType.正式客户"
                         status="success"></el-progress>
          </div>
          <div style="display:flex;margin-bottom:10px">
            <span>&nbsp;&nbsp;&nbsp;流失客户</span>
            <el-progress :text-inside="true"
                         :stroke-width="24"
                         style="margin-left:20px;width:60%"
                         :percentage="userType.流失"
                         status="warning"></el-progress>
          </div>

          <div style="display:flex;margin-bottom:10px">资源池客户
            <el-progress :text-inside="true"
                         :stroke-width="24"
                         style="margin-left:20px;width:60%"
                         :percentage="userType.资源池客户"
                         status="exception"></el-progress>
          </div>
          <div style="display:flex;margin-bottom:10px">&nbsp;&nbsp;&nbsp;开发失败
            <el-progress :text-inside="true"
                         :stroke-width="24"
                         style="margin-left:20px;width:60%"
                         :percentage="userType.开发失败"
                         status="exception"></el-progress>
          </div>

        </div>

      </el-card>
      <el-divider>

      </el-divider>

      <template style="margin-top:30px">
        <h1>服务管理</h1>
        <!-- <el-button style="
                margin-top:20px"
                @click="clearFilter">清除所有过滤器</el-button> -->
        <el-table :data="tableData.filter(data => !search || data.customerName.toLowerCase().includes(search.toLowerCase()))"
                  style="width: 90%;">

          <el-table-column prop="traceTime"
                           label="日期"
                           sortable
                           width="150"
                           column-key="date">
          </el-table-column>
          <el-table-column label="客户名称"
                           prop="customerName">
          </el-table-column>
          <el-table-column label="客户类型"
                           prop="status">
          </el-table-column>
          <el-table-column label="服务类型"
                           prop="type">
          </el-table-column>
          <el-table-column label="服务内容"
                           prop="traceDetails">
          </el-table-column>

          <el-table-column align="right"
                           width="150">
            <template slot="header"
                      slot-scope="scope">
              <el-input v-model="search"
                        size="mini"
                        placeholder="输入关键字搜索" />
            </template>
            <template slot-scope="scope"
                      style="width:500px"
                      width="300">

              <el-button size="mini"
                         @click="seeMore(scope.$index, scope.row)">查看</el-button>

              <el-button size="mini"
                         @click="handleDelete(scope.$index, scope.row)">删除</el-button>

              <!-- <el-button size="mini"
                         type="danger"
                         @click="handleDelete(scope.$index, scope.row)">Delete</el-button> -->
            </template>
          </el-table-column>

        </el-table>
        <div class=""
             style="width:auto;text-align:center;margin-top:10px">
          <!-- <span class="demonstration"></span> -->
          <el-pagination layout="prev, pager, next"
                         :total="total"
                         @current-change="handleCurrentChange"
                         :current-page.sync="currentPage"
                         :page-size="10">
          </el-pagination>
          <!-- <el-pagination @current-change="handleCurrentChange"
                         :current-page.sync="currentPage"
                         :page-size="100"
                         layout="total, prev, pager, next"
                         :total="total">
          </el-pagination> -->
        </div>
      </template>
    </div>
  </div>
</template>

<script>
import { serverAdd, serverDel, serverUp, serverList, serverNum, serverStatus, num } from "@/api/server";
import addServer from './addServer.vue'
export default {
  components: { addServer },
  data () {
    return {
      userType: '',//客户分类
      customerNum: 1,
      total: 1,
      visible: false,
      currentPage: 1,
      dialogTableVisible: false,
      dialogFormVisible: false,
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
      formLabelWidth: '120px',
      tableData: [{
        customerName: 'test',
      }, {
        customerName: '王小虎',
      }],
      search: ''
    }
  },
  created () {

    //全部页码！！！！！！！！！！


    //获取用户数量

    num({}).then((success) => {
      if (success.data.status == 200) {

        console.log('获取数量');
        this.total = success.data.data
        console.log('总', this.total);
        console.log(success);
        // console.log(success.data);
        console.log('总test', success.data.data);


      } else {
        this.$message.info(success.data.message);
      }
      // console.log("jljklhklh" + this.ruleForm.username);
    }).catch(error => {
      console.log('获取数量失败');

    })
    serverStatus().then((success) => {
      if (success.data.status === 200) {

        // this.$message.success(success.data.message);
        console.log('获取客户占比', success.data.message);

        this.userType = success.data.data

      } else {
        this.$message.info(success.data.message);
      }
      // console.log("jljklhklh" + this.ruleForm.username);
    }).catch(error => {
      console.log('出错了，请联系管理员');

    })


    this.handleCurrentChange()
    let fd = new FormData();
    fd.append('username', window.sessionStorage.getItem("username"));
    fd.append('role_id', window.sessionStorage.getItem("role_id"));
    fd.append('pageNo', 1);
    fd.append('pageSize', 10);
    serverList(fd).then((success) => {
      if (success.data.status === 200) {

        // this.$message.success(success.data.message);
        console.log('获取服务信息', success.data.message);
        this.tableData = success.data.data
      } else {
        this.$message.info(success.data.message);
      }
      // console.log("jljklhklh" + this.ruleForm.username);
    }).catch(error => {
      this.$message.error('出错了，请联系管理员');

    })


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
      fd.append('username', window.sessionStorage.getItem("username"));
      fd.append('role_id', window.sessionStorage.getItem("role_id"));

      fd.append('keyWord', key)
      fd.append('pageNo', parseInt(e))
      fd.append('pageSize', 10)
      serverList(fd).then(success => {
        if (success.data.status === 200) {
          // this.$message.success(success.data.message)

          console.log('test客户', success.data.data)

          this.tableData = success.data.data.records

        } else {
          this.$message.error(success.data.message)
        }
      }).catch(error => {
        this.$message.error('出错了，请联系管理员');
      })
    },
    handleEdit (index, row) {
      console.log(index, row);
    },
    handleDelete (index, row) {
      let that = this
      let fd = new FormData()
      fd.append('id', row.id)
      console.log('111', this.tableData);
      this.$confirm('此操作将删除该服务记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        serverDel(fd).then((success) => {
          if (success.data.status === 200) {

            this.$message.success(success.data.message);
            // this.resetForm()
            console.log('xiabiao', index);
            console.log(that.tableData);
            that.tableData.splice(index, 1)


          } else {
            this.$message.info(success.data.message);
          }
          // console.log("jljklhklh" + this.ruleForm.username);
        }).catch(error => {
          this.$message.error('出错了，请联系管理员');
          console.log(that.tableData);

        })



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
    seeMore (index, row) {
      this.$router.push({
        path: '/index/seeMore',
        query: {
          //服务id
          serverId: row.id,
          data: row,
          tag: 1
        }
      })
    }
  }//method
}
</script>

<style>
</style>