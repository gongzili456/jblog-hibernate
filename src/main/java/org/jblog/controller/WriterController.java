package org.jblog.controller;

import java.util.Date;
import java.util.List;

import org.jblog.domain.Article;
import org.jblog.domain.ArticleGroup;
import org.jblog.domain.User;
import org.jblog.service.ArticleGroupService;
import org.jblog.service.ArticleService;
import org.jblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/writer")
public class WriterController {

	@Autowired
	ArticleGroupService groupService;

	@Autowired
	ArticleService articleService;

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String toWrite(Model model) {
		return "writer/writer";
	}

	@RequestMapping(value = "/groups", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public List<ArticleGroup> getGroups(Model model) {
		List<ArticleGroup> groups = groupService.listByUser(1l);
		return groups;
	}

	@RequestMapping(value = "/group/articles/{groupId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<Article> getArticles(@PathVariable Long groupId) {
		List<Article> articles = articleService.listByGroup(groupId);
		return articles;
	}

	@RequestMapping(value = "/articles", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public Article createArticle(@RequestBody Article article) {
		User user = userService.load(1l);
		article.setAuthor(user);
		article.setCreateTime(new Date());
		article.setModifyTime(new Date());
		article.setDesc(article.getContent().length() > 100 ? article
				.getContent().substring(100) : article.getContent());
		article.setWordCount(article.getContent().length());
		Long id = (Long) articleService.save(article);
		Article a = articleService.get(id);
		return a;

	};

	@RequestMapping(value = "/articles/{articleId}", method = RequestMethod.PUT)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public Article updateArticle(@RequestBody Article article,
			@PathVariable Long articleId) {
		article.setAuthor(null);
		article.setModifyTime(new Date());
		article.setDesc(article.getContent().length() > 100 ? article
				.getContent().substring(100) : article.getContent());
		article.setWordCount(article.getContent().length());
		articleService.update(article);
		Article a = articleService.get(articleId);
		return a;
	}

	@RequestMapping(value = "/articles/{articleId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Article getArticle(@PathVariable Long articleId) {
		Article article = articleService.get(articleId);
		return article;

	}

}
