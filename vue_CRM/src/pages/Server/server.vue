<template>
  <div style="display:flex;flex-direction:row;width:auto;">
    <div class="block">
      <h1>近期更新</h1>
      <el-timeline>
        <el-timeline-item timestamp="2018/4/12"
                          placement="top">
          <el-card>
            <h4>更新 Github 模板</h4>
            <p>王小虎 提交于 2018/4/12 20:46</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2018/4/3"
                          placement="top">
          <el-card>
            <h4>更新 Github 模板</h4>
            <p>王小虎 提交于 2018/4/3 20:46</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2018/4/2"
                          placement="top">
          <el-card>
            <h4>更新 Github 模板</h4>
            <p>王小虎 提交于 2018/4/2 20:46</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
    <el-card style="flex:1;margin-left:20px;border-radius:10px;display:flex;flex-direction:column">
      <h1>客户状态</h1>
      <div style="text-align:center;width:100%">

        <el-progress type="circle"
                     :percentage="0"
                     format="ssss">

        </el-progress>

        <el-progress type="circle"
                     :percentage="25"></el-progress>
        <el-progress type="circle"
                     :percentage="100"
                     status="success"></el-progress>
        <el-progress type="circle"
                     :percentage="70"
                     status="warning"></el-progress>
        <el-progress type="circle"
                     :percentage="50"
                     status="exception"></el-progress>
      </div>
      <el-divider></el-divider>
      <template style="margin-top:30px">
        <h1>服务管理</h1>
        <!-- <el-button style="
                margin-top:20px"
                @click="clearFilter">清除所有过滤器</el-button> -->
        <el-table :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                  style="width: 100%;">

          <el-table-column prop="date"
                           label="日期"
                           sortable
                           width="180"
                           column-key="date"
                           :filters="[{text: '2016-05-01', value: '2016-05-01'}, {text: '2016-05-02', value: '2016-05-02'}, {text: '2016-05-03', value: '2016-05-03'}, {text: '2016-05-04', value: '2016-05-04'}]"
                           :filter-method="filterHandler">
          </el-table-column>
          <el-table-column label="Name"
                           prop="name">
          </el-table-column>

          <el-table-column prop="tag"
                           label="标签"
                           width="100"
                           :filters="[{ text: '家', value: '家' }, { text: '公司', value: '公司' }]"
                           :filter-method="filterTag"
                           filter-placement="bottom-end">
            <template slot-scope="scope">
              <el-tag :type="scope.row.tag === '家' ? 'primary' : 'success'"
                      disable-transitions>{{scope.row.tag}}</el-tag>
            </template>
          </el-table-column>

          <el-table-column align="right">
            <template slot="header"
                      slot-scope="scope">
              <el-input v-model="search"
                        size="mini"
                        placeholder="输入关键字搜索" />
            </template>
            <template slot-scope="scope">

              <el-button size="mini"
                         @click="seeMore()">查看</el-button>
              <el-button size="mini"
                         @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
              <el-button size="mini"
                         type="danger"
                         @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
            </template>
          </el-table-column>

        </el-table>
        <div class=""
             style="width:auto;text-align:center;margin-top:10px">
          <span class="demonstration"></span>
          <el-pagination @size-change="handleSizeChange"
                         @current-change="handleCurrentChange"
                         :current-page.sync="currentPage1"
                         :page-size="100"
                         layout="total, prev, pager, next"
                         :total="1000">
          </el-pagination>
        </div>
      </template>
    </el-card>
  </div>
</template>

<script>
export default {
  data () {
    return {
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      formLabelWidth: '120px',
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1517 弄'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1519 弄'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1516 弄'
      }],
      search: ''
    }
  },
  methods: {
    handleEdit (index, row) {
      console.log(index, row);
    },
    handleDelete (index, row) {
      console.log(index, row);
    },
    resetDateFilter () {
      this.$refs.filterTable.clearFilter('date');
    },
    clearFilter () {
      this.$refs.filterTable.clearFilter();
    },
    formatter (row, column) {
      return row.address;
    },
    filterTag (value, row) {
      return row.tag === value;
    },
    filterHandler (value, row, column) {
      const property = column['property'];
      return row[property] === value;
    },
    open () {
      const h = this.$createElement;
      this.$msgbox({
        title: '消息',
        message: h('p', null, [
          h('span', null, '内容可以是 '),
          h('i', { style: 'color: teal' }, 'VNode')
        ]),
        showCancelButton: true,
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        beforeClose: (action, instance, done) => {
          if (action === 'confirm') {
            instance.confirmButtonLoading = true;
            instance.confirmButtonText = '执行中...';
            setTimeout(() => {
              done();
              setTimeout(() => {
                instance.confirmButtonLoading = false;
              }, 300);
            }, 3000);
          } else {
            done();
          }
        }
      }).then(action => {
        this.$message({
          type: 'info',
          message: 'action: ' + action
        });
      });
    },
    seeMore () {
      this.$router.push({
        path: '/index/seeMore',
        query: {
          serverId: 12131315451
        }
      })
    }
  }//method
}
</script>

<style>
</style>