package com.christofmeg.rechiseledae2.common.data;

import appeng.core.definitions.AEBlocks;
import com.christofmeg.rechiseledae2.RechiseledAE2;
import com.christofmeg.rechiseledae2.common.block.BaseBlock;
import com.christofmeg.rechiseledae2.common.init.BlockRegistry;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RechiseledRecipeProvider implements DataProvider {

    private final String MOD_ID;
    private final DataGenerator generator;

    public RechiseledRecipeProvider(DataGenerator generator){
        this.MOD_ID = RechiseledAE2.MOD_ID;
        this.generator = generator;
    }

    @Override
    public @NotNull String getName(){
        return "Rechiseled Recipes: " + this.MOD_ID;
    }

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput cache) {

        List<Item> certus_quartz = new ArrayList<>();
        certus_quartz.add(AEBlocks.QUARTZ_BLOCK.asItem());
        certus_quartz.add(AEBlocks.QUARTZ_BRICKS.asItem());
        certus_quartz.add(AEBlocks.QUARTZ_PILLAR.asItem());
        certus_quartz.add(AEBlocks.CHISELED_QUARTZ_BLOCK.asItem());
        certus_quartz.add(AEBlocks.CUT_QUARTZ_BLOCK.asItem());
        certus_quartz.add(AEBlocks.SMOOTH_QUARTZ_BLOCK.asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_BORDERED.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_BRICK_PAVING.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_CHISELED_PILLAR.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_CHISELED_SQUARES.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_CONNECTING.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_CROSSES.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_DIAGONAL_TILES.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_PATTERN.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_ROTATED_BRICKS.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_ROWS.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_SCALES.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_SMALL_TILES.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_SQUARES.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_STRIPES.get().asItem());
        certus_quartz.add(BlockRegistry.CERTUS_QUARTZ_BLOCK_TILES.get().asItem());
        CompletableFuture<?> certusQuartzTask = chiselingRecipe(certus_quartz, cache, "certus_quartz");

        List<Item> sky_stone = new ArrayList<>();
        sky_stone.add(AEBlocks.SKY_STONE_BRICK.asItem());
        sky_stone.add(AEBlocks.SKY_STONE_SMALL_BRICK.asItem());
        sky_stone.add(AEBlocks.SMOOTH_SKY_STONE_BLOCK.asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_BIG_TILES.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_BORDERED.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_BRICK_PATTERN.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_BRICK_PAVING.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_CHISELED_BRICKS.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_COBBLED.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_CRUSHED.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_DIAGONAL_BRICKS.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_PATH.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_ROTATED_BRICKS.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_SLATED.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_SMALL_BRICKS.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_SMALL_TILES.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_SMOOTH.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_SMOOTH_BRICK_PAVING.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_SMOOTH_LARGE_TILES.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_SMOOTH_ROTATED_BRICKS.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_SMOOTH_TILES.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_SQUARES.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_TILES.get().asItem());
        sky_stone.add(BlockRegistry.SKY_STONE_WAVES.get().asItem());
        CompletableFuture<?> skyStoneTask = chiselingRecipe(sky_stone, cache, "sky_stone");

        return CompletableFuture.allOf(certusQuartzTask, skyStoneTask);
    }

    private @NotNull CompletableFuture<?> chiselingRecipe(List<Item> itemList, CachedOutput cache, String jsonName) {

        List<CompletableFuture<?>> masterTask = new ArrayList<>();

        Path path = this.generator.getPackOutput().getOutputFolder();
        List<CompletableFuture<?>> tasks = new ArrayList<>();

        JsonObject json = new JsonObject();
        json.addProperty("type", "rechiseled:chiseling");
        json.addProperty("overwrite", false);

        JsonArray entries = new JsonArray();
        for (Item item : itemList) {
            if (item != null) {
                JsonObject object = new JsonObject();
                String string = item.getDescriptionId().replace("item.", "").replace("block.", "").replace(".", ":");
                object.addProperty("item", string);
                Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string));
                if (block instanceof BaseBlock baseBlock) {
                    Item blockItem = baseBlock.asItem();
                    if (
                            !blockItem.toString().equals("certus_quartz_block_chiseled_squares") &&
                            !blockItem.toString().equals("sky_stone_cobbled") &&
                            !blockItem.toString().equals("sky_stone_slated")
                    ) {
                        object.addProperty("connecting_item", string + "_connecting");
                    }
                }
                entries.add(object);
            }
        }
        json.add("entries", entries);

        Path recipePath = path.resolve("data/" + MOD_ID + "/chiseling_recipes/" + jsonName + ".json");
        tasks.add(DataProvider.saveStable(cache, json, recipePath));

        masterTask.add(CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new)));

        return CompletableFuture.allOf(masterTask.toArray(CompletableFuture[]::new));
    }

}