package vidal.falcon.pc2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class VfDTOEnterprise {
    private Long vfId;
    private String vfFullName;
    private Integer vfCountDriverEmployees;
    private Integer vfCountAdministratorEmployees;
    private Date vfDateAffiliation;
    private String vfStatus;
    private Double vfSalaries;
}
