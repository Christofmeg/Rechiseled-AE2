package com.christofmeg.rechiseledae2.common.data;

import com.christofmeg.rechiseledae2.RechiseledAE2;
import com.christofmeg.rechiseledae2.client.data.FusionBlockStateProvider;
import com.christofmeg.rechiseledae2.client.data.ModBlockStateProvider;
import com.christofmeg.rechiseledae2.client.data.ModItemModelProvider;
import com.christofmeg.rechiseledae2.client.data.ModLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = RechiseledAE2.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    private DataGenerators() {}
    private static final String[] LOCALE_CODES = new String[] {"en_us",};

    @SuppressWarnings("unused")
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        if (event.includeClient())
        {
            gen.addProvider(true, new ModBlockStateProvider(output, existingFileHelper));
            gen.addProvider(true, new FusionBlockStateProvider(output, existingFileHelper));
            gen.addProvider(true, new ModItemModelProvider(output, existingFileHelper ));
        }
        if (event.includeServer()) {
            ModBlockTagsProvider blockTags = gen.addProvider(true, new ModBlockTagsProvider(output, lookupProvider, existingFileHelper));
            gen.addProvider(true, new RechiseledRecipeProvider(gen));
        }
        for(String locale : LOCALE_CODES) {
            gen.addProvider(true, new ModLanguageProvider(output, locale));
        }
    }

}