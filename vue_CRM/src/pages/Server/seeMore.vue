<template>
  <div style="display:flex;flex-direction:column;">
    <el-page-header @back="goBack"
                    :content="serverId"
                    style="margin-bottom:40px">
    </el-page-header>
    <!-- <h1 style="margin:30px">{{  }}</h1> -->
    <!-- {{ serverId }}aaaaaaaaaaaaaaa -->
    <div style="margin-bottom:30px">
      <el-steps :active="2"
                align-center>
        <el-step title="步骤1"
                 description="这是一段很长很长很长的描述性文字"></el-step>
        <el-step title="步骤2"
                 description="这是一段很长很长很长的描述性文字"></el-step>
        <el-step title="步骤3"
                 description="这是一段很长很长很长的描述性文字"></el-step>
        <el-step title="步骤4"
                 description="这是一段很长很长很长的描述性文字"></el-step>
      </el-steps>
    </div>

    <el-card>
      <h1>服务信息</h1>
      <el-form ref="form"
               :model="form"
               label-width="80px">
        <el-form-item label="活动名称">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="活动区域">
          <el-select v-model="form.region"
                     placeholder="请选择活动区域">
            <el-option label="区域一"
                       value="shanghai"></el-option>
            <el-option label="区域二"
                       value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="活动时间">
          <el-col :span="11">
            <el-date-picker type="date"
                            placeholder="选择日期"
                            v-model="form.date1"
                            style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line"
                  :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker placeholder="选择时间"
                            v-model="form.date2"
                            style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="即时配送">
          <el-switch v-model="form.delivery"></el-switch>
        </el-form-item>
        <el-form-item label="活动性质">
          <el-checkbox-group v-model="form.type">
            <el-checkbox label="美食/餐厅线上活动"
                         name="type"></el-checkbox>
            <el-checkbox label="地推活动"
                         name="type"></el-checkbox>
            <el-checkbox label="线下主题活动"
                         name="type"></el-checkbox>
            <el-checkbox label="单纯品牌曝光"
                         name="type"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="特殊资源">
          <el-radio-group v-model="form.resource">
            <el-radio label="线上品牌商赞助"></el-radio>
            <el-radio label="线下场地免费"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="活动形式">
          <el-input type="textarea"
                    v-model="form.desc"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary"
                     @click="onSubmit">保存修改</el-button>
          <el-button type="primary"
                     @click="onSubmit">查看合同</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </el-card>

    <template>
      <h1>访谈记录</h1>
      <div class="block">
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
    </template>
  </div>
</template>

<script>
export default {
  data () {
    return {
      serverId: '',
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      }
    }
  },
  created () {
    this.getParams()
  },
  watch: {
    '$route': 'getParams'
  },
  methods: {
    getParams () {
      const serverId = this.$route.query.serverId
      console.log(serverId);
      this.serverId = serverId
    },
    goBack () {
      console.log('go back');
      this.$router.push({
        path: '/index/server',

      })
    },
    handleClick (row) {
      console.log(row);
    },
    onSubmit () {
      console.log('submit!');
    }
    //me
  }

}
</script>

<style>
</style>