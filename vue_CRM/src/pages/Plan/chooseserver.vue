<template>
  <div>
    <el-alert :title="'选择服务：'+choosed"
              type="warning">
    </el-alert>
    <el-table ref="tableData"
              :data="tableData"
              highlight-current-row
              @row-click="choose"
              @current-change="handleCurrentChange"
              style="width: 100%">
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
    </el-table>
    <div style="margin-top: 20px">
      <el-button style="margin-left:90%"
                 type="text"
                 @click="setCurrent">取消选择</el-button>
    </div>
  </div>

</template>

<script>
import { serverList, } from "@/api/server";
export default {
  data () {
    return {
      choosed: '未选择',
      tableData: [{
        trace_id: 111111,
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, ],
      currentRow: null
    }
  },

  methods: {
    setCurrent (row) {
      this.$refs.tableData.setCurrentRow(row);
    },
    handleCurrentChange (val) {
      this.currentRow = val;
      this.choosed = '未选择'
    },
    choose (item) {

      //获取服务id
      console.log(item.trace_id);
      this.choosed = item.trace_id
      this.$emit('choose', this.choosed)

    }
  },
  created () {
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
  }
}
</script>

<style>
</style>