package cn.com.insurance.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.insurance.blog.model.AjaxObject;
import cn.com.insurance.blog.service.BlogService;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/save", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public AjaxObject save(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "save");
		return new AjaxObject(map);
	}

	@RequestMapping(value = "/edit", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public AjaxObject edit(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "niucqing");
		map.put("age", 20);
		return new AjaxObject(map);
	}

	@RequestMapping(value = "/query/blog/list", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public void queryBlogList(HttpServletRequest request) {

	}

	@RequestMapping(value = "/query/blog", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public void queryBlogById(HttpServletRequest request) {

	}

}
