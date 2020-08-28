package com.sndy.Hytools.CommandManager;

import com.sndy.Hytools.Global;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

class Responses {
    //help responses
    static void save(String profile){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[HYTOOLS]: " + EnumChatFormatting.GREEN + "Saved profile!"));
    }
}
