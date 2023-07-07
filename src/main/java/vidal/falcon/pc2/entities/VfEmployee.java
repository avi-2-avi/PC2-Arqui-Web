package vidal.falcon.pc2.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name= "vf_employees")
@Data
@NoArgsConstructor
public class VfEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vfId;

    private String vfName;
    private Date vfDateBirth;
    private String vfLicenseCategory;
    private Double vfSalary;
    private String vfType;

    @ManyToOne
    @JoinColumn(name = "vf_enterprise_id")
    private VfEnterprise vfEnterprise;

    public VfEmployee(String vfName, Date vfDateBirth, String vfLicenseCategory, Double vfSalary, String vfType, VfEnterprise vfEnterprise) {
        this.vfName = vfName;
        this.vfDateBirth = vfDateBirth;
        this.vfLicenseCategory = vfLicenseCategory;
        this.vfSalary = vfSalary;
        this.vfType = vfType;
        this.vfEnterprise = vfEnterprise;
    }
}
