package com.christofmeg.rechiseledae2.common.init;

import com.christofmeg.rechiseledae2.RechiseledAE2;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeModeTabRegistry {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RechiseledAE2.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = CREATIVE_MODE_TABS.register(RechiseledAE2.MOD_ID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + RechiseledAE2.MOD_ID))
            .icon(() -> BlockRegistry.CERTUS_QUARTZ_BLOCK_STRIPES.get().asItem().getDefaultInstance())
            .displayItems((parameters, output) -> ItemRegistry.ITEMS.getEntries().forEach(item -> output.accept(item.get())))
            .build());

}
