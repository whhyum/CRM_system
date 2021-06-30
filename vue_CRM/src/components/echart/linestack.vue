<template>
  <div class="echart"
       ref="linestack"
       :style="{float:'center','width':'100%','text-align':'center'}"></div>
</template>

<script>
import { getMoneyData, getJudgeData, getJobData, getJobMoneyData } from "@/api/chart";
export default {
  created () {
    getJobMoneyData().then((success) => {
      if (success.data.status === 200) {
        console.log('zuihouzuihou', this.option);
        console.log(success.data.data);
        this.option.legend.data = success.data.data.leg
        this.option.xAxis.data = success.data.data.xData
        this.option.series = success.data.data.yData
        console.log('debug', success.data.data.yData);
        console.log('zuihouzuihou', this.option);
        this.initChart()

      } else {
        this.$message.info(success.data.message);
      }
      // console.log("jljklhklh" + this.ruleForm.username);
    }).catch(error => {
      this.$message.error('出错了，请联系管理员: ' + error.response.status);

    })
  },
  methods: {

    initChart (data) {

      let getchart = this.$echarts.init(this.$refs.linestack);
      // var option = {
      //   title: {
      //     // text: '折线图堆叠'
      //   },
      //   tooltip: {
      //     trigger: 'axis'
      //   },
      //   legend: {
      //     data: ['邮件营销', '联盟广告', '视频广告', '直接访问', '搜索引擎']
      //   },
      //   grid: {
      //     left: '3%',
      //     right: '4%',
      //     bottom: '3%',
      //     containLabel: true
      //   },
      //   toolbox: {
      //     feature: {
      //       saveAsImage: {}
      //     }
      //   },
      //   xAxis: {
      //     type: 'category',
      //     boundaryGap: false,
      //     data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
      //   },
      //   yAxis: {
      //     type: 'value'
      //   },
      //   series: [
      //     {
      //       name: '邮件营销',
      //       type: 'line',
      //       stack: '总量',
      //       data: [120, 132, 101, 134, 90, 230, 210]
      //     },
      //     {
      //       name: '联盟广告',
      //       type: 'line',
      //       stack: '总量',
      //       data: [220, 182, 191, 234, 290, 330, 310]
      //     },
      //     {
      //       name: '视频广告',
      //       type: 'line',
      //       stack: '总量',
      //       data: [150, 232, 201, 154, 190, 330, 410]
      //     },
      //     {
      //       name: '直接访问',
      //       type: 'line',
      //       stack: '总量',
      //       data: [320, 332, 301, 334, 390, 330, 320]
      //     },
      //     {
      //       name: '搜索引擎',
      //       type: 'line',
      //       stack: '总量',
      //       data: [820, 932, 901, 934, 1290, 1330, 1320]
      //     }
      //   ]
      // };
      getchart.setOption(this.option);
      //随着屏幕大小调节图表
      window.addEventListener("resize", () => {
        getchart.resize();
      });
    },

  },
  mounted () {
    this.initChart()
  },
  data () {
    return {
      option: {
        title: {
          // text: '折线图堆叠'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['邮件营销', '联盟广告', '视频广告', '直接访问', '搜索引擎']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '邮件营销',
            type: 'line',
            stack: '总量',
            data: [120, 132, 101, 134, 90, 230, 210]
          },
          {
            name: '联盟广告',
            type: 'line',
            stack: '总量',
            data: [220, 182, 191, 234, 290, 330, 310]
          },
          {
            name: '视频广告',
            type: 'line',
            stack: '总量',
            data: [150, 232, 201, 154, 190, 330, 410]
          },
          {
            name: '直接访问',
            type: 'line',
            stack: '总量',
            data: [320, 332, 301, 334, 390, 330, 320]
          },
          {
            name: '搜索引擎',
            type: 'line',
            stack: '总量',
            data: [820, 932, 901, 934, 1290, 1330, 1320]
          }
        ]
      },
    }
  }

}
</script>


<style>
</style>