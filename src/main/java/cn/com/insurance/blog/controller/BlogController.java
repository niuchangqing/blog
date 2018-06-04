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

import cn.com.insurance.blog.common.JedisProxy;
import cn.com.insurance.blog.model.AjaxObject;
import cn.com.insurance.blog.model.BlogModel;
import cn.com.insurance.blog.service.BlogService;
import redis.clients.jedis.Jedis;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);

	@Autowired
	private BlogService blogService;

	private Jedis jedis = JedisProxy.createProxy();

	@RequestMapping(value = "/save", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public AjaxObject save(HttpServletRequest request) {
		Map<String, String> map = jedis.hgetAll("red_packets_config_yellowbox");
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
	public AjaxObject queryBlogList(HttpServletRequest request) {
		BlogModel model = new BlogModel();
		model.setId(100L);
		model.setTitle("hello");
		model.setBody("text");
		return new AjaxObject(model);
	}

	@RequestMapping(value = "/query/blog", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public void queryBlogById(HttpServletRequest request) {
		blogService.queryBlogById();
	}

}
