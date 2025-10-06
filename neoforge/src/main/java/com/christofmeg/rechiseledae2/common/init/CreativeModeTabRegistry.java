package com.christofmeg.rechiseledae2.common.init;

import com.christofmeg.rechiseledae2.RechiseledAE2;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeModeTabRegistry {

    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RechiseledAE2.MOD_ID);

    @SuppressWarnings("unused")
    public static final RegistryObject<CreativeModeTab> TAB = REGISTRY.register(RechiseledAE2.MOD_ID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + RechiseledAE2.MOD_ID)).icon(
                    () -> new ItemStack(BlockRegistry.CERTUS_QUARTZ_BLOCK_STRIPES.get().asItem()))
            .displayItems((parameters, tabData) -> ItemRegistry.ITEMS.getEntries().stream().map(RegistryObject::get)
                    .forEach(tabData::accept))
            .build());

}
