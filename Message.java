package com.sndy.Hytools.MessageManager;

import net.minecraft.client.Minecraft;

public class Message {

    /**
     * Sends a chat message as the player to the chat type specified,
     * used to avoid chat spam filters by distancing messages that would
     * otherwise be blocked by chat filters.
     *
     * Sends messages in order of priority with .5 second intervals
     * between messages. Always use when sending messages to chat.
     *
     * chatType param: 0 = allChat | 1 = pChat | 2 = response(/r) | 3 = none
     * ** use none for special cases like commands **
     *
     * @param message  Message you want to send
     * @param chatType Which channel to send message to
     * @param priority Message priority
     */
    public static void add(String message, int chatType, boolean priority){

    }
}