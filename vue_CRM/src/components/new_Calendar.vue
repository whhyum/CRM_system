<template>
  <div style="width:90%;margin: 20px auto;">
    <!-- ref 用来拿到这个日历对象  defaultView 默认以月份方式显示 locale 语言 header 头部的按钮 buttonText 头部按钮的文字 plugins 插件 weekends 是否显示周日周天 eventLimit 当框里面显示东西多的时候会显示+1 eventLimitText 在+1后面显示的文字 dateClick 点击事件 eventClick点击框里面内容事件 contentHeight 日历高度-->
    <FullCalendar
      ref="fullCalendar"
      defaultView="dayGridMonth"
      locale="zh-cn"
      :header="{
        left: 'prev',
        center: 'title',
        right:'today next '
      }"
      :buttonText="buttonText"
      :plugins="calendarPlugins"
      weekends="ture"
      :events="getCalendarEvents"
      :eventLimit="true"
      eventLimitText="更多"
      @dateClick="handleDateClick"
      @eventClick="handleEventClick"
      :contentHeight="700"
    />

    <el-dialog :visible.sync="dialogFormVisible">
      <el-form class="demo-form-inline">
        <el-form-item label="事件名">
          <el-input v-model="shijian"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="add">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import FullCalendar from "@fullcalendar/vue";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import interactionPlugin from "@fullcalendar/interaction";
export default {
  name: "Test",
  components: {
    // 注册
    FullCalendar
  },
  data() {
    return {
      // 事件名
      shijian: "",
      dialogFormVisible: false,
      arg: "",
      buttonText: {
        prev: "上月",
        next: "下月",
        today: "今天"
      },
      calendarPlugins: [
        dayGridPlugin,
        timeGridPlugin,
        interactionPlugin
      ],
      //   初始化加载列表
      calendarEvents: [],
      calendarApi: null
    };
  },
  methods: {
    getCalendarEvents(info, successCallback, failureCallback) {
      const events = [
        ...this.calendarEvents,
        {
          id: 1,
          title: "事件名1",
          start: "2020-04-09"
        },
        {
          id: 2,
          title: "事件名2",
          start: "2020-04-01"
        }
      ]
      // 返回数据加载页面时显示在日历上
      successCallback(events);
    },
    // 点击触发事件
    handleDateClick(arg) {
      // 显示添加弹出框
      this.dialogFormVisible = true;
      // 把当前点击的数据保留
      this.arg = arg;
    },
    // 添加一个事件
    add() {
    // 添加
      this.calendarEvents.push({
        id: 1,
        title: this.shijian,
        start: this.arg.date,
        allDay: this.arg.allDay
      });
      //   清空input
      this.shijian = "";
      //   隐藏弹出框
      this.dialogFormVisible = false;
      //   刷新日历
      this.calendarApi.refetchEvents();
    },
    // 点击已经添加的内容
    handleEventClick(info) {
      alert("id: " + info.event.id);
    }
  },
  mounted() {
    //  把日历对象赋值以便操作日历
    this.calendarApi = this.$refs.fullCalendar.getApi();
  }
};
</script>

<style lang='css'>
@import "~@fullcalendar/core/main.css";
@import "~@fullcalendar/daygrid/main.css";
@import "~@fullcalendar/timegrid/main.css";
</style>
