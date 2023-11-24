package th.mfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import th.mfu.dto.UserLoginDto;
import th.mfu.service.DefaultUserService;

@Controller
@RequestMapping("/login")
public class LoginController {
@Autowired
	private DefaultUserService userService;

    @ModelAttribute("user")
    public UserLoginDto userLoginDTO() {
        return new UserLoginDto();
    }
    
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public void  loginUser(@ModelAttribute("user") 
	UserLoginDto userLoginDTO) {
	 userService.loadUserByUsername(userLoginDTO.getUsername());
	}
}