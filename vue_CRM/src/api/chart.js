import request from '@/utils/api'

export function getMoneyData(data) {
    return request({
        url: '/getMoneyData',
        headers : {"Content-Type" : "application/json;charset=utf-8"},
        method: 'post',
        // dataType: "json",
        data

    })
}

export function getJudgeData(data) {
  return request({
      url: '/getJudgeData',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data

  })
}

export function getJobData(data) {
  return request({
      url: '/getJobData',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data

  })
}

export function getJobMoneyData(data) {
  return request({
      url: '/getJobData',
      headers : {"Content-Type" : "application/json;charset=utf-8"},
      method: 'post',
      // dataType: "json",
      data

  })
}