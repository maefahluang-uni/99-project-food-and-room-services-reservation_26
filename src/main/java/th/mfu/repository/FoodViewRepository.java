package th.mfu.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.mfu.domain.FoodView;

import javax.transaction.Transactional;
import java.util.List;

public interface FoodViewRepository extends CrudRepository<FoodView,Long>{

    @Modifying
    @Transactional
    @Query("UPDATE FoodView f SET f.fdname = :fdName, f.fdpic = :fdPic, f.fdprice = :fdPrice WHERE f.id = :fdId")
    void customUpdate(
            @Param("fdId") Long fdId,
            @Param("fdName") String fdName,
            @Param("fdPic") String fdPicture,
            @Param("fdPrice") Integer fdPrice
    );

    Long findQuantityById(Long roomId);

    // for search using JPQL
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM FoodView f WHERE f.fdname LIKE %:keyword%", nativeQuery = true)
    List<FoodView> findByKeyword(@Param("keyword") String keyword);



}

