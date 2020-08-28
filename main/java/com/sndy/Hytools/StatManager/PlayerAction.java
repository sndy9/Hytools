package com.sndy.Hytools.StatManager;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

import java.util.HashMap;

public class PlayerAction {

    public static String profile;
    public static HashMap<String, Player> stats = new HashMap<String, Player>();

    /**
     * Returns blockPos based off of the specified player's in game
     * location.
     *
     * @param username PlayerAction username
     * @return Returns the blockPos the player is at
     */
    public static BlockPos getLocation(String username) {
        EntityPlayer target = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(username);
        return target.getPosition();
    }

    /**
     * Use to get the player's item statistics. Can only be used to get
     * a player's current held item, their helmet, leggings, chestplate,
     * and boots.
     * <p>
     * SLOT PARAM:
     * 1 = heldItem | 2 = boots | 3 = leggings | 4 = chestplate
     * 5 = helmet
     *
     * @param username PlayerAction username
     * @param slot   Slot ID
     * @return Returns a string with the name of the item, changes
     * if the item is renamed to the renamed item's name
     */
    public static String getItems(String username, int slot) {
        EntityPlayer target = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(username);
        if (slot == 1) {
            return target.getHeldItem().getDisplayName();
        } else {
            return target.getCurrentArmor(slot - 2).getDisplayName();
        }
    }

    /**
     * Use to get the player's K/D ratio. Calculated here and not stored
     * in normal stats because that would be redundant and a waste of
     * space.
     *
     * @param username PlayerAction username
     * @return Returns float K/D
     */
    public static float getKD(String username) {
        return stats.get(username).getKills() / stats.get(username).getDeaths();
    }

    /**
     * Creates a new player in the database.
     *
     * @param username Player being added to the database's username
     */
    public static void createNewPlayerProfile(String username){
        Player newPlayer = new Player(0, 0, 0, 0, 0, 0, 0, 0, 0);
        stats.put(username, newPlayer);
    }

    /**
     * Allows to add a player and manually input values for their
     * stats.
     *
     * @param username Player username
     * @param a        Kills
     * @param b        Deaths
     * @param c        Cookies
     * @param d        Chat messages
     * @param e        Parkour wins
     * @param f        Egg Hunt wins
     * @param g        Playtime
     * @param h        Fastest parkour
     * @param i        Fastest Egg Hunt
     */
    public static void createNewPlayerProfile(String username, int a, int b, int c, int d, int e, int f, int g, int h, int i){
        Player newPlayer = new Player(a, b, c, d, e, f, g, h, i);
        stats.put(username, newPlayer);
    }
}
