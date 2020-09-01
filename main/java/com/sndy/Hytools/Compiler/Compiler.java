package com.sndy.Hytools.Compiler;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Compiler {
    public static void Compile(String FilePath){
        String Contents = "";
        try{
            Files.newBufferedReader(Paths.get(FilePath));
            Contents = "";
        }
        catch (IOException exception){
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.RED + exception));

        }

        Contents.split(";");
    }
}
