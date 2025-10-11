package com.christofmeg.rechiseledae2.common.init;

import com.christofmeg.rechiseledae2.RechiseledAE2;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nonnull;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS;

    private ItemRegistry() {
    }

    public static void init(@Nonnull IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    static {
        ITEMS = DeferredRegister.createItems(RechiseledAE2.MOD_ID);
    }

}
