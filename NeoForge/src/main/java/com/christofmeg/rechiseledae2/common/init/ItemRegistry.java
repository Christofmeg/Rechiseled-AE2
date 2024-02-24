package com.christofmeg.rechiseledae2.common.init;

import com.christofmeg.rechiseledae2.RechiseledAE2;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS;

    private ItemRegistry() {
    }

    public static void init(@Nonnull IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RechiseledAE2.MOD_ID);
    }

}
