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
 * Agent generated by hbm2java
 */
@Entity
@Table(name = "agent", schema = "public")
public class Agent extends DataEntity {

    private String lastName;
    private String firstName;
    private String middleName;
    private String contractNumber;
    private Set medicalConsultations = new HashSet(0);

    public Agent() {
    }

    public Agent(Long id) {
        this.id = id;
    }

    public Agent(Long id, String lastName, String firstName, String middleName, String contractNumber, Set medicalConsultations) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.contractNumber = contractNumber;
        this.medicalConsultations = medicalConsultations;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "middle_name")
    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "contract_number", length = 20)
    public String getContractNumber() {
        return this.contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "agent")
    public Set getMedicalConsultations() {
        return this.medicalConsultations;
    }

    public void setMedicalConsultations(Set medicalConsultations) {
        this.medicalConsultations = medicalConsultations;
    }
}
