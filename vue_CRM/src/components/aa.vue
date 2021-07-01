 <template>
  <div>
    <full-calendar ref='can'
                   :events='data'
                   class="test-fc"
                   first-day='1'
                   @changeMonth="changeMonth"
                   @eventClick="eventClick"
                   @dayClick="dayClick"
                   @moreClick="moreClick">
    </full-calendar> // 点击 more, 展示当天所有事件，可自己定义事件
  </div>
</template>
<script>
import FullCalendar from '@fullcalendar/vue'
import full from 'vue-fullcalendar'
import dayGridPlugin from '@fullcalendar/daygrid'
import timeGridPlugin from '@fullcalendar/timegrid'
import interactionPlugin from '@fullcalendar/interaction'
import listPlugin from '@fullcalendar/list'
// // import moment from "moment";  :events="data"
// var demoEvents = [
//   {
//     title: 'Sunny Out of Office',
//     start: '2021-06-25',
//     end: '2021-07-27'
//   },
//   {
//     title: 'eeeeeeeee',
//     start: '2021-06-11', // 事件开始时间
//     end: '2021-06-30', // 事件结束时间
//     Cal_content: "运动量为：55公里",
//     cssClass: 'red',
//   }
// ]
export default {
  name: 'index',
  components: {
    FullCalendar, 'full-calendar': require('vue-fullcalendar')

  },
  data () {
    return {
      // mon: demoEvents,

      data: [
        {
          id: 1,
          title: 'eeeeeeeee',
          start: '2021-06-10', // 事件开始时间
          end: '2021-06-11', // 事件结束时间
          editable: true,
          // display: 'background',
          // Cal_content: "运动量为：55公里",
          // color: '#FFFFFF',
          color: '#797979',
          // backgroundColor: '#FFFFFF',
          // status: '#6bb377',
          // cssClass: ['color', '#010101']
          // 事件的样式 class名（由后台返回数据） red为自己定义的class名
        },
        {

          title: 'eeeeeeeee',
          start: '2021-06-11', // 事件开始时间
          end: '2021-06-30', // 事件结束时间
          cssClass: 'red', // 事件的样式 class名（由后台返回数据） red为自己定义的class名
        },
        {
          title: 'sssss',
          start: '2018-12-25',
          end: '2021-12-30',
          cssClass: 'blue'
        },
      ],
      calendarOptions: {
        // plugins: [dayGridPlugin, interactionPlugin, timeGridPlugin, listPlugin],
        initialView: 'dayGridMonth',
        events: [
          {
            title: '黄娇变电站3020开关综合检修',
            start: '2021-06-22 02:30',
            end: '2021-06-25 03:30',
            color: '#797979',
            editable: true
          },//可以拖动但不能缩放，但在周、日视图中是可以进行缩放的
          {
            title: '黄娇变电站3020开关综合检修',
            start: '2021-01-19 00:30',
            end: '2021-01-19 04:30',
            color: '#5580EE',
            editable: true
          }, //可以拖动、缩放
          {
            title: '准备公司资料',
            start: '2021-01-21 04:00',
            end: '2021-01-21 07:00',
            color: '#EDB378',
            editable: true,
            // overlap: true,
            // display: 'background',
          },
          {
            title: '准备公司资料',
            start: '2021-01-23 04:00',
            end: '2021-01-23 05:00',
            overlap: false,
            // display: 'background',
            color: '#797979'
          },//背景色 (添加相同时间的背景色时颜色会重叠) 一点要初始化日期时间 initialDate: '2020-07-10',
        ],
        workingTicketVisible: false, //工作表票详情页面
        eventClick: this.handleEventClick,
      }

    }
  },
  // components: {
  //   'full-calendar': require('vue-fullcalendar')
  // },
  methods: {
    // events: function (start, end,, callback) {
    //   var d = new Date(start._d);
    //   var startdate = "";
    //   if (d.getDate() == 01) {
    //     startdate = d.getFullYear() + '-' + (d.getMonth() + 1) + '-01';
    //   }
    //   else {
    //     if (d.getMonth() == 11) {
    //       startdate = (d.getFullYear() + 1) + '-01-01';
    //     }
    //     else {
    //       startdate = d.getFullYear() + '-' + (d.getMonth() + 2) + '-01';
    //     }
    //   }
    // },

    // 选择月份
    changeMonth (start, end, current) {
      console.log('changeMonth', start, end, current)
    },
    // 点击事件
    eventClick (event, jsEvent, pos) {

      console.log('eventClick', event, jsEvent, pos)
    },
    // 点击当天
    dayClick (day, jsEvent) {
      console.log(this.data);
      console.log(this.$refs.can);
      console.log('dayClick', day, jsEvent)
    },
    // 查看更多
    moreClick (day, events, jsEvent) {
      console.log('moreCLick', day, events, jsEvent)
    },
  },
  components: {
    'full-calendar': require('vue-fullcalendar')
  },

}
</script>
<style scoped>
.red {
  background-color: red;
  color: rebeccapurple;
}
</style>