<template>
  <div>
    <el-alert :title="'选择服务：'+choosed"
              type="warning">
    </el-alert>
    <el-table ref="singleTable"
              :data="tableData"
              highlight-current-row
              @row-click="choose"
              @current-change="handleCurrentChange"
              style="width: 100%">
      <el-table-column type="index"
                       width="50">
      </el-table-column>
      <el-table-column property="date"
                       label="日期"
                       width="120">
      </el-table-column>
      <el-table-column property="name"
                       label="姓名"
                       width="120">
      </el-table-column>
      <el-table-column property="address"
                       label="地址">
      </el-table-column>
    </el-table>
    <div style="margin-top: 20px">
      <el-button style="margin-left:90%"
                 type="text"
                 @click="setCurrent()">取消选择</el-button>
    </div>
  </div>

</template>

<script>
export default {
  data () {
    return {
      choosed: '未选择',
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
      currentRow: null
    }
  },

  methods: {
    setCurrent (row) {
      this.$refs.singleTable.setCurrentRow(row);
    },
    handleCurrentChange (val) {
      this.currentRow = val;
      this.choosed = '未选择'
    },
    choose (item) {
      console.log(item.name);
      this.choosed = item.name
      this.$emit('choose', this.choosed)
    }
  }
}
</script>

<style>
</style>