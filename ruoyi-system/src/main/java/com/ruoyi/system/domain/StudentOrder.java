package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 解疑辅导室预约信息对象 student_order
 * 
 * @author ruoyi
 * @date 2022-04-27
 */
public class StudentOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预约解疑辅导室编号 */
    private String studentOrderId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderDate;

    /** 科目 */
    @Excel(name = "科目")
    private String subjectName;

    /** 教师账号 */
    private String uId;

    /** 学生账号 */
    @Excel(name = "学生账号")
    private String studentId;

    /** 辅导室编号 */
    @Excel(name = "辅导室编号")
    private Long roomId;

    /** 节数 */
    @Excel(name = "节数")
    private Long timeId;

    public void setStudentOrderId(String studentOrderId) 
    {
        this.studentOrderId = studentOrderId;
    }

    public String getStudentOrderId() 
    {
        return studentOrderId;
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
    public void setStudentId(String studentId) 
    {
        this.studentId = studentId;
    }

    public String getStudentId() 
    {
        return studentId;
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
            .append("studentOrderId", getStudentOrderId())
            .append("orderDate", getOrderDate())
            .append("subjectName", getSubjectName())
            .append("uId", getuId())
            .append("studentId", getStudentId())
            .append("roomId", getRoomId())
            .append("timeId", getTimeId())
            .toString();
    }
}
