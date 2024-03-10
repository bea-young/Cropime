package me.beayoung.cropime.utils;

public class CropInfo {
    public final CropType cropType;
    public final int growthStage;
    public final int maxGrowthStage;
    public final int growthPercentage;

    public CropInfo(CropType cropType, int growthStage, int maxGrowthStage) {
        this.cropType = cropType;
        this.growthStage = growthStage;
        this.maxGrowthStage = maxGrowthStage;
        this.growthPercentage = (int) ((double) growthStage / maxGrowthStage * 100);
    }
}
