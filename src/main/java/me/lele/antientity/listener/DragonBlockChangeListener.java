package me.lele.antientity.listener;

import me.lele.antientity.Anti_Entity;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.entity.EntityType;

import java.util.List;

public class DragonBlockChangeListener implements Listener {

    private final Anti_Entity plugin;

    public DragonBlockChangeListener(Anti_Entity plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        FileConfiguration config = plugin.getPluginConfig();
        // 检查是否启用阻止末影龙破坏方块
        if (config.getBoolean("preventDragonDamage")) {
            // 检查是否是末影龙的爆炸
            if (event.getEntityType() == EntityType.ENDER_DRAGON) {
                    // 阻止爆炸破坏方块
                    event.blockList().clear();
            }
        }
    }

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {
        FileConfiguration config = plugin.getPluginConfig();
        // 检查是否启用阻止末影龙破坏方块
        if (config.getBoolean("preventDragonDamage")) {
            // 检查是否是末影龙
            if (event.getEntityType() == EntityType.ENDER_DRAGON) {
                    // 阻止末影龙破坏方块
                    event.setCancelled(true);
            }
        }
    }
}
