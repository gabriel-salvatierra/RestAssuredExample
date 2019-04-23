package managers;

import dataProvider.ConfigFileReader;
import dataProvider.JSONDataReader;

public class FileReaderManager {
    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;
    private static JSONDataReader jsonDataReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }

    public JSONDataReader getJSONReader() {
        return (jsonDataReader == null) ? new JSONDataReader() : jsonDataReader;
    }
}
