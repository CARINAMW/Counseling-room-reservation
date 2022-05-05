package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TeacherOrderMapper;
import com.ruoyi.system.domain.TeacherOrder;
import com.ruoyi.system.service.ITeacherOrderService;

/**
 * 辅导室预约信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-27
 */
@Service
public class TeacherOrderServiceImpl implements ITeacherOrderService 
{
    @Autowired
    private TeacherOrderMapper teacherOrderMapper;

    /**
     * 查询辅导室预约信息
     * 
     * @param teacherOrderId 辅导室预约信息主键
     * @return 辅导室预约信息
     */
    @Override
    public TeacherOrder selectTeacherOrderByTeacherOrderId(String teacherOrderId)
    {
        return teacherOrderMapper.selectTeacherOrderByTeacherOrderId(teacherOrderId);
    }

    /**
     * 查询辅导室预约信息列表
     * 
     * @param teacherOrder 辅导室预约信息
     * @return 辅导室预约信息
     */
    @Override
    public List<TeacherOrder> selectTeacherOrderList(TeacherOrder teacherOrder)
    {
        return teacherOrderMapper.selectTeacherOrderList(teacherOrder);
    }

    /**
     * 新增辅导室预约信息
     * 
     * @param teacherOrder 辅导室预约信息
     * @return 结果
     */
    @Override
    public int insertTeacherOrder(TeacherOrder teacherOrder)
    {
        return teacherOrderMapper.insertTeacherOrder(teacherOrder);
    }

    /**
     * 修改辅导室预约信息
     * 
     * @param teacherOrder 辅导室预约信息
     * @return 结果
     */
    @Override
    public int updateTeacherOrder(TeacherOrder teacherOrder)
    {
        return teacherOrderMapper.updateTeacherOrder(teacherOrder);
    }

    /**
     * 批量删除辅导室预约信息
     * 
     * @param teacherOrderIds 需要删除的辅导室预约信息主键
     * @return 结果
     */
    @Override
    public int deleteTeacherOrderByTeacherOrderIds(String[] teacherOrderIds)
    {
        return teacherOrderMapper.deleteTeacherOrderByTeacherOrderIds(teacherOrderIds);
    }

    /**
     * 删除辅导室预约信息信息
     * 
     * @param teacherOrderId 辅导室预约信息主键
     * @return 结果
     */
    @Override
    public int deleteTeacherOrderByTeacherOrderId(String teacherOrderId)
    {
        return teacherOrderMapper.deleteTeacherOrderByTeacherOrderId(teacherOrderId);
    }
}
