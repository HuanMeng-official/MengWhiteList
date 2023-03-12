package huanmeng.mengwhitelist;

import huanmeng.mengwhitelist.Commands.*;
import huanmeng.mengwhitelist.Events.JoinEvent;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MengWhiteList extends JavaPlugin {
    public static String m = ChatColor.YELLOW + "[幻梦娘]";

    @Override
    public void onLoad() {
        // Plugin loading logic
        System.out.println(ChatColor.GOLD + "MengWhiteList is loading");
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        System.out.println(ChatColor.GOLD + "MengWhiteList is enable");
        getServer().getPluginManager().registerEvents(new JoinEvent(),this);
        Objects.requireNonNull(getCommand("mwl_add")).setExecutor(new WhiteListAdd());
        Objects.requireNonNull(getCommand("mwl_remove")).setExecutor(new WhiteListRemove());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.GOLD + "MengWhiteList is disable");
    }
}
