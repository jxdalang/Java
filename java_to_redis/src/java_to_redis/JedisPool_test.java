package java_to_redis;

import redis.clients.jedis.*;


public class JedisPool_test {

    private static JedisPool pool = null;

    /** 
     * 构建redis连接池 
     *  
     * @param ip 
     * @param port 
     * @return JedisPool 
     */
    public static JedisPool getPool() {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            // 设置pool最多可分配多少个Jedis实例，如果赋值为-1，则表示不限制
            config.setMaxTotal(50);
            // 设置一个pool最多有多少个状态为idle(空闲的)的Jedis实例
            config.setMaxIdle(5);
            // 设置在获得一个Jedis实例时，是否提前进行validate操作
            config.setTestOnBorrow(true);
            pool = new JedisPool(config, "localhost", 6379);
        }
        return pool;
    }

    /** 
     * 获取数据 
     *  
     * @param key 
     * @return 
     */
    public static String get(String key) {
        String value = null;

        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            jedis = pool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            // 释放redis对象
            jedis.close();
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return value;
    }
}
