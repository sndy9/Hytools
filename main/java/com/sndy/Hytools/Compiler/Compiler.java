package com.sndy.Hytools.Compiler;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Compiler {
    public static void Compile(String FilePath){
        BufferedReader reader = null;
        try{
            File file = new File(FilePath);
            reader = new BufferedReader(new FileReader(file));

            String str = reader.toString();

            String lines[] = str.split(";");

            for (int x = 0; lines.length >= x; x++){
                String args[] = lines[x].split(" ");
                for (int y = 0; args.length >= y; y++){
                    if (args[y].equals("ExVar;")){
                        //EXAMPLE CODE TO RUN
                        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.GREEN + "example message"));
                    }
                }
            }
        }
        catch (IOException exception){
            exception.printStackTrace();
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.RED + exception));
        }
        finally {
            try{
                if (reader != null) {
                    reader.close();
                }
            }
            catch (IOException exception){
                exception.printStackTrace();
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.RED + exception));
            }
        }
    }
}
