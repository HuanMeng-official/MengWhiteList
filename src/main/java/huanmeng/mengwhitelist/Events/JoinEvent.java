package huanmeng.mengwhitelist.Events;

import huanmeng.mengwhitelist.MengWhiteList;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.Objects;

public class JoinEvent implements Listener {
    Plugin config = MengWhiteList.getPlugin(MengWhiteList.class);
    @EventHandler
    public void PlayerOnLogin(PlayerLoginEvent login){
        // 自动重载配置文件
        config.reloadConfig();
        // 检测白名单开启状态
        if(config.getConfig().getBoolean("enable")){
            String loginPlayer = login.getPlayer().getName();
            List<String> wedPlayer = config.getConfig().getStringList("players");
            if(!wedPlayer.contains(loginPlayer)){
                // 拦截玩家登录
                login.setResult(PlayerLoginEvent.Result.KICK_WHITELIST);
                login.disallow(login.getResult(), ChatColor.translateAlternateColorCodes
                        ('&', Objects.requireNonNull(
                                config.getConfig().getString("no-tips"))
                        )
                );
            } else {
                login.allow();
            }
        } else {
            System.out.println(ChatColor.RED + "您未启用白名单，为了您的服务器安全，请开启白名单");
        }
    }
}