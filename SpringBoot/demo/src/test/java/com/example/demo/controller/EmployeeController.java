package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    

    List<Employee> emplist= new ArrayList<>();


        @PostMapping("save")
        public Employee saveEmployee(@RequestBody Employee employee)
        {
            emplist.add(employee);
            return employee;
        }
        @GetMapping("getAll")
        public List<Employee> getAllEmployee()
        {
            return emplist;
        }
        @GetMapping("getbyid/{id}")
        public Employee getEmployeeById(@PathVariable int id)
        {
            for(Employee e:emplist)
            {
                if(e.getId()==id)
                {
                    return e;
                }
            }
            return new Employee();
        }

        @DeleteMapping("deletebyid/{id}")
        public Employee deleteEmployeeById(@PathVariable int id)
        {
            for (Employee e:emplist)
            {
                if(e.getId()==id)
                {
                    emplist.remove(e);
                    return e;
                }
                
            }
            return new Employee();

        }
}
