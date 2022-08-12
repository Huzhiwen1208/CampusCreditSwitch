<template>
<div class="home">
  <div class="homeSub">
      <div class="floatL left">
         <a href="https://www.hist.edu.cn/">
          <div class="l-top">
              
            <img @mousemove= "toIndex" @mouseleave="toIndexCancel" src="@/assets/logo1.png" style="margin-top:0;height:80px;cursor:pointer;"></img>
          </div>
          </a>
          <div class="l-middle">
              <div style="font-size:34px; margin-top:15px;">校园学分认证</div>
              <div style="font-size:11px; margin-top:10px; ">Authentication of credits in college</div>
              <div style="width:100%;height:150px;margin-left:20px;">
                <a href="http://localhost:8082/login/">
                  <div class="fun-left">
                      <div style="margin:0;padding:0;">
                          <img src="/学生登录.png" style="width:90px;margin:0;padding:0;">
                      </div>
                      <div  style="margin-top:10px;color:#000;font-size:17px;">
                          学生登录
                      </div>
                  </div>
                  </a>
                  <div class="fun-right">
                    <a href="http://localhost:8080/login/">
                      <div style="margin:0;padding:0;">
                          <img src="/老师登录.png" style="width:90px;margin:0;padding:0;">
                      </div>
                      <div style="margin-top:10px;color:#000;font-size:17px;">
                          教师登录
                      </div>
                    </a>
                  </div>
              </div>
              <div style="width:100%;height:150px; margin-left:20px;">
                  <div class="fun-left">
                    <a href="http://localhost:8080/login/">
                      <div style="margin:0;padding:0;">
                          <img  src="/管理登录.png" style="width:90px;margin:0;padding:0;">
                      </div>
                      <div  style="margin-top:10px;color:#000;font-size:17px;">
                          管理登录
                      </div>
                      </a>
                  </div>
                  <div class="fun-right">
                      <div style="margin:0;padding:0;">
                          <el-image src="http://zsjyc.ncst.edu.cn/atm/1589187409104/20200511170109575.png" style="width:90px;margin:0;padding:0;"></el-image>
                      </div>
                      <div style="margin-top:10px;color:#000;font-size:17px;">
                          公告信息
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <div class="floatL right">
         <div class="r-top" style="height:80%;">
             <el-carousel :interval="4000" height="400px"  trigger="click">
                <el-carousel-item v-for="(item,idx) in UrlList" :key="idx">
                    <el-image :src="item" style="padding-left:25px; margin-top:10px; padding-right:15px;height:500px;width:800px;"></el-image>
                </el-carousel-item>
            </el-carousel>
         </div>
         <div style="text-align:center;background:#f1f1f1; height:80px; width:700px;  margin-left:150px; margin-top:30px;">

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="mailto:shuji@ncst.edu.cn" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">学校首页</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="mailto:xiaozhang@ncst.edu.cn" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">教学信息</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="/xwgk/" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">教学机构</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="http://jwc.ncst.edu.cn/col/1423961950339/2020/03/05/1504576143548.html" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">文献检索</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="http://kyglxt.ncst.edu.cn/business/login.jsp" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">科研系统</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="http://elearning.ncst.edu.cn" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">OA系统</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="http://xxfw.ncst.edu.cn/" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">教务管理</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="http://fxcszx.ncst.edu.cn/" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">学生管理</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="http://xkjs.ncst.edu.cn" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">科研管理</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="http://hqggfw.ncst.edu.cn/" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">后勤服务</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="http://www.qgxy.cn/" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">VPN入口</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="http://jtxy.ncst.edu.cn/" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">教务系统</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="http://qaxy.ncst.edu.cn/" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">红色资源</a>
</div>

<div style="float:left; width:auto; text-algin:center;  line-height:30px; padding:5px 20px;"><a href="http://www.myfy.com.cn/" target="_blank" style="color:#333333; font-size:14px;font-family:'Microsoft YaHei' ! important; ">学习系统</a>
</div>

<div class="clearfloat"></div>
</div>
      </div>
      <div class="clearfloat"></div>
      <div class="foot">
  
          <div @click="dialogVisible = true" class="foot-row" style="background: url('http://zsjyc.ncst.edu.cn/atm/1589187409104/20200602112815977.png') no-repeat;" >
            <div style="float:left; margin-left:40px; margin-right:20px; padding-top:8px; padding-left:8px;"><img src="http://zsjyc.ncst.edu.cn/atm/1589187409104/20200520085817254.png"></div>
            <div style="float:left; font-size:18px;">学分认证简介</div>
            <div style="clear:both"></div>
          </div>
          <div class="foot-row" style="background: url('http://zsjyc.ncst.edu.cn/atm/1589187409104/20200602112815977.png') no-repeat;">
            <div style="float:left; margin-left:40px; margin-right:20px; padding-top:8px; padding-left:8px;"><img src="http://zsjyc.ncst.edu.cn/atm/1589187409104/20200520085817376.png"></div>
            <div style="float:left; font-size:18px;">认证类型</div>
            <div style="clear:both"></div>
          </div>
          <div class="foot-row"  style="background: url('http://zsjyc.ncst.edu.cn/atm/1589187409104/20200602112815977.png') no-repeat;">
            <div style="float:left; margin-left:40px; margin-right:20px; padding-top:8px; padding-left:8px;"><img src="http://zsjyc.ncst.edu.cn/atm/1589187409104/2020052008581729.png"></div>
            <div style="float:left; font-size:18px;">认证指南</div>
            <div style="clear:both"></div>
          </div>
          <div class="foot-row" style="background: url('http://zsjyc.ncst.edu.cn/atm/1589187409104/20200602112815977.png') no-repeat;" >
            <div style="float:left; margin-left:40px; margin-right:20px; padding-top:8px; padding-left:8px;"><img src="http://zsjyc.ncst.edu.cn/atm/1589187409104/20200520085817450.png"></div>
            <div style="float:left; font-size:18px;">联系我们</div>
            <div style="clear:both"></div>
          </div>
          
      </div>
  </div>
  <el-dialog
  title="认证简介"
  :visible.sync="dialogVisible"
  width="30%"
  ><p>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基于我国高考政策、高招录取规则和高考生对学科认知的局限性等多方面因素，
    大学生入学后产生对当前专业不满意或不适应等情况，进而产生了学生转其他专业的需要。
    学生入校后随着对专业理解的深入，自身的兴趣和发展、就业前景、专业的教学水平等因素，
    也促使一些学生产生调整专业的需求。 
转专业关系到学生的兴趣发展和能力的挖掘，转专业问题成为高校迫切关注的问题之一。
近年来多所高校和学者开展了对学生转专业原因和状况的研究和分析，有学者通过调查研究发现：
学业挫折、就业前景和兴趣爱好等是学生转专业的主因，超过 40% 的受访学生具有转专业意向，
其中大学一年级学生意 
向最强，随着年级升高，转专业意向减弱。2003 年 1 月，复旦大学 244 名大学生重新选择了
自己的专业，首次开辟了我国高校转专业的先例。紧随其后，国内浙江大学、吉林大学、山东大
学等一大批高校跟进，陆续公布了自己的转专业管理办法，也对申请时间、条件、流程等做出了
详实的规定。 <br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;近年来，全国高校本科生转专业的总体情况呈现如下的发展特点：（1）本科学生转专业人数逐
年增多，申请学生积极报名，甚至出现“竞争激烈”的场面；（2）各高校不断依据自身特色，出
台更加规范可行的政策，细则详细明确，便于有条不紊的执行；（3）本科生重新选择专业由原
来盲目追求热门专业向更 
加理性化发展，学生除了关注自身兴趣外还综合考虑学习环境、人生价值等因素；（4）二级学
院拥有了更多的自主权，而志愿填报、按流程审核、录取等业务趋于规范，也更加科学。 
校园学分认证系统的设计与实现，注重学生兴趣和专长，便于充分发挥高校的教学资源承载能
力。<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本系统在转专业准入条件、跨学院转专业、学院内转专业等方面制定了详实的申报资格、
选拔考核规则等，转专业条件设置合理， 使申报录取工作过程灵活性得到了进一步提升。
我国高校的数字化校园建设也在不断完善教学的数字化、科研的数字化、管理的数字化和服务
的数字化。转专业业务和教学、科研、管理等多个方面息息相关，建立数字化的转专业信息管
理系统成为数字化校园建设中的一个重要环节 [2]。为了更好的实现转专业管理，校园学分
认证系统将转专业工作完全 通过信息管理平台执行，通过该系统校师生可以方便有效地进行
申请、查询、录取等一系列转专业相关业务。另外，转专业系统作为数字化校园大平台的一个
模块，在建设过程中，需要遵循统一身份认证、数据交互共享的基本原则，为学生、教师和管
理人员提供便捷服务，实现数字化校园大平台数据的有效共享，能够给学校其他业务系统提供
服务和支持，也能够为学校的各项决策提供数据支持，进一步推进学校的信息化发展 [3]。</p>
  <span slot="footer" class="dialog-footer">
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
</el-dialog>
</div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      UrlList: ["/xiaoxun1.png", "/keep01.png", "/keep02.png"],
      dialogVisible : false,
    };
  },
  methods: {
    toLogin() {
      this.$router.push("/login");
    },
    toIndex() {
      var img = document.querySelector(".l-top>img");
      img.style.height = "82px";
    },
    toIndexCancel() {
      var img = document.querySelector(".l-top>img");
      img.style.height = "80px";
    },
  },
};
</script>

<style>
.home {
  display: flex;
  align-items: center;
  justify-content: space-around;
  text-align: center;
}
.homeSub {
  margin-top: 30px;
  margin-left: 20px;
  margin-right: 20px;
  padding: 15px;
  border: 5px solid white;
  border-radius: 4px;
}
a {
  text-decoration: none;
}
.l-top {
  height: 70px;
  margin-left: 0;
  padding-left: 0;
}
.r-bottom {
  height: 11%;
  padding-top: 15px;
  margin-top: 3%;
  display: flex;
  align-items: center;
  justify-content: space-around;
  font-weight: bold;
  font-size: 30px;
  font-family: "\6977\4F53";
  letter-spacing: 4px;
}
.floatL {
  display: inline;
  float: left;
}
.left {
  width: 50vh;
  height: 70vh;
}
.right {
  width: 140vh;
  height: 70vh;
}
.foot {
  width: 190vh;
  height: 18vh;
  margin-top: 20px;
}
.foot-row {
  float: left;
  margin-left: 40px;
  width: 260px;
  height: 52px;
  line-height: 52px;
  cursor: pointer;
  margin-top: 40px;
  text-align: center;
}

.clearfloat {
  clear: both;
  height: 0;
  line-height: 0;
  font-size: 0;
}
.el-carousel-item .el-image {
  width: 800px;
}
.fun-left {
  float: left;
  width: 150px;
  height: 90%;
  margin-top: 30px;
  cursor: pointer;
}
.fun-right {
  float: left;
  width: 150px;
  height: 90%;
  cursor: pointer;
  margin-top: 30px;
}
</style>