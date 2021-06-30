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




export function userNum(data) {
  return request({
      url: '/employee/num',
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
      url: '/checkCore',
      method: 'post',
      data,
  })
}


export function userDel(data) {
  return request({
      url: '/user/delete',
      method: 'post',
      data,
  })
}

export function userUp(data) {
  return request({
      url: '/user/update',
      method: 'post',
      data,
  })
}

export function userAdd(data) {
  return request({
    url: '/user/add',
    method: 'post',
    data,
  })
}

export function userList(data) {
  return request({
    url: '/user/list',
    method: 'post',
    data,
  })
}

export function userStar(data) {
  return request({
    url: '/user/selectStar',
    method: 'post',
    data,
  })
}

export function userSeach(data) {
  return request({
    url: '/user/list',
    method: 'post',
    data,
  })
}



// http://localhost:8082/selectInput_user

export function userComplainA(data) {
  return request({
    url: '/selectInput_user',
    method: 'post',
    data,
  })
}
// http://localhost:8082/complain/add

export function userComplainB(data) {
  return request({
    url: '/complain/add',
    method: 'post',
    data,
  })
}






////////////////////////////////////////
// userStar(this.$qs.stringify({

// })
// ).then((success) => {
//   if (success.data.status === 200) {
//     this.$message.success(success.data.message);
//   } else {
//     this.$message.error(success.data.message);
//   }
// }).catch(error => {
//   this.$message.error('出错了，请联系管理员');
// })
