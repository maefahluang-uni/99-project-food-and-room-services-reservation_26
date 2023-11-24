package th.mfu.repository;

import org.hibernate.mapping.List;
import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Listfood;

public interface ListfoodRepository extends CrudRepository<Listfood,Long>{

}
