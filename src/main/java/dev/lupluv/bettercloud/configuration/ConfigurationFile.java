package dev.lupluv.bettercloud.configuration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigurationFile {

    File file;

    public ConfigurationFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void addJSONArray(JSONArray ar){
        try (FileWriter file = new FileWriter(this.file.getPath())) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(ar.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJSONObject(String arrayName, String objectName){
        return new JSONObject();
    }

}
