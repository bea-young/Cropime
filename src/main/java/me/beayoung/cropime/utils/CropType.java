package me.beayoung.cropime.utils;

import org.bukkit.Material;

public enum CropType {
    WHEAT {
        @Override
        public Material getMaterial() {
            return Material.WHEAT;
        }
    }, CARROTS {
        @Override
        public Material getMaterial() {
            return Material.CARROTS;
        }
    }, POTATOES {
        @Override
        public Material getMaterial() {
            return Material.POTATOES;
        }
    }, BEETROOTS {
        @Override
        public Material getMaterial() {
            return Material.BEETROOTS;
        }
    }, NETHER_WART {
        @Override
        public Material getMaterial() {
            return Material.NETHER_WART;
        }
    }, COCOA {
        @Override
        public Material getMaterial() {
            return Material.COCOA;
        }
    }, SWEET_BERRIES {
        @Override
        public Material getMaterial() {
            return Material.SWEET_BERRY_BUSH;
        }
    }, BAMBOO {
        @Override
        public Material getMaterial() {
            return Material.BAMBOO;
        }
    }, PUMPKIN_STEM {
        @Override
        public Material getMaterial() {
            return Material.PUMPKIN_STEM;
        }
    }, MELON_STEM {
        @Override
        public Material getMaterial() {
            return Material.MELON_STEM;
        }
    }; // Add any other current crops

    // Method to find a CropType by Material
    public static CropType fromMaterial(Material material) {
        for (CropType cropType : values()) {
            if (cropType.getMaterial() == material) {
                return cropType;
            }
        }
        return null;
    }

    // Abstract method to get the Material
    public abstract Material getMaterial();
}
