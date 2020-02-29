package app.Util;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class ConfigurationTest {
    @Test
    public void config() {
        Properties properties = new Configuration("src/main/resources/config/configuration.yml").getProperties();
        properties.getProperty("database_host");
        Properties properties1 = new Properties();
        properties1.setProperty("database_host", "95.181.178.241");
        properties1.setProperty("database_port", "5432");
        properties1.setProperty("database_database", "eugen");
        properties1.setProperty("database_user", "server");
        properties1.setProperty("database_password", "gEt0Q2sY");
        properties1.setProperty("port", "5432");

        assertEquals("Difference!", properties, properties1);
    }

}
