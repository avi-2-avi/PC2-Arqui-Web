package vidal.falcon.pc2.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vidal.falcon.pc2.entities.VfEmployee;
import vidal.falcon.pc2.entities.VfEnterprise;
import vidal.falcon.pc2.services.VfEmployeeService;
import vidal.falcon.pc2.repositories.VfEmployeeRepository;
import vidal.falcon.pc2.repositories.VfEnterpriseRepository;

@Service
public class VfEmployeeServiceImpl implements VfEmployeeService {
    @Autowired
    private VfEmployeeRepository vfEmployeeRepository;
    @Autowired
    private VfEnterpriseRepository vfEnterpriseRepository;
    public VfEmployee vfSave(VfEmployee vfEmployee) {
        VfEnterprise vfEnterpriseFound = vfEnterpriseRepository.findById(vfEmployee.getVfEnterprise().getVfId()).get();
        VfEmployee newEmployee = new VfEmployee(
                vfEmployee.getVfName(),
                vfEmployee.getVfDateBirth(),
                vfEmployee.getVfLicenseCategory(),
                vfEmployee.getVfSalary(),
                vfEmployee.getVfType(),
                vfEnterpriseFound
        );
        VfEmployee savedEmployee = vfEmployeeRepository.save(newEmployee);
        savedEmployee.getVfEnterprise().setVfEmployees(null);
        return savedEmployee;
    }
}
