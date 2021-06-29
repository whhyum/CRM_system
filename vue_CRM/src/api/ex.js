import request from '@/utils/api'

export function exList(data) {
    return request({
        url: '/judge/selectAll',
        headers : {"Content-Type" : "application/json;charset=utf-8"},
        method: 'post',
        // dataType: "json",
        data

    })
}
// http://localhost:8082/employee/num

export function exNum(data) {
  return request({
      url: '/employee/num',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data

  })
}

export function exAdd(data) {
  return request({
      url: '/judge/add',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data

  })
}
// http://localhost:8082/employee/deleteById

export function employeeDel(data) {
  return request({
      url: '/employee/deleteById',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data

  })
}

// http://localhost:8082/employee/update

export function exUp(data) {
  return request({
      url: '/employee/update',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data

  })
}