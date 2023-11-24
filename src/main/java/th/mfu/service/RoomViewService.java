package th.mfu.service;

import org.springframework.stereotype.Service;

import th.mfu.domain.RoomView;
import th.mfu.repository.RoomViewRepository;

import java.util.List;

@Service
public class RoomViewService {
    private final RoomViewRepository roomViewRepository;

    public RoomViewService(RoomViewRepository roomViewRepository) {
        this.roomViewRepository = roomViewRepository;
    }
    public void updateRoomView(
            Long rvId,
            String rvName,
            String rvPic,
            Integer rvPrice
    ){
        roomViewRepository.customUpdate(rvId,rvName,rvPic,rvPrice);
    }
    public List<RoomView> findBykeyword(String keywordString){
        return roomViewRepository.findByKeyword(keywordString);

    }
}
