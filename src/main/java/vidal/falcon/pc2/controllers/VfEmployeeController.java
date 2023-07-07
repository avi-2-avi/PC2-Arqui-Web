package vidal.falcon.pc2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vidal.falcon.pc2.entities.VfEmployee;
import vidal.falcon.pc2.services.VfEmployeeService;

@RestController
@RequestMapping("/api")
public class VfEmployeeController {
    @Autowired
    VfEmployeeService vfEmployeeService;
    @PostMapping("/employees")
    public ResponseEntity<VfEmployee> createVfEmployee(@RequestBody VfEmployee vfEmployee){
        VfEmployee vfSavedEmployee = vfEmployeeService.vfSave(vfEmployee);
        return new ResponseEntity<VfEmployee>(vfSavedEmployee, HttpStatus.CREATED);
    }
}
