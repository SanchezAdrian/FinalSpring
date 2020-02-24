package example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import example.constantes.constantes;
import example.converter.NewsConverter;
import example.entity.News;
import example.model.NewsModel;
import example.service.NewsService;

@Controller
@RequestMapping("/ciclistas")
public class NewsController {
	
	@Autowired
	@Qualifier("newsConverter")
	private NewsConverter newsConverter;

	@Autowired
	@Qualifier("newsServiceImpl")
	private NewsService newsService;
	

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView(constantes.HOME);
		
		mav.addObject("noticias",newsService.getListNews());
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/createNews")
	public ModelAndView createNew() {
		ModelAndView mav = new ModelAndView(constantes.CREATENW_VIEW);
		mav.addObject("noticia",new News());
		return mav;
	}
	
	@PostMapping("/addNews")
	public ModelAndView addNew(@ModelAttribute("noticia") NewsModel newsModel) {
		ModelAndView mav = new ModelAndView(constantes.HOME);
		newsService.addNew(newsModel);
		mav.addObject("noticias",newsService.getListNews());
		return mav;
	}

}
