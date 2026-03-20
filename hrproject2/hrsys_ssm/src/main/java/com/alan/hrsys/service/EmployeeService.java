package com.alan.hrsys.service;

import com.alan.hrsys.entity.Employee;

import java.util.List;

public interface EmployeeService {
    // 根据条件查询员工列表
    List<Employee> search(Employee condition);

    // 根据ID查询员工
    Employee searchById(Integer id);

    // 新增员工
    boolean add(Employee emp);

    // 修改员工信息
    boolean update(Employee emp);

    // 删除员工
    boolean delete(Integer id);

    // 根据部门 ID 更新员工信息
    boolean updateByDep(int depId);
}
