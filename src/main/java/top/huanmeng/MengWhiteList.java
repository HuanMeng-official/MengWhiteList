package top.huanmeng;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import top.huanmeng.Commands.WhiteListAdd;
import top.huanmeng.Commands.WhiteListRemove;
import top.huanmeng.Events.JoinEvent;
import top.huanmeng.Tools.Metrics;

import java.util.Objects;

public final class MengWhiteList extends JavaPlugin {
    public static String m = ChatColor.YELLOW + "[幻梦娘]";
    @Override
    public void onLoad() {
        getLogger().info(ChatColor.DARK_RED + "MengWhiteList is loading");
    }

    @Override
    public void onEnable() {
        getLogger().info(ChatColor.DARK_GREEN + "=========================");
        getLogger().info(ChatColor.GOLD + "__  ____       ____");
        getLogger().info(ChatColor.GOLD + "|  \\/  \\ \\     / /| |");
        getLogger().info(ChatColor.GOLD + "| |\\/| |\\ \\ /\\ / /| |");
        getLogger().info(ChatColor.GOLD + "| |  | | \\ V  V / | |___");
        getLogger().info(ChatColor.GOLD + "|_|  |_|  \\_/\\_/   |_____|");
        int pluginId = 18850;
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinEvent(),this);
        Objects.requireNonNull(getCommand("mwl_add")).setExecutor(new WhiteListAdd());
        Objects.requireNonNull(getCommand("mwl_remove")).setExecutor(new WhiteListRemove());
        boolean enable = getConfig().getBoolean("enable",true);
        if (enable){
            getLogger().info(m + ChatColor.RESET + "功能“WhiteList”已开启");
        }else {
            getLogger().info(m + ChatColor.RESET + "功能“WhiteList”已开启");
        }
        getLogger().info(ChatColor.DARK_GREEN + "=========================");
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.DARK_RED + "MengWhiteList is disable");
    }
}
