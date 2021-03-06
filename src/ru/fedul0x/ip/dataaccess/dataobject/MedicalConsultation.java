package ru.fedul0x.ip.dataaccess.dataobject;

// Generated 23.12.2012 2:11:14 by Hibernate Tools 3.2.1.GA
import ru.fedul0x.ip.dataaccess.dataobject.Agent;
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
 * MedicalConsultation generated by hbm2java
 */
@Entity
@Table(name = "medical_consultation", schema = "public")
public class MedicalConsultation extends DataEntity {

    private ServicePrice servicePrice;
    private Service service;
    private SystemUser systemUser;
    private PaymentMethod paymentMethod;
    private Payer payer;
    private Patient patient;
    private Agent agent;
    private Date registrationDate;
    private Boolean isPrimarySurveyType;
    private Boolean isPrintedServiceDocument;
    private Date repeatSurveyDate;
    private String repeatSurveyDocument;
    private String priceList;
    private Date endSubscriptionDate;
    private Set schedules = new HashSet(0);

    public MedicalConsultation() {
    }

    public MedicalConsultation(Long id) {
        this.id = id;
    }

    public MedicalConsultation(Long id, ServicePrice servicePrice, Service service, SystemUser systemUser, PaymentMethod paymentMethod, Payer payer, Patient patient, Agent agent, Date registrationDate, Boolean isPrimarySurveyType, Boolean isPrintedServiceDocument, Date repeatSurveyDate, String repeatSurveyDocument, String priceList, Date endSubscriptionDate, Set schedules) {
        this.id = id;
        this.servicePrice = servicePrice;
        this.service = service;
        this.systemUser = systemUser;
        this.paymentMethod = paymentMethod;
        this.payer = payer;
        this.patient = patient;
        this.agent = agent;
        this.registrationDate = registrationDate;
        this.isPrimarySurveyType = isPrimarySurveyType;
        this.isPrintedServiceDocument = isPrintedServiceDocument;
        this.repeatSurveyDate = repeatSurveyDate;
        this.repeatSurveyDocument = repeatSurveyDocument;
        this.priceList = priceList;
        this.endSubscriptionDate = endSubscriptionDate;
        this.schedules = schedules;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_price_id")
    public ServicePrice getServicePrice() {
        return this.servicePrice;
    }

    public void setServicePrice(ServicePrice servicePrice) {
        this.servicePrice = servicePrice;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repeat_survey_id")
    public Service getService() {
        return this.service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_user_id")
    public SystemUser getSystemUser() {
        return this.systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id")
    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payer_id")
    public Payer getPayer() {
        return this.payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    public Agent getAgent() {
        return this.agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "registration_date", length = 13)
    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Column(name = "is_primary_survey_type")
    public Boolean getIsPrimarySurveyType() {
        return this.isPrimarySurveyType;
    }

    public void setIsPrimarySurveyType(Boolean isPrimarySurveyType) {
        this.isPrimarySurveyType = isPrimarySurveyType;
    }

    @Column(name = "is_printed_service_document")
    public Boolean getIsPrintedServiceDocument() {
        return this.isPrintedServiceDocument;
    }

    public void setIsPrintedServiceDocument(Boolean isPrintedServiceDocument) {
        this.isPrintedServiceDocument = isPrintedServiceDocument;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "repeat_survey_date", length = 13)
    public Date getRepeatSurveyDate() {
        return this.repeatSurveyDate;
    }

    public void setRepeatSurveyDate(Date repeatSurveyDate) {
        this.repeatSurveyDate = repeatSurveyDate;
    }

    @Column(name = "repeat_survey_document")
    public String getRepeatSurveyDocument() {
        return this.repeatSurveyDocument;
    }

    public void setRepeatSurveyDocument(String repeatSurveyDocument) {
        this.repeatSurveyDocument = repeatSurveyDocument;
    }

    @Column(name = "price_list", length = 50)
    public String getPriceList() {
        return this.priceList;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "end_subscription_date", length = 13)
    public Date getEndSubscriptionDate() {
        return this.endSubscriptionDate;
    }

    public void setEndSubscriptionDate(Date endSubscriptionDate) {
        this.endSubscriptionDate = endSubscriptionDate;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "medicalConsultation")
    public Set getSchedules() {
        return this.schedules;
    }

    public void setSchedules(Set schedules) {
        this.schedules = schedules;
    }
}
