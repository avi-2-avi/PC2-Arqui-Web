package vidal.falcon.pc2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vidal.falcon.pc2.dtos.VfDTOEnterprise;
import vidal.falcon.pc2.entities.VfEnterprise;
import vidal.falcon.pc2.services.VfEnterpriseService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VfEnterpriseController {
    @Autowired
    VfEnterpriseService vfEnterpriseService;
    @PostMapping("/enterprises")
    public ResponseEntity<VfEnterprise> createVfEnterprise(@RequestBody VfEnterprise vfEnterprise){
        VfEnterprise vfSavedEnterprise = vfEnterpriseService.vfSave(vfEnterprise);
        return new ResponseEntity<VfEnterprise>(vfSavedEnterprise, HttpStatus.CREATED);
    }

    @GetMapping("/enterprises/summary")
    public ResponseEntity<List<VfDTOEnterprise>>  getVfEnterpriseSummary(){
        List<VfDTOEnterprise> dtoEnterprises = vfEnterpriseService.vfListEnterpriseSummary();
        return new ResponseEntity<List<VfDTOEnterprise>>(dtoEnterprises, HttpStatus.OK);
    }
}
