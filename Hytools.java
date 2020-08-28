package com.sndy.Hytools;
// Created by sndy on 7/11/2020.
import com.sndy.Hytools.CommandManager.HytoolsCommands;
import com.sndy.Hytools.GUIManager.GUIMain;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Hytools.MODID, version = Hytools.VERSION)
public class Hytools { //main controller class, searches for messages
    //Mod info
    public static final String MODID = "hytools";
    static final String VERSION = Global.VERSION;
    //Other
    public static boolean modEnabled = false;

    @EventHandler
    public void init(FMLPostInitializationEvent event) { //register events here
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new GUIMain());
        ClientCommandHandler.instance.registerCommand(new HytoolsCommands());
    }

    @SubscribeEvent
    public static void onChat(ClientChatReceivedEvent event){

    }
}