import Mock from 'mockjs' 

const Random = Mock.Random
let Result = {
    code: 200,
    msg: "操作成功",
    data: null
}
Mock.mock('/codepath','get',()=>{
  let str = Random.string('lower1234567890',5)
    Result.data = {
        token: Random.string(32),
        codeImgPath: Random.dataImage('100x40',str)
    }
    console.log(Result.data.codeImgPath);
    return Result;
})
Mock.mock('/login','post',()=>{
    console.log('调用post');
    return Result;
})


Mock.mock('/user/Admin','get',()=>{
    console.log('获取管理员信息');
    Result.data = {
        id:'2',
        username:'王 丽',
        password:'123456',
        avatar:'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.wmzhe.top%2Fuploadimg%2Fpc%2F5c%2F5c09%2F5c09a8174a7a41f8d67e8f3247d64496.jpg&refer=http%3A%2F%2Fimg.wmzhe.top&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1651975732&t=7e3a2a70c59b2a8caacb3006742b6e82'
    }
    return Result;
})
Mock.mock('/logout','post',(req)=>{
    // console.log("req: "+req);
    Result.data = [
        {
            id:201814660302,
            name:'胡志文',
            grade:'大四',
            mail:'29308@qq.com',
            academy:'冶金',
            major:'材料3班',
            card:'411423200012085533'
        }
    ]
    return Result;
})


Mock.mock('/users/menus','get',(req)=>{
    console.log("req: "+req);
    Result.data = {
        navSub: [
            {
              title: "权限管理",
              name: "权限管理",
              path: "",
              icon: "el-icon-s-check",
              component:'',
              children: [
                {
                  title: "用户管理",
                  name: "User",
                  path: "/users",
                  component:'/sys/User',
                  icon: "el-icon-s-custom",
                  children:[]
                },
                {
                  title: "菜单管理",
                  name: "菜单管理",
                  path: "/menus",
                  component:'/sys/Menu',
                  icon: "el-icon-menu",
                  children:[]
                },
              ],
            },
          ],
        navNoSub:[
            {
              title: "课程管理",
              name: "课程管理",
              path: "/classes",
              component:'/sys/Class',
              icon: "el-icon-s-custom",
              children:[]
            },
            {
              title: "公告信息管理",
              name: "公告信息管理",
              path: "/infos",
              component:'/sys/Info',
              icon: "el-icon-menu",
              children:[]
            },
            // {
            //   title: "公告信息管理",
            //   name: "公告信息管理2",
            //   path: "",
            //   icon: "el-icon-menu",
            //   component:'',
            //   children:[]
            // },
            // {
            //   title: "公告信息管理",
            //   name: "公告信息管理3",
            //   path: "",
            //   component:'',
            //   icon: "el-icon-menu",
            //   children:[]
            // },
        ],
        perm: []
    }
    return Result;
})