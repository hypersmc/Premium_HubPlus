package me.hypersmc.jumpwatch.main.Selector;

import me.hypersmc.jumpwatch.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;


public class Selector implements Listener {
    Main main = JavaPlugin.getPlugin(Main.class);
    ItemStack item = null;
    CustomConfig selector = null;

    public Selector(Main plugin){
        this.main = plugin;
        this.selector = this.main.selectorconfig;
    }
    public void setupSelector() {
        String[] item2 = this.selector.getConfig().getString("selector.item").split(":");
        this.item = new ItemStack(Material.valueOf(item2[0].toLowerCase()), 1);
        ItemMeta im = this.item.getItemMeta();
        im.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.selector.getConfig().getString("selector.displayname")));
        ArrayList<String> lore = new ArrayList<>();
        for (String i : this.selector.getConfig().getStringList("selector.lore"))
            lore.add(ChatColor.translateAlternateColorCodes('&', i));
        im.setLore(lore);
        this.item.setItemMeta(im);
    }
    public void servertp(Player player, String msg, String server){
        player.sendMessage(msg);
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);
            out.writeUTF("Connect");
            out.writeUTF(server);
            player.sendPluginMessage((Plugin)this.main, "BungeeCord", b.toByteArray());
            b.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void giveselector(Player player){
        player.getInventory().setItem(this.selector.getConfig().getInt("giveSlot"), this.item);
    }
    public void menuopen(Player player){
        Inventory inventory = Bukkit.createInventory(null, Integer.parseInt(this.selector.getConfig().getString("MenuSize")), ChatColor.translateAlternateColorCodes('&', this.selector.getConfig().getString("MenuName")));
        for (String l : this.selector.getConfig().getStringList("items")){
            String[] type = this.selector.getConfig().getString(String.valueOf(l) + ".type").split(":");

        }
    }
}
