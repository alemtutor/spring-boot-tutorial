package com.alemtutor.springboottutorial.service;

import com.alemtutor.springboottutorial.entity.Department;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface DepartmentService{
    public Department postDepartment(Department department);
    public Department getDepartmentById(Long id);
    public List<Department>getDepartments();


   public void deleteDepartmentById(Long id);

    public Department updateDepartment(Long id, Department department);
}
