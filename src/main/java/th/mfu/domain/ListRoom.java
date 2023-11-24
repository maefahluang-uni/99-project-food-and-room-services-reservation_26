package th.mfu.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ListRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer tell;
    private Date checkin;
    private Date checkout;


    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

    @OneToOne(cascade = CascadeType.MERGE)
    private Payment payment;

    public ListRoom(Long id, String name, Integer tell, Date checkin, Date checkout, User user, Payment payment) {

        this.id = id;
        this.name = name;
        this.tell = tell;
        this.checkin = checkin;
        this.checkout = checkout;
        this.user = user;
        this.payment = payment;
    }

    public ListRoom() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTell() {
        return tell;
    }

    public void setTell(Integer tell) {
        this.tell = tell;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
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

