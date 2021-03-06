package ru.fedul0x.ip.dataaccess.dataobject;

// Generated 23.12.2012 2:11:14 by Hibernate Tools 3.2.1.GA
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import ru.fedul0x.ip.dataaccess.DataEntity;

/**
 * InsuranceCompany generated by hbm2java
 */
@Entity
@Table(name = "insurance_company", schema = "public")
public class InsuranceCompany extends DataEntity {

    private String insuranceCompanyName;
    private String description;

    public InsuranceCompany() {
    }

    public InsuranceCompany(Long id) {
        this.id = id;
    }

    public InsuranceCompany(Long id, String insuranceCompanyName, String description) {
        this.id = id;
        this.insuranceCompanyName = insuranceCompanyName;
        this.description = description;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "insurance_company_name")
    public String getInsuranceCompanyName() {
        return this.insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
