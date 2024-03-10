package me.beayoung.cropime.display;

import me.beayoung.cropime.utils.CropInfo;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.chat.ChatType;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.entity.Player;

import static me.beayoung.cropime.utils.CropUtility.getProgressBar;

public class ProgressBarDisplay  {
    private ProgressBarDisplay() {}

    public static void showCropInfo(Player player, CropInfo cropInfo) {
        int growthPercentage = cropInfo.growthPercentage;

        String progressBar = getProgressBar(growthPercentage);
        Component message = Component.text(progressBar);

        player.sendActionBar(message);
    }
}
