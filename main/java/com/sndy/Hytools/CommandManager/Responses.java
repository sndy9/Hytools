package com.sndy.Hytools.CommandManager;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

class Responses {

    static void help(){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: Help: " + EnumChatFormatting.GREEN + "help message"));
    }
    static void save(String profile){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.GREEN + "Saved profile!"));
    }

    static void nonexistantProfile(String arg){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.RED + "Profile \""+ arg + "\" does not exist."));
    }

    static void attemptingToLoadProfile(String profile){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.YELLOW + "Attempting to load profile: " + EnumChatFormatting.GOLD + profile + EnumChatFormatting.YELLOW + "..."));
    }

    static void profileLoaded(String profile){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.GREEN + "Profile \"" + EnumChatFormatting.GOLD + profile + EnumChatFormatting.GREEN + "\" loaded successfully."));
    }

    static void profileCreated(String arg){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.GREEN + "Profile \"" + EnumChatFormatting.GOLD + arg + EnumChatFormatting.GREEN + "\" created successfully."));
    }

    static void invalidProfileSlashDot(String arg){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.RED + "Profile name \""+ arg + "\" contains '/' or '.' and " + EnumChatFormatting.RED + "is" + EnumChatFormatting.RED + " invalid."));
    }

    static void addedPlayerToProfile(String arg, String profile){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.GREEN + "Added player \"" + EnumChatFormatting.GOLD + arg + EnumChatFormatting.GREEN + "\" to profile \"" + EnumChatFormatting.GOLD + profile + EnumChatFormatting.GREEN + "\"!"));
    }

    static void playerAlreadyInProfile(String arg, String profile){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.RED + "Profile \""+ profile + "\" already contains player \"" + arg + "\"."));
    }
    
    static void NameAFile(){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.RED + "Name a file to compile."));
    }

    static void NotAFile(){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.RED + "That is not a file."));
    }
}