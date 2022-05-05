import request from '@/utils/request'

// 查询解疑辅导室预约信息列表
export function listStuorder(query) {
  return request({
    url: '/system/stuorder/list',
    method: 'get',
    params: query
  })
}

// 查询解疑辅导室预约信息详细
export function getStuorder(studentOrderId) {
  return request({
    url: '/system/stuorder/' + studentOrderId,
    method: 'get'
  })
}

// 新增解疑辅导室预约信息
export function addStuorder(data) {
  return request({
    url: '/system/stuorder',
    method: 'post',
    data: data
  })
}

// 修改解疑辅导室预约信息
export function updateStuorder(data) {
  return request({
    url: '/system/stuorder',
    method: 'put',
    data: data
  })
}

// 删除解疑辅导室预约信息
export function delStuorder(studentOrderId) {
  return request({
    url: '/system/stuorder/' + studentOrderId,
    method: 'delete'
  })
}
