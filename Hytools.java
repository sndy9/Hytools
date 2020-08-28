package com.sndy.Hytools;
// Created by sndy on 7/11/2020.
import com.sndy.Hytools.CommandManager.HytoolsCommands;
import com.sndy.Hytools.DataManager.Profile;
import com.sndy.Hytools.GUIManager.GUIMain;
import com.sndy.Hytools.StatManager.PlayerAction;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import java.io.File;

@Mod(modid = Hytools.MODID, version = Hytools.VERSION)
public class Hytools { //main controller class, searches for messages
    //Mod info
    public static final String MODID = "hytools";
    static final String VERSION = Global.VERSION;
    //Other
    public static boolean modEnabled = false;

    @EventHandler
    public void init(FMLInitializationEvent event) { //register events here
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new GUIMain());
        ClientCommandHandler.instance.registerCommand(new HytoolsCommands());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        PlayerAction.profile = "default";
        File tmpDir = new File("Hytools");
        if (!tmpDir.exists()){
            //create base directories (only activates on first use)
            File directory1 = new File("Hytools");
            if (directory1.mkdir()){
                System.out.println("[HYTOOLS]: Hytools directory successfully created!");
                File directory2 = new File("Hytools/default");
                if (directory2.mkdir()){
                    System.out.println("[HYTOOLS]: default profile directory successfully created!");
                    Profile.saveStats(PlayerAction.profile);
                }
            }
        }
    }
}