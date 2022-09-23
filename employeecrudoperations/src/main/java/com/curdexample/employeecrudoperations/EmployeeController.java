package com.curdexample.employeecrudoperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;



    public HashMap<Integer, Employee> cache = new HashMap<>();

    @GetMapping(value = "/getMsg/{name}")
    public String getMsg(@PathVariable String name) {

        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay < 12) {
            return "Hi, Good Morning " + name + " " + timeStamp;
        } else if (timeOfDay < 6) {
            return "Hi, Good Late Night " + name + " " + timeStamp;
        } else if (timeOfDay < 16) {
            return "Hi, Good Afternoon " + name + " " + timeStamp;
        } else if (timeOfDay < 21) {
            return "Hi, Good Evening " + name + " " + timeStamp;
        } else {
            return "Hi, Good Night " + name + " " + timeStamp;
        }
    }
    // URL: http://localhost:8080/getMsg/Rupali
    //o/p: Hi, Good Afternoon Rupali 2022/09/07 15:28:26

    // Create Employee
    @PostMapping(value = "/addEmp")
    public Employee createEmployee(@RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }

    // for getting all Employee
    @GetMapping(value = "/findAllEmp")
    public String getAllEmployee()
    {
        return  CacheManager.cache.values().toString();
       // return employeeRepository.findAll();
    }

    // search a Particular Employee with given Id
    @GetMapping("/findEmpWithId/{empId}")
    public Employee getEmployee(@PathVariable int empId)
    {
        return CacheManager.cache.get(empId);
       // return employeeRepository.findById(empId);
    }
    @PutMapping("/updateEmp/{empId}")
    public String updateEmployee(@PathVariable int empId,@RequestBody Employee employee ){
     Optional<Employee> employee1=employeeRepository.findById(empId);
     if(employee1.isPresent()){
       return employeeRepository.save(employee).toString();
     }
     else{
         return "Employee id with this "+empId +"Not Present";
     }
    }

    @DeleteMapping("/deleteEmp/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empId, @RequestBody Employee employee)
    {
        String msg=null;
        Optional<Employee> employee1=employeeRepository.findById(empId);
        if(employee1.isPresent())
        {
            employeeRepository.deleteById(empId);
            msg="Employee Deleted Successfully";
        }else
        {
            msg="For empId " +empId + "no Employee is Present!!!";
        }
        return new ResponseEntity<String>(msg, HttpStatus.OK);

    }

}


