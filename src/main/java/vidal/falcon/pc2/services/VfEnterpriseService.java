package vidal.falcon.pc2.services;

import vidal.falcon.pc2.dtos.VfDTOEnterprise;
import vidal.falcon.pc2.entities.VfEnterprise;

import java.util.List;

public interface VfEnterpriseService {
    public VfEnterprise vfSave(VfEnterprise vfEnterprise);
    public List<VfDTOEnterprise> vfListEnterpriseSummary();
}
