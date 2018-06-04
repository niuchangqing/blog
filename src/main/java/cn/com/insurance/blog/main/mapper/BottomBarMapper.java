package cn.com.insurance.blog.main.mapper;

import java.util.List;
import java.util.Map;

import cn.com.insurance.blog.main.po.BottomBar;
public interface BottomBarMapper {

	BottomBar selectByPrimaryKey(Long id);

	List<BottomBar> selectAll();

	/**
	 * 查询记录总数，分页
	 * 
	 * @return
	 */
	Integer queryCount();

	/**
	 * 分页查询记录
	 * 
	 * @param list
	 * @return
	 */
	List<BottomBar> queryList(Map<String, Object> map);

	Long queryEffectiveId();

	/**
	 * 查询失效数据
	 * 
	 * @return
	 */
	List<Long> queryInvalid();
}
