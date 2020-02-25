package example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import example.constantes.constantes;
import example.converter.NewsConverter;
import example.service.NewsService;

@Controller
@RequestMapping("/ciclistas")
public class HomeController {
	
	@Autowired
	@Qualifier("newsConverter")
	private NewsConverter newsConverter;

	@Autowired
	@Qualifier("newsServiceImpl")
	private NewsService newsService;
	
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView(constantes.HOME);
		
		mav.addObject("noticias",newsService.getListNews());
		return mav;
	}

}
