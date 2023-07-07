package vidal.falcon.pc2.servicesImpl;
import org.springframework.stereotype.Service;
import vidal.falcon.pc2.dtos.VfDTOEnterprise;
import vidal.falcon.pc2.entities.VfEnterprise;
import vidal.falcon.pc2.repositories.VfEnterpriseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import vidal.falcon.pc2.services.VfEnterpriseService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class VfEnterpriseServiceImpl implements VfEnterpriseService {
    @Autowired
    private VfEnterpriseRepository vfEnterpriseRepository;

    public VfEnterprise vfSave(VfEnterprise vfEnterprise) {
        VfEnterprise vfNewEnterprise = new VfEnterprise(
                vfEnterprise.getVfName(),
                vfEnterprise.getVfType(),
                vfEnterprise.getVfDateAffiliation(),
                vfEnterprise.getVfDateFoundation(),
                vfEnterprise.getVfStatus()
        );
        VfEnterprise vfSavedEnterprise = vfEnterpriseRepository.save(vfNewEnterprise);
        return vfSavedEnterprise;
    }

    public List<VfDTOEnterprise> vfListEnterpriseSummary() {
        List<VfEnterprise> vfEnterpriseList = vfEnterpriseRepository.findAll();
        List<VfDTOEnterprise> vfDTOEnterpriseList = new ArrayList<>();

        for (VfEnterprise vfEnt : vfEnterpriseList) {
            String vfFullName = vfEnt.getVfName() + ' ' + vfEnt.getVfType();
            Integer vfCountDriverEmployees = (int) vfEnt.getVfEmployees().stream().filter(p -> p.getVfType().equals("Chofer")).count();
            Integer vfCountAdministratorEmployees = (int) vfEnt.getVfEmployees().stream().filter(p -> p.getVfType().equals("Administrativo")).count();
            Double vfSalaries = vfEnt.getVfEmployees().stream().map(p -> p.getVfSalary()).reduce(0.0, Double::sum);

            VfDTOEnterprise vfDTOEnterprise = new VfDTOEnterprise(
                    vfEnt.getVfId(),
                    vfFullName,
                    vfCountDriverEmployees,
                    vfCountAdministratorEmployees,
                    vfEnt.getVfDateAffiliation(),
                    vfEnt.getVfStatus(),
                    vfSalaries
            );
            vfDTOEnterpriseList.add(vfDTOEnterprise);
        }
        // Sort by vfFullName
        vfDTOEnterpriseList = vfDTOEnterpriseList.stream().sorted(Comparator.comparing(VfDTOEnterprise::getVfFullName)).toList();
        return vfDTOEnterpriseList;
    }
}



