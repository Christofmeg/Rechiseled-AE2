package com.christofmeg.rechiseledae2.common.data;

import com.christofmeg.rechiseledae2.RechiseledAE2;
import com.christofmeg.rechiseledae2.client.data.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = RechiseledAE2.MOD_ID)
public class DataGenerators {
    private DataGenerators() {}

    @SuppressWarnings("unused")
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

//        gen.addProvider(event.includeClient(), new ModLanguageProvider(output));
        gen.addProvider(event.includeClient(), new BlockTextureProvider(gen, existingFileHelper));
        gen.addProvider(event.includeClient(), new ModBlockStateProvider(output, existingFileHelper));
        gen.addProvider(event.includeClient(), new FusionBlockStateProvider(output, existingFileHelper));
        gen.addProvider(event.includeClient(), new ModItemModelProvider(output, existingFileHelper ));

        ModBlockTagsProvider blockTags = gen.addProvider(event.includeServer(), new ModBlockTagsProvider(output, lookupProvider, existingFileHelper));
  //      gen.addProvider(event.includeServer(), new RechiseledRecipeProvider(gen));
    }

}