package bookstore.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookstore.service.ReclamationAdminService;
import bookstore.service.ReclamationClientService;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
	@Autowired
    private ReclamationClientService reclamationClientService;
	@Autowired
    private ReclamationAdminService reclamationAdminService;
	
}
