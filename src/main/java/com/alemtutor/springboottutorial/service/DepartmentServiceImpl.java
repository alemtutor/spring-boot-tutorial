package com.alemtutor.springboottutorial.service;

import com.alemtutor.springboottutorial.entity.Department;
import com.alemtutor.springboottutorial.repository.DepartmentRepository;
import com.alemtutor.springboottutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department postDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Department> getDepartments() {
        return repository.findAll();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department department1 = repository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName())&&
                !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            department1.setDepartmentName(department.getDepartmentName());

        }
        if(Objects.nonNull(department.getDepartmentCode())&&
                !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            department1.setDepartmentCode(department.getDepartmentCode());

        }
        if(Objects.nonNull(department.getDepartmentAddress())&&
                !"".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            department1.setDepartmentAddress(department.getDepartmentAddress());

        }
      return repository.save(department1);
    }
}
