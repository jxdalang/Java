package java_to_redis;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.*;

public class TestJedisBasic {

    Jedis jedis;

    @Before
    public void setUp() {
        jedis = new Jedis("localhost"); // 连接本地的Redis服务进行测试
    }

    @After
    public void tearDown() throws Exception {
        jedis.close(); // 测试结束时释放资源
    }

    @Test
    public void testGet() {
        assertEquals(null, jedis.get("neverused"));
    }

    @Test
    public void testString() {
        // 添加数据
        jedis.set("name", "test_name");
        // 读取数据
        assertEquals("test_name", jedis.get("name"));
    }
    
}
