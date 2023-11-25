package th.mfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import th.mfu.domain.Listitem;
import th.mfu.domain.Payment;
import th.mfu.repository.ListitemRepository;
import th.mfu.repository.PaymentRepository;



@Controller
public class ListfoodController {

    private final ListitemRepository listitemRepository;
    private final PaymentRepository paymentRepository;

    public ListfoodController(ListitemRepository listitemRepository,
                              PaymentRepository paymentRepository) {
        this.listitemRepository = listitemRepository;
        this.paymentRepository = paymentRepository;
    }





    @GetMapping("/confirm-food/{id}")
    public String confirmOrderbyId(@PathVariable Long id) {
        // change status to confirm
        Listitem templistitem = listitemRepository.findById(id).get();
        templistitem.setFoodStatus("confirm");
        long payId = templistitem.getListfood().getPayment().getId();

        // add confirm price to total price
        Payment temppayment = paymentRepository.findById(payId).get();
        Integer oldtotalpay = temppayment.getPay_total();
        Integer newtotalpay = oldtotalpay
                + (templistitem.getFoodAmount() * templistitem.getFoodView().getFdprice());
        temppayment.setPay_total(newtotalpay);

        // save to repo
        listitemRepository.save(templistitem);
        paymentRepository.save(temppayment);

        return "redirect:/user";
    }

    @GetMapping("/cancel-food/{id}")
    public String cancelOrderbyId(@PathVariable Long id) {
        Listitem templistitem = listitemRepository.findById(id).get();
        templistitem.setFoodStatus("cancel");
        listitemRepository.save(templistitem);

        return "redirect:/user";
    }
    
}
