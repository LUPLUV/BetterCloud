package dev.lupluv.bettercloud.configuration;

import dev.lupluv.bettercloud.Main;

import java.io.File;
import java.io.IOException;

public class Configuration {

    private static Configuration configuration;

    public static Configuration getConfiguration() {
        if(configuration == null){
            try {
                configuration = new Configuration();
            } catch (IOException e) {
                System.out.println("Failed to load Configurations");
                System.out.println("Error Code below:");
                e.printStackTrace();
            }
        }
        return configuration;
    }

    String dirName;
    File configFile;

    public Configuration() throws IOException {
        configFile = new File("config.json");
        if(!configFile.exists()){
            Main.firstRun = true;
            configFile.createNewFile();
        }
    }

    public File getTasksFolder(){
        return new File(dirName + "//local//tasks");
    }
}
