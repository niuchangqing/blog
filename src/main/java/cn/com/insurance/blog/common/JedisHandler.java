package cn.com.insurance.blog.common;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.InvocationHandler;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisHandler implements InvocationHandler {
	private JedisPool jedisPool;

	public JedisHandler(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	/**
	 * 当使用jedis方法的时候，实际调用的这里的方法
	 * 
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Object invoke = method.invoke(jedis, args);
			System.out.println("jedisPool Active-" + jedisPool.getNumActive()+"---Idle-"+jedisPool.getNumIdle());
			return invoke;
		} finally {
			if (jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}
}
