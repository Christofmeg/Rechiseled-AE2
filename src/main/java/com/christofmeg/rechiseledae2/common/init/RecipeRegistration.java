package com.christofmeg.rechiseledae2.common.init;

import appeng.core.definitions.AEBlocks;
import com.christofmeg.rechiseledae2.RechiseledAE2;
import com.supermartijn642.core.registry.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

public class RecipeRegistration {

    public static final ResourceLocation CERTUS_QUARTZ = location("quartz_block");
    public static final ResourceLocation SKY_STONE = location("sky_stone");

    private static ResourceLocation location(String name){
        return ResourceLocation.fromNamespaceAndPath(RechiseledAE2.MOD_ID, name);
    }

    private static Supplier<ItemLike> getBlock(String identifier){
        ResourceLocation location = ResourceLocation.parse(identifier);
        return () -> Registries.BLOCKS.getValue(location);
    }

    public static void init() {
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, () -> AEBlocks.QUARTZ_BLOCK, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, () -> AEBlocks.QUARTZ_BRICKS, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, () -> AEBlocks.QUARTZ_PILLAR, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, () -> AEBlocks.CHISELED_QUARTZ_BLOCK, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, () -> AEBlocks.CUT_QUARTZ_BLOCK, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, () -> AEBlocks.SMOOTH_QUARTZ_BLOCK, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_BORDERED::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "bordered" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_BRICK_PAVING::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "brick_paving" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_CHISELED_PILLAR::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "chiseled_pillar" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_CHISELED_SQUARES::get, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_CONNECTING::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "connecting" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_CROSSES::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "crosses" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_DIAGONAL_TILES::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "diagonal_tiles" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_PATTERN::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "pattern" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_ROTATED_BRICKS::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "rotated_bricks" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_ROWS::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "rows" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_SCALES::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "scales" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_SMALL_TILES::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "small_tiles" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_SQUARES::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "squares" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_STRIPES::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "stripes" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(CERTUS_QUARTZ, BlockRegistry.CERTUS_QUARTZ_BLOCK_TILES::get, getBlock("rechiseledae2:certus_quartz_block" + "_" + "tiles" + "_connecting"));

        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, () -> AEBlocks.SKY_STONE_BLOCK, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, () -> AEBlocks.SKY_STONE_BRICK, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, () -> AEBlocks.SKY_STONE_SMALL_BRICK, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, () -> AEBlocks.SMOOTH_SKY_STONE_BLOCK, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_BIG_TILES::get, getBlock("rechiseledae2:sky_stone" + "_" + "big_tiles" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_BORDERED::get, getBlock("rechiseledae2:sky_stone" + "_" + "bordered" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_BRICK_PATTERN::get, getBlock("rechiseledae2:sky_stone" + "_" + "brick_pattern" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_BRICK_PAVING::get, getBlock("rechiseledae2:sky_stone" + "_" + "brick_paving" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_CHISELED_BRICKS::get, getBlock("rechiseledae2:sky_stone" + "_" + "chiseled_bricks" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_COBBLED::get, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_CRUSHED::get, getBlock("rechiseledae2:sky_stone" + "_" + "crushed" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_DIAGONAL_BRICKS::get, getBlock("rechiseledae2:sky_stone" + "_" + "diagonal_bricks" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_PATH::get, getBlock("rechiseledae2:sky_stone" + "_" + "path" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_ROTATED_BRICKS::get, getBlock("rechiseledae2:sky_stone" + "_" + "rotated_bricks" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_SLATED::get, null);
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_SMALL_BRICKS::get, getBlock("rechiseledae2:sky_stone" + "_" + "small_bricks" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_SMALL_TILES::get, getBlock("rechiseledae2:sky_stone" + "_" + "small_tiles" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_SMOOTH::get, getBlock("rechiseledae2:sky_stone" + "_" + "smooth" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_SMOOTH_BRICK_PAVING::get, getBlock("rechiseledae2:sky_stone" + "_" + "smooth_brick_paving" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_SMOOTH_LARGE_TILES::get, getBlock("rechiseledae2:sky_stone" + "_" + "smooth_large_tiles" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_SMOOTH_ROTATED_BRICKS::get, getBlock("rechiseledae2:sky_stone" + "_" + "smooth_rotated_bricks" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_SMOOTH_TILES::get, getBlock("rechiseledae2:sky_stone" + "_" + "smooth_tiles" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_SQUARES::get, getBlock("rechiseledae2:sky_stone" + "_" + "squares" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_TILES::get, getBlock("rechiseledae2:sky_stone" + "_" + "tiles" + "_connecting"));
        RechiseledAE2.REGISTRATION.chiselingEntry(SKY_STONE, BlockRegistry.SKY_STONE_WAVES::get, getBlock("rechiseledae2:sky_stone" + "_" + "waves" + "_connecting"));
    }
}
