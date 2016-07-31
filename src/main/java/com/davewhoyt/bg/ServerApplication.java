package com.davewhoyt.bg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.net.URI;

@SpringBootApplication
public class ServerApplication {

    @Autowired
    Environment environment;

    @Value("${spring.datasource.driver-class-name}")
    private String databaseDriverClassName;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    @Bean
    public DataSource datasource() {
        try {
            String[] profiles = environment.getActiveProfiles();
            String currentProfile = profiles == null ? "whoah null!" : profiles[0];

            String dsUrl, dbUser, dbPassword;

            if ("production".equals(currentProfile)) {
                URI dbUri = new URI(System.getenv("DATABASE_URL"));

                dbUser = dbUri.getUserInfo().split(":")[0];
                dbPassword = dbUri.getUserInfo().split(":")[1];
                dsUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            } else {
                dsUrl = datasourceUrl;
                dbUser = databaseUsername;
                dbPassword = databasePassword;
            }
            org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
            ds.setDriverClassName(databaseDriverClassName);
            ds.setUrl(dsUrl);
            ds.setUsername(dbUser);
            ds.setPassword(dbPassword);
            return ds;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
