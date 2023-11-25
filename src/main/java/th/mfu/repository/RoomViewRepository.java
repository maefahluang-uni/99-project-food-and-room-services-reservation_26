package th.mfu.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.mfu.domain.RoomView;

import javax.transaction.Transactional;
import java.util.List;

public interface RoomViewRepository extends CrudRepository<RoomView,Long>{

    @Modifying
    @Transactional
    @Query("UPDATE RoomView r SET r.rvname = :rvName, r.rvpic = :rvPic, r.rvprice = :rvPrice WHERE r.id = :rvId")
    void customUpdate(
            @Param("rvId") Long rvId,
            @Param("rvName") String rvName,
            @Param("rvPic") String rvPicture,
            @Param("rvPrice") Integer rvPrice
    );

    Long findQuantityById(Long roomId);

    // for search using JPQL
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM Room r WHERE r.rvname LIKE %:keyword%", nativeQuery = true)
    List<RoomView> findByKeyword(@Param("keyword") String keyword);



}

