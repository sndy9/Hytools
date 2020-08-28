package com.sndy.Hytools.CommandManager;

import com.sndy.Hytools.DataManager.Profile;
import com.sndy.Hytools.StatManager.PlayerAction;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

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
            }
        }
    }
}
