package utilsGUI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigProperties {
    String fileName = "./config/config.properties";

    public void setProp(String key, String value) {
        try {
            Path pathFileName = Paths.get(fileName);

            if (Files.notExists(pathFileName)) {
                Files.createFile(pathFileName);
            }

            FileInputStream fileIn = new FileInputStream(fileName);
            FileOutputStream fileOut = new FileOutputStream(fileName);

            Properties props = new Properties();
            props.load(fileIn);
            props.setProperty(key, value);
            props.store(fileOut, "Salvou com sucesso");

            fileIn.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProp(String key) throws IOException {
        Path pathFileName = Paths.get(fileName);

        if (Files.notExists(pathFileName)) {
            return "";
        }

        FileInputStream fileIn = new FileInputStream(fileName);

        Properties props = new Properties();
        props.load(fileIn);

        fileIn.close();

        String value = props.getProperty(key);
        return value;
    }
}