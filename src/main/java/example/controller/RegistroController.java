package example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import example.constantes.constantes;
import example.converter.TestCrypt;
import example.entity.UserCredential;
import example.model.UserCredentialModel;
import example.service.Impl.UserServiceImpl;

@Controller
@RequestMapping("/ciclistas")
public class RegistroController {
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserServiceImpl userServiceImpl;
	
	private TestCrypt enc=new TestCrypt();

	
	@GetMapping("/registro")
	public ModelAndView registrar() {
		ModelAndView mav =new ModelAndView(constantes.REG);
		mav.addObject("userCredential",new UserCredential());
		return mav;
	}
	
	@PostMapping("/addUserCredential")
	public ModelAndView addUser(@ModelAttribute("userCredential") UserCredentialModel userCredentialModel, Model model, RedirectAttributes flash) {
		ModelAndView mav = new ModelAndView(constantes.LOGIN_VIEW);
		userCredentialModel.setPassword(enc.encrypt(userCredentialModel.getPassword()));
		userServiceImpl.addUser(userCredentialModel);
		return mav;
	}

}
