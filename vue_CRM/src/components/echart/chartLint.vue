<template>
  <div class="echart"
       id="echart-line"
       :style="{float:'left',width: '100%', height: '230px'}"></div>
</template>

<script>
import { getMoneyData, getJudgeData, getJobData, getJobMoneyData } from "@/api/chart";
// import echarts from "echarts";

export default {
  created () {
    getMoneyData().then((success) => {
      if (success.data.status === 200) {

        this.$message.success(success.data.message);

        this.name = '企业绩效'
        this.xData = success.data.data.xData
        this.yData = success.data.data.yData
        // let chartmainbar = this.$echarts.init(this.$refs.chartmainbar);
        // const { name, xData, yData } = this
        // console.log(this.$refs)
        const { name, xData, yData } = this
        console.log('jixiaochax', success.data.data);
        console.log('我在更新', this.name);
        this.initChart(name, xData, yData)
        // this.$refs.chart_line_one.initChart(name, xData, yData)
      } else {
        this.$message.info(success.data.message);
      }
      // console.log("jljklhklh" + this.ruleForm.username);
    }).catch(error => {
      this.$message.error('出错了，请联系管理员: ' + error.response.status);

    })

  },

  methods: {

    initChart (name, xData, yData) {

      let getchart = this.$echarts.init(document.getElementById('echart-line'));
      var option = {

        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: [name],
          bottom: '0%'
        },
        grid: { //调整图表上下左右位置
          top: '10%',
          left: '3%',
          right: '8%',
          bottom: '11%',
          containLabel: true
        },

        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: xData
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: name,
            type: 'line',
            stack: '总量',
            data: yData
          },
        ],
        name: '',
        xData: '',
        yData: '',
      };

      getchart.setOption(option);
      //随着屏幕大小调节图表
      window.addEventListener("resize", () => {
        getchart.resize();
      });
    },

  },
  mounted () {
    this.initChart()
  }

}
</script>
