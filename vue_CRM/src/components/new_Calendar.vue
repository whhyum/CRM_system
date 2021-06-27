<template>
  <!-- ref 用来拿到这个日历对象  defaultView 默认以月份方式显示 locale 语言 header 头部的按钮 buttonText 头部按钮的文字 plugins 插件 weekends 是否显示周日周天 eventLimit 当框里面显示东西多的时候会显示+1 eventLimitText 在+1后面显示的文字 dateClick 点击事件 eventClick点击框里面内容事件 contentHeight 日历高度-->
  <!-- <div style="width:90%;margin: 20px auto;">
    
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
  </div> -->
  <FullCalendar ref="calendar"
                default-view="resourceTimelineNinetyDay"
                locale="zh-cn"
                week-number-calculation="ISO"
                slot-width="38"
                :scheduler-license-key="licenseKey"
                :slot-label-format="slotLabelFormat"
                :event-time-format="evnetTime"
                :header="header"
                :button-text="buttonText"
                :aspect-ratio="aspectRatio"
                :views="views"
                :plugins="calendarPlugins"
                resource-area-width="350px"
                resource-label-text="任务"
                :resources="resources"
                :events="calendarEvents"
                @eventResize="eventResizeFun"
                @eventDrop="eventDropFun"
                @resourceRender="resourceRenderFun"
                @eventRender="eventRenderFun" />

</template>

<script>
import FullCalendar from '@fullcalendar/vue'
import resourceTimelinePlugin from '@fullcalendar/resource-timeline'
import interactionPlugin from '@fullcalendar/interaction'
import '@fullcalendar/core/main.css'
import '@fullcalendar/timeline/main.css'
import '@fullcalendar/resource-timeline/main.css'
import '@/styles/cover.scss' //覆盖样式文件

export default {
  components: {
    FullCalendar
  },
  data () {
    return {
      // buttonText: { day: '天', month: '月', week: '周' },
      licenseKey: 'GPL-My-Project-Is-Open-Source',
      calendarPlugins: [
        resourceTimelinePlugin, interactionPlugin
      ],
      aspectRatio: 2.2,
      // 自定义视图显示3个月
      views: {
        resourceTimelineNinetyDay: {
          type: 'resourceTimeline',
          // duration: { month: 2 }
          visibleRange: function (currentDate) {
            // Generate a new date for manipulating in the next step
            var startDate = new Date(currentDate.valueOf())
            var endDate = new Date(currentDate.valueOf())

            // Adjust the start & end dates, respectively
            startDate.setDate(startDate.getDate() - 15) // One day in the past
            endDate.setDate(startDate.getDate() + 91) // Two days into the future

            return { start: startDate, end: endDate }
          }
        }
      },
      header: {
        left: '',
        center: 'title',
        right: '',
        prev, next,
        resourceTimelineDay, resourceTimelineWeek, resourceTimelineMonth
      },
      evnetTime: {
        hour: 'numeric',
        minute: '2-digit',
        hour12: false
      },
      slotLabelFormat: {},
      slotLabelFormat: [
        { day: 'numeric', weekday: 'short' }, // top level of text
        { weekday: 'short' } // lower level of text
      ],
      titleFormat: { year: 'numeric', month: 'short', day: 'numeric' },
      resources: [],
      calendarEvents: [
        { resourceId: '1', id: '1', event: '111', title: '111', start: '2020-04-01', end: '2020-04-13', workTime: 3 },
        { resourceId: '1', id: '1', event: '', title: '', start: '2020-04-13', end: '2020-04-17', color: 'rgba(83,180,179,0.2)', workTime: 3 },
        { resourceId: '1', id: '1', event: '111', title: '111', start: '2020-03-01', end: '2020-03-08', workTime: 3 },
        { resourceId: '2', id: '2', event: '222', title: '222', start: '2020-04-03', end: '2020-04-07', workTime: 3 },
        { resourceId: '222', id: '222', event: '222.1', title: '222.1', start: '2020-04-05', end: '2020-04-25', workTime: 3, color: 'rgba(83,180,179,1)' },
        { resourceId: '3', event: '333', id: '333', title: '333', start: '2020-04-05', end: '2020-04-15', workTime: 3, color: 'rgba(83,180,179,1)' },
        { resourceId: '4', event: '444', id: '444', title: '444', start: '2020-04-07', end: '2020-04-16', workTime: 3 },
        { resourceId: '5', event: '555', id: '5', title: '555', start: '2020-04-11', end: '2020-04-18', workTime: 3 },
        { resourceId: '6', event: '666', id: '6', title: '555', start: '2020-04-12', end: '2020-04-15', workTime: 3, color: 'rgba(83,180,179,1)' }
      ]
    }
  }
}