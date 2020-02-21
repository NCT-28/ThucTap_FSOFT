package vn.com.heyzo.restfulangularjs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.com.heyzo.restfulangularjs.dao.EmployeeDAO;
import vn.com.heyzo.restfulangularjs.model.Employee;
import vn.com.heyzo.restfulangularjs.model.EmployeeForm;
  
@RestController 
public class MainRESTController {
  
    @Autowired
    private EmployeeDAO employeeDAO;
  
  
    // URL:
    // http://localhost:8080/employees
    @RequestMapping(value = "/employees", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeDAO.getAllEmployees();
        return list;
    }
  
    // URL:
    // http://localhost:8080/employee/{empId}
    
    @RequestMapping(value = "/employee/{empId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee getEmployee(@PathVariable("empId") Long empId) {
        return employeeDAO.getEmployee(empId);
    }
  
    // URL:
    // http://localhost:8080/employee

  
    @RequestMapping(value = "/employee", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody EmployeeForm empForm) {
  
        System.out.println("(Service Side) Creating employee with empNo: " + empForm.getEmpNo());
  
        return employeeDAO.addEmployee(empForm);
    }
  
    // URL:
    // http://localhost:8080/employee
    @RequestMapping(value = "/employee", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee updateEmployee(@RequestBody EmployeeForm empForm) {
  
        System.out.println("(Service Side) Editing employee with Id: " + empForm.getEmpId());
  
        return employeeDAO.updateEmployee(empForm);
    }
  
    // URL:
    // http://localhost:8080/employee/{empId}
    @RequestMapping(value = "/employee/{empId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmployee(@PathVariable("empId") Long empId) {
  
        System.out.println("(Service Side) Deleting employee with Id: " + empId);
  
        employeeDAO.deleteEmployee(empId);
    }
  
}
