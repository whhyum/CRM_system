<template>
  <div>
    <div style="display:flex;flex-direction:row;flex-wrap:wrap">
      <el-card style="margin-right: 30px;width:550px">
        <h1>销售分析</h1>
        <div class="analysisTask">
          <ChartLine style="width:500px;height:400px"
                     ref="chart_line_one" />
        </div>
      </el-card>
      <el-card style="width:auto">
        <h1>业绩排行</h1>
        <div class="">
          <div id="chartmainbar"
               ref="chartmainbar"
               style="width:500px; height:400px;"></div>

        </div>
      </el-card>
      <el-card style="margin-right: 30px;margin-top:20px;">
        <h1>客户差异化分析</h1>
        <div class="">
          <pierose style="width:400px;height:400px"></pierose>

        </div>
      </el-card>
      <el-card style="margin-right: 30px;margin-top:20px;">
        <h1>趋势分析</h1>
        <linestack style="width:620px;height:400px"></linestack>
      </el-card>
      <!-- <el-card style="margin-right: 30px;margin-top:20px;width:100%">
        <template>
          <el-table ref="multipleTable"
                    :data="tableData"
                    tooltip-effect="dark"
                    style="width: 100%"
                    @selection-change="handleSelectionChange">
            <el-table-column type="selection"
                             width="55">
            </el-table-column>
            <el-table-column label="日期"
                             width="120">
              <template slot-scope="scope">{{ scope.row.date }}</template>
            </el-table-column>
            <el-table-column prop="name"
                             label="姓名"
                             width="120">
            </el-table-column>
            <el-table-column prop="address"
                             label="地址"
                             show-overflow-tooltip>
            </el-table-column>
          </el-table>
          <div style="margin-top: 20px">
            <el-button @click="toggleSelection([tableData[1], tableData[2]])">切换第二、第三行的选中状态</el-button>
            <el-button @click="toggleSelection()">取消选择</el-button>
          </div>
        </template>
      </el-card> -->
    </div>

  </div>
</template>


<script>
import ChartLine from '../../components/echart/chartLint.vue'
import pierose from '../../components/echart/pierose.vue'
import linestack from '../../components/echart/linestack.vue'
import { getMoneyData, getJudgeData, getJobData, getJobMoneyData } from "@/api/chart";
export default {
  created () {
    this.getData()
  },
  mounted () {


    // this.drawLine()

  },
  data () {
    return {
      xd: '',
      yd: '',
      name: '张雪',
      xData: ['2020-02', '2020-03', '2020-04', '2020-05'],
      yData: [30.25, 132, 80, 134],

      //
      optionbar: {
        title: {
          // text: 'ECharts 数据统计'
        },
        tooltip: {},
        legend: {
          data: ['业绩排行']
        },
        xAxis: {
          data: ["1", "2", "3", "4", "5"]
        },
        yAxis: {
          // data: [500, 200, 360, 100, 200]
        },
        series: [{
          name: '业绩',
          type: 'bar', //设置图表主题
          data: [500, 200, 360, 100, 200]
        }]
      },

      tableData: [{
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      },],
      multipleSelection: [],

    }
  },
  components: {
    ChartLine, pierose, linestack
  },
  methods: {
    getData () {
      getJudgeData().then((success) => {
        if (success.data.status === 200) {

          this.optionbar.xAxis.data = success.data.data.xData
          this.optionbar.series[0].data = success.data.data.yData
          // success.data.data.yData
          // this.optionbar.legend.data = success.data.data.xData
          // this.xd = success.data.data.xData
          // this.yd = success.data.data.yData

          // console.log(success.data.data);
          console.log('初始化业绩yyy数据', this.optionbar.xAxis);
          console.log('初始化业绩yyy数据', this.optionbar.series[0]);
          this.drawLine()
          // this.drawLine()
        } else {
          this.$message.info(success.data.message);
        }
        // console.log("jljklhklh" + this.ruleForm.username);
      }).catch(error => {
        // this.$message.error('出错了，请联系管理员');

      })
    },
    drawLine () {
      //基于准本好的DOM，初始化echarts实例
      // let chartmainline = this.$echarts.init(document.getElementById("chartmainline"));
      // let chartmainbar = this.$echarts.init(document.getElementById("chartmainbar"));


      // setTimeout(() => {
      console.log('画图', this.optionbar);
      // this.$refs.chartmainbar.clear();
      var chartmainbar = this.$echarts.init(this.$refs.chartmainbar);

      // this.getData()


      chartmainbar.setOption(this.optionbar, true);
      // }, 10);




    },
    handleSelectionChange (val) {
      this.multipleSelection = val;
      // this.$refs.multipleSelection = 
      console.log(this.multipleSelection);
    },
    toggleSelection (rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
  }

}
</script>

<style>
.analysisTask {
  width: 600px;
  height: 300px;
}
card {
  border-radius: 30px;
}
</style>