package huanmeng.mengwhitelist.Commands;

import huanmeng.mengwhitelist.MengWhiteList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import static huanmeng.mengwhitelist.MengWhiteList.m;

import java.util.List;

public class WhiteListAdd implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!sender.isOp()){
            sender.sendMessage(m + ChatColor.RED + "该命令只能由管理员执行");
            return false;
        }
        if (args.length != 1) {
            sender.sendMessage(m + ChatColor.RED + "Used: /mwl_add <player>");
            return false;
        }
        Plugin config = MengWhiteList.getPlugin(MengWhiteList.class);

        List<String> whitelist = config.getConfig().getStringList("players");
        if(whitelist.contains(args[0])){
            sender.sendMessage(m + ChatColor.RED + "该玩家已拥有白名单，切勿重复添加");
            return false;
        }
        whitelist.add(args[0]);
        config.getConfig().set("players", whitelist);
        config.saveConfig();
        sender.sendMessage(m + ChatColor.WHITE + "已将该玩家添加入白名单");
        return false;
    }
}