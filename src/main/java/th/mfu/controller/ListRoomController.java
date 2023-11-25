package th.mfu.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import th.mfu.domain.ListRoom;
import th.mfu.domain.Listitem;
import th.mfu.domain.Payment;
import th.mfu.repository.ListRoomrepository;
import th.mfu.repository.ListitemRepository;
import th.mfu.repository.PaymentRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class ListRoomController {

    private final ListitemRepository listitemRepository;
    private final PaymentRepository paymentRepository;
    private final ListRoomrepository listRoomrepository;

    public ListRoomController(ListitemRepository listitemRepository, PaymentRepository paymentRepository, ListRoomrepository listRoomrepository) {
        this.listitemRepository = listitemRepository;
        this.paymentRepository = paymentRepository;
        this.listRoomrepository = listRoomrepository;
    }

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/booking-room")
    public String bookingRoom(@RequestParam("name") String name,
                              @RequestParam("tell") Integer tell,
                              @RequestParam("checkin") Date checkin,
                              @RequestParam("checkout") Date checkout) {

        // Create a new ListRoom object
        ListRoom listRoom = new ListRoom();
        listRoom.setName(name);
        listRoom.setTell(tell);
        listRoom.setCheckin(checkin);
        listRoom.setCheckout(checkout);

        // Pass the ListRoom object to the view
        return "booking-room-form";
    }

    @PostMapping("/booking_roomsave")
    public String saveBookingroom(@ModelAttribute ListRoom listRoom) {
        // Save the ListRoom object to the repository
        listRoomrepository.save(listRoom);
        return "redirect:/user";
    }




    @GetMapping("/confirm-room/{id}")
    public String confirmOrderbyId(@PathVariable Long id) {
        // change status to confirm
        Listitem templistitem = listitemRepository.findById(id).get();
        templistitem.setRoomStatus("confirm");
        long payId = templistitem.getListRoom().getPayment().getId();

        // add confirm price to total price
        Payment temppayment = paymentRepository.findById(payId).get();
        Integer oldtotalpay = temppayment.getPay_total();
        Integer newtotalpay = oldtotalpay
                + (templistitem.getRoomAmpunt() * templistitem.getRoomView().getRvprice());
        temppayment.setPay_total(newtotalpay);

        // save to repo
        listitemRepository.save(templistitem);
        paymentRepository.save(temppayment);

        return "redirect:/user";
    }

    @GetMapping("/cancel-room/{id}")
    public String cancelOrderbyId(@PathVariable Long id) {
        Listitem templistitem = listitemRepository.findById(id).get();
        templistitem.setFoodStatus("cancel");
        listitemRepository.save(templistitem);

        return "redirect:/user";
    }
    
}
