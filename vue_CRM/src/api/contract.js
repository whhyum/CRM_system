import request from '@/utils/api'

export function contractAdd(data) {
    return request({
        url: '/contract/add',
        headers : {"Content-Type" : "application/json;charset=utf-8"},
        method: 'post',
        // dataType: "json",
        data

    })
}

export function contractServer(data) {
  return request({
      url: '/selectByTrace_id',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data

  })
}

export function contractName(data) {
  return request({
      url: '/selectByUsername',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data

  })
}

export function contractList(data) {
  return request({
      url: '/contract/list',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data

  })
}
export function contractNum(data) {
  return request({
      url: '/contract/num',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data

  })
}