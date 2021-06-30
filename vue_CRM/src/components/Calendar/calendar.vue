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
import { allPlan } from '@/api/plan'
export default {
  data () {
    return {
      planData: '',
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
              content: "<div style='width: 100%;background-color:#B8D6DE;padding:10px'>" +
                "<div style='border-bottom: 0.01rem solid #B8D6DE;line-height: 0.3rem;color: white;'>" + eve.servserName + "</div>" +
                "<div style='color: white'>客户名称：" + eve.servserName + "</div>" +
                "<div style='color: white'>开始时间：" + info.event.start + "</div>" +
                "<div style='color: white'>结束时间：" + info.event.end + "</div>" +
                "<div style='color: white'>大体需求：" + info.event.title + "</div>" +
                // "<div style='color: #666666'>参训成员："+eve.remember+"</div>" +
                "<div style='color: white'>备注：" + eve.detail + "</div>" +
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
          title: 'test',
          start: '2021-06-10', // 事件开始时间
          end: '2021-06-12', // 事件结束时间
          editable: true,
          color: '#B8D6DE',
          detail: 'sssss',
          // startT: '2012-',
          servserName: 'aaa'
        }
        ],//日程事件的json

      }

    }
  },
  components: {
    FullCalendar
  },
  methods: {

  },
  created () {
    allPlan().then((success) => {
      if (success.data.status === 200) {

        // this.$message.success(success.data.message);
        console.log('获取日程信息', success.data.message);
        this.planData = success.data.data
        this.calendarOptions.events = this.planData

        // this.calendarOptions.events.id = this.planData.tractId
        // this.calendarOptions.events.start = this.planData.start
        // this.calendarOptions.events.end = this.planData.end
        // this.calendarOptions.events.desc = this.planData.detail
        // this.calendarOptions.events.servserName = this.planData.servserName
        // this.calendarOptions.color 
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

<style lang="scss" scoped>
</style>>

