package me.lele.antientity;

import me.lele.antientity.listener.CreeperExplosionListener;
import me.lele.antientity.listener.DragonBlockChangeListener;
import me.lele.antientity.listener.EndermanBlockChangeListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Anti_Entity extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // 加载默认配置
        saveDefaultConfig();

        // 注册Creeper爆炸事件监听器
        getServer().getPluginManager().registerEvents(new CreeperExplosionListener(this), this);
        // 注册末影人搬运方块事件监听器
        getServer().getPluginManager().registerEvents(new EndermanBlockChangeListener(this), this);
        // 注册末影龙破坏方块事件监听器
        getServer().getPluginManager().registerEvents(new DragonBlockChangeListener(this), this);
        getLogger().info("Anti-Entity 已启用");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic


        getLogger().info("Anti-Entity 已关闭");
    }

    // 获取插件配置
    public FileConfiguration getPluginConfig() {
        return this.getConfig();
    }
}
