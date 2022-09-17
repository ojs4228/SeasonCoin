package net.kormons.seasoncoin.command;

import net.kormons.seasoncoin.Util.Util;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetCoin implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Util util = new Util();
        Player player = (Player) sender;

        if (label.equalsIgnoreCase("코인설정")) {

            if (player.isOp()) {

                if (args.length == 0 || args.length == 1) {

                    player.sendMessage("/코인설정 (플레이어) (코인)");

                }
                if (args.length == 2){

                    try {
                        int num = Integer.parseInt(args[1]);
                    }catch (NumberFormatException e){
                        player.sendMessage("올바른 숫자를 입력해주세요.");

                        return true;
                    }

                    OfflinePlayer targetPlayer = Bukkit.getOfflinePlayer(args[0]);
                    int coin = Integer.parseInt(args[1]);

                    if(!targetPlayer.hasPlayedBefore()){
                        player.sendMessage("해당 플레이어는 접속 한적이 없습니다.");
                        return true;
                    }

                    if(coin < 0){
                        player.sendMessage("코인을 설정 할 수 없습니다");
                        return true;
                    }


                    util.setCoin(targetPlayer,coin);
                    player.sendMessage(targetPlayer.getName() +" 님의 코인을" + coin +"으로 설정 했습니다.");

                    return true;
                }


            }



        }
        return false;
    }
}