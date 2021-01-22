package com.byx.jdbc.test;

import com.byx.jdbc.mapper.BeanRowMapper;
import com.byx.jdbc.JdbcTemplate;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QueryListTest
{
    @Test
    public void test1()
    {
        List<User> users = JdbcTemplate.queryList("SELECT * FROM users", new BeanRowMapper<>(User.class));

        assertNotNull(users);
        assertEquals(5, users.size());
    }

    @Test
    public void test2()
    {
        List<User> users = JdbcTemplate.queryList("SELECT * FROM users WHERE password = ?", new BeanRowMapper<>(User.class), "456");

        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    public void test3()
    {
        List<User> users = JdbcTemplate.queryList("SELECT * FROM users WHERE password = 10086", new BeanRowMapper<>(User.class));

        assertNotNull(users);
        assertEquals(0, users.size());
    }

    @Test
    public void test4()
    {
        List<String> usernames = JdbcTemplate.queryList("SELECT * FROM users", rs -> rs.getString("username"));

        assertNotNull(usernames);
        assertEquals(5, usernames.size());
    }

    @Test
    public void test5()
    {
        List<User> users = JdbcTemplate.queryList("SELECT * FROM users WEAR id = 1", new BeanRowMapper<>(User.class));

        assertNull(users);
    }

    @Test
    public void test6()
    {
        List<User> users = JdbcTemplate.queryList("SELECT * FROM users", new BeanRowMapper<>(User.class), "aaa");

        assertNull(users);
    }

    @Test
    public void test7()
    {
        List<User> users = JdbcTemplate.queryList("SELECT * FROM users", User.class);

        assertNotNull(users);
        assertEquals(5, users.size());
    }

    @Test
    public void test8()
    {
        List<User> users = JdbcTemplate.queryList("SELECT * FROM users WHERE password = ?", User.class, "456");

        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    public void test9()
    {
        List<User> users = JdbcTemplate.queryList("SELECT * FROM users WHERE password = 10086", User.class);

        assertNotNull(users);
        assertEquals(0, users.size());
    }

    @Test
    public void test10()
    {
        List<User> users = JdbcTemplate.queryList("SELECT * FROM", User.class);

        assertNull(users);
    }

    @Test
    public void test11()
    {
        List<User> users = JdbcTemplate.queryList("SELECT * FROM users", User.class, "aaa", "123");

        assertNull(users);
    }
}