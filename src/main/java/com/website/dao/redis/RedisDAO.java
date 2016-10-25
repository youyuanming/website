package com.website.dao.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisDAO {

	@Autowired	
	private RedisTemplate redisTemplate;
	
	/**
	 * 持久化对象
	 * @param key
	 * @param value
	 */
	public void set(String key,String value) {
		ValueOperations<String,String> operations = redisTemplate.opsForValue();
		operations.set(key, value);
    }
	
	/**
	 * 持久化对象
	 * @param key
	 * @param value
	 */
	public void set(String key,Object value) {
		ValueOperations<String,Object> operations = redisTemplate.opsForValue();
		operations.set(key, value);
    }
	
	/**
	 * 设置key并设置超时时间
	 * @param key
	 * @param value
	 * @param timeout 分钟
	 */
	public void set(String key,String value,int timeout) {
		ValueOperations<String,String> operations = redisTemplate.opsForValue();
		operations.set(key, value, timeout, TimeUnit.SECONDS);
    }
	
	/**
	 * 设置key并设置超时时间
	 * @param key
	 * @param value
	 * @param timeout 分钟
	 */
	public void set(String key,Object value,int timeout) {
		ValueOperations<String,Object> operations = redisTemplate.opsForValue();
		operations.set(key, value, timeout, TimeUnit.SECONDS);
    }
	
	/**
	 * 查询类型为string的key
	 * @param key
	 * @return
	 */
	public String getString(String key){
		ValueOperations<String,String> operations = redisTemplate.opsForValue();
		return operations.get(key);
	}
	
	/**
	 * 查询类型为Object的key
	 * @param key
	 * @return
	 */
	public Object getObject(String key){
		ValueOperations operations = redisTemplate.opsForValue();
		return operations.get(key);
	}
	
	/**
	 * 删除key
	 * @param key
	 */
	public void delete(String key) {
		redisTemplate.delete(key);
    }
	
}
