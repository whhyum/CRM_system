<template>
  <div style="width:100%;height:inherit;">
    <!-- <h2>添加客户</h2> -->
    <div class="add">
      <el-card style="width:50%;margin-right:10px;flex:1">
        <AddPage></AddPage>
      </el-card>
      <el-card style="width:50%;flex:1">
        <StarCus></StarCus>
        {{userName}}
      </el-card>
    </div>

    <el-card style="width:100%;height:100%;border-radius: 10px;">
      <el-tag class="unit tag"
              v-for="tag in tags"
              :key="tag.name"
              closable
              :type="tag.type">
        {{tag.name}}
      </el-tag>
      <el-input placeholder="请输入内容"
                prefix-icon="el-icon-search"
                v-model="input2"
                class="search_input unit">
      </el-input>
      <el-button @click="clearFilter">清除所有过滤器</el-button>
      <el-table :data="tableData"
                border
                class="unit"
                style="width: 100%;height:500px">
        <el-table-column fixed
                         sortable
                         prop="date"
                         label="日期"
                         width="150">
        </el-table-column>
        <el-table-column prop="name"
                         label="姓名"
                         width="120">
        </el-table-column>
        <el-table-column prop="province"
                         label="省份"
                         width="120">
        </el-table-column>
        <el-table-column prop="city"
                         label="市区"
                         width="120">
        </el-table-column>

        <el-table-column prop="address"
                         label="地址"
                         width="300">
        </el-table-column>
        <el-table-column prop="zip"
                         label="邮编"
                         width="120">
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
        <el-table-column fixed="right"
                         label="操作"
                         width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)"
                       type="text"
                       size="small">查看</el-button>
            <el-button type="text"
                       size="small">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination class="bottom"
                     background
                     layout="prev, pager, next"
                     :total="100">
      </el-pagination>
    </el-card>
  </div>
</template>

<script>
import AddPage from '@/pages/Customer/addCustomer.vue'
import StarCus from '@/pages/Customer/StarCustomer.vue'
import Calendar from '@/components/Calendar.vue'
export default {
  computed: {
    userName () {
      return this.$store.state.user.userName
    }
  },
  methods: {
    handleClick (row) {
      console.log(row);
      this.currentItem = row;
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
    }

  },
  components: { Calendar, AddPage, StarCus },
  data () {
    return {
      currentItem: '',
      input2: '',

      tags: [
        { name: '标签一', type: '' },
        { name: '标签二', type: 'success' },
        { name: '标签三', type: 'info' },
        { name: '标签四', type: 'warning' },
        { name: '标签五', type: 'danger' }
      ],
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1518 弄',
        zip: 200333
      }, {
        date: '2016-05-04',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1517 弄',
        zip: 200333
      }, {
        date: '2016-05-01',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1519 弄',
        zip: 200333
      }, {
        date: '2016-05-03',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1516 弄',
        zip: 200333
      }],
    }
  }
}
</script>

<style>
.unit {
  margin-bottom: 10px;
}
.tag {
  margin-right: 10px;
}
.bottom {
  /* position: absolute; */
  margin-top: 6px;
  margin-left: 30%;
}
.add {
  margin-bottom: 10px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}
</style>