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
        <!-- zzzzzzzzzzz -->

      </el-card>
    </div>

  </div>
</template>


<script>
import ChartLine from '../../components/echart/chartLint.vue'
import pierose from '../../components/echart/pierose.vue'
import linestack from '../../components/echart/linestack.vue'

export default {
  data () {
    return {
      name: '张雪',
      xData: ['2020-02', '2020-03', '2020-04', '2020-05'],
      yData: [30.25, 132, 80, 134],
      optionbar: {
        title: {
          // text: 'ECharts 数据统计'
        },
        tooltip: {},
        legend: {
          data: ['用户来源']
        },
        xAxis: {
          data: ["Android", "IOS", "PC", "Ohter", "tesr"]
        },
        yAxis: {

        },
        series: [{
          name: '访问量',
          type: 'bar', //设置图表主题
          data: [500, 200, 360, 100, 200]
        }]
      }


    }
  },
  mounted () {
    this.drawLine()
  },
  components: {
    ChartLine, pierose, linestack
  },
  methods: {
    drawLine: function () {
      //基于准本好的DOM，初始化echarts实例
      // let chartmainline = this.$echarts.init(document.getElementById("chartmainline"));
      // let chartmainbar = this.$echarts.init(document.getElementById("chartmainbar"));
      let chartmainbar = this.$echarts.init(this.$refs.chartmainbar);
      const { name, xData, yData } = this
      console.log(this.$refs)
      this.$refs.chart_line_one.initChart(name, xData, yData)
      //绘制图表
      // chartmainline.setOption(this.optionline);
      console.log(this.$refs)
      chartmainbar.setOption(this.optionbar);
    }
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