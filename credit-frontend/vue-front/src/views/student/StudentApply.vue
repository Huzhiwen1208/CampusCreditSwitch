<template>
  <div class="apply">
    <div class="header">
      <el-steps :active="step" align-center>
        <el-step title="选择申请专业" description=""></el-step>
        <el-step title="填写申请表" description=""></el-step>
        <el-step title="联系方式" description=""></el-step>
        <el-step title="待审核" description=""></el-step>
      </el-steps>
    </div>
    <div v-if="step === 1" class="main">
      <div class="left1">
        <el-select
          v-model="value"
          placeholder="请选择目标专业"
          style="width: 300px"
        >
          <el-option v-for="item in majors" :key="item.id" :value="item.name">
          </el-option>
        </el-select>
      </div>
      <div class="right1">
        <el-button @click="next2()" type="primary" style="width: 300px"
          >下一步</el-button
        >
      </div>
    </div>
    <div v-else-if="step === 2" class="main align">
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="申请人">
          <el-input v-model="form.name" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item label="学号">
          <el-input v-model="form.id" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item label="校届选择">
          <el-select
            v-model="form.grade"
            style="width: 300px"
            placeholder="请选择校届"
          >
            <el-option label="大一" value="大一"></el-option>
            <el-option label="大二" value="大二"></el-option>
            <el-option label="大三" value="大三"></el-option>
            <el-option label="大四" value="大四"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="学院">
          <el-input v-model="form.academy" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item label="专业班级">
          <el-input v-model="form.major" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item label="已修读学分">
          <el-input v-model="form.totalCredits" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item label="申请时间">
          <el-col :span="20">
            <el-date-picker
              type="date"
              style="width: 300px"
              placeholder="选择日期"
              v-model="form.applyDate"
            ></el-date-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="本专业情况">
          <el-select
            v-model="form.preMajor"
            style="width: 300px"
            placeholder="本专业是否存在未通过课程"
          >
            <el-option label="是" value="1"></el-option>
            <el-option label="否" value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 130px" @click="back1"
            >上一步</el-button
          >
          <el-button type="primary" style="width: 130px" @click="next3"
            >下一步</el-button
          >
        </el-form-item>
      </el-form>
    </div>
    <div v-else-if="step === 3" class="main">
      <div class="top3">
        您的联系方式
        <el-input
          placeholder="请输入您的邮箱"
          style="width: 300px; margin-left: 20px"
          v-model="mail"
        ></el-input>
      </div>
      <div class="bottom3">
        <el-button type="primary" style="width: 120px" @click="back2"
          >上一步</el-button
        >
        <el-button type="primary" style="width: 120px" @click="next4"
          >提交申请</el-button
        >
      </div>
    </div>
    <div v-else-if="step === 4" class="main">
      <el-result icon="success" title="提交成功" subTitle="请耐心等待审核">
        <template slot="extra">
          <el-button type="primary" @click="toIndex" size="medium"
            >返回首页</el-button
          >
        </template>
      </el-result>
    </div>
  </div>
</template>

<script>
export default {
  name: "StudentApply",
  mounted() {
    this.clear();
  },
  data() {
    return {
      step: 1,
      mail: "",
      value: "",
      majors: [
        {
          id: 10001,
          name: "计算机科学与技术",
        },
        {
          id: 10002,
          name: "电气工程",
        },
        {
          id: 10003,
          name: "冶金工程",
        },
        {
          id: 10004,
          name: "教育技术学",
        },
      ],
      form: {
        name: "王丽",
        id: "20191514",
        major: "18计科2",
        preMajor: "0",
        applyDate: "",
        academy: "信息工程学院",
        grade: "大四",
        totalCredits:8.5
      },
    };
  },
  methods: {
    toIndex() {
      this.clear();
      this.step = 1;
    },
    clear() {
      this.value = "";
      this.$store.commit("SET_MAJOR", null);
      this.$store.commit("SET_APPLYER", null);
    },
    next2() {
      if (this.value === null || this.value === "")
        this.$message.error("请选择将要申请的专业");
      else {
        this.$store.commit("SET_MAJOR", this.value);
        this.step++;
      }
    },
    back1() {
      this.step--;
      this.value = this.$store.state.major;
    },
    back2() {
      this.step--;
    },
    next3() {
      for (let item in this.form) {
        console.log(item);
        console.log(this.form[item]);
        console.log();
        if (this.form[item] === null || this.form[item] === "") {
          this.$message.error("有未填项，请填写后操作");
          return;
        }
      }
      this.$store.commit("SET_APPLYER", this.form);
      this.step++;
    },
    next4() {
      if (this.mail.trim() === "") this.$message.error("请输入您的联系方式");
      else if (this.mail === "11111") {
          this.$message.error("请输入正确的邮箱格式！")
      } else {
        this.step++;
       
          this.$message.success('申请成功，请等待审核')
          setInterval(()=>{

            var dv = document.querySelector('.main')
            dv.innerHTML = '<h2> 恭喜您！您的申请已被受理通过！ </h2>'

          },10000)
        }
        
      }
    
  },
};
</script>

<style>
.header {
  background-color: #fff;
  padding-top: 20px;
  margin-bottom: 70px;
}
.main {
  text-align: center;
}
.left1 {
  margin-bottom: 30px;
}
.align {
  display: flex;
  align-items: center;
  justify-content: space-around;
}
.top3 {
  margin-top: 30px;
  margin-bottom: 30px;
}
.bottom3 {
  margin-bottom: 30px;
  margin-left: 112px;
}
</style>