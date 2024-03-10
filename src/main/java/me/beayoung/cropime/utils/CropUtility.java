package me.beayoung.cropime.utils;

import me.beayoung.cropime.Cropime;
import me.beayoung.cropime.display.ProgressBarDisplay;
import me.beayoung.cropime.display.TextDisplay;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;

public class CropUtility {
    private CropUtility() {}

    public static boolean isBlockCrop(Block block) {
        return block.getBlockData() instanceof Ageable;
    }

    public static CropInfo getCropInfo(Block block) {
        Ageable ageable = (Ageable) block.getBlockData();
        CropType cropType = CropType.fromMaterial(block.getType());
        return new CropInfo(cropType, ageable.getAge(), ageable.getMaximumAge());
    }

    public static String getProgressBar(int percentage) {
        Cropime plugin = Cropime.getInstance();
        Integer progressBarLength = (Integer) plugin.getConfigValue("progress-bar.length");
        Character filledChar = (Character) plugin.getConfigValue("progress-bar.filled-char");
        Character emptyChar = (Character) plugin.getConfigValue("progress-bar.empty-char");

        StringBuilder progressBar = new StringBuilder();
        for(int i = 0; i < progressBarLength; i++) {
            if(i < percentage / 100.0 * progressBarLength) {
                progressBar.append(filledChar);
            } else {
                progressBar.append(emptyChar);
            }
        }

        return progressBar.toString();
    }

    public static String applyTextFormat(String cropType, String percentage) {
        Cropime plugin = Cropime.getInstance();
        String textFormat = (String) plugin.getConfigValue("display.text-format");
        return textFormat.replace("{crop_type}", cropType).replace("{percentage}", percentage);
    }

    public static void sendActionBar(Player player, CropInfo info) {
        Cropime plugin = Cropime.getInstance();

        String displayType = (String) plugin.getConfigValue("display.display-type");

        if(displayType.equalsIgnoreCase("text")) {
            TextDisplay.showCropInfo(player, info);
        } else if(displayType.equalsIgnoreCase("progress-bar")) {
            ProgressBarDisplay.showCropInfo(player, info);
        }
    }
}
