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
        if (args[0].toLowerCase().equals("profile")) {
            if (args.length == 2 && args[1].toLowerCase().equals("save")) {
                Profile.saveStats(PlayerAction.profile);
                Responses.save(PlayerAction.profile);
            }
            if (args.length == 3 && args[1].toLowerCase().equals("load")) {
                File tmpDir = new File("Hytools/" + args[2].toLowerCase());
                if (tmpDir.exists()){
                    Responses.attemptingToLoadProfile(args[2]);
                    Profile.loadProfile(PlayerAction.profile, args[2]);
                    Responses.profileLoaded(PlayerAction.profile);
                } else{
                    Responses.nonexistantProfile(args[2]);
                }
            }
            if (args.length == 3 && args[1].toLowerCase().equals("create")) {
                Profile.createNewProfile(args[2]);
                Responses.profileCreated(args[2]);
            }
        }
    }
}
