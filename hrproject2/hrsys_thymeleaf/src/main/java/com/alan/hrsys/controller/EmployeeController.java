package com.alan.hrsys.controller;

import com.alan.hrsys.entity.Department;
import com.alan.hrsys.entity.Employee;
import com.alan.hrsys.service.DepartmentService;
import com.alan.hrsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @Autowired
    private DepartmentService depService;

    // 多条件查询
    @RequestMapping("search")
    public ModelAndView search(Employee condition) { // 注意：这里假设 condition 是方法参数
        ModelAndView mv = new ModelAndView("emp/show");
        List<Employee> list = empService.search(condition);
        List<Department> depList = depService.searchAll();
        mv.addObject("list", list);
        mv.addObject("depList", depList);
        mv.addObject("c", condition);
        return mv;
    }

    @RequestMapping("showAdd")
    public ModelAndView showAdd() {
        ModelAndView mv = new ModelAndView("emp/add");
        List<Department> depList = depService.searchAll();
        mv.addObject("depList", depList);
        return mv;
    }

    @RequestMapping("add")
    public String add(Employee emp) {
        boolean flag = empService.add(emp);
        return "redirect:search";
    }

    @RequestMapping("showUpdate")
    public ModelAndView showUpdate(Integer id) {
        Employee emp = empService.searchById(id);
        List<Department> depList = depService.searchAll();
        ModelAndView mv = new ModelAndView("emp/update");
        mv.addObject("emp", emp);
        mv.addObject("depList", depList);
        return mv;
    }

    @RequestMapping("update")
    public String update(Employee emp) { // 注意：这里假设是 Employee emp
        boolean flag = empService.update(emp);
        return "redirect:search";
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        boolean flag = empService.delete(id);
        return "redirect:search";
    }
}