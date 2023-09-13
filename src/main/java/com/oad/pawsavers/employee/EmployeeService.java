package com.oad.pawsavers.employee;

import com.oad.pawsavers.common.constants.UserTypes;
import com.oad.pawsavers.user.UserDTO;
import com.oad.pawsavers.user.UserService;
import com.oad.pawsavers.usertype.UserTypeDTO;
import com.oad.pawsavers.usertype.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTypeService userTypeService;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeMapper.toEmployeeDTOList(employeeRepository.findAll());
    }

    public Optional<EmployeeDTO> getEmployeeById(long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toEmployeeDTO);
    }

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        try {
            Optional<UserDTO> user = userService.getUserById(employeeDTO.getEmployeeId());
            if (user.isPresent()) {
                Optional<UserTypeDTO> userTypeDTO = userTypeService.getUserTypeById(user.get().getUserTypeId());
                if (userTypeDTO.isPresent() && UserTypes.EMPLOYEE.toString().equals(userTypeDTO.get().getTypeOfUser())) {
                    return employeeRepository.save(employeeMapper.toEmployeeEntity(employeeDTO));
                } else {
                    throw new RuntimeException("User type doesn't exist or isn't " + UserTypes.PET_RESCUER + ".");
                }
            } else {
                throw new RuntimeException("User: Is already a Pet Rescuer / Not registered to be Pet Rescuer / No exists.");
            }
        } catch (Error error) {
            System.out.println("Error: " + error.getMessage());
            return null;
        }
    }

    public boolean deleteEmployeeById(long id) {
        if (getEmployeeById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateEmployeeById(long id, EmployeeDTO employeeDTO) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee employeeToUpdate = employee.get();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            employeeToUpdate.setHireDate(LocalDate.parse(employeeDTO.getEmployeeHireDate(), formatter));
            employeeMapper.toEmployeeDTO(employeeRepository.save(employeeToUpdate));
            return true;
        } else {
            return false;
        }
    }
}
