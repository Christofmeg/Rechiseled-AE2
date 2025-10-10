package com.christofmeg.rechiseledae2.common.data;

import com.christofmeg.rechiseledae2.RechiseledAE2;
import com.christofmeg.rechiseledae2.common.init.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RechiseledAE2.MOD_ID, existingFileHelper);
    }

    @Override
    public @NotNull String getName() {
        return RechiseledAE2.MOD_NAME + " - Block Tags";
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider p_256380_) {
        BlockRegistry.BLOCKS.getEntries().stream().map(DeferredHolder::get).forEach(block -> {
            this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);

            if (block.getDescriptionId().contains("sky_stone")) {
                this.tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            }
        });

    }
}