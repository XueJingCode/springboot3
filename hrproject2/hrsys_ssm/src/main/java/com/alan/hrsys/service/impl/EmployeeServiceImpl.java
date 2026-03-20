package com.alan.hrsys.service.impl;

import com.alan.hrsys.dao.EmployeeDao;
import com.alan.hrsys.entity.Employee;
import com.alan.hrsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // 开启事务支持，确保增删改操作的数据一致性
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao empDao;

    /**
     * 根据条件查询员工列表
     */
    @Override
    public List<Employee> search(Employee condition) {
        return empDao.search(condition);
    }

    /**
     * 根据ID查询单个员工
     * 注意：DAO层参数是 int，如果传 null 会自动拆箱报错，建议前端确保传值
     */
    @Override
    public Employee searchById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("员工ID不能为空");
        }
        return empDao.searchById(id); // 自动拆箱为 int
    }

    /**
     * 新增员工
     * DAO 返回 int (受影响行数)，转为 boolean
     */
    @Override
    public boolean add(Employee emp) {
        if (emp == null) {
            throw new IllegalArgumentException("员工对象不能为空");
        }
        return empDao.add(emp) > 0;
    }

    /**
     * 修改员工信息
     */
    @Override
    public boolean update(Employee emp) {
        if (emp == null) {
            throw new IllegalArgumentException("员工对象无效");
        }
        return empDao.update(emp) > 0;
    }

    /**
     * 删除员工
     * 注意：DAO层参数是 int
     */
    @Override
    public boolean delete(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("员工ID不能为空");
        }
        return empDao.delete(id) > 0; // 自动拆箱为 int
    }

    /**
     * 【额外补充】根据部门ID更新员工信息
     * 虽然接口没定义，但 DAO 里有这个方法，如果需要可以在 Service 接口中也加上
     */
    public boolean updateByDep(int depId) {
        return empDao.updateByDep(depId) > 0;
    }
}
