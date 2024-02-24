package com.christofmeg.rechiseledae2.client.data;

import com.christofmeg.rechiseledae2.RechiseledAE2;
import com.christofmeg.rechiseledae2.common.init.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModBlockStateProvider extends BlockStateProvider {
    public static List<Map<RegistryObject<Block>, String>> masterList = new ArrayList<>();

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RechiseledAE2.MOD_ID, exFileHelper);

        Map<RegistryObject<Block>, String> certus_quartz = new HashMap<>();
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_BORDERED, "block/" + "certus_quartz_block_bordered");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_BRICK_PAVING,  "block/" + "certus_quartz_block_brick_paving");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_CHISELED_PILLAR,  "block/" + "certus_quartz_block_chiseled_pillar");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_CHISELED_SQUARES,  "block/" + "certus_quartz_block_chiseled_squares");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_CONNECTING,  "block/" + "certus_quartz_block_connecting");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_CROSSES,  "block/" + "certus_quartz_block_crosses");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_DIAGONAL_TILES,  "block/" + "certus_quartz_block_diagonal_tiles");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_PATTERN,  "block/" + "certus_quartz_block_pattern");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_ROTATED_BRICKS,  "block/" + "certus_quartz_block_rotated_bricks");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_ROWS,  "block/" + "certus_quartz_block_rows");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_SCALES,  "block/" + "certus_quartz_block_scales");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_SMALL_TILES,  "block/" + "certus_quartz_block_small_tiles");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_SQUARES,  "block/" + "certus_quartz_block_squares");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_STRIPES,  "block/" + "certus_quartz_block_stripes");
        certus_quartz.put(BlockRegistry.CERTUS_QUARTZ_BLOCK_TILES, "block/" + "certus_quartz_block_tiles");
        masterList.add(certus_quartz);

        Map<RegistryObject<Block>, String> sky_stone = new HashMap<>();
        sky_stone.put(BlockRegistry.SKY_STONE_BIG_TILES, "block/" + "sky_stone_big_tiles");
        sky_stone.put(BlockRegistry.SKY_STONE_BORDERED, "block/" + "sky_stone_bordered");
        sky_stone.put(BlockRegistry.SKY_STONE_BRICK_PATTERN, "block/" + "sky_stone_brick_pattern");
        sky_stone.put(BlockRegistry.SKY_STONE_BRICK_PAVING, "block/" + "sky_stone_brick_paving");
        sky_stone.put(BlockRegistry.SKY_STONE_CHISELED_BRICKS, "block/" + "sky_stone_chiseled_bricks");
        sky_stone.put(BlockRegistry.SKY_STONE_CRUSHED, "block/" + "sky_stone_crushed");
        sky_stone.put(BlockRegistry.SKY_STONE_DIAGONAL_BRICKS, "block/" + "sky_stone_diagonal_bricks");
        sky_stone.put(BlockRegistry.SKY_STONE_PATH, "block/" + "sky_stone_path");
        sky_stone.put(BlockRegistry.SKY_STONE_ROTATED_BRICKS, "block/" + "sky_stone_rotated_bricks");
        sky_stone.put(BlockRegistry.SKY_STONE_SMALL_BRICKS, "block/" + "sky_stone_small_bricks");
        sky_stone.put(BlockRegistry.SKY_STONE_SMALL_TILES, "block/" + "sky_stone_small_tiles");
        sky_stone.put(BlockRegistry.SKY_STONE_SMOOTH, "block/" + "sky_stone_smooth");
        sky_stone.put(BlockRegistry.SKY_STONE_SMOOTH_BRICK_PAVING, "block/" + "sky_stone_smooth_brick_paving");
        sky_stone.put(BlockRegistry.SKY_STONE_SMOOTH_LARGE_TILES, "block/" + "sky_stone_smooth_large_tiles");
        sky_stone.put(BlockRegistry.SKY_STONE_SMOOTH_ROTATED_BRICKS, "block/" + "sky_stone_smooth_rotated_bricks");
        sky_stone.put(BlockRegistry.SKY_STONE_SMOOTH_TILES, "block/" + "sky_stone_smooth_tiles");
        sky_stone.put(BlockRegistry.SKY_STONE_SQUARES, "block/" + "sky_stone_squares");
        sky_stone.put(BlockRegistry.SKY_STONE_TILES, "block/" + "sky_stone_tiles");
        sky_stone.put(BlockRegistry.SKY_STONE_WAVES, "block/" + "sky_stone_waves");
        masterList.add(sky_stone);

    }

    @Override
    public @NotNull String getName() {
        return RechiseledAE2.MOD_NAME + " - BlockModel & BlockState";
    }

    @Override
    protected void registerStatesAndModels() {

        block(BlockRegistry.SKY_STONE_COBBLED, "block/" + "sky_stone_cobbled");
        cubeColumn(BlockRegistry.SKY_STONE_SLATED, "block/" + "sky_stone_slated");

        for (Map<RegistryObject<Block>, String> map : masterList) {
            for (Map.Entry<RegistryObject<Block>, String> entry : map.entrySet()) {
                RegistryObject<Block> block = entry.getKey();
                block(block, entry.getValue());
            }
        }

    }

    private void block(RegistryObject<Block> block, String path) {
        simpleBlock(block.get(), models().cubeAll(block.getId().getPath(), new ResourceLocation(RechiseledAE2.MOD_ID, path)));
    }

    private void cubeColumn(RegistryObject<Block> block, String path) {
        simpleBlock(block.get(), models().cubeColumn(
                block.getId().getPath(),
                new ResourceLocation(RechiseledAE2.MOD_ID, path + "_side"),
                new ResourceLocation(RechiseledAE2.MOD_ID, path + "_end")
        ));
    }


}