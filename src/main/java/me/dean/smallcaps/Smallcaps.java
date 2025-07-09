package me.dean.smallcaps;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import me.dean.smallcaps.commands.smallCapsCommand;
import me.dean.smallcaps.placeholder.smallcapsplaceholder;
import me.dean.smallcaps.util.smallCharacterUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Smallcaps extends JavaPlugin {

    @Override
    public void onLoad(){
        CommandAPI.onLoad(new CommandAPIBukkitConfig(this)
                .verboseOutput(true)
                .setNamespace("smallcaps"));
    }

    @Override
    public void onEnable() {
        CommandAPI.onEnable();
        smallCharacterUtil characterUtil = new smallCharacterUtil();
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new smallcapsplaceholder(characterUtil).register();
        }
        new smallCapsCommand(characterUtil).register();
    }

    @Override
    public void onDisable() {
        CommandAPI.onDisable();
    }
}
