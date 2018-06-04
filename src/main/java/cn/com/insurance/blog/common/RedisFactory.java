package cn.com.insurance.blog.common;

import java.lang.reflect.Method;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisFactory {
	private static Logger logger = LoggerFactory.getLogger(RedisFactory.class);

	private static RedisFactory proxyInstance = createProxy();
	private static JedisPool pool;

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
		pool = new JedisPool(config, pro.getString("ip"), pro.getInt("port"));
	}

	public static Jedis getProxy() {
		return proxyInstance.getJedis();
	}

	public Jedis getJedis() {
		if (pool != null) {
			return pool.getResource();
		} else {
			return null;
		}
	}

	public static RedisFactory createProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(RedisFactory.class);
		enhancer.setCallback(new MethodInterceptor() {
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
					throws Throwable {
				if (method.getName().equals("getJedis")) {
					Jedis result = (Jedis) methodProxy.invokeSuper(o, objects);
					pool.returnResource(result);
					logger.error("redis closed--空闲-" + pool.getNumIdle() + "-Active-" + pool.getNumActive());
					return result;
				} else {
					logger.error("redis ddd");
					return method.invoke(o, objects);

				}
			}
		});

		return (RedisFactory) enhancer.create();
	}
}
