package me.hypersmc.jumpwatch.main;

import me.hypersmc.jumpwatch.main.Selector.CustomConfig;
import me.hypersmc.jumpwatch.main.Selector.Selector;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    private Selector selector;
    private static Plugin plugin;
    public CustomConfig selectorconfig = new CustomConfig((Plugin)this, "config.yml");
    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
}
