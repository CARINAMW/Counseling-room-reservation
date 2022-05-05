package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 辅导室预约信息对象 teacher_order
 * 
 * @author ruoyi
 * @date 2022-04-27
 */
public class TeacherOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 辅导室预约编号 */
    private String teacherOrderId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderDate;

    /** 科目 */
    @Excel(name = "科目")
    private String subjectName;

    /** 账号 */
    private String uId;

    /** 课程 */
    @Excel(name = "课程")
    private String course;

    /** 学生人数 */
    @Excel(name = "学生人数")
    private Long studentNum;

    /** 辅导室编号 */
    @Excel(name = "辅导室编号")
    private Long roomId;

    /** 节数 */
    @Excel(name = "节数")
    private Long timeId;

    public void setTeacherOrderId(String teacherOrderId) 
    {
        this.teacherOrderId = teacherOrderId;
    }

    public String getTeacherOrderId() 
    {
        return teacherOrderId;
    }
    public void setOrderDate(Date orderDate) 
    {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() 
    {
        return orderDate;
    }
    public void setSubjectName(String subjectName) 
    {
        this.subjectName = subjectName;
    }

    public String getSubjectName() 
    {
        return subjectName;
    }
    public void setuId(String uId) 
    {
        this.uId = uId;
    }

    public String getuId() 
    {
        return uId;
    }
    public void setCourse(String course) 
    {
        this.course = course;
    }

    public String getCourse() 
    {
        return course;
    }
    public void setStudentNum(Long studentNum) 
    {
        this.studentNum = studentNum;
    }

    public Long getStudentNum() 
    {
        return studentNum;
    }
    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setTimeId(Long timeId) 
    {
        this.timeId = timeId;
    }

    public Long getTimeId() 
    {
        return timeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("teacherOrderId", getTeacherOrderId())
            .append("orderDate", getOrderDate())
            .append("subjectName", getSubjectName())
            .append("uId", getuId())
            .append("course", getCourse())
            .append("studentNum", getStudentNum())
            .append("roomId", getRoomId())
            .append("timeId", getTimeId())
            .toString();
    }
}
