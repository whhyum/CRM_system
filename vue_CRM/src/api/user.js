import request from '@/utils/request'

export function userLogin(data) {
    return request({
        url: 'http://a331c7816ed5.ngrok.io/api/login',
        method: 'post',
        data
    })
}