package th.mfu.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Long id; 
    private Date payDate;
    private Integer pay_total;
    public Payment(Long id, Date payDate, Integer pay_total) {
        this.id = id;
        this.payDate = payDate;
        this.pay_total = pay_total;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getPayDate() {
        return payDate;
    }
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
    public Integer getPay_total() {
        return pay_total;
    }
    public void setPay_total(Integer pay_total) {
        this.pay_total = pay_total;
    }

  
    
}
