package com.alan.hrsys.dao;

import com.alan.hrsys.entity.Department;
import java.util.List;

public interface DepartmentDao {
    // 查询所有部门
    List<Department> searchAll();

    // 根据ID查询部门
    Department searchById(int id);

    // 新增部门
    int add(Department dept);

    // 更新部门
    int update(Department dept);

    // 删除部门
    int delete(int id);

}