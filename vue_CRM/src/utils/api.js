import axios from 'axios'
import store from '@/store'

//const baseURL="localhost:8088/api"

//创建axios实例
const service = axios.create({
    baseURL: 'http://127.0.0.1:8082', // api的base_url
    headers: {
      // "Content-Type": "application/x-www-form-urlencoded",
      // "content-type":"application/json;charset=utf-8",
      "Content-Type":"multipart/form-data",
      "token": window.sessionStorage.getItem("token")
  }
})

// request 请求拦截
service.interceptors.request.use(
    config => {
        if (store.getters.getToken) {
          console.log(store.getters.getToken)
          config.headers['token'] = window.sessionStorage.getItem("token")
        }
        return config
    },
    error => {
        // do something with request error
        console.log(error) // for debug
        return Promise.reject(error)
    }
)

axios.interceptors.response.use(success => {
  if (success.status && success.status == 200 && success.data.status == 500) {
    Message.error({message: success.data.msg})
    return;
  }
  if (success.data.msg) {
    Message.success({message: success.data.msg})
  }
  return success.data;
}, error => {
  if (error.response.status == 504 || error.response.status == 404) {
    Message.error({message: '服务器出错'})
  } else if (error.response.status == 403) {
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
  // console.log('asafssdfasg')
  return;
})

let base = ''; // 加其他路径

export const postKeyValueRequest = (url, params) => {
  return axios({
    method: 'post',
    url: `${base}${url}`,
    data: params,
    transformRequest: [function (data) {
      let ret = '';
      for (let i in data) {
        ret += encodeURIComponent(i) + '=' + encodeURIComponent(data[i]) + '&'
      }
      return ret;
    }],
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  });
}
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


export default service

