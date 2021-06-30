<template>
  <div style="display:flex;flex-direction:column;">
    <el-page-header @back="goBack"
                    :content="serverId"
                    style="margin-bottom:40px">
    </el-page-header>
    <!-- <h1 style="margin:30px">{{  }}</h1> -->
    <!-- {{ serverId }}aaaaaaaaaaaaaaa -->
    <div style="margin-bottom:30px">
      <el-steps :active="form.processStatus"
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
            <el-form-item label="服务进度">
              <el-select v-model="form.processStatus"
                         placeholder="请选择服务记录">
                <el-option label="客户交接中"
                           value="1"></el-option>
                <el-option label="制定需求计划"
                           value="2"></el-option>
                <el-option label="签订合同"
                           value="3"></el-option>
                <el-option label="完成服务"
                           value="4"></el-option>

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
              <el-radio-group v-model="form.traceResult">
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
              <el-input v-model="form.traceType"></el-input>
            </el-form-item>

            <el-form-item label="服务内容">
              <el-input type="textarea"
                        v-model="form.traceDetails"></el-input>
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
              <span v-else
                    style="">{{ now }}</span>
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
                <h2>{{ item.status }}:{{ item.customerName }}</h2>
                <p>{{ item.type }}</p>
                <p>{{ item.traceDetails }}</p>
              </el-card>
            </el-timeline-item>
          </div>

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
      now: '',
      process_status: '',
      process_type: '',
      tag: '',
      serverId: '',
      form: {
        processStatus: '',
        traceDetails: '',
        customerName: '',
        traceResult: '',
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
    let nowDate = new Date();
    let date = {
      year: nowDate.getFullYear(),
      month: nowDate.getMonth() + 1,
      day: nowDate.getDate(),
    }
    console.log(date);
    let systemDate = date.year + '-' + (date.month >= 10 ? date.month : '0' + date.month) + '-' + (date.day >= 10 ? date.day : '0' + date.day)
    this.now = systemDate;

    this.getParams()

    let fd = new FormData();
    fd.append('trace_id', this.serverId);
    //获取相关合同

    contractServer(fd).then((success) => {
      if (success.data.status === 201) {

        // this.$message.success(success.data.message);
        console.log('没有合同可以创建', success.data.message)
        this.contract_status = false
        // this.newC()


      } else if (success.data.status === 202) {
        console.log('查看合同', success.data.message)
        this.contract_status = true
        this.contractform = success.data.data

      } else {
        this.$message.info(success.data.message);
      }
      // console.log("jljklhklh" + this.ruleForm.username);
    }).catch(error => {
      // this.$message.error('出错了，请联系管理员');

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
    newC () {
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
      console.log('youwuID', this.serverId);
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
    },
    getParams () {
      const serverId = this.$route.query.serverId
      console.log(serverId);
      this.serverId = serverId
      if (!this.$route.query.data) {
        this.$route.query.data = {}
      }
      // this.tag = this.$route.query.tag
      this.form = this.$route.query.data
      console.log('ceshishujv', this.form);
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
      fd.append('traceDetails', this.form.traceDetails);
      fd.append('traceType', this.form.traceType);
      fd.append('traceResult', this.form.traceResult);
      fd.append('customerName', this.form.customerName);
      fd.append('processStatus', this.form.processStatus);
      fd.append('processType', this.form.processType);
      fd.append('inputUser', this.form.inputUser);
      fd.append('status', this.form.status);
      fd.append('type', this.form.type);
      fd.append('id', this.serverId);

      serverUp(fd).then((success) => {

        if (success.data.status === 200) {
          console.log('保存修改');
          this.contract_status = false
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
      // contractform: {
      //         traceId: '',
      //         part_a: '',
      //         part_b: '',
      //         seller: '',
      //         creatTime: '',
      //         finishTime: '',
      //         serverType: '',
      //         money: '',
      //         payType: '',
      //         moneyStatus: '',
      //         traceId: '',
      //         job: '',
      let fd = new FormData()
      // fd.append('traceId', this.contractform.traceId);
      fd.append('part_a', this.contractform.part_a);
      fd.append('part_b', this.contractform.part_b);
      fd.append('seller', this.contractform.seller);
      fd.append('creatTime', this.now);
      fd.append('finishTime', this.now);
      fd.append('serverType', this.contractform.serverType);
      fd.append('money', this.contractform.money);
      fd.append('payType', this.contractform.payType);
      fd.append('moneyStatus', this.contractform.moneyStatus);
      fd.append('traceId', this.serverId);
      fd.append('job', this.contractform.job);
      contractAdd(fd).then((success) => {
        if (success.data.status === 200) {

          this.$message.success(success.data.message);
          // this.$forceUpdate()
          // this.tableData.splice(index, 1)
          // this.resetForm()
          // this.st
          this.contract_status = true
        } else {
          this.$message.info(success.data.message);
        }
        // console.log("jljklhklh" + this.ruleForm.username);
      }).catch(error => {
        this.$message.error('出错了，请联系管理员 ');

      })

      //提交合同


    }
    //me
  }

}
</script>

<style>
</style>