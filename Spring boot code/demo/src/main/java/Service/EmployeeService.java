package Service;

import Repository.EmployeeRepository;
import models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee){

        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    public List<Employee> searchAll(){
        return employeeRepository.findAll();

    }

    public Employee searchById(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElse( null);

        if (employee == null){

            //Trow an error
        }

        return employee;
    }

    public  Employee update(Long employeeId, Employee employeeDetails){

        Employee employee = employeeRepository.findById(employeeId).orElse( null);

        if (employee == null){

            //Trow an error
        }

      employee.setFirstname(employeeDetails.getFirstname());
      employee.setLastname(employeeDetails.getLastname());
      employee.setEmailId(employeeDetails.getEmailId());

        Employee updatedEmployee = employeeRepository.save(employee);

        return employee;

    }
}
