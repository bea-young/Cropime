package me.beayoung.cropime.listeners;

import me.beayoung.cropime.Cropime;
import me.beayoung.cropime.utils.CropInfo;
import me.beayoung.cropime.utils.CropUtility;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class CropListener implements Listener {
    private final Cropime plugin;

    public CropListener() {
        this.plugin = Cropime.getInstance();
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(!plugin.getConfigValue("general.interaction-mode").equals("shift-right-click")) return;

        if(!event.getAction().isRightClick()) return;
        if(event.getClickedBlock() == null) return;

        Player player = event.getPlayer();

        if(!player.isSneaking()) return;

        Block block = event.getClickedBlock();

        if(!CropUtility.isBlockCrop(block)) return;

        CropInfo cropInfo = CropUtility.getCropInfo(block);

        CropUtility.sendActionBar(player, cropInfo);
    }
}
