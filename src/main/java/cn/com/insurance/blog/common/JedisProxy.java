package cn.com.insurance.blog.common;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisProxy {
	private static Logger logger = LoggerFactory.getLogger(JedisProxy.class);
	private static JedisPool jedisPool;

	static {
		PropertiesConfiguration pro = null;
		try {
			pro = new PropertiesConfiguration("redis.properties");
		} catch (ConfigurationException e) {
			logger.error("初始化redis.properties失败", e);
		}
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxWaitMillis(pro.getLong("max_wait_millis"));
		config.setMaxIdle(pro.getInt("max_idle"));
		config.setMinIdle(pro.getInt("min_idle"));
		config.setMaxTotal(pro.getInt("max_total"));
		jedisPool = new JedisPool(config, pro.getString("ip"), pro.getInt("port"));
	}

	public static Jedis createProxy() {
		Enhancer enhancer = new Enhancer();
		// 设置代理的父类，就设置需要代理的类
		enhancer.setSuperclass(Jedis.class);
		// 设置自定义的代理方法
		Callback callback = new JedisHandler(jedisPool);
		enhancer.setCallback(callback);

		Object o = enhancer.create();
		Jedis jedis = null;
		if (o instanceof Jedis) {
			jedis = (Jedis) o;
		}
		return jedis;
	}
}
