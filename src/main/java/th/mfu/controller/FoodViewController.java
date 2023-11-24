package th.mfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import th.mfu.domain.FoodView;
import th.mfu.repository.FoodViewRepository;
import th.mfu.service.FoodViewService;

// Admin //
@Controller
public class FoodViewController {
    private final FoodViewRepository foodViewRepository;
    private final FoodViewService foodViewService;

    public FoodViewController(FoodViewRepository foodViewRepository, FoodViewService foodViewService) {
        this.foodViewRepository = foodViewRepository;
        this.foodViewService = foodViewService;
    }

    @GetMapping("/add-food")
    public String addAFoodViewForm(Model model) {
        model.addAttribute("foodview", new FoodView());
        return "add-food-from";
    }

    @PostMapping("/update-food/{id}")
    public String updateFoodViewFrom(Model model, @PathVariable Long id) {
        model.addAttribute("foodview", foodViewRepository.findById(id));
        model.addAttribute("foodId",id);
        return "add-food-from-id";
    }
    @PostMapping("/admin_savefoods")
    public String saveFoodViews(@ModelAttribute FoodView foodView) {
        foodViewRepository.save(foodView);
        return "redirect:/admin";
    }

    @PostMapping("/admin_update_food")
    public String updateFoodView(@ModelAttribute("foodview") FoodView foodView, @RequestParam("id") Long id) {
        if (id != null && foodView != null) {
            foodViewService.updateFoodView(
                    id, foodView.getFdname(),
                    foodView.getFdpic(),
                    foodView.getFdprice());
        }
        return "redirect:/admin";
    }
    @GetMapping("/delete-food{id}")
    public String deleteFood(@PathVariable Long id){
        foodViewRepository.deleteById(id);
        return "redirect:/admin";
    }
    @GetMapping("/delete-food")
    public String removeAllFood(){
        foodViewRepository.deleteAll();
        return "redirect:/admin";    }
}
