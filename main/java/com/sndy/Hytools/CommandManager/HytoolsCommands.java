package com.sndy.Hytools.CommandManager;

import com.sndy.Hytools.DataManager.Profile;
import com.sndy.Hytools.StatManager.PlayerAction;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.io.File;
import java.util.HashMap;

public class HytoolsCommands extends CommandBase {
    HashMap<String, int[]> playerData = new HashMap<String, int[]>();
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    @Override
    public String getCommandName() {return "hytools";}
    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }
    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        String profile = PlayerAction.profile;
        if (args.length == 0 || args[0].toLowerCase().equals("help")){
            Responses.help();
        }
        else if (args[0].toLowerCase().equals("profile")) {
            if (args.length == 2 && args[1].toLowerCase().equals("save")) {
                Profile.saveStats(profile);
                Responses.save(profile);
            }
            if (args.length == 3 && args[1].toLowerCase().equals("load")) {
                File tmpDir = new File("Hytools/" + args[2].toLowerCase());
                if (tmpDir.exists()){
                    Responses.attemptingToLoadProfile(args[2]);
                    Profile.loadProfile(profile, args[2]);
                    Responses.profileLoaded(PlayerAction.profile);
                } else{
                    Responses.nonexistantProfile(args[2]);
                }
            }
            if (args.length == 3 && args[1].toLowerCase().equals("create")) {
                if (!args[2].contains("/") || !args[2].contains(".")) {
                    Profile.createNewProfile(args[2]);
                    Responses.profileCreated(args[2]);
                }else{
                    Responses.invalidProfileSlashDot(args[2]);
                }
            }
            if (args[1].toLowerCase().equals("players")) {
                if (args.length == 4 && args[2].toLowerCase().equals("add")) {
                    if (!PlayerAction.stats.containsKey(args[3])) {
                        PlayerAction.createNewPlayerProfile(args[3]);
                        Responses.addedPlayerToProfile(args[3], profile);
                        Profile.saveStats(profile);
                        Responses.save(profile);
                    }else{
                        Responses.playerAlreadyInProfile(args[3], profile);
                    }
                }
                if (args.length == 13 && args[2].toLowerCase().equals("add")) {
                    System.out.println("met requirements");
                    if (!PlayerAction.stats.containsKey(args[3])) {
                        PlayerAction.createNewPlayerProfile(args[3], Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]), Integer.parseInt(args[9]), Integer.parseInt(args[10]), Integer.parseInt(args[11]), Integer.parseInt(args[12]));
                        Responses.addedPlayerToProfile(args[3], profile);
                        Profile.saveStats(profile);
                        Responses.save(profile);
                    }else{
                        Responses.playerAlreadyInProfile(args[3], profile);
                    }
                }
            }
        }
    }
}