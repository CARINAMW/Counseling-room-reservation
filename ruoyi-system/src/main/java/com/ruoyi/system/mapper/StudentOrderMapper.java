package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentOrder;

/**
 * 解疑辅导室预约信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-27
 */
public interface StudentOrderMapper 
{
    /**
     * 查询解疑辅导室预约信息
     * 
     * @param studentOrderId 解疑辅导室预约信息主键
     * @return 解疑辅导室预约信息
     */
    public StudentOrder selectStudentOrderByStudentOrderId(String studentOrderId);

    /**
     * 查询解疑辅导室预约信息列表
     * 
     * @param studentOrder 解疑辅导室预约信息
     * @return 解疑辅导室预约信息集合
     */
    public List<StudentOrder> selectStudentOrderList(StudentOrder studentOrder);

    /**
     * 新增解疑辅导室预约信息
     * 
     * @param studentOrder 解疑辅导室预约信息
     * @return 结果
     */
    public int insertStudentOrder(StudentOrder studentOrder);

    /**
     * 修改解疑辅导室预约信息
     * 
     * @param studentOrder 解疑辅导室预约信息
     * @return 结果
     */
    public int updateStudentOrder(StudentOrder studentOrder);

    /**
     * 删除解疑辅导室预约信息
     * 
     * @param studentOrderId 解疑辅导室预约信息主键
     * @return 结果
     */
    public int deleteStudentOrderByStudentOrderId(String studentOrderId);

    /**
     * 批量删除解疑辅导室预约信息
     * 
     * @param studentOrderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentOrderByStudentOrderIds(String[] studentOrderIds);
}
