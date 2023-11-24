package th.mfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import th.mfu.domain.RoomView;
import th.mfu.repository.RoomViewRepository;
import th.mfu.service.RoomViewService;


//Admin//
@Controller
public class RoomViewController {
    private final RoomViewRepository roomViewRepository;
    private final RoomViewService roomViewService;

    public RoomViewController(RoomViewRepository roomViewRepository,RoomViewService roomViewService) {
        this.roomViewRepository = roomViewRepository;
        this.roomViewService =roomViewService;
    }

    @GetMapping("/add-room")
    public String addRoomViewForm(Model model) {
        model.addAttribute("roomview", new RoomView());
        return "add-room-from";
    }
    @PostMapping("/update-Room/{id}")
    public String updateRoomViewFrom(Model model,@PathVariable Long id){
        model.addAttribute("roomview",roomViewRepository.findById(id));
        return "add-room-from-{id}";
    }
    @PostMapping("/admin_saverooms")
    public String saveRoomviews(@ModelAttribute RoomView roomView) {
        roomViewRepository.save(roomView);
        return "redirect:/admin";
    }
    @PostMapping("/admin_update_room")
    public String updateRoomView(@ModelAttribute("roomview") RoomView roomView, @RequestParam("id") Long id) {
        if (id != null && roomView != null) {
            roomViewService.updateRoomView(
                    id, roomView.getRvname(),
                    roomView.getRvpic(),
                    roomView.getRvprice());
        }
        return "redirect:/admin";
    }

    @GetMapping("/delete-room{id}")
    public String deleteRoom(@PathVariable Long id){
        roomViewRepository.deleteById(id);
        return "redirect:/admin";
    }
    @GetMapping("/delete-room")
    public String removeAllRoom(){
        roomViewRepository.deleteAll();
        return "redirect:/admin";    }
}

