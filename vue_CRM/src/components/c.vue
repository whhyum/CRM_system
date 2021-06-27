<template>
  <full-calendar ref="fullCalendar"
                 style="height: 100%"
                 :options="calendarOptions">

  </full-calendar>
</template>

<script>

import FullCalendar from "@fullcalendar/vue";
import dayGridPlugin from "@fullcalendar/daygrid";
import interactionPlugin from "@fullcalendar/interaction";

// 会议室1日程安排
let scheduleList0 = [
  { id: 1, title: '小破孩', userId: 3, beginDate: '2021-06-21 09:30', endDate: '2021-06-30 11:30', remark: '备注内容', status: '#f08f00' },
  { id: 2, title: '项目会议', userId: 2, beginDate: '2020-12-14 09:30', endDate: '2020-12-14 14:30', remark: '备注内容', status: '#6bb377' },
  { id: 3, title: '供应商接待', userId: 3, beginDate: '2020-12-18 10:00', endDate: '2020-12-18 12:30', remark: '备注内容', status: '#6bb377' },
  { id: 4, title: '部门周会', userId: 2, beginDate: '2020-12-18 13:30', endDate: '2020-12-19 15:30', remark: '备注内容', status: '#999' },
  { id: 5, title: '项目分析会', userId: 1, beginDate: '2020-12-29 14:30', endDate: '2020-12-29 17:00', remark: '备注内容', status: '#6bb377' },
];
export default {
  data () {
    return {
      calendarOptions: {
        //   timeGridPlugin  可显示每日时间段
        height: 700,
        plugins: [dayGridPlugin, interactionPlugin],
        headerToolbar: {
          left: "prev,next today",
          center: "title",
          right: "dayGridMonth,dayGridWeek,dayGrid",
          // right: 'agendaWeek,dayGridWeek,dayGrid'
        },
        buttonText: {
          // 设置按钮
          today: "今天",
          month: "月",
          week: "周",
          dayGrid: "天",
        },
        // allDaySlot: false,
        editable: true,
        selectable: true,
        navLinks: true,
        // displayEventEnd: true,//所有视图显示结束时间
        initialView: "dayGridMonth", // 设置默认显示月，可选周、日
        dateClick: this.handleDateClick,
        eventClick: this.handleEventClick,
        eventsSet: this.handleEvents,
        select: this.handleDateSelect,
        // timezone:''
        // 设置日程
        events: [
          {
            id: 1,
            title: '09:30~11:30 小破孩',
            start: '2020-12-11',
            end: '2020-12-13',
            color: '#f08f00',
          },
          {
            id: 2,
            title: '9:30~14:30 项目会议',
            start: '2020-12-14',
            end: '2020-12-14',
            color: '#6bb377',
          },
        ],
        eventColor: "#f08f00", // 修改日程背景色
        locale: "zh-cn", // 设置语言
        weekNumberCalculation: "ISO", // 周数
        customButtons: {
          prev: { // this overrides the prev button
            text: "PREV",
            click: () => {
              this.prev();
            }
          },
          next: { // this overrides the next button
            text: "PREV",
            click: () => {
              this.next();
            }
          },
          today: {
            text: "今天",
            click: () => {
              this.today();
            }
          }
        }
      },
    }
  },
  mounted () {
    // 获取用户信息
    this.calendarApi = this.$refs.fullCalendar.getApi();
  },
  methods: {
    prev () {
      this.calendarApi.prev();
    },
    // 切换下一个按钮事件
    next () {
      this.calendarApi.next();
    },
    // 点击今天按钮
    today () {
      this.calendarApi.today();
    },
    handleDateClick: function (arg) {
      this.$forceUpdate();
      console.log(arg, '事件1')
    },
    handleEventClick (calEvent) {
      console.log(calEvent, '事件2');
      this.dialogVisible = true; // 显示dialog弹窗
      let id = calEvent.event.id; // 获取当前点击日程的ID
      let info = this.subList.filter((item) => {
        return item.id == id // 通过ID进行数据匹配 
      });
      this.$nextTick(() => {
        this.form = _.cloneDeep(info[0]); // 数据通过深拷贝赋值到form表单用于编辑
        this.getShowTime(this.form.beginDate, this.form.endDate); // 处理时间回显格式
        console.log(info[0], '数据')
      });
    },
    getShowTime (beginDate, endDate) {
      this.form.startDate = this.dealWithTime(beginDate);
      this.form.startTime = this.getHoursMin(beginDate);
      this.form.endDate = this.dealWithTime(endDate);
      this.form.endTime = this.getHoursMin(endDate);
    },
    // 获取时分时间
    getHoursMin (value) {
      return value.substring(11, 16);
    },
    // 处理会议时间格式
    dealWithTime (date) {
      let newDate = /\d{4}-\d{1,2}-\d{1,2}/g.exec(date)[0];
      return newDate;
    },
    handleEvents (events) {
      console.log(events, '事件3');
    },
    getReservationList (arrayData) {
      let newArr = [];
      this.subList = arrayData;
      arrayData.forEach((item) => {
        newArr.push({
          start: this.dealWithTime(item.beginDate),
          end: this.addDate(this.dealWithTime(item.endDate), 1),
          color: item.status,
          id: item.id,
          title: `${this.getTitle(item.beginDate, item.endDate)} ${item.title}`,
        })
      });
      this.calendarOptions.events = newArr;
    },

    // 日期加1天
    addDate (date, days) {
      var d = new Date(date);
      d.setDate(d.getDate() + days);
      var mon = (d.getMonth() + 1) < 10 ? "0" + (d.getMonth() + 1) : d.getMonth() + 1;
      let endD = d.getDate() < 10 ? '0' + d.getDate() : d.getDate();
      return `${d.getFullYear()}-${mon}-${endD}`;
    },
    // 获取会议事件title
    getTitle (date1, date2) {
      let start = date1.substring(11, 16);
      let end = date2.substring(11, 16);
      return `${start}~${end}`;
    },


  }

}
</script>

<style>
</style>