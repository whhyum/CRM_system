import axios from 'axios'
import {Message} from 'element-ui';

// 相应拦截器
axios.interceptors.response.use(success =>{
  // 判断业务逻辑是否出错
  if(success.status && success.status ==200){
    if(success.data.code == 500||success.data.code == 401 ||success.data.code == 403){
      Message.error({message: success.data.message});
      return;
    }
    if(success.data.message){
      Message.success({message:success.data.message});
    }
  }
  return success.data;
}, error => {
  if(error.response.code == 504 || error.response.code == 404) {
    Message.error({message: '服务器出错'})
  }else if(error.response.status == 403) {
    Message.error({message: '权限不足，请联系管理员'})
  } else if (error.response.status == 401) {
    mymessage.error({message: error.response.data.msg ? error.response.data.msg : '尚未登录，请登录'})
    router.replace('/');
  } else {
    if (error.response.data.msg) {
      Message.error({message: error.response.data.msg})
    } else {
      Message.error({message: '未知错误!'})
    }
  }
  return;
})

// 创送JSON格式的POST请求
export const postRequest = (url, params) => {
  return axios({
    method: 'post',
    url: `${base}${url}`,
    data: params
  })
}
export const putRequest = (url, params) => {
  return axios({
    method: 'put',
    url: `${base}${url}`,
    data: params
  })
}
export const getRequest = (url, params) => {
  return axios({
    method: 'get',
    url: `${base}${url}`,
    params: params
  })
}
export const deleteRequest = (url, params) => {
  return axios({
    method: 'delete',
    url: `${base}${url}`,
    params: params
  })
}
