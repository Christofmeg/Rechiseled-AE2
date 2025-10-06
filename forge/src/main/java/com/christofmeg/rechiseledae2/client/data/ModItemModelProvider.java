package com.christofmeg.rechiseledae2.client.data;

import com.christofmeg.rechiseledae2.RechiseledAE2;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RechiseledAE2.MOD_ID, existingFileHelper);
    }

    @Override
    public @NotNull String getName() {
        return RechiseledAE2.MOD_NAME + " - ItemModel";
    }

    @Override
    protected void registerModels() {

        withExistingParent("certus_quartz_block_chiseled_squares", modLoc("block/" + "certus_quartz_block_chiseled_squares"));
        withExistingParent("sky_stone_cobbled", modLoc("block/" + "sky_stone_cobbled"));
        withExistingParent("sky_stone_slated", modLoc("block/" + "sky_stone_slated"));

        for(Map<RegistryObject<Block>, String> map : ModBlockStateProvider.masterList) {
            for (Map.Entry<RegistryObject<Block>, String> entry : map.entrySet()) {
                withExistingParent(entry.getValue().replace("block/", ""), modLoc(entry.getValue()));
            }
        }

    }

}