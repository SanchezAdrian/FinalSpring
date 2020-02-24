package example.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import example.converter.NewsConverter;
import example.entity.News;
import example.model.NewsModel;
import example.repository.NewsJpaRepository;
import example.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	@Qualifier("newsJpaRepository")
	private NewsJpaRepository newsJpaRepository;
	
	@Autowired
	@Qualifier("newsConverter")
	private NewsConverter newsConverter;
	
	
	@Override
	public List<NewsModel> getListNews() {
		List<NewsModel> newsModel=new ArrayList<NewsModel>();
		for(News news:newsJpaRepository.findAll())
			newsModel.add(newsConverter.entity2model(news));
		return newsModel;
	}

	@Override
	public News addNew(NewsModel newModel) {
		News news=newsConverter.model2entity(newModel);
		return newsJpaRepository.save(news);
	}

	@Override
	public int removeNew(String id) {
		newsJpaRepository.deleteById(id);
		return 0;
	}

}
