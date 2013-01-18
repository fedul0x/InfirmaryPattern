package ru.fedul0x.ip.dataaccess.dataobject;

// Generated 23.12.2012 2:11:14 by Hibernate Tools 3.2.1.GA
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import ru.fedul0x.ip.dataaccess.DataEntity;

/**
 * SupplementalHealthInsurance generated by hbm2java
 */
@Entity
@Table(name = "supplemental_health_insurance", schema = "public")
public class SupplementalHealthInsurance extends DataEntity {

    private String insuranceType;
    private String description;
    private Set patients = new HashSet(0);
    private Set servicePrices = new HashSet(0);

    public SupplementalHealthInsurance() {
    }

    public SupplementalHealthInsurance(Long id) {
        this.id = id;
    }

    public SupplementalHealthInsurance(Long id, String insuranceType, String description, Set patients, Set servicePrices) {
        this.id = id;
        this.insuranceType = insuranceType;
        this.description = description;
        this.patients = patients;
        this.servicePrices = servicePrices;
    }

    @Id
    @Override
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "insurance_type")
    public String getInsuranceType() {
        return this.insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "supplementalHealthInsurance")
    public Set getPatients() {
        return this.patients;
    }

    public void setPatients(Set patients) {
        this.patients = patients;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "supplementalHealthInsurance")
    public Set getServicePrices() {
        return this.servicePrices;
    }

    public void setServicePrices(Set servicePrices) {
        this.servicePrices = servicePrices;
    }
}
