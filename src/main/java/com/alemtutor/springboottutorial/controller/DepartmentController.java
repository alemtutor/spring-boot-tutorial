package com.alemtutor.springboottutorial.controller;


import com.alemtutor.springboottutorial.entity.Department;
import com.alemtutor.springboottutorial.service.DepartmentService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    Logger logger = LoggerFactory.logger(DepartmentController.class);
    @Autowired
    private DepartmentService service;
   @PostMapping("/departments")
  public Department postDepartment(@Valid @RequestBody Department department)
   {
       logger.info("Department controller of postDepartment method");
      return service.postDepartment(department);
   }
    @GetMapping("departments/{id}")
    public Department getDepartmentById(@PathVariable("id")Long id)
    {
        return service.getDepartmentById(id);
    }
    @GetMapping("/departments")
    public List<Department> getAllDepartments()
    {
        logger.info("Department controller of List Departments method");
        return service.getDepartments();
    }
    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")Long id)
    {
        service.deleteDepartmentById(id);
        return "Department Deleted successfully " + id;
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department)
    {
       return service.updateDepartment(departmentId, department);

    }
}
