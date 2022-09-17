package net.kormons.seasoncoin.Util;

import net.kormons.seasoncoin.SeasonCoin;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.IOException;

public class Util {

    private static SeasonCoin instance;

    public void setUp(Player player) {

        instance = SeasonCoin.getInstance();

        instance.getCustomConfig().set("coin." + player.getUniqueId() + ".닉네임", player.getName());
        instance.getCustomConfig().set("coin." + player.getUniqueId() + ".보유 코인", 0);


        saveCoinConfig();

        player.sendMessage("셋업완료!");

    }

    public int getCoin(OfflinePlayer targetPlayer) {

        instance = SeasonCoin.getInstance();

        reloadCoinConfig();

        int playerCoin = instance.getCustomConfig().getInt("coin." + targetPlayer.getUniqueId() + ".보유 코인");

        return playerCoin;

    }

    public void saveCoinConfig() {

        instance = SeasonCoin.getInstance();

        try {
            instance.getCustomConfig().save(instance.getCoinConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setCoin(OfflinePlayer targetPlayer, int coin) {

        instance = SeasonCoin.getInstance();

        instance.getCustomConfig().set("coin." + targetPlayer.getUniqueId() + ".보유 코인", coin);

        saveCoinConfig();


    }

    public void addCoin(OfflinePlayer targetPlayer, int addCoin) {

        instance = SeasonCoin.getInstance();

        int playerCoin = getCoin(targetPlayer);

        int num = playerCoin + addCoin;

        instance.getCustomConfig().set("coin." + targetPlayer.getUniqueId() + ".보유 코인", num);

        saveCoinConfig();


    }

    public boolean removeCoin(OfflinePlayer targetPlayer, int removeCoin) {

        instance = SeasonCoin.getInstance();

        int playerCoin = getCoin(targetPlayer);

        int num = playerCoin - removeCoin;

        if (num < 0) {
            return false;
        }

        instance.getCustomConfig().set("coin." + targetPlayer.getUniqueId() + ".보유 코인", num);

        saveCoinConfig();

        return true;


    }

    public void reloadCoinConfig(){

        instance = SeasonCoin.getInstance();

        try {
            instance.getCustomConfig().load(instance.coinConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }



}




