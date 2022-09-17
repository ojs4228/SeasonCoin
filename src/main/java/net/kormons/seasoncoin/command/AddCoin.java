package net.kormons.seasoncoin.command;

import net.kormons.seasoncoin.Util.Util;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AddCoin implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Util util = new Util();
        Player player = (Player) sender;

        if(label.equalsIgnoreCase("코인추가")){

            if(player.isOp()){

                if(args.length == 0 || args.length == 1){
                    player.sendMessage("/코인추가 (플레이어) (코인)");
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



                    util.addCoin(targetPlayer, coin);

                    player.sendMessage(targetPlayer.getName() +" 님의 코인에" + coin +"코인을 더했습니다");
                    player.sendMessage(targetPlayer.getName() + "님의 총 코인은" + util.getCoin(targetPlayer) + "코인 입니다");

                    return true;
                }





            }
        }

        return false;
    }
}
