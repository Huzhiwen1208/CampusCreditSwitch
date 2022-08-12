<template>
  <div>
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
                >查看详情</el-button
              >
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="30%"
    >
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
          <el-button type="primary" @click="dialogVisible = false">确定</el-button>
          <el-button type="danger" @click="onCancel(book)">取消学习</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "StudentCourse",
  mounted() {
    this.books = this.$store.state.books;
  },
  data() {
    return {
      book: {
        id:'',
        englishName: "",
        credit:'',
        detail:'',
        teacher:''
      },
      dialogVisible: false,
      books: []
    };
  },
  methods: {
    show(book) {
      this.book = book
      this.dialogVisible = true;
    },
    onCancel(book) {
      this.$confirm('是否确认终止学习该课程？此操作不可撤销！','警示','{type:error}').then(()=>{
        // this.books.
        for(let i = 0; i < this.books.length; i++){
          if(this.books[i].id === book.id){
            this.books.splice(i,1)
            break
          }
        }
        this.$message.success("此课程已终止学习！进度清零！");
        this.dialogVisible = false
      }).catch(()=>{
        this.$message.info('取消操作！')
      })
    }
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