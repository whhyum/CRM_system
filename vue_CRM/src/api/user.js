import request from '@/utils/api'

export function userLogin(data) {
    return request({
        url: '/api/login',
        headers : {"Content-Type" : "application/json;charset=utf-8"},
        method: 'post',
        // dataType: "json",
        data
        
    })
}

export function userSend(data) {
  return request({
      url: '/send',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data
      
  })
}

export function userReg(data) {
  return request({
      url: 'http://cbd277c00321.ngrok.io/api/login',
      method: 'post',
      data,
  })
}