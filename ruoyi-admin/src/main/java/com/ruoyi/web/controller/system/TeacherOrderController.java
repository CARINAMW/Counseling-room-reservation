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
import com.ruoyi.system.domain.TeacherOrder;
import com.ruoyi.system.service.ITeacherOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 辅导室预约信息Controller
 *
 * @author ruoyi
 * @date 2022-04-27
 */
@RestController
@RequestMapping("/system/order")
public class TeacherOrderController extends BaseController
{
    @Autowired
    private ITeacherOrderService teacherOrderService;

    /**
     * 查询辅导室预约信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeacherOrder teacherOrder)
    {
        startPage();
        List<TeacherOrder> list = teacherOrderService.selectTeacherOrderList(teacherOrder);
        return getDataTable(list);
    }

    /**
     * 导出辅导室预约信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "辅导室预约信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TeacherOrder teacherOrder)
    {
        List<TeacherOrder> list = teacherOrderService.selectTeacherOrderList(teacherOrder);
        ExcelUtil<TeacherOrder> util = new ExcelUtil<TeacherOrder>(TeacherOrder.class);
        util.exportExcel(response, list, "辅导室预约信息数据");
    }

    /**
     * 获取辅导室预约信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/{teacherOrderId}")
    public AjaxResult getInfo(@PathVariable("teacherOrderId") String teacherOrderId)
    {
        return AjaxResult.success(teacherOrderService.selectTeacherOrderByTeacherOrderId(teacherOrderId));
    }

    /**
     * 新增辅导室预约信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "辅导室预约信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeacherOrder teacherOrder)
    {
        return toAjax(teacherOrderService.insertTeacherOrder(teacherOrder));
    }

    /**
     * 修改辅导室预约信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "辅导室预约信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeacherOrder teacherOrder)
    {
        return toAjax(teacherOrderService.updateTeacherOrder(teacherOrder));
    }

    /**
     * 删除辅导室预约信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "辅导室预约信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teacherOrderIds}")
    public AjaxResult remove(@PathVariable String[] teacherOrderIds)
    {
        return toAjax(teacherOrderService.deleteTeacherOrderByTeacherOrderIds(teacherOrderIds));
    }



}
