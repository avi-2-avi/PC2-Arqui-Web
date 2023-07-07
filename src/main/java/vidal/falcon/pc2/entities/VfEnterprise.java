package vidal.falcon.pc2.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;

import java.util.Date;
import java.util.List;

@Entity
@Table(name= "vf_enterprises")
@Data
@NoArgsConstructor
public class VfEnterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vfId;

    private String vfName;
    private String vfType;
    private Date vfDateAffiliation;
    private Date vfDateFoundation;
    private String vfStatus;

    @OneToMany(mappedBy = "vfEnterprise")
    private List<VfEmployee> vfEmployees;

    public VfEnterprise(String vfName, String vfType, Date vfDateAffiliation, Date vfDateFoundation, String vfStatus) {
        this.vfName = vfName;
        this.vfType = vfType;
        this.vfDateAffiliation = vfDateAffiliation;
        this.vfDateFoundation = vfDateFoundation;
        this.vfStatus = vfStatus;
    }
}
