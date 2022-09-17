package net.kormons.seasoncoin.command;

import net.kormons.seasoncoin.Util.Util;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CheckCoin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Util util = new Util();
        Player player = (Player) sender;
        int coin;

        if (label.equalsIgnoreCase("코인확인")) {

            if (args.length == 1) {

                if (player.isOp()) {

                    OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[0]);

                    if (offlinePlayer.hasPlayedBefore()) {

                        coin = util.getCoin(offlinePlayer);

                        player.sendMessage(offlinePlayer.getName() + "님의 코인은 " + coin + " 입니다");

                        return true;


                    }else {
                        player.sendMessage("플레이어를 찾을 수 없습니다.");

                        return true;
                    }

                } else {return false;}


                }else {

                coin = util.getCoin(player);
                player.sendMessage("플레이어 님의 코인은 " + coin + "입니다");


            }



        }
        return true;
    }
}
