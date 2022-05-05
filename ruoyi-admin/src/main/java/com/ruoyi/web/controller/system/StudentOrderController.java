package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.StudentOrder;
import com.ruoyi.system.service.IStudentOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 解疑辅导室预约信息Controller
 *
 * @author ruoyi
 * @date 2022-04-27
 */
@RestController
@RequestMapping("/system/stuorder")
public class StudentOrderController extends BaseController
{
    @Autowired
    private IStudentOrderService studentOrderService;

    /**
     * 查询解疑辅导室预约信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:stuorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudentOrder studentOrder)
    {
        startPage();
        List<StudentOrder> list = studentOrderService.selectStudentOrderList(studentOrder);
        return getDataTable(list);
    }

    /**
     * 导出解疑辅导室预约信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:stuorder:export')")
    @Log(title = "解疑辅导室预约信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentOrder studentOrder)
    {
        List<StudentOrder> list = studentOrderService.selectStudentOrderList(studentOrder);
        ExcelUtil<StudentOrder> util = new ExcelUtil<StudentOrder>(StudentOrder.class);
        util.exportExcel(response, list, "解疑辅导室预约信息数据");
    }

    /**
     * 获取解疑辅导室预约信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:stuorder:query')")
    @GetMapping(value = "/{studentOrderId}")
    public AjaxResult getInfo(@PathVariable("studentOrderId") String studentOrderId)
    {
        return AjaxResult.success(studentOrderService.selectStudentOrderByStudentOrderId(studentOrderId));
    }

    /**
     * 新增解疑辅导室预约信息
     */
    @PreAuthorize("@ss.hasPermi('system:stuorder:add')")
    @Log(title = "解疑辅导室预约信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentOrder studentOrder)
    {
        return toAjax(studentOrderService.insertStudentOrder(studentOrder));
    }

    /**
     * 修改解疑辅导室预约信息
     */
    @PreAuthorize("@ss.hasPermi('system:stuorder:edit')")
    @Log(title = "解疑辅导室预约信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentOrder studentOrder)
    {
        return toAjax(studentOrderService.updateStudentOrder(studentOrder));
    }

    /**
     * 删除解疑辅导室预约信息
     */
    @PreAuthorize("@ss.hasPermi('system:stuorder:remove')")
    @Log(title = "解疑辅导室预约信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentOrderIds}")
    public AjaxResult remove(@PathVariable String[] studentOrderIds)
    {
        return toAjax(studentOrderService.deleteStudentOrderByStudentOrderIds(studentOrderIds));
    }



}
