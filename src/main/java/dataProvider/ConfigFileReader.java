package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "configs//environment.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getHost() {
        String host = properties.getProperty("HOST");
        if (host != null) {
            return host;
        } else {
            throw new RuntimeException("HOST not specified in the Configuration.properties file");
        }
    }

    public String getKey() {
        String key = properties.getProperty("key");
        if (key != null) {
            return key;
        } else {
            throw new RuntimeException("Key not specified in the Configuration.properties file");
        }
    }
}
