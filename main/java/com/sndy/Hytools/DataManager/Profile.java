package com.sndy.Hytools.DataManager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.sndy.Hytools.StatManager.Player;
import com.sndy.Hytools.StatManager.PlayerAction;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Profile {

    private static FileWriter file;

    public static void saveStats(String profile) {
        Gson gson = new Gson();
        String json = gson.toJson(PlayerAction.stats);
        try {
            file = new FileWriter("Hytools\\" + profile + "\\stats.json");
            file.write(json);
        } catch (Exception e) {
            System.out.println("[HYTOOLS]: Error when writing to file: Hytools/" + profile + "/stats.json!");
        } finally {
            try {
                file.flush();
                file.close();
            } catch (Exception e) {
                System.out.println("[HYTOOLS]: Error when writing to file: Hytools/" + profile + "/stats.json!");
            }
        }
    }

    private static void loadStats(String profile) {
        try {
            HashMap<String, Player> armor = new HashMap<String, Player>();
            Type type = new TypeToken<HashMap<String, Player>>() {
            }.getType();
            Gson gson = new Gson();
            JsonElement read = new JsonParser().parse(new FileReader("Hytools/" + profile + "/stats.json"));
            PlayerAction.stats = new Gson().fromJson(read, type);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[HYTOOLS]: Error when loading from file: Hytools/" + profile + "/stats.json!");
        }
    }

    public static void loadProfile(String oldProfile, String newProfile) {
        saveStats(oldProfile);
        PlayerAction.stats.clear();
        loadStats(newProfile);
        PlayerAction.profile = newProfile;
    }

    public static void createNewProfile(String profileName) {
        File directory2 = new File("Hytools/" + profileName);
        if (directory2.mkdir()) {
            System.out.println("[HYTOOLS]: new profile directory successfully created!");
            PlayerAction.profile = profileName;
            Profile.saveStats(PlayerAction.profile);
        }
    }
}
