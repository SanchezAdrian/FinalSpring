package example.service;

import java.util.List;

import example.entity.News;
import example.model.NewsModel;



public interface NewsService {

	public abstract List<NewsModel> getListNews();
	public abstract News addNew(NewsModel newModel);
	public abstract int removeNew(String id);

}
