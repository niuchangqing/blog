package cn.com.insurance.blog.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.insurance.blog.main.mapper.BottomBarMapper;
import cn.com.insurance.blog.main.po.BottomBar;
import cn.com.insurance.blog.service.BlogService;

@Service("blogServiceImpl")
public class BlogServiceImpl implements BlogService {
	private static Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);

	@Autowired
	private BottomBarMapper bottomBarMapper;

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void queryBlogList() {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(readOnly = true)
	public void queryBlogById() {
		// TODO Auto-generated method stub
		List<BottomBar> list = bottomBarMapper.selectAll();
		logger.error("++++++++++++" + list.size() + "+++++++++++++++");
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub

	}

}
