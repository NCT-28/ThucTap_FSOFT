	package vn.com.heyzo.oauth2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.heyzo.oauth2.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/user/getEmployeesList", produces = "application/json")
    @ResponseBody
    public List<Employee> getEmployeesList() {
        List<Employee> employees = new ArrayList<>();
        Employee emp = new Employee();
        emp.setEmpId("Toan001");
        emp.setEmpName("Nguyễn Công Toàn");
        employees.add(emp);
        return employees;

    }

}
