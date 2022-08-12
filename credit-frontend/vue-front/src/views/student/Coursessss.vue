<template>
  <div>
    <h2 style="margin-left: 420px; letter-spacing: 4px">欢迎学习以下课程</h2>
    <hr />
    <el-row>
      <el-col
        :span="4"
        v-for="(o, index) in books"
        :key="index"
        style="margin-left: 30px"
      >
        <el-card :body-style="{ padding: '0px' }">
          <img
            style="width: 180px; margin-left: 12px; margin-top: 10px"
            :src="o.url"
            class="image"
          />
          <div style="padding: 14px">
            <span>{{ o.description }}</span>
            <div class="bottom clearfix">
              <el-button type="text" @click="show(o)" class="button"
                >课程详情</el-button
              >
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
      <el-form ref="form" :model="book" label-width="80px">
        <el-form-item label="课程号">
          <el-input v-model="book.id"></el-input>
        </el-form-item>
        <el-form-item label="指导教师">
          <el-input v-model="book.teacher"></el-input>
        </el-form-item>

        <el-form-item label="课程英文名">
          <el-input v-model="book.englishName"></el-input>
        </el-form-item>
        <el-form-item label="所含学分">
          <el-input v-model="book.credit"></el-input>
        </el-form-item>
        <el-form-item label="课程详情">
          <el-input type="textarea" v-model="book.detail"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="dialogVisible = false"
            >暂不学习</el-button
          >
          <el-button type="success" @click="concrete(book)">加入学习</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "Coursessss",
  data() {
    return {
      book: {
        id: "",
        englishName: "",
        credit: "",
        detail: "",
        teacher: "",
      },
      dialogVisible: false,
      books: [
      {
        url: "/os.png",
        detail: "ososos",
        credit: "2",
        id: "HBKJ10010",
        teacher:'李士勇',
        englishName:'operating system',
        description: "操作系统",
      },
      {
        url: "/cn.png",
        detail: "ososos",
        credit: "2",
        id: "HBKJ10001",
        description: "计算机网络",
        teacher:'李士勇',
        englishName:'computer network',
      },
      {
        url: "/linux.png",
        detail: "ososos",
        credit: "2",
        id: "HBKJ10231",
        description: "Linux系统",
        teacher:'李士勇',
        englishName:'Linux operating system',
      },
      {
        url: "/ds.png",
        detail: "ososos",
        credit: "2",
        id: "HBKJ10888",
        description: "数据结构",
        teacher:'李士勇',
        englishName:'data structure'
      },
      {
        url: "/cp.png",
        detail: "ososos",
        credit: "2",
        id: "HBKJ10056",
        description: "计算机原理",
        teacher:'李士勇',
        englishName:'computer theory'
      },
      {
        url: "/java.png",
        detail: "ososos",
        credit: "3",
        id: "HBKJ20010",
        description: "Java程序设计基础",
        teacher:'李士勇',
        englishName:'Java programming foundation'
      },
      {
        url: "/suanfa.png",
        detail: "ososos",
        credit: "3.5",
        id: "HBKJ20310",
        description: "算法设计与分析",
        teacher:'李士勇',
        englishName:'algorithm design and analysis'
      },
      {
        url: "/web.png",
        detail: "ososos",
        credit: "2",
        id: "HBKJ10353",
        description: "Web网页设计",
        teacher:'李士勇',
        englishName:'Web design'
      },
      {
        url: "/data.png",
        detail: "ososos",
        credit: "2.5",
        id: "HBKJ30000",
        description: "数据分析",
        teacher:'李士勇',
        englishName:'Data analysis'
      },
      {
        url: "/eng.png",
        detail: "ososos",
        credit: "1.5",
        id: "HBKJ30001",
        description: "计算机英语",
        teacher:'李士勇',
        englishName:'computer english'
      },
      ],
    };
  },
  methods: {
    show(book) {
      this.book = book;
      this.dialogVisible = true;
    },
    concrete(book) {
      this.$confirm("是否确认选择学习该课程？", "提示", "{type:info}")
        .then(() => {
            let bookList = this.$store.state.books
            console.log(bookList);
            let ids = []
          for(let i = 0; i < bookList.length;i++){
              ids.push(bookList[i].id)
          }
          if (ids.indexOf(book.id) < 0) {
            this.$store.commit("ADDONE", book);
            this.$message.success("选择成功！请查看《我的课程》");
          } else {
            this.$message.error("课程已被学习！");
          }
          this.dialogVisible = false;
        })
        .catch(() => {
          this.$message.info("取消操作！");
        });
    },
  },
};
</script>

<style>
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}
.el-card:hover {
  margin-top: -5px;
}
</style>