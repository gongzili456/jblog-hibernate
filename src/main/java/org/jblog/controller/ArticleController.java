package org.jblog.controller;

import org.jblog.domain.Article;
import org.jblog.service.ArticleGroupService;
import org.jblog.service.ArticleService;
import org.jblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/articles")
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@Autowired
	UserService userService;

	@Autowired
	ArticleGroupService groupService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String toWrite(Model model) {
		return "article_write";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public String acticleSave() {
		return null;
	}
	
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String acticle(@PathVariable Long id, Model model) {
		Article article = articleService.get(id);
		model.addAttribute("article", article);
		return "article";
	}

}
