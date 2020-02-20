package vn.com.heyzo.jwt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.heyzo.jwt.Utils.FakeNewUtil;
import vn.com.heyzo.jwt.models.NewsModels;


@RestController
public class NewController {
	@GetMapping(value = "/news")
	public List<NewsModels> getNew(){
		 return FakeNewUtil.getAllNews();
	}
}
