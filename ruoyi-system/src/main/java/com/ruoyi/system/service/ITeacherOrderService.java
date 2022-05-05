package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TeacherOrder;

/**
 * 辅导室预约信息Service接口
 * 
 * @author ruoyi
 * @date 2022-04-27
 */
public interface ITeacherOrderService 
{
    /**
     * 查询辅导室预约信息
     * 
     * @param teacherOrderId 辅导室预约信息主键
     * @return 辅导室预约信息
     */
    public TeacherOrder selectTeacherOrderByTeacherOrderId(String teacherOrderId);

    /**
     * 查询辅导室预约信息列表
     * 
     * @param teacherOrder 辅导室预约信息
     * @return 辅导室预约信息集合
     */
    public List<TeacherOrder> selectTeacherOrderList(TeacherOrder teacherOrder);

    /**
     * 新增辅导室预约信息
     * 
     * @param teacherOrder 辅导室预约信息
     * @return 结果
     */
    public int insertTeacherOrder(TeacherOrder teacherOrder);

    /**
     * 修改辅导室预约信息
     * 
     * @param teacherOrder 辅导室预约信息
     * @return 结果
     */
    public int updateTeacherOrder(TeacherOrder teacherOrder);

    /**
     * 批量删除辅导室预约信息
     * 
     * @param teacherOrderIds 需要删除的辅导室预约信息主键集合
     * @return 结果
     */
    public int deleteTeacherOrderByTeacherOrderIds(String[] teacherOrderIds);

    /**
     * 删除辅导室预约信息信息
     * 
     * @param teacherOrderId 辅导室预约信息主键
     * @return 结果
     */
    public int deleteTeacherOrderByTeacherOrderId(String teacherOrderId);
}
