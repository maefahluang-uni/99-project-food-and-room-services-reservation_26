package th.mfu.service;

import org.springframework.stereotype.Service;

import th.mfu.domain.FoodView;
import th.mfu.repository.FoodViewRepository;


import java.util.List;

@Service
public class FoodViewService {
    private final FoodViewRepository foodViewRepository;

    public FoodViewService(FoodViewRepository foodViewRepository) {
        this.foodViewRepository = foodViewRepository;
    }
    public void updateFoodView(
            Long fdId,
            String fdName,
            String fdPic,
            Integer fdPrice
    ){
        foodViewRepository.customUpdate(fdId,fdName,fdPic,fdPrice);
    }
    public List<FoodView> findBykeyword(String keywordString){
        return foodViewRepository.findByKeyword(keywordString);

    }

}
