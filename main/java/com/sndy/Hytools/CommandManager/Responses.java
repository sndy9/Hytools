package com.sndy.Hytools.CommandManager;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

class Responses {
    static void save(String profile){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.GREEN + "Saved profile!"));
    }

    static void nonexistantProfile(String arg){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.RED + "Profile \""+ arg + "\" does not exist."));
    }

    static void attemptingToLoadProfile(String profile){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.YELLOW + "Attempting to load profile: " + EnumChatFormatting.GOLD + profile + EnumChatFormatting.YELLOW + "!"));
    }

    static void profileLoaded(String profile){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.GREEN + "Profile \"" + EnumChatFormatting.GOLD + profile + EnumChatFormatting.GREEN + "\" loaded successfully."));
    }

    static void profileCreated(String arg){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.GREEN + "Profile \"" + EnumChatFormatting.GOLD + arg + EnumChatFormatting.GREEN + "\" created successfully."));
    }
}
