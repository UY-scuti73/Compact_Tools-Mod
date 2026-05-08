package xyz.quazaros.compacttools;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import xyz.quazaros.compacttools.item.ModItems;

@Mod(CompactTools.MOD_ID)
public class CompactTools {

    public static final String MOD_ID = "compacttools73";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CompactTools(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {
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