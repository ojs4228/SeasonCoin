package net.kormons.seasoncoin;

import net.kormons.seasoncoin.Util.Util;
import net.kormons.seasoncoin.command.*;
import net.kormons.seasoncoin.event.SetUp;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class SeasonCoin extends JavaPlugin {

    private static SeasonCoin instance;
    public File coinConfigFile;
    private FileConfiguration coinConfig;
    public static Util utilInstance;

    @Override
    public void onEnable() {


        this.getCommand("코인셋업").setExecutor(new SetUpCommand());
        this.getCommand("코인확인").setExecutor(new CheckCoin());
        this.getCommand("코인설정").setExecutor(new SetCoin());
        this.getCommand("코인추가").setExecutor(new AddCoin());
        this.getCommand("코인삭제").setExecutor(new RemoveCoin());


        this.getServer().getPluginManager().registerEvents(new SetUp(), this);

        instance = this;

        createCustomConfig();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SeasonCoin getInstance() {
        return instance;
    }

    public File getCoinConfigFile(){return this.coinConfigFile;}

    public FileConfiguration getCustomConfig() {
        return this.coinConfig;
    }



    private void createCustomConfig() {
        coinConfigFile = new File(getDataFolder(), "coin.yml");
        if (!coinConfigFile.exists()) {
            coinConfigFile.getParentFile().mkdirs();
            saveResource("coin.yml", false);
        }

        coinConfig = new YamlConfiguration();
        try {
            coinConfig.load(coinConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
