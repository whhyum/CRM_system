<template>
  <div style="display:flex;flex-direction:column;">
    <el-page-header @back="goBack"
                    :content="serverId"
                    style="margin-bottom:40px">
    </el-page-header>
    <!-- <h1 style="margin:30px">{{  }}</h1> -->
    <!-- {{ serverId }}aaaaaaaaaaaaaaa -->
    <div style="margin-bottom:30px">
      <el-steps :active="form.process_status"
                align-center>
        <el-step title="阶段一"
                 description="客户交接中..."></el-step>
        <el-step title="阶段二"
                 description="制定需求计划"></el-step>
        <el-step title="阶段三"
                 description="签订合同"></el-step>
        <el-step title="阶段四"
                 description="完成服务"></el-step>
      </el-steps>
    </div>

    <el-card>
      <div style="display:flex;flex-direction:row">
        <div style="flex:1;margin-right:30px;padding-right:30px">
          <h1>服务信息</h1>
          <el-form ref="form"
                   :model="form"
                   label-width="80px">
            <el-form-item label="日期">
              <span>{{ form.traceTime }}</span>
            </el-form-item>

            <el-form-item label="客户类型">
              <el-select v-model="form.status"
                         placeholder="请选择客户类型">
                <el-option label="流失"
                           value="流失"></el-option>
                <el-option label="开发失败"
                           value="开发失败"></el-option>
                <el-option label="潜在客户"
                           value="潜在客户"></el-option>
                <el-option label="正式客户"
                           value="正式客户"></el-option>
                <el-option label="资源池客户"
                           value="资源池客户"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="服务方式">
              <el-select v-model="form.type"
                         placeholder="请选择沟通方式">
                <el-option label="邮件"
                           value="邮件"></el-option>
                <el-option label="电话"
                           value="电话"></el-option>
                <el-option label="QQ"
                           value="QQ"></el-option>
                <el-option label="微信"
                           value="微信"></el-option>
                <el-option label="面议"
                           value="面议"></el-option>
                <el-option label="其他"
                           value="其他"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="服务效果">
              <el-radio-group v-model="form.trace_result">
                <el-radio label="优"></el-radio>
                <el-radio label="中"></el-radio>
                <el-radio label="差"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="客户名称">
              <el-input v-model="form.customerName"
                        style=""></el-input>
            </el-form-item>
            <el-form-item label="服务类型">
              <el-input v-model="form.trace_type"></el-input>
            </el-form-item>

            <el-form-item label="服务内容">
              <el-input type="textarea"
                        v-model="form.trace_details"></el-input>
            </el-form-item>

            <el-form-item>
              <el-button type="primary"
                         @click="onSubmit">保存修改</el-button>

              <el-button @click="goBack">取消</el-button>
            </el-form-item>
          </el-form>
        </div>

        <!-- 合同信息 -->
        <div style="flex:1">
          <h1>合同信息</h1>
          <el-form ref="form"
                   :model="contractform"
                   label-width="80px">
            <el-form-item label="日期">
              <span v-if="contract_status">{{ contractform.creatTime }}</span>
              <el-input v-else
                        v-model="contractform.creatTime"
                        style=""></el-input>
            </el-form-item>

            <el-form-item label="甲方">
              <span v-if="contract_status">
                {{ contractform.part_a }}</span>
              <el-input v-else
                        v-model="contractform.part_a"
                        style=""></el-input>
            </el-form-item>

            <el-form-item label="乙方">
              <span v-if="contract_status">
                {{ contractform.part_b }}</span>
              <el-input v-else
                        v-model="contractform.part_b"
                        style=""></el-input>
            </el-form-item>
            <el-form-item label="客户行业">
              <span v-if="contract_status">
                {{ contractform.job }}</span>
              <el-input v-else
                        v-model="contractform.job"
                        style=""></el-input>
            </el-form-item>
            <el-form-item label="交接人">
              <span v-if="contract_status">
                {{ contractform.seller }}</span>
              <el-input v-else
                        v-model="contractform.seller"
                        style=""></el-input>
            </el-form-item>
            <el-form-item label="金额">
              <span v-if="contract_status">
                {{ contractform.money }}</span>
              <el-input v-else
                        v-model="contractform.money"
                        style=""></el-input>
            </el-form-item>
            <el-form-item label="交易方式">
              <span v-if="contract_status">
                {{ contractform.payType }}</span>
              <el-input v-else
                        v-model="contractform.payType"
                        style=""></el-input>
            </el-form-item>
            <el-form-item label="交易状况">
              <span v-if="contract_status">
                {{ contractform.moneyStatus }}</span>
              <el-input v-else
                        v-model="contractform.moneyStatus"
                        style=""></el-input>
            </el-form-item>
            <el-button type="primary"
                       v-if="!contract_status"
                       style="margin-left:50%"
                       @click="checkContract">提交合同</el-button>

          </el-form>
        </div>

      </div>
    </el-card>
    <template>
      <h1>访谈记录</h1>
      <div class="block">
        <el-timeline>
          <div v-for="(item, index) in topDate"
               :key="index">
            <el-timeline-item :timestamp="item.traceTime"
                              placement="top">
              <el-card>
                <h4>{{ item.status }}:{{ item.costomerName }}</h4>
                <p>{{ item.type }}</p>
                <p>{{ item.traceDetails }}</p>
              </el-card>
            </el-timeline-item>
          </div>

          <!-- <el-timeline-item timestamp="2018/4/3"
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
          </el-timeline-item> -->
        </el-timeline>
      </div>
    </template>
  </div>
</template>

<script>
import { serverUp, selectTop5ByDate } from "@/api/server";
import { contractServer, contractAdd } from '@/api/contract'
export default {
  data () {
    return {
      process_status: '',
      process_type: '',
      tag: '',
      serverId: '',
      form: {
        process_status: '',
        trace_details: '',
        customerName: '',
        trace_result: '',
        type: '',
        status: '',

      },
      contractform: {
        traceId: '',
        part_a: '',
        part_b: '',
        seller: '',
        creatTime: '',
        finishTime: '',
        serverType: '',
        money: '',
        payType: '',
        moneyStatus: '',
        traceId: '',
        job: '',
      },
      topDate: [
        {
          costomerName: 'ttttt',
          traceTime: '2021'
        },
      ],
      contract_status: false,//是否已有合同，true 有合同
    }
  },
  created () {
    this.getParams()

    let fd = new FormData();
    fd.append('trace_id', this.serverId);
    //获取相关合同

    contractServer({ fd }).then((success) => {
      if (success.data.status === 201) {

        // this.$message.success(success.data.message);
        console.log('没有合同可以创建', success.data.message)
        contract_status = false
        let fd = new FormData()
        fd.append('part_a', this.contractform.part_a);
        fd.append('part_b', this.contractform.part_b);
        fd.append('seller', this.contractform.seller);
        fd.append('creatTime', this.contractform.creatTime);
        fd.append('serverType', this.contractform.serverType);
        fd.append('moneyStatus', this.contractform.moneyStatus);
        fd.append('money', this.contractform.money);
        fd.append('payType', this.contractform.payType);
        fd.append('job', this.contractform.job);
        fd.append('traceId', this.contractformform.traceId);
        fd.append('traceId', this.serverId);
        //创建合同
        contractAdd(fd).then((success) => {
          if (success.data.status === 200) {

            this.$message.success(success.data.message);
            // this.resetForm()
          } else {
            this.$message.info(success.data.message);
          }
          // console.log("jljklhklh" + this.ruleForm.username);
        }).catch(error => {
          this.$message.error('出错了，请联系管理员');

        })


      } else if (success.data.status === 202) {
        console.log('查看合同', success.data.message)

        this.contractform = success.data.data

      } else {
        this.$message.info(success.data.message);
      }
      // console.log("jljklhklh" + this.ruleForm.username);
    }).catch(error => {
      this.$message.error('出错了，请联系管理员');

    })

    //获取前5条记录
    selectTop5ByDate().then((success) => {
      if (success.data.status === 200) {
        this.$message.success(success.data.message);
        this.topDate = success.data.data
      } else {
        this.$message.info(success.data.message);
      }
      // console.log("jljklhklh" + this.ruleForm.username);
    }).catch(error => {
      this.$message.error('出错了，请联系管理员');

    })


  },
  watch: {
    '$route': 'getParams'
  },
  methods: {
    getParams () {
      const serverId = this.$route.query.serverId
      console.log(serverId);
      this.serverId = serverId
      if (!this.$route.query.data) {
        this.$route.query.data = {}
      }
      // this.tag = this.$route.query.tag
      this.form = this.$route.query.data
      this.process_status = this.$route.query.data.process_status
      this.process_type = this.$route.query.data.process_type

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
      console.log('submit!')
      let fd = new FormData()
      fd.append('trace_details', this.form.trace_details);
      fd.append('trace_type', this.form.trace_type);
      fd.append('trace_result', this.form.trace_result);
      fd.append('customer_name', this.form.customer_name);
      fd.append('process_status', this.form.process_status);
      fd.append('process_type', this.form.process_type);
      fd.append('input_user', this.form.input_user);
      fd.append('status', this.form.status);
      fd.append('type', this.form.type);

      serverUp(fd).then((success) => {
        console.log('保存修改');
        if (success.data.status === 200) {
          this.$message.success(success.data.message);
        } else {
          this.$message.info(success.data.message);
        }
        // console.log("jljklhklh" + this.ruleForm.username);
      }).catch(error => {
        this.$message.error('出错了，请联系管理员');
      })

    },

    checkContract () {




    }
    //me
  }

}
</script>

<style>
</style>