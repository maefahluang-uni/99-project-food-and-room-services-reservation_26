package th.mfu.domain;

import javax.persistence.*;

@Entity

public class RoomView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rvname;
    private String rvpic;
    private Integer rvprice;

    public RoomView(Long id, String rvname, String rvpic, Integer rvprice) {
        this.id = id;
        this.rvname = rvname;
        this.rvpic = rvpic;
        this.rvprice = rvprice;
    }

    public RoomView() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRvname() {
        return rvname;
    }

    public void setRvname(String rvname) {
        this.rvname = rvname;
    }

    public String getRvpic() {
        return rvpic;
    }

    public void setRvpic(String rvpic) {
        this.rvpic = rvpic;
    }

    public Integer getRvprice() {
        return rvprice;
    }

    public void setRvprice(Integer rvprice) {
        this.rvprice = rvprice;
    }
}
