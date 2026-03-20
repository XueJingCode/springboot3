package com.alan.hrsys.service;

import com.alan.hrsys.entity.Department;
import java.util.List;

public interface DepartmentService {
    /**
     * 查询所有部门
     */
    List<Department> searchAll();

    /**
     * 根据ID查询部门
     */
    Department searchById(int id);

    /**
     * 新增部门
     */
    boolean add(Department dept);

    /**
     * 修改部门
     */
    boolean update(Department dept);

    /**
     * 删除部门
     */
    boolean delete(int id);
}