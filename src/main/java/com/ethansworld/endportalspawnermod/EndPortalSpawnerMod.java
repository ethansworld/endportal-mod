// Main class for the mod
package com.ethansworld.endportalspawnermod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(EndPortalSpawnerMod.MODID)
public class EndPortalSpawnerMod {
    public static final String MODID = "endportalspawnermod";
    public static final Logger LOGGER = LogUtils.getLogger();
    public EndPortalSpawnerMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
    }
}
