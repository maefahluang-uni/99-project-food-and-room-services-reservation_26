package th.mfu.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Listfood {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

    @OneToOne(cascade = CascadeType.MERGE)
    private Payment payment;

    public Listfood(Long id, Date listDate, User user, Payment payment) {
        this.id = id;
        this.user = user;
        this.payment = payment;
    }

    public Listfood() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

   

    
    
}
