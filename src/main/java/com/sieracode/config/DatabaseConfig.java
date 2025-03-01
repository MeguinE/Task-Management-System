package com.sieracode.config;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private String url;
    private String user;
    private String password;

    public DatabaseConfig() {
        loadConfig();
    }

    private void loadConfig() {
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties props = new Properties();
            props.load(input);
            this.url = props.getProperty("db.url");
            this.user = props.getProperty("db.user");
            this.password = props.getProperty("db.password");
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar la configuración de la base de datos", e);
        }
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}