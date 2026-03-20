package com.alan.hrsys.service.impl;

import com.alan.hrsys.dao.DepartmentDao;
import com.alan.hrsys.entity.Department;
import com.alan.hrsys.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // 开启事务，确保增删改操作的数据一致性
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao deptDao;

    /**
     * 查询所有部门
     */
    @Override
    public List<Department> searchAll() {
        return deptDao.searchAll();
    }

    /**
     * 根据ID查询部门
     * 注意：DAO层参数是 int，这里接收 Integer 并校验，防止 null 导致拆箱异常
     */
    @Override
    public Department searchById(int id) {
        // 如果业务层允许传 Integer，可以在这里判空；
        // 既然接口定义是 int，调用方必须传非空值。
        // 为了安全，如果上层传的是 Integer 包装类，建议在 Controller 层判空。
        // 此处直接调用，若 id 为 0 或负数，由 DAO 层或数据库处理。
        return deptDao.searchById(id);
    }

    /**
     * 新增部门
     * 将 DAO 返回的受影响行数 (int) 转换为 boolean
     */
    @Override
    public boolean add(Department dept) {
        if (dept == null) {
            throw new IllegalArgumentException("部门对象不能为空");
        }
        // 可选：添加业务校验，如部门名称不能为空
        if (dept.getName() == null || dept.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("部门名称不能为空");
        }
        return deptDao.add(dept) > 0;
    }

    /**
     * 修改部门
     */
    @Override
    public boolean update(Department dept) {
        if (dept == null || dept.getId() <= 0) {
            throw new IllegalArgumentException("部门对象或ID无效");
        }
        return deptDao.update(dept) > 0;
    }

    /**
     * 删除部门
     */
    @Override
    public boolean delete(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("部门ID必须大于0");
        }
        return deptDao.delete(id) > 0;
    }
}
