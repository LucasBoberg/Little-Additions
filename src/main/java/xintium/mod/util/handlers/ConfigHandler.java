package xintium.mod.util.handlers;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xintium.mod.Main;
import xintium.mod.util.Reference;

import java.io.File;

public class ConfigHandler {
    public static Configuration config;

    public static int GUI_ALLOY_MERGER = 0;
    public static int GUI_CRUSHER = 1;
    public static int GUI_BRONZE_FURNACE = 2;

    public static int MAGNET_RANGE = 6;
    public static float WALKING_SPEED_MODIFIER = 0.15f;

    public static boolean generateCopper, generateTin, generateSilver, bronzeTools, bronzeArmor;

    public static void init(File file) {
        config = new Configuration(file);

        String category;

        category = "IDs";
        config.addCustomCategoryComment(category, "Set ID's for each entity and gui");
        GUI_ALLOY_MERGER = config.getInt("Alloy Merger GUI ID", category, 0, 0, 999, "ID for the Alloy Merger GUI");
        GUI_CRUSHER = config.getInt("Crusher GUI ID", category, 1, 0, 999, "ID for the Crusher GUI");
        GUI_BRONZE_FURNACE = config.getInt("Bronze Furnace GUI ID", category, 2, 0, 999, "ID for the Bronze Furnace GUI");

        category = "Baubles";
        config.addCustomCategoryComment(category, "Tweak the Baubles abilities");
        MAGNET_RANGE = config.getInt("Magnet Charm Range", category, 6, 1, 32, "Change the range of the Magnet Charm");
        WALKING_SPEED_MODIFIER = config.getFloat("Power Walking Belt speed modifier", category, 0.15f, 0.11f, 5.0f, "Change the speed you get when using the Power Walking Belt");

        category = "World";
        config.addCustomCategoryComment(category, "Declare whether ores should generate");
        generateCopper = config.getBoolean("Generate Copper", category, true, "Should copper ore generate");
        generateTin = config.getBoolean("Generate Tin", category, true, "Should tin ore generate");
        generateSilver = config.getBoolean("Generate Silver", category, true, "Should silver ore generate");

        category = "Tools and Armor";
        config.addCustomCategoryComment(category, "Declare whether tools and armor should be available");
        bronzeTools = config.getBoolean("Remove Bronze Tools", category, false, "Should Bronze Tools not be available");
        bronzeArmor = config.getBoolean("Remove Bronze Armor", category, false, "Should Bronze Armor not be available");

        config.save();
    }

    public static void registerConfig(FMLPreInitializationEvent event) {
        Main.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MODID);
        Main.config.mkdirs();
        init(new File(Main.config.getPath(), Reference.MODID + ".cfg"));
    }
}
