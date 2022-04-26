package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentOrderMapper;
import com.ruoyi.system.domain.StudentOrder;
import com.ruoyi.system.service.IStudentOrderService;

/**
 * 解疑辅导室预约信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-25
 */
@Service
public class StudentOrderServiceImpl implements IStudentOrderService 
{
    @Autowired
    private StudentOrderMapper studentOrderMapper;

    /**
     * 查询解疑辅导室预约信息
     * 
     * @param timeId 解疑辅导室预约信息主键
     * @return 解疑辅导室预约信息
     */
    @Override
    public StudentOrder selectStudentOrderByTimeId(Long timeId)
    {
        return studentOrderMapper.selectStudentOrderByTimeId(timeId);
    }

    /**
     * 查询解疑辅导室预约信息列表
     * 
     * @param studentOrder 解疑辅导室预约信息
     * @return 解疑辅导室预约信息
     */
    @Override
    public List<StudentOrder> selectStudentOrderList(StudentOrder studentOrder)
    {
        return studentOrderMapper.selectStudentOrderList(studentOrder);
    }

    /**
     * 新增解疑辅导室预约信息
     * 
     * @param studentOrder 解疑辅导室预约信息
     * @return 结果
     */
    @Override
    public int insertStudentOrder(StudentOrder studentOrder)
    {
        return studentOrderMapper.insertStudentOrder(studentOrder);
    }

    /**
     * 修改解疑辅导室预约信息
     * 
     * @param studentOrder 解疑辅导室预约信息
     * @return 结果
     */
    @Override
    public int updateStudentOrder(StudentOrder studentOrder)
    {
        return studentOrderMapper.updateStudentOrder(studentOrder);
    }

    /**
     * 批量删除解疑辅导室预约信息
     * 
     * @param timeIds 需要删除的解疑辅导室预约信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentOrderByTimeIds(Long[] timeIds)
    {
        return studentOrderMapper.deleteStudentOrderByTimeIds(timeIds);
    }

    /**
     * 删除解疑辅导室预约信息信息
     * 
     * @param timeId 解疑辅导室预约信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentOrderByTimeId(Long timeId)
    {
        return studentOrderMapper.deleteStudentOrderByTimeId(timeId);
    }
}
