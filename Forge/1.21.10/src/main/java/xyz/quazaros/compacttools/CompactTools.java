package xyz.quazaros.compacttools;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import xyz.quazaros.compacttools.item.ModItems;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CompactTools.MOD_ID)
public class CompactTools {

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "compacttools73";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public CompactTools(FMLJavaModLoadingContext context) {
        var modBusGroup = context.getModBusGroup();

        ModItems.register(modBusGroup);

        // Register the item to a creative tab
        BuildCreativeModeTabContentsEvent.getBus(modBusGroup).addListener(this::addCreative);
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.WOODEN_TOOL);
            event.accept(ModItems.STONE_TOOL);
            event.accept(ModItems.COPPER_TOOL);
            event.accept(ModItems.IRON_TOOL);
            event.accept(ModItems.GOLDEN_TOOL);
            event.accept(ModItems.DIAMOND_TOOL);
            event.accept(ModItems.NETHERITE_TOOL);
        }
    }
}
