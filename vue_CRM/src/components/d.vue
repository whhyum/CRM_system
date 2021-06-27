<template>
  <div class="M_container">

    <div class="D_down">
      <FullCalendar ref="myCalendar"
                    :options="calendarOptions" />
      <ul>
        <li><span class="waiting"></span>待执行</li>
        <li><i class="starting"></i>执行中</li>
        <li><i class="finished"></i>已完成</li>
      </ul>
    </div>

  </div>
</template>
 
<script>
import FullCalendar from '@fullcalendar/vue'
import dayGridPlugin from '@fullcalendar/daygrid'
import timeGridPlugin from '@fullcalendar/timegrid'
import interactionPlugin from '@fullcalendar/interaction'
import listPlugin from '@fullcalendar/list'

export default {
  name: "index",
  components: {
    FullCalendar,

  },
  data () {
    return {

      calendarOptions: {
        // 引入的插件，比如fullcalendar/daygrid，fullcalendar/timegrid引入后才可显示月，周，日
        plugins: [dayGridPlugin, interactionPlugin, timeGridPlugin, listPlugin],
        initialView: 'dayGridMonth', // 默认为那个视图（月：dayGridMonth，周：timeGridWeek，日：timeGridDay）
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
        firstDay: 1, // 设置一周中显示的第一天是哪天，周日是0，周一是1，类推
        locale: 'zh-cn', // 切换语言，当前为中文
        eventColor: '#3BB2E3', // 全部日历日程背景色
        themeSystem: 'bootstrap', // 主题色(本地测试未能生效)
        // initialDate: moment().format('YYYY-MM-DD'), // 自定义设置背景颜色时一定要初始化日期时间
        timeGridEventMinHeight: '20', // 设置事件的最小高度
        aspectRatio: 1.65, // 设置日历单元格宽度与高度的比例。
        // displayEventTime: false, // 是否显示时间
        allDaySlot: false, // 周，日视图时，all-day 不显示
        eventLimit: true, // 设置月日程，与all-day slot的最大显示数量，超过的通过弹窗显示
        headerToolbar: { // 日历头部按钮位置
          left: '',
          center: 'prevYear,prev title next,nextYear',
          // right: 'today dayGridMonth,timeGridWeek,timeGridDay'
          right: ''
        },
        buttonText: {
          // today: '今天',
          // month: '月',
          // week: '周',
          // day: '日'
        },
        slotLabelFormat: {
          hour: '2-digit',
          minute: '2-digit',
          meridiem: false,
          hour12: false // 设置时间为24小时
        },
        eventLimitNum: { // 事件显示数量限制(本地测试未能生效)
          dayGrid: {
            eventLimit: 5
          },
          timeGrid: {
            eventLimit: 2 // adjust to 6 only for timeGridWeek/timeGridDay
          }
        },
        eventClick: this.handleEventClick,
      },
      workingTicketVisible: false //工作表票详情页面

    }
  },
  mounted () {
  },
  methods: {
    /**
     * 点击日历日程事件
     *
     * info: 事件信息
     * event是日程（事件）对象
     * jsEvent是个javascript事件
     * view是当前视图对象。
     */
    handleEventClick (info) {
      console.log(info)

    },

  }
}
</script>
 
<style lang="scss" scoped>
.M_container {
  width: 100vw;
  height: calc(100vh - 130px);
  display: flex;

  .P_left {
    width: 20%;
    margin-right: 10px;
    height: 100%;
    background: #ffffff;
    padding: 10px;
    > .el-radio-group {
      margin-bottom: 10px;
    }
    .tree_Panel {
      .asideTree_panel {
        .el-tree-node {
          position: relative;
        }
        .D_tree_icon {
          width: 20px;
          height: 20px;
          float: right;
          position: absolute;
          right: 2px;
        }
        ::v-deep .el-tree-node__expand-icon.is-leaf::before {
          color: transparent;
          cursor: default;
          content: none;
        }

        .line {
          width: 17px;
          height: 14px;
          display: inline-block;
          // background: url("./assets/images/common/icon-jx.png");
        }
      }
    }
  }
  .el-icon-addJX {
    width: 20px;
    height: 20px;
    background: #1890ff;
  }
  .P_right {
    width: 80%;
    height: 100%;
    padding: 10px;
    background: #ffffff;
    .D_title {
      display: flex;
      justify-content: space-between;
    }
    .D_up {
      width: 100%;
      height: calc(100vh - 620px);
      overflow-y: auto;
      background: #eff4fe;
      padding: 0 10px;
      font-size: 13px;
      font-family: "Source Han Sans CN Regular";
      > .el-row {
        height: 150px;
        display: flex;
        flex-wrap: wrap;
        .el-col {
          width: 48%;
          height: auto;
          margin: 10px 1%;
        }
      }
      .yuan {
        width: 4px;
        height: 15px;
        display: inline-block;
        opacity: 1;
        margin-right: 5px;
        border: unset !important;
        background: #2275f2;
        border-radius: 0;
      }
    }
    .D_down {
      width: 100%;
      margin-top: 10px;
      /*height: calc(100vh - 525px);*/
      overflow-y: auto;
      > ul {
        list-style: none;
        padding: 0;
        margin: 5px 0 0 0;
        float: right;
        width: 20%;
        display: flex;
        justify-content: space-around;
        font-family: "Source Han Sans CN Medium";
        font-size: 13px;
        > li {
          width: 30%;
          .waiting {
            width: 15px;
            height: 15px;
            background: #5580ee;
            display: inline-block;
            border-radius: 50%;
            margin-right: 5px;
          }
          .starting {
            width: 15px;
            height: 15px;
            background: #edb378;
            display: inline-block;
            border-radius: 50%;
            margin-right: 5px;
          }
          .finished {
            width: 15px;
            height: 15px;
            background: #797979;
            display: inline-block;
            border-radius: 50%;
            margin-right: 5px;
          }
        }
      }

      //日历样式
      ::v-deep .fc .fc-toolbar-title {
        font-size: 15px !important;
        font-family: "Source Han Sans CN Regular";
        line-height: 24px;
      }
      ::v-deep .fc .fc-button {
        padding: 0;
      }
      ::v-deep .fc-toolbar-chunk {
        display: flex;
        margin: 0 0 5px 0;
      }
      ::v-deep .fc .fc-toolbar.fc-header-toolbar {
        margin: 0 !important;
      }
      ::v-deep .fc .fc-col-header-cell-cushion {
        font-size: 15px;
        font-family: "Source Han Sans CN Regular";
        color: #333;
      }
      ::v-deep .fc .fc-timegrid-slot-label-cushion {
        font-size: 13px;
        font-family: "Source Han Sans CN Regular";
      }
      ::v-deep .fc .fc-view-harness {
        height: 360px !important;
        overflow: auto;
      }
    }
  }
}
</style>