<template>
  <div>
    <el-table
      :data="tableData"
      height="900"
      border
      stripe
      style="width: 100%"
      :cell-style="rowStyle"
      :header-cell-style="headerRowStyle"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="index" label="序号"></el-table-column>
      <el-table-column prop="date" label="修读日期"> </el-table-column>
      <el-table-column prop="id" label="课程号"> </el-table-column>
      <el-table-column prop="chineseName" label="中文名"> </el-table-column>
      <el-table-column prop="englishName" label="英文名"> </el-table-column>

      <el-table-column label="课程介绍">
        <template slot-scope="scope">
          <span @click="showDetail(scope.row)" style="text-decoration:underline;cursor: pointer;color:blue;">查看</span>
        </template>
      </el-table-column>

      <el-table-column prop="credits" label="所含学分"> </el-table-column>
      <el-table-column label="结果">
        <template slot-scope="scope">
          <el-button :type="scope.row.type" size="small" >{{scope.row.status}}</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog
      title="详情"
      :visible.sync="dialogVisible"
      width="30%"
    >
    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{content}}</span>
     <span slot="footer" class="dialog-footer">
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "StudentCredit",
  data() {
    return {
      content:'',
      dialogVisible: false,
      tableData: [
        {
          date: "2016-05-03",
          id:'HBKJ10001',
          chineseName : '计算机网络',
          englishName : 'computer network',
          credits:'2',
          status:'正在修读',
          type:'info',
          detail: "计算机网络也称计算机通信网。关于计算机网络的最简单定义是：一些相互连接的、以共享资源为目的的、自治的计算机的集合。若按此定义，则早期的面向终端的网络都不能算是计算机网络，而只能称为联机系统（因为那时的许多终端不能算是自治的计算机）。但随着硬件价格的下降，许多终端都具有一定的智能，因而“终端”和“自治的计算机”逐渐失去了严格的界限。若用微型计算机作为终端使用，按上述定义，则早期的那种面向终端的网络也可称为计算机网络。 ",
          
        },
        {
          date: "2016-06-03",
          id:'HBKJ10010',
          chineseName : '操作系统',
          englishName : 'operating system',
          credits:'2',
          status:'正在修读',
          detail: "在计算机中，操作系统是其最基本也是最为重要的基础性系统软件。从计算机用户的角度来说，计算机操作系统体现为其提供的各项服务；从程序员的角度来说，其主要是指用户登录的界面或者接口；如果从设计人员的角度来说，就是指各式各样模块和单元之间的联系。事实上，全新操作系统的设计和改良的关键工作就是对体系结构的设计，经过几十年以来的发展，计算机操作系统已经由一开始的简单控制循环体发展成为较为复杂的分布式操作系统，再加上计算机用户需求的愈发多样化，计算机操作系统已经成为既复杂而又庞大的计算机软件系统之一。 ",
          type:'info',
        },
        {
          date: "2017-01-01",
          id:'HBKJ10056',
          chineseName : '计算机原理',
          englishName : 'computer theory',
          credits:'3',
          status:'通过',
          type:'primary'
        },
        {
          date: "2017-03-11",
          id:'HBKJ10231',
          chineseName : 'Linux操作系统',
          englishName : 'Linux operating system',
          credits:'2.5',
          status:'正在修读',
          type:'info',
        },
        {
          date: "2017-05-03",
          id:'HBKJ10353',
          chineseName : 'Web网页设计',
          englishName : 'Web design',
          credits:'1.5',
          status:'通过',
          type:'primary'
        },
        {
          date: "2017-07-07",
          id:'HBKJ20010',
          chineseName : 'Java程序设计基础',
          englishName : 'Java programming foundation',
          credits:'3',
          status:'未通过',
          type:'danger',
          detail:'',
        },
        {
          date: "2017-08-03",
          id:'HBKJ10079',
          chineseName : 'C#程序设计基础',
          englishName : 'C# programming foundation',
          credits:'2.5',
          status:'正在修读',
          type:'info'
        },
        {
          date: "2018-02-03",
          id:'HBKJ10888',
          chineseName : '数据结构',
          englishName : 'data structure',
          credits:'4',
          status:'通过',
          type:'primary'
        },
        {
          date: "2018-05-12",
          id:'HBKJ20310',
          chineseName : '算法设计与分析',
          englishName : 'algorithm design and analysis',
          credits:'3.5',
          status:'通过',
          type:'primary'
        },
       
      ],
    };
  },
  methods: {
      showDetail(row) {
        this.content = row.detail;
        this.dialogVisible = true;
      },
    toggleSelection(rows) {
      if (rows) {
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },

    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    rowStyle() {
      return "text-align:center";
    },
    headerRowStyle() {
      return "text-align: center";
    },
  },
};
</script>

<style>
</style>