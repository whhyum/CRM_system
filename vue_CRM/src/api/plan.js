// http://localhost:8082/plan/addPlan

import request from '@/utils/api'

export function addPlan(data) {
    return request({
        url: '/plan/addPlan',
        headers : {"Content-Type" : "application/json;charset=utf-8"},
        method: 'post',
        // dataType: "json",
        data

    })
}
// http://localhost:8082/plan/selectAll

export function allPlan(data) {
  return request({
      url: '/plan/selectAll',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data

  })
}