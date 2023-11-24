package th.mfu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Listitem {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private Integer foodAmount;
    private Integer roomAmpunt;
    private String foodStatus;

    private String roomStatus;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Listfood listfood;
    @ManyToOne(cascade = CascadeType.MERGE)
    private FoodView foodView;

    @ManyToOne(cascade = CascadeType.MERGE)
    private ListRoom listRoom;
    @ManyToOne(cascade = CascadeType.MERGE)
    private RoomView roomView;

    public Listitem(Long id, Integer foodAmount, Integer roomAmpunt, String foodStatus, String roomStatus, Listfood listfood, FoodView foodView, ListRoom listRoom, RoomView roomView) {

        this.id = id;
        this.foodAmount = foodAmount;
        this.roomAmpunt = roomAmpunt;
        this.foodStatus = foodStatus;
        this.roomStatus = roomStatus;
        this.listfood = listfood;
        this.foodView = foodView;
        this.listRoom = listRoom;
        this.roomView = roomView;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(Integer foodAmount) {
        this.foodAmount = foodAmount;
    }

    public Integer getRoomAmpunt() {
        return roomAmpunt;
    }

    public void setRoomAmpunt(Integer roomAmpunt) {
        this.roomAmpunt = roomAmpunt;
    }

    public String getFoodStatus() {
        return foodStatus;
    }

    public void setFoodStatus(String foodStatus) {
        this.foodStatus = foodStatus;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Listfood getListfood() {
        return listfood;
    }

    public void setListfood(Listfood listfood) {
        this.listfood = listfood;
    }

    public FoodView getFoodView() {
        return foodView;
    }

    public void setFoodView(FoodView foodView) {
        this.foodView = foodView;
    }

    public ListRoom getListRoom() {
        return listRoom;
    }

    public void setListRoom(ListRoom listRoom) {
        this.listRoom = listRoom;
    }

    public RoomView getRoomView() {
        return roomView;
    }

    public void setRoomView(RoomView roomView) {
        this.roomView = roomView;
    }
}
