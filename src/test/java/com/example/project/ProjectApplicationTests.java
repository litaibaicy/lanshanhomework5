package com.example.project;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class ProjectApplicationTests {
    DataSource dataSource;

    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from lose", Long.class);
        log.info("记录总数:{}", aLong);

        log.info("数据源类型:{}", dataSource.getClass());
    }

}
