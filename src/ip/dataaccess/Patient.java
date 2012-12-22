package ip.dataaccess;
// Generated 23.12.2012 2:11:14 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Patient generated by hbm2java
 */
@Entity
@Table(name="patient"
    ,schema="public"
)
public class Patient  implements java.io.Serializable {


     private int id;
     private SupplementalHealthInsurance supplementalHealthInsurance;
     private String firstName;
     private String lastName;
     private String middleName;
     private Date birthdayDate;
     private Date registrationDate;
     private Boolean sex;
     private String state;
     private String town;
     private String district;
     private String street;
     private String building;
     private String flat;
     private String home;
     private String workplace;
     private String homePhone;
     private String mobilePhone;
     private String workPhone;
     private String medicalInsuranceSeries;
     private String medicalInsuranceNumber;
     private Date contractTermEnding;
     private Date contractValidityBeginning;
     private String medicalCardNumber;
     private Date medicalCardDate;
     private Set medicalConsultations = new HashSet(0);

    public Patient() {
    }

	
    public Patient(int id) {
        this.id = id;
    }
    public Patient(int id, SupplementalHealthInsurance supplementalHealthInsurance, String firstName, String lastName, String middleName, Date birthdayDate, Date registrationDate, Boolean sex, String state, String town, String district, String street, String building, String flat, String home, String workplace, String homePhone, String mobilePhone, String workPhone, String medicalInsuranceSeries, String medicalInsuranceNumber, Date contractTermEnding, Date contractValidityBeginning, String medicalCardNumber, Date medicalCardDate, Set medicalConsultations) {
       this.id = id;
       this.supplementalHealthInsurance = supplementalHealthInsurance;
       this.firstName = firstName;
       this.lastName = lastName;
       this.middleName = middleName;
       this.birthdayDate = birthdayDate;
       this.registrationDate = registrationDate;
       this.sex = sex;
       this.state = state;
       this.town = town;
       this.district = district;
       this.street = street;
       this.building = building;
       this.flat = flat;
       this.home = home;
       this.workplace = workplace;
       this.homePhone = homePhone;
       this.mobilePhone = mobilePhone;
       this.workPhone = workPhone;
       this.medicalInsuranceSeries = medicalInsuranceSeries;
       this.medicalInsuranceNumber = medicalInsuranceNumber;
       this.contractTermEnding = contractTermEnding;
       this.contractValidityBeginning = contractValidityBeginning;
       this.medicalCardNumber = medicalCardNumber;
       this.medicalCardDate = medicalCardDate;
       this.medicalConsultations = medicalConsultations;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="supplemental_health_insurance_id")
    public SupplementalHealthInsurance getSupplementalHealthInsurance() {
        return this.supplementalHealthInsurance;
    }
    
    public void setSupplementalHealthInsurance(SupplementalHealthInsurance supplementalHealthInsurance) {
        this.supplementalHealthInsurance = supplementalHealthInsurance;
    }
    
    @Column(name="first_name")
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="last_name")
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name="middle_name")
    public String getMiddleName() {
        return this.middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="birthday_date", length=13)
    public Date getBirthdayDate() {
        return this.birthdayDate;
    }
    
    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="registration_date", length=13)
    public Date getRegistrationDate() {
        return this.registrationDate;
    }
    
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    @Column(name="sex")
    public Boolean getSex() {
        return this.sex;
    }
    
    public void setSex(Boolean sex) {
        this.sex = sex;
    }
    
    @Column(name="state")
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    @Column(name="town")
    public String getTown() {
        return this.town;
    }
    
    public void setTown(String town) {
        this.town = town;
    }
    
    @Column(name="district")
    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    
    @Column(name="street")
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    @Column(name="building")
    public String getBuilding() {
        return this.building;
    }
    
    public void setBuilding(String building) {
        this.building = building;
    }
    
    @Column(name="flat")
    public String getFlat() {
        return this.flat;
    }
    
    public void setFlat(String flat) {
        this.flat = flat;
    }
    
    @Column(name="home")
    public String getHome() {
        return this.home;
    }
    
    public void setHome(String home) {
        this.home = home;
    }
    
    @Column(name="workplace")
    public String getWorkplace() {
        return this.workplace;
    }
    
    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
    
    @Column(name="home_phone")
    public String getHomePhone() {
        return this.homePhone;
    }
    
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    
    @Column(name="mobile_phone")
    public String getMobilePhone() {
        return this.mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    
    @Column(name="work_phone")
    public String getWorkPhone() {
        return this.workPhone;
    }
    
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
    
    @Column(name="medical_insurance_series", length=10)
    public String getMedicalInsuranceSeries() {
        return this.medicalInsuranceSeries;
    }
    
    public void setMedicalInsuranceSeries(String medicalInsuranceSeries) {
        this.medicalInsuranceSeries = medicalInsuranceSeries;
    }
    
    @Column(name="medical_insurance_number", length=20)
    public String getMedicalInsuranceNumber() {
        return this.medicalInsuranceNumber;
    }
    
    public void setMedicalInsuranceNumber(String medicalInsuranceNumber) {
        this.medicalInsuranceNumber = medicalInsuranceNumber;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="contract_term_ending", length=13)
    public Date getContractTermEnding() {
        return this.contractTermEnding;
    }
    
    public void setContractTermEnding(Date contractTermEnding) {
        this.contractTermEnding = contractTermEnding;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="contract_validity_beginning", length=13)
    public Date getContractValidityBeginning() {
        return this.contractValidityBeginning;
    }
    
    public void setContractValidityBeginning(Date contractValidityBeginning) {
        this.contractValidityBeginning = contractValidityBeginning;
    }
    
    @Column(name="medical_card_number", length=15)
    public String getMedicalCardNumber() {
        return this.medicalCardNumber;
    }
    
    public void setMedicalCardNumber(String medicalCardNumber) {
        this.medicalCardNumber = medicalCardNumber;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="medical_card_date", length=13)
    public Date getMedicalCardDate() {
        return this.medicalCardDate;
    }
    
    public void setMedicalCardDate(Date medicalCardDate) {
        this.medicalCardDate = medicalCardDate;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="patient")
    public Set getMedicalConsultations() {
        return this.medicalConsultations;
    }
    
    public void setMedicalConsultations(Set medicalConsultations) {
        this.medicalConsultations = medicalConsultations;
    }




}


