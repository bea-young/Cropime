package me.beayoung.cropime.display;

import me.beayoung.cropime.utils.CropInfo;
import me.beayoung.cropime.utils.CropUtility;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.entity.Player;

public class TextDisplay {
    private TextDisplay() {}

    public static void showCropInfo(Player player, CropInfo cropInfo) {
        Component message = Component.text(CropUtility.applyTextFormat(cropInfo.cropType.name(), cropInfo.growthPercentage + "%"));
        player.sendActionBar(message);
    }
}
