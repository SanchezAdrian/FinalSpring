package example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import example.entity.News;
import example.model.NewsModel;
import example.repository.NewsJpaRepository;

@Component("newsConverter")
public class NewsConverter {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	@Qualifier("newsJpaRepository")
	private NewsJpaRepository newsJpaRepository;
	
	//entity 2 model 
	public NewsModel entity2model(News news) {
		News saveNew = newsJpaRepository.save(news);
		NewsModel returnvalue = modelMapper.map(saveNew, NewsModel.class);
		return returnvalue;
	}
	
	// model 2 entity
	
	public News model2entity(NewsModel newsModel) {
		News news = modelMapper.map(newsModel, News.class);
		return news;
	}

}
