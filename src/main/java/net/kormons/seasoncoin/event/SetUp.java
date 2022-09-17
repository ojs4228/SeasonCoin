package net.kormons.seasoncoin.event;

import net.kormons.seasoncoin.Util.Util;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class SetUp implements Listener {



    @EventHandler
    public void joinEvent(PlayerJoinEvent event){

        Util util = new Util();

        OfflinePlayer player = event.getPlayer();

        if (!player.hasPlayedBefore()) {

            util.setUp((Player) player);

        }

    }
}
