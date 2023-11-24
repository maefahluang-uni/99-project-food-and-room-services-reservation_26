package th.mfu.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import th.mfu.domain.User;
import th.mfu.dto.UserRegisteredDTO;


public interface DefaultUserService extends UserDetailsService{

	User save(UserRegisteredDTO userRegisteredDTO);
	
}