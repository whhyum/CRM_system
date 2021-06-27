<template>
  <div class="echart"
       ref="echartpie"
       :style="{float:'center','width':'100%','text-align':'center'}"></div>
</template>

<script>
export default {
  methods: {

    initChart (data) {

      let getchart = this.$echarts.init(this.$refs.echartpie);
      var option = {
        title: {
          // text: '南丁格尔玫瑰图',
          // subtext: '纯属虚构',
          left: 'center'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          left: 'center',
          top: 'bottom',
          data: ['rose1', 'rose2', 'rose3', 'rose4', 'rose5', 'rose6', 'rose7', 'rose8']
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        series: [
          {
            name: '差异分析',
            type: 'pie',
            radius: [20, 140],
            center: ['50%', '50%'],
            roseType: 'radius',
            itemStyle: {
              borderRadius: 5
            },
            label: {
              show: true
            },
            emphasis: {
              label: {
                show: true
              }
            },
            data:
              // data
              [
                { value: 40, name: 'rose 1' },
                { value: 33, name: 'rose 2' },
                { value: 28, name: 'rose 3' },
                { value: 22, name: 'rose 4' },
                { value: 20, name: 'rose 5' },
                { value: 15, name: 'rose 6' },
                { value: 12, name: 'rose 7' },
                { value: 10, name: 'rose 8' }
              ]
          }
        ]
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

<style>
</style>