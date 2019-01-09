package com.management.service.oa.impl;

import com.management.dao.oa.DepartmentMapper;
import com.management.pojo.oa.Department;
import com.management.service.oa.IDepartmentService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAll() {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        return departmentMapper.findAll();
    }
}
