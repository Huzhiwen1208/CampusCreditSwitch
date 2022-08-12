<template>
  <div class="apply">
    <div class="oneCard" v-for="(req, idx) in applierList" :key="idx">
      <el-card shadow="hover">
        <div class="datee">
          {{ req.date }}
          <el-badge v-show="req.status === 0" value="new" class="item">
          </el-badge>
        </div>

        <div class="content">
          <span class="fontp"
            >来自学号<span class="idd">{{ req.id }}</span
            >学生的申请</span
          >
          <el-button v-if="req.status === 1" style="margin-left: 0" type="info"
            >已受理</el-button
          >
          <el-button
            @click="subAppliers(req)"
            v-else-if="req.status === 0 && req.id != '20191588' "
            style="margin-left: 0"
            :type="type1"
            >{{ contentA }}</el-button
          >
          <el-button v-else-if="req.id === '20191588' " style="margin-left: 0" type="danger"
            >未受理</el-button
          >
        </div>
      </el-card>
    </div>
    <el-dialog title="申请人信息" :visible.sync="dialogVisible" width="30%">
      <el-form ref="form" :model="showCon" label-width="80px">
        <el-form-item label="学生姓名">
          <el-input v-model="showCon.name"></el-input>
        </el-form-item>
        <el-form-item label="学生学号">
          <el-input v-model="showCon.id"></el-input>
        </el-form-item>
        <el-form-item label="原学院">
          <el-input v-model="showCon.xueyuan"></el-input>
        </el-form-item>
        <el-form-item label="原专业">
          <el-input v-model="showCon.major"></el-input>
        </el-form-item>
        <el-form-item label="已得学分">
          <el-input v-model="showCon.credits"></el-input>
        </el-form-item>
        <el-form-item label="申请时间">
          <el-input v-model="showCon.date"></el-input>
        </el-form-item>
      </el-form>

      <span style="text-align: center; margin-left: 107px">
        <el-button type="primary" @click="passOne">给予通过</el-button>
        <el-button type="danger" @click="noPassOne">驳回申请</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="请填写驳回理由"
      :visible.sync="dialogVisible4Reason"
      width="30%"
    >
      <el-input
        type="textarea"
        :rows="6"
        placeholder="请在此填写驳回理由"
        style="margin-bottom: 20px"
        v-model="textarea"
      >
      </el-input>

      <span style="text-align: center; margin-left: 107px; margin-top: 30px">
        <el-button type="danger" @click="concrete">确定驳回</el-button>
        <el-button @click="cancel">取消驳回</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "Apply",
  mounted() {
    this.$store.commit("SET_APPLIERLIST", this.applierList);
    this.$axios.get("http://localhost:8081/appliers").then((res) => {
      this.appliers = res.data;
      for (let i = 0; i < this.appliers; i++) {
        this.applierList.splice(0, 0, this.addOne);
      }
    });
  },
  data() {
    return {
      dialogVisible: false,
      dialogVisible4Reason: false,
      textarea: "",
      appliers: 0,
      type1: "danger",
      contentA: "未受理",
      // addOne:{
      //     id:'20191514',
      //     status:0,
      //     date:'2022-4-28',
      //     major:'计算机科学与技术',
      // },
      applierList: [
        {
          id: "20191514",
          status: 0,
          date: "2022-4-28",
          major: "计算机科学与技术",
        },
        {
          id: "20191588",
          status: 0,
          date: "2022-4-28",
          major: "计算机科学与技术",
        },
        {
          id: "20190303",
          status: 1,
          date: "2022-4-1",
          major: "计算机科学与技术",
        },
        {
          id: "20210311",
          status: 1,
          date: "2022-2-4",
          major: "计算机科学与技术",
        },
        {
          id: "20210310",
          status: 1,
          date: "2022-1-2",
          major: "计算机科学与技术",
        },
        {
          id: "20180308",
          status: 1,
          date: "2021-5-4",
          major: "计算机科学与技术",
        },
        {
          id: "20180309",
          status: 1,
          date: "2021-5-4",
          major: "计算机科学与技术",
        },
      ],
      showCon: {
        id: "20191514",
        date: "2022-4-28",
        major: "计算机科学与技术",
        name: "王丽",
        xueyuan: "信息工程学院",
        credits: "8.5",
      },
    };
  },
  // watch: {
  //   applierList: {
  //     handler(newVal, oldVal) {
  //       this.$store.commit('SET_APPLIERLIST',this.applierList)
  //     },
  //     deep: true
  //   }
  // },
  methods: {
    subAppliers(req) {
      this.$axios.delete("http://localhost:8081/appliers").then((res) => {
        console.log("1111");
        this.dialogVisible = true;
        this.$store.commit('SET_APPNEW','')
      });
    },

    passOne() {
      this.$message.success("已同意20191514 王丽 同学的申请！");
      this.type1 = "info";
      this.contentA = "已受理";
      console.log(this.type1);
      this.dialogVisible = false;
    },
    noPassOne() {
      this.dialogVisible4Reason = true;
    },
    concrete() {
      this.$message.info("已经驳回20191514王丽同学的申请!");

      this.dialogVisible = false;
      this.dialogVisible4Reason = false;
    },
    cancel() {
      this.$message.info("取消驳回操作");
      this.dialogVisible4Reason = false;
      location.reload();
    },
  },
};
</script>

<style>
.oneCard {
  width: 70%;
  margin-left: 172px;
  background-color: #ccc;
  cursor: pointer;
  margin-bottom: 20px;
}
.el-card {
  height: 100px;
  margin: 0;
  padding: 0;
}
.oneCard:hover {
  height: 98px;
}
.datee {
  margin: 0;
  padding: 0;
  letter-spacing: 1px;
  font-weight: bold;
}
.el-card__body {
  padding: 8px;
}
.content {
  display: flex;
  align-items: center;
  justify-content: space-around;
}
.fontp {
  letter-spacing: 3px;
  font-size: 24px;
}
.idd {
  color: #f15757;
}
.item {
  margin-left: 720px;
}
</style>