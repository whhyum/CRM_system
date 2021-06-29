import request from '@/utils/api'


//跟进进度
export function serverList(data) {
    return request({
        url: '/trace/list',
        headers : {"Content-Type" : "application/json;charset=utf-8"},
        method: 'post',
        // dataType: "json",
        data
    })
}

export function serverAdd(data) {
  return request({
      url: '/trace/add',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data
  })
}
export function serverDel(data) {
  return request({
      url: '/trace/deleteById',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data
  })
}

export function serverUp(data) {
  return request({
      url: '/trace/update',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data
  })
}

export function serverStatus(data) {
  return request({
      url: '/user/getTypeData',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data
  })
}

export function serverNum(data) {
  return request({
      url: '/user/num',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data
  })
}
// http://localhost:8082/trace/selectTop5ByDate

export function selectTop5ByDate(data) {
  return request({
      url: '/trace/selectTop5ByDate',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data
  })
}