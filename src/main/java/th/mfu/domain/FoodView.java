package th.mfu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class FoodView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fdname;
    private String fdpic;
    private Integer fdprice;
    private String fdStatus;

    public FoodView(Long id, String fdname, String fdpic, Integer fdprice,String fdStatus) {
        this.id = id;
        this.fdname = fdname;
        this.fdpic = fdpic;
        this.fdprice = fdprice;
        this.fdStatus=fdStatus;

    }

    public FoodView() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFdname() {
        return fdname;
    }

    public void setFdname(String fdname) {
        this.fdname = fdname;
    }

    public String getFdpic() {
        return fdpic;
    }

    public void setFdpic(String fdpic) {
        this.fdpic = fdpic;
    }

    public Integer getFdprice() {
        return fdprice;
    }

    public void setFdprice(Integer fdprice) {
        this.fdprice = fdprice;
    }

    public String getFdStatus() {
        return fdStatus;
    }

    public void setFdStatus(String fdStatus) {
        this.fdStatus = fdStatus;
    }
    
}


