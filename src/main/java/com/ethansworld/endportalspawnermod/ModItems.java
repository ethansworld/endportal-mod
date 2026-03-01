package com.ethansworld.endportalspawnermod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndPortalSpawnerMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndPortalSpawnerMod.MODID);
    public static final RegistryObject<Item> END_PORTAL_STAFF = ITEMS.register("end_portal_staff", EndPortalStaffItem::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        eventBus.register(ModItems.class);
    }

    @SubscribeEvent
    public static void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(END_PORTAL_STAFF);
        }
    }
}