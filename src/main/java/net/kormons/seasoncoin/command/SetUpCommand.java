package net.kormons.seasoncoin.command;

import net.kormons.seasoncoin.Util.Util;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class SetUpCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Util util = new Util();


        if (label.equalsIgnoreCase("코인셋업")) {

            Player player = (Player) sender;
            OfflinePlayer offlinePlayer = player;


                util.setUp(player);
                return true;


        }

        return true;

    }
}

