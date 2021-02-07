package bookstore.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class UserController {

	@GetMapping("/secured/all")
	public String securedAuth(){
		return "auth suceeded";
	}
}
