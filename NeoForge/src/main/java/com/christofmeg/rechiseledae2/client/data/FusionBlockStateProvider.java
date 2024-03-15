package com.christofmeg.rechiseledae2.client.data;

import com.christofmeg.rechiseledae2.RechiseledAE2;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class FusionBlockStateProvider extends BlockStateProvider {

    private final PackOutput output;

    public FusionBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RechiseledAE2.MOD_ID, exFileHelper);
        this.output = output;
    }

    @Override
    protected void registerStatesAndModels() {
    }

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput cache) {

        List<CompletableFuture<?>> tasks = new ArrayList<>();

        for(Map<RegistryObject<Block>, String> map : ModBlockStateProvider.masterList) {
            CompletableFuture<?> task = block(map, cache);
            tasks.add(task);
        }

        return CompletableFuture.allOf(CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new)));
    }

    private @NotNull CompletableFuture<?> block(Map<RegistryObject<Block>, String> map, CachedOutput cache) {

        List<CompletableFuture<?>> tasks = new ArrayList<>();

        for (Map.Entry<RegistryObject<Block>, String> entry : map.entrySet()) {
            RegistryObject<Block> block = entry.getKey();

            ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block.get());
            if (location != null) {

                Path jsonPath = this.output.getOutputFolder();

                CompletableFuture<Void> blockStateConnecting = getBlockStateConnecting(location, block, jsonPath, cache);
                CompletableFuture<Void> blockModelConnecting = getBlockModelConnecting(location, block, jsonPath, cache);
                CompletableFuture<Void> blockConnectingMcmeta = getBlockConnectingMcmeta(block, jsonPath, cache);
                CompletableFuture<Void> itemModelConnecting = getItemModelConnecting(location, block, jsonPath, cache);

                tasks.addAll(List.of(blockStateConnecting, blockModelConnecting, Objects.requireNonNull(blockConnectingMcmeta), itemModelConnecting));
            }
        }

        return CompletableFuture.allOf(CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new)));
    }

    @NotNull
    private static CompletableFuture<Void> getBlockStateConnecting(ResourceLocation location, RegistryObject<Block> block, Path jsonPath, CachedOutput cache) {
        JsonObject json = new JsonObject();
        JsonObject variants = new JsonObject();
        JsonObject empty = new JsonObject();
        empty.addProperty("model", "rechiseledae2:block/" + location.getPath() + "_connecting");
        variants.add("", empty);
        json.add("variants", variants);

        Path recipePath = jsonPath.resolve("assets/" + RechiseledAE2.MOD_ID + "/blockstates/" + block.getId().getPath() + "_connecting" + ".json");
        return DataProvider.saveStable(cache, json, recipePath).thenAccept(result -> {});
    }

    @NotNull
    private static CompletableFuture<Void> getBlockModelConnecting(ResourceLocation location, RegistryObject<Block> block, Path jsonPath, CachedOutput cache) {
        JsonObject blockModelConnecting = new JsonObject();
        blockModelConnecting.addProperty("type", "fusion:connecting");
        blockModelConnecting.addProperty("parent", "minecraft:block/cube_all");

        JsonArray connections = new JsonArray();
        JsonObject connectionsType = new JsonObject();
        connectionsType.addProperty("type", "fusion:is_same_block");
        connections.add(connectionsType);
        blockModelConnecting.add("connections", connections);

        blockModelConnecting.addProperty("loader", "fusion:model");

        JsonObject textures = new JsonObject();
        textures.addProperty("all", "rechiseledae2:block/" + location.getPath());
        blockModelConnecting.add("textures", textures);

        Path recipePath = jsonPath.resolve("assets/" + RechiseledAE2.MOD_ID + "/models/block/" + block.getId().getPath() + "_connecting" + ".json");
        return DataProvider.saveStable(cache, blockModelConnecting, recipePath).thenAccept(result -> {});
    }

    @NotNull
    private static CompletableFuture<Void> getBlockConnectingMcmeta(RegistryObject<Block> block, Path jsonPath, CachedOutput cache) {
        JsonObject mcmetaFile = new JsonObject();

        JsonObject connectionsType = new JsonObject();
        connectionsType.addProperty("type", "connecting");
        mcmetaFile.add("fusion", connectionsType);

        Path recipePath = jsonPath.resolve("assets/" + RechiseledAE2.MOD_ID + "/textures/block/" + block.getId().getPath() + ".png.mcmeta");
        return DataProvider.saveStable(cache, mcmetaFile, recipePath).thenAccept(result -> {});
    }

    @NotNull
    private static CompletableFuture<Void> getItemModelConnecting(ResourceLocation location, RegistryObject<Block> block, Path jsonPath, CachedOutput cache) {
        JsonObject json = new JsonObject();
        json.addProperty("parent", "rechiseledae2:block/" + location.getPath() + "_connecting");

        Path recipePath = jsonPath.resolve("assets/" + RechiseledAE2.MOD_ID + "/models/item/" + block.getId().getPath() + "_connecting" + ".json");
        return DataProvider.saveStable(cache, json, recipePath).thenAccept(result -> {});
    }

}