package me.beayoung.cropime;

import me.beayoung.cropime.listeners.CropListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

@SuppressWarnings("unused")
public final class Cropime extends JavaPlugin {
    private final HashMap<String, Object> configValues = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        loadConfig();
        registerListeners();
        registerCommands();

        getLogger().info("Cropime has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Cropime has been disabled!");
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        configValues.put("general.toggle-mode", getConfig().getBoolean("general.toggle-mode"));
        configValues.put("general.interaction-mode", getConfig().getString("general.interaction-mode"));
        configValues.put("general.update-interval", getConfig().getInt("general.update-interval"));
        configValues.put("display.display-type", getConfig().getString("display.display-type"));
        configValues.put("display.text-format", getConfig().getString("display.text-format"));
        configValues.put("progress-bar.length", getConfig().getInt("progress-bar.length"));
        configValues.put("progress-bar.filled-char", getConfig().getString("progress-bar.filled-char"));
        configValues.put("progress-bar.empty-char", getConfig().getString("progress-bar.empty-char"));
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new CropListener(), this);
    }

    private void registerCommands() {
        // TODO: Register commands
    }

    public static Cropime getInstance() {
        return getPlugin(Cropime.class);
    }

    public Object getConfigValue(String key) {
        return configValues.get(key);
    }
}
