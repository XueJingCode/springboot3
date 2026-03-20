package com.alan.hrsys.controller;

import com.alan.hrsys.entity.Department;
import com.alan.hrsys.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("dept") // 统一路径前缀：/hrsys/dept/...
public class DepartmentController {

    @Autowired
    private DepartmentService deptService;

    /**
     * 查询所有部门并展示列表
     * 访问路径：/dept/search
     */
    @RequestMapping("search")
    public ModelAndView search() {
        ModelAndView mv = new ModelAndView("dept/show"); // 对应 WEB-INF/jsp/dept/show.jsp
        List<Department> list = deptService.searchAll();
        mv.addObject("list", list);
        return mv;
    }

    /**
     * 跳转到新增页面
     * 访问路径：/dept/showAdd
     */
    @RequestMapping("showAdd")
    public String showAdd() {
        return "dept/add"; // 对应 WEB-INF/jsp/dept/add.jsp
    }

    /**
     * 执行新增操作
     * 访问路径：/dept/add
     */
    @RequestMapping("add")
    public String add(Department dept) {
        boolean flag = deptService.add(dept);
        // 无论成功失败，都跳回列表页（实际项目中可加消息提示）
        return "redirect:search";
    }

    /**
     * 跳转到修改页面
     * 访问路径：/dept/showUpdate?id=1
     */
    @RequestMapping("showUpdate")
    public ModelAndView showUpdate(Integer id) {
        Department dept = deptService.searchById(id);
        ModelAndView mv = new ModelAndView("dept/update"); // 对应 WEB-INF/jsp/dept/update.jsp
        mv.addObject("dept", dept);
        return mv;
    }

    /**
     * 执行修改操作
     * 访问路径：/dept/update
     */
    @RequestMapping("update")
    public String update(Department dept) {
        boolean flag = deptService.update(dept);
        return "redirect:search";
    }

    /**
     * 执行删除操作
     * 访问路径：/dept/delete?id=1
     */
    @RequestMapping("delete")
    public String delete(Integer id) {
        boolean flag = deptService.delete(id);
        return "redirect:search";
    }
}