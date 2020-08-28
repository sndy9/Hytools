package com.sndy.Hytools.StatManager;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

import java.util.HashMap;

public class Player {

    static String profile;

    static HashMap<String, int[]> stats = new HashMap<String, int[]>();
    static HashMap<String, HashMap<String, int[]>> profiles = new HashMap<String, HashMap<String, int[]>>();

    /**
     * Returns statistics about the specified player that return an
     * integer value.
     *
     * STAT PARAM:
     * 0 = kills | 1 = deaths | 2 = cookies | 3 = chatMessages
     * 4 = parkourWins | 5 = eggHuntWins | 6 = playtime | 7 = fastestParkour
     * 8 = fastestEggHunt
     *
     * @param player Player username
     * @param stat   Statistic ID
     * @return       Returns an player-specific statistic corresponding
     *               to the stat ID
     */
    public static Object getStats(String player, int stat){
        return profiles.get(profile).get(player)[stat];
    }

    /**
     * Returns blockPos based off of the specified player's in game
     * location.
     *
     * @param player Player username
     * @return       Returns the blockPos the player is at
     */
    public static BlockPos getLocation(String player){
        EntityPlayer target = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(player);
        return target.getPosition();
    }

    /**
     * Use to get the player's item statistics. Can only be used to get
     * a player's current held item, their helmet, leggings, chestplate,
     * and boots.
     *
     * SLOT PARAM:
     * 1 = heldItem | 2 = boots | 3 = leggings | 4 = chestplate
     * 5 = helmet
     *
     * @param player Player username
     * @param slot   Slot ID
     * @return       Returns a string with the name of the item, changes
     *               if the item is renamed to the renamed item's name
     */
    public static String getItems(String player, int slot){
        EntityPlayer target = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(player);
        if (slot == 1){
            return target.getHeldItem().getDisplayName();
        }
        else{
            return target.getCurrentArmor(slot - 2).getDisplayName();
        }
    }

    /**
     * Use to get the player's K/D ratio. Calculated here and not stored
     * in normal stats because that would be redundant and a waste of
     * space.
     * 
     * @param player Player username
     * @return       Returns float K/D
     */
    public static float getKD(String player){
        return profiles.get(player).get(player)[0] / profiles.get(player).get(player)[1];
    }

    /**
     * Use to alter stats in the player stats hashmap.
     *
     * STAT PARAM:
     * 0 = kills | 1 = deaths | 2 = cookies | 3 = chatMessages
     * 4 = parkourWins | 5 = eggHuntWins | 6 = playtime | 7 = fastestParkour
     * 8 = fastestEggHunt
     *
     * @param player    Player username
     * @param stat      Stat ID
     * @param value     Value to add or overwrite
     * @param overwrite True if overwrite
     */
    public static void alterStat(String player, int stat, int value, boolean overwrite){
        if (overwrite){
            int returnValue[] = profiles.get(profile).get(player);
            returnValue[stat] = value;
            stats.put(player, returnValue);
            profiles.put(profile, stats);
        }else {
            int returnValue[] = profiles.get(profile).get(player);
            returnValue[stat] = returnValue[stat] + value;
            stats.put(player, returnValue);
            profiles.put(profile, stats);
        }
    }
}
