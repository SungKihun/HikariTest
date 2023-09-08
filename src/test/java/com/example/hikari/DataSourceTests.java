package com.example.hikari;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/context-datasource.xml")
@Log4j2
public class DataSourceTests {
    @Setter(onMethod_ = { @Autowired})
    private DataSource dataSource;

    @Test
    public void testConnection() {
        try (Connection con = dataSource.getConnection()) {
            log.info(con);
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }
}
