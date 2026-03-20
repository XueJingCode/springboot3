package com.alan.hrsys.dao;

import com.alan.hrsys.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    // 根据条件查询员工列表
    List<Employee> search(Employee condition);
    // 根据ID查询员工
    Employee searchById(int id);
    // 新增员工
    int add(Employee emp);
    // 修改员工信息
    int update(Employee emp);
    // 删除员工
    int delete(int id);
    // 根据部门ID修改部门
    int updateByDep(int depId);
    }
