<script>
import 'tippy.js/dist/tippy.css';
import 'tippy.js/themes/light.css';
import 'tippy.js/animations/scale.css'

</script>

<template>
  <FullCalendar ref="fullCalendar"
                :options="calendarOptions" />
</template>

<script>
import '@fullcalendar/core/vdom'
import dayGridPlugin from '@fullcalendar/daygrid'
import timeGridPlugin from '@fullcalendar/timegrid'
import interactionPlugin from '@fullcalendar/interaction'
import listPlugin from '@fullcalendar/list'
import FullCalendar from '@fullcalendar/vue'
import tippy from "tippy.js";

export default {
  data () {
    return {
      calendarOptions: {
        plugins: [dayGridPlugin, interactionPlugin, timeGridPlugin],//加载插件，V5采用插件模块方式加入
        editable: true,//是否可编辑
        droppable: true,//可拖拽的
        initialView: 'dayGridMonth',//日插件
        // initialDate:""//初始化日期
        timeZone: 'local',//采用时区
        locale: "zh-cn",//采用中文
        height: 700,//日历高度
        dateClick: this.handleDateClick,//日期方格点击事件
        eventClick: this.handleEventClick,//日程点击事件
        eventMouseEnter:
          function (info) {//鼠标hover事件，对应也有其他鼠标事件监听
            console.log(info)
            let col = info.event.borderColor;
            let eve = info.event._def.extendedProps
            tippy(info.el, {//tippy hover插件
              content: "<div style='width: 100%;background-color:red;padding:10px'>" +
                "<div style='border-bottom: 0.01rem solid #CCCCCC;line-height: 0.3rem;color: black;'>" + info.event.title + "</div>" +
                "<div style='color: #666666'>训练名称：" + eve.desc + "</div>" +
                "<div style='color: #666666'>训练日期：" + eve.trainDate + "</div>" +
                "<div style='color: #666666'>开始时间：" + eve.startT + "</div>" +
                "<div style='color: #666666'>结束时间：" + eve.endtime + "</div>" +
                "<div style='color: #666666'>训练地点：" + eve.address + "</div>" +
                // "<div style='color: #666666'>参训成员："+eve.remember+"</div>" +
                "<div style='color: #666666'>备注：" + eve.remark + "</div>" +
                "</div>",//允许Html配置
              theme: 'light',//主题选取
              // trigger: 'click',//触发类型
              interactive: true,//可交互的
              placement: 'right-end',//悬浮框位置
              allowHTML: true,//是否允许html文本
            });
          },

        titleFormat: { year: 'numeric', month: 'long' },//日期title格式

        dayCellClassNames: "bgTd",//日期方格样式设置
        events: [{
          id: 1,
          title: 'eeeeeeeee',
          start: '2021-06-10', // 事件开始时间
          end: '2021-06-11', // 事件结束时间
          editable: true,
          color: 'red',
          desc: 'sssss',
          startT: '2012-'
        }
        ],//日程事件的json

      }

    }
  },
  components: {
    FullCalendar
  },
  methods: {

  }
}
</script>

<style lang="scss" scoped>
</style>>

