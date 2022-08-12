import axios from "axios";
import ElementUI from "element-ui";
import router from "./router"

//设置axios访问基础路径
// axios.defaults.baseURL = "http://localhost:8081"

const resAxios = axios.create({
    timeout: 5000,
    headers:{
        "content-type": "application/json"
    }
})

//设置拦截器前置拦截器
resAxios.interceptors.request.use(config=>{
    //jwt的携带
    config.headers['Authorization'] = localStorage.getItem('token')
})
//设置拦截器后置拦截器
resAxios.interceptors.response.use(resp => {
    console.log("resp"+resp);
    //非系统内部异常，返回了resp对象
    if(resp.data.code === 200)      //请求成功
        return resp;
    else {      //请求失败
        ElementUI.Message.error(resp.data.msg ? resp.data.msg : '系统异常')
        return Promise.reject(resp.data.msg)
    }
},error=>{
    console.log(error);
    if(error.response.data) //返回的Result数据不为空
        error.message = error.response.data.msg

    if(error.response.status === 401) //状态码401，无权限，路由跳转登录界面
        router.push("/login")   
    ElementUI.Message.error(error.message,{duration:3000})  //用饿了么报错
    return Promise.reject(error)
})

export default resAxios