package ru.fedul0x.ip.dataaccess.dataobject;

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
import ru.fedul0x.ip.dataaccess.DataEntity;

/**
 * Staff generated by hbm2java
 */
@Entity
@Table(name = "staff", schema = "public")
public class Staff extends DataEntity {

    private StaffPosition staffPosition;
    private String lastName;
    private String firstName;
    private String middleName;
    private String specialisation;
    private String address;
    private String passportSeries;
    private String passportNumber;
    private String passportIssuedBy;
    private Date birthdayDate;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String individualPersonalAccountInsuranceNumber;
    private String contractNumber;
    private Date contractDate;
    private Double normHours;
    private Float rate;
    private Set schedulesForNurseId = new HashSet(0);
    private Set schedulesForDoctorId = new HashSet(0);
    private Set systemUsers = new HashSet(0);

    public Staff() {
    }

    public Staff(Long id) {
        this.id = id;
    }

    public Staff(Long id, StaffPosition staffPosition, String lastName, String firstName, String middleName,
            String specialisation, String address, String passportSeries, String passportNumber, String passportIssuedBy, Date birthdayDate,
            String homePhone, String mobilePhone, String workPhone,
            String individualPersonalAccountInsuranceNumber, String contractNumber, Date contractDate,
            Double normHours, Float rate, Set schedulesForNurseId, Set schedulesForDoctorId, Set systemUsers) {
        this.id = id;
        this.staffPosition = staffPosition;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.specialisation = specialisation;
        this.address = address;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.passportIssuedBy = passportIssuedBy;
        this.birthdayDate = birthdayDate;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.individualPersonalAccountInsuranceNumber = individualPersonalAccountInsuranceNumber;
        this.contractNumber = contractNumber;
        this.contractDate = contractDate;
        this.normHours = normHours;
        this.rate = rate;
        this.schedulesForNurseId = schedulesForNurseId;
        this.schedulesForDoctorId = schedulesForDoctorId;
        this.systemUsers = systemUsers;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_position_id")
    public StaffPosition getStaffPosition() {
        return this.staffPosition;
    }

    public void setStaffPosition(StaffPosition staffPosition) {
        this.staffPosition = staffPosition;
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

    @Column(name = "specialisation")
    public String getSpecialisation() {
        return this.specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Column(name = "address")
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "passport_series", length = 4)
    public String getPassportSeries() {
        return this.passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    @Column(name = "passport_number", length = 6)
    public String getPassportNumber() {
        return this.passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Column(name = "passport_issued_by")
    public String getPassportIssuedBy() {
        return this.passportIssuedBy;
    }

    public void setPassportIssuedBy(String passportIssuedBy) {
        this.passportIssuedBy = passportIssuedBy;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday_date", length = 13)
    public Date getBirthdayDate() {
        return this.birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    @Column(name = "home_phone")
    public String getHomePhone() {
        return this.homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Column(name = "mobile_phone")
    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Column(name = "work_phone")
    public String getWorkPhone() {
        return this.workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    @Column(name = "individual_personal_account_insurance_number", length = 11)
    public String getIndividualPersonalAccountInsuranceNumber() {
        return this.individualPersonalAccountInsuranceNumber;
    }

    public void setIndividualPersonalAccountInsuranceNumber(String individualPersonalAccountInsuranceNumber) {
        this.individualPersonalAccountInsuranceNumber = individualPersonalAccountInsuranceNumber;
    }

    @Column(name = "contract_number", length = 10)
    public String getContractNumber() {
        return this.contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "contract_date", length = 13)
    public Date getContractDate() {
        return this.contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @Column(name = "norm_hours", precision = 17, scale = 17)
    public Double getNormHours() {
        return this.normHours;
    }

    public void setNormHours(Double normHours) {
        this.normHours = normHours;
    }

    @Column(name = "rate", precision = 8, scale = 8)
    public Float getRate() {
        return this.rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "staffByNurseId")
    public Set getSchedulesForNurseId() {
        return this.schedulesForNurseId;
    }

    public void setSchedulesForNurseId(Set schedulesForNurseId) {
        this.schedulesForNurseId = schedulesForNurseId;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "staffByDoctorId")
    public Set getSchedulesForDoctorId() {
        return this.schedulesForDoctorId;
    }

    public void setSchedulesForDoctorId(Set schedulesForDoctorId) {
        this.schedulesForDoctorId = schedulesForDoctorId;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "staff")
    public Set getSystemUsers() {
        return this.systemUsers;
    }

    public void setSystemUsers(Set systemUsers) {
        this.systemUsers = systemUsers;
    }
}
