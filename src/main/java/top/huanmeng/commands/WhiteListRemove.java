package top.huanmeng.commands;

import top.huanmeng.MengWhiteList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import static top.huanmeng.MengWhiteList.m;

import java.util.List;
import java.util.Objects;

public class WhiteListRemove implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!sender.isOp()){
            sender.sendMessage(m + ChatColor.RED + "该命令只能由管理员执行");
            return false;
        }
        if(args.length != 1){
            sender.sendMessage(m + ChatColor.RED + "Used: /mwl_remove <player>");
            return false;
        }
        Plugin config = MengWhiteList.getPlugin(MengWhiteList.class);
        List<String> whitelist = config.getConfig().getStringList("players");
        if(whitelist.contains(args[0])){
            Player remove = Bukkit.getPlayer(args[0]);
            whitelist.remove(args[0]);
            config.getConfig().set("players", whitelist);
            config.saveConfig();
            sender.sendMessage(m + ChatColor.RESET + "已取消玩家白名单");
            if(remove == null){
                return false;
            }
            if(remove.isOnline()){
                sender.sendMessage(m + ChatColor.RESET + "已取消玩家白名单");
                remove.kickPlayer(ChatColor.translateAlternateColorCodes('&',
                                Objects.requireNonNull(config.getConfig().getString("tips"))
                        )
                );
            }
        } else {
            sender.sendMessage(m + ChatColor.RED + "该玩家不在白名单中，请检查玩家名是否输入正确");
        }
        return false;
    }
}