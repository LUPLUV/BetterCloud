package dev.lupluv.bettercloud;

import dev.lupluv.bettercloud.configuration.Configuration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static boolean firstRun = false;

    public static void main(String[] strings){

        Configuration.getConfiguration();

        if(firstRun){ setup();}else{
            System.out.println("Already Setup :D");
        }

    }

    public static void setup(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the BetterCloud Installation Guide :D");
        System.out.println("Ip Address:");
        String ip = scanner.next();
        System.out.println("You have set the IP address to " + ip);
        JSONObject cloudConfig = new JSONObject();
        cloudConfig.put("IPAddress", ip);
        System.out.println("Port:");
        String port = scanner.next();
        System.out.println("You have set the Port to " + port);
        cloudConfig.put("Port", port);
        System.out.println("Memory (in Megabytes):");
        long memory = scanner.nextLong();
        System.out.println("You have set the Memory to " + memory + " Megabytes");
        cloudConfig.put("Memory", memory);
        JSONArray ar = new JSONArray();
        ar.add(cloudConfig);
        try (FileWriter file = new FileWriter("config.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(ar.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
