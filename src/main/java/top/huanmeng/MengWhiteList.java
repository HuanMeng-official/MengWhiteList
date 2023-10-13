package top.huanmeng;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import top.huanmeng.commands.*;
import top.huanmeng.events.JoinEvent;

import java.util.Objects;
import java.util.logging.Logger;

public final class MengWhiteList extends JavaPlugin {
    public static String m = ChatColor.YELLOW + "[幻梦娘]";
    public static Logger logger = Bukkit.getLogger();
    @Override
    public void onLoad() {
        logger.info(ChatColor.DARK_RED + "MengWhiteList is loading");
    }

    @Override
    public void onEnable() {
        logger.info(ChatColor.DARK_GREEN + "=========================");
        logger.info(ChatColor.GOLD + "__  ____       ____");
        logger.info(ChatColor.GOLD + "|  \\/  \\ \\     / /| |");
        logger.info(ChatColor.GOLD + "| |\\/| |\\ \\ /\\ / /| |");
        logger.info(ChatColor.GOLD + "| |  | | \\ V  V / | |___");
        logger.info(ChatColor.GOLD + "|_|  |_|  \\_/\\_/   |_____|");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinEvent(),this);
        Objects.requireNonNull(getCommand("mwl_add")).setExecutor(new WhiteListAdd());
        Objects.requireNonNull(getCommand("mwl_remove")).setExecutor(new WhiteListRemove());
        boolean enable = getConfig().getBoolean("enable",true);
        if (enable){
            logger.info(m + ChatColor.RESET + "功能“WhiteList”已开启");
        }else {
            logger.info(m + ChatColor.RESET + "功能“WhiteList”已关闭");
        }
        logger.info(ChatColor.DARK_GREEN + "=========================");
    }

    @Override
    public void onDisable() {
        logger.info(ChatColor.DARK_RED + "MengWhiteList is disable");
    }
}
