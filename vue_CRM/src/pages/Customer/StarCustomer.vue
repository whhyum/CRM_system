<template>
  <div>
    
    <div style="width:auto">

      <h2 style="margin-left:10px">星标客户</h2>
      <el-table :data="tableData"
                stripe
                style="width: 120%">
        <!-- <el-table-column prop="inputTime"
                       label="日期"
                       width="200">
      </el-table-column> -->
        <el-table-column prop="username"
                         label="姓名"
                         width="100">
        </el-table-column>
        <el-table-column prop="job"
                         label="行业"
                         width="100">
        </el-table-column>
        <el-table-column prop="status"
                         label="客户状态"
                         width="120">
        </el-table-column>
        <el-table-column prop="area"
                         label="地区"
                         width="120">
        </el-table-column>
        <el-table-column prop="inputUser"
                         label="交接员工"
                         width="120">
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import { userStar } from "@/api/user";
export default {
  created () {
    console.log(this.$store.state.user.username);
    userStar().then((success) => {
      if (success.data.status === 200) {
        this.$message.success('更新列表成功');
        console.log(success.data.data);
        this.tableData = success.data.data
      } else {
        this.$message.error(success.data.message);
      }
    }).catch(error => {
      this.$message.error('出错了，请联系管理员');
    })

  },
  data () {
    return {
      tableData: [],
    }
  },
  methods: {

  }
}
</script>

<style>
</style>