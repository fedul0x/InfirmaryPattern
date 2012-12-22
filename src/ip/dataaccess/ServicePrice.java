package ip.dataaccess;
// Generated 23.12.2012 2:11:14 by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
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

/**
 * ServicePrice generated by hbm2java
 */
@Entity
@Table(name="service_price"
    ,schema="public"
)
public class ServicePrice  implements java.io.Serializable {


     private int id;
     private Service service;
     private SupplementalHealthInsurance supplementalHealthInsurance;
     private BigDecimal price;
     private Double fotDoc;
     private Double fotMs;
     private Set medicalConsultations = new HashSet(0);

    public ServicePrice() {
    }

	
    public ServicePrice(int id) {
        this.id = id;
    }
    public ServicePrice(int id, Service service, SupplementalHealthInsurance supplementalHealthInsurance, BigDecimal price, Double fotDoc, Double fotMs, Set medicalConsultations) {
       this.id = id;
       this.service = service;
       this.supplementalHealthInsurance = supplementalHealthInsurance;
       this.price = price;
       this.fotDoc = fotDoc;
       this.fotMs = fotMs;
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
    @JoinColumn(name="service_id")
    public Service getService() {
        return this.service;
    }
    
    public void setService(Service service) {
        this.service = service;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="supplemental_health_insurance_id")
    public SupplementalHealthInsurance getSupplementalHealthInsurance() {
        return this.supplementalHealthInsurance;
    }
    
    public void setSupplementalHealthInsurance(SupplementalHealthInsurance supplementalHealthInsurance) {
        this.supplementalHealthInsurance = supplementalHealthInsurance;
    }
    
    @Column(name="price", precision=131089, scale=0)
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    @Column(name="fot_doc", precision=17, scale=17)
    public Double getFotDoc() {
        return this.fotDoc;
    }
    
    public void setFotDoc(Double fotDoc) {
        this.fotDoc = fotDoc;
    }
    
    @Column(name="fot_ms", precision=17, scale=17)
    public Double getFotMs() {
        return this.fotMs;
    }
    
    public void setFotMs(Double fotMs) {
        this.fotMs = fotMs;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="servicePrice")
    public Set getMedicalConsultations() {
        return this.medicalConsultations;
    }
    
    public void setMedicalConsultations(Set medicalConsultations) {
        this.medicalConsultations = medicalConsultations;
    }




}


