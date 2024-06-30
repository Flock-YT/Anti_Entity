package me.lele.antientity.listener;

import me.lele.antientity.Anti_Entity;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.List;

public class CreeperExplosionListener implements Listener {

    private final Anti_Entity plugin;

    public CreeperExplosionListener(Anti_Entity plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        FileConfiguration config = plugin.getPluginConfig();
        // 检查是否启用阻止Creeper爆炸破坏方块
        if (config.getBoolean("preventCreeperDamage")) {
            // 检查是否是Creeper的爆炸
            if (event.getEntityType() == EntityType.CREEPER) {
                // 获取Creeper生效世界列表
                List<String> creeperWorlds = config.getStringList("creeperWorlds");
                // 检查是否在指定的世界中
                if (creeperWorlds.contains(event.getLocation().getWorld().getName())) {
                    // 阻止爆炸破坏方块
                    event.blockList().clear();
                }
            }
        }
    }

}
