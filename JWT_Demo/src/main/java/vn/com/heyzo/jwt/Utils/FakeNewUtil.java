package vn.com.heyzo.jwt.Utils;

import java.util.ArrayList;
import java.util.List;

import vn.com.heyzo.jwt.models.NewsModels;

public class FakeNewUtil {
	public static List<NewsModels> getAllNews() {
		List<NewsModels> newsList = new ArrayList<NewsModels>();
		newsList.add(new NewsModels("test1", " Noi dung test 1 ", "Toan 1"));
		newsList.add(new NewsModels("test2", " Noi dung test 2 ", "Toan 2"));
		newsList.add(new NewsModels("test3", " Noi dung test 3 ", "Toan 3"));
		return newsList;
	}
}
