package me.lele.antientity.listener;

import me.lele.antientity.Anti_Entity;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import java.util.List;

public class EndermanBlockChangeListener implements Listener {

    private final Anti_Entity plugin;

    public EndermanBlockChangeListener(Anti_Entity plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {
        FileConfiguration config = plugin.getPluginConfig();
        // 检查是否启用阻止末影人搬运方块
        if (config.getBoolean("preventEndermanMoveBlock")) {
            // 检查是否是末影人
            if (event.getEntityType() == EntityType.ENDERMAN) {
                // 获取末影人生效世界列表
                List<String> endermanWorlds = config.getStringList("endermanWorlds");
                // 检查是否在指定的世界中
                if (endermanWorlds.contains(event.getBlock().getWorld().getName())) {
                    // 阻止末影人搬运方块
                    event.setCancelled(true);
                }
            }
        }
    }

}
