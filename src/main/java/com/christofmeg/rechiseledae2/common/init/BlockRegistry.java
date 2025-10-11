package com.christofmeg.rechiseledae2.common.init;

import appeng.block.AEBaseBlock;
import com.christofmeg.rechiseledae2.RechiseledAE2;
import com.christofmeg.rechiseledae2.common.block.BaseBlock;
import com.christofmeg.rechiseledae2.common.item.ConnectingBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class BlockRegistry {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(RechiseledAE2.MOD_ID);

    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_BORDERED;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_BRICK_PAVING;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_CHISELED_PILLAR;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_CHISELED_SQUARES;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_CONNECTING;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_CROSSES;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_DIAGONAL_TILES;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_PATTERN;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_ROTATED_BRICKS;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_ROWS;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_SCALES;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_SMALL_TILES;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_SQUARES;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_STRIPES;
    public static final DeferredHolder<Block, Block> CERTUS_QUARTZ_BLOCK_TILES;

    public static final DeferredHolder<Block, Block> SKY_STONE_BIG_TILES;
    public static final DeferredHolder<Block, Block> SKY_STONE_BORDERED;
    public static final DeferredHolder<Block, Block> SKY_STONE_BRICK_PATTERN;
    public static final DeferredHolder<Block, Block> SKY_STONE_BRICK_PAVING;
    public static final DeferredHolder<Block, Block> SKY_STONE_CHISELED_BRICKS;
    public static final DeferredHolder<Block, Block> SKY_STONE_COBBLED;
    public static final DeferredHolder<Block, Block> SKY_STONE_CRUSHED;
    public static final DeferredHolder<Block, Block> SKY_STONE_DIAGONAL_BRICKS;
    public static final DeferredHolder<Block, Block> SKY_STONE_PATH;
    public static final DeferredHolder<Block, Block> SKY_STONE_ROTATED_BRICKS;
    public static final DeferredHolder<Block, Block> SKY_STONE_SLATED;
    public static final DeferredHolder<Block, Block> SKY_STONE_SMALL_BRICKS;
    public static final DeferredHolder<Block, Block> SKY_STONE_SMALL_TILES;
    public static final DeferredHolder<Block, Block> SKY_STONE_SMOOTH;
    public static final DeferredHolder<Block, Block> SKY_STONE_SMOOTH_BRICK_PAVING;
    public static final DeferredHolder<Block, Block> SKY_STONE_SMOOTH_LARGE_TILES;
    public static final DeferredHolder<Block, Block> SKY_STONE_SMOOTH_ROTATED_BRICKS;
    public static final DeferredHolder<Block, Block> SKY_STONE_SMOOTH_TILES;
    public static final DeferredHolder<Block, Block> SKY_STONE_SQUARES;
    public static final DeferredHolder<Block, Block> SKY_STONE_TILES;
    public static final DeferredHolder<Block, Block> SKY_STONE_WAVES;
    private static final BlockBehaviour.Properties CERTUS_QUARTZ = AEBaseBlock.stoneProps().mapColor(MapColor.COLOR_CYAN).strength(3.0F, 5.0F).requiresCorrectToolForDrops();
    private static final BlockBehaviour.Properties SKY_STONE = AEBaseBlock.stoneProps().mapColor(MapColor.COLOR_BLACK).strength(5.0F, 150.0F).requiresCorrectToolForDrops();

    public static void init(@Nonnull IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }

    static {
        CERTUS_QUARTZ_BLOCK_BORDERED = connecting("certus_quartz_block" + "_" + "bordered", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_BRICK_PAVING = connecting("certus_quartz_block" + "_" + "brick_paving", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_CHISELED_PILLAR = connecting("certus_quartz_block" + "_" + "chiseled_pillar", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_CHISELED_SQUARES = block("certus_quartz_block" + "_" + "chiseled_squares", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_CONNECTING = connecting("certus_quartz_block" + "_" + "connecting", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_CROSSES = connecting("certus_quartz_block" + "_" + "crosses", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_DIAGONAL_TILES = connecting("certus_quartz_block" + "_" + "diagonal_tiles", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_PATTERN = connecting("certus_quartz_block" + "_" + "pattern", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_ROTATED_BRICKS = connecting("certus_quartz_block" + "_" + "rotated_bricks", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_ROWS = connecting("certus_quartz_block" + "_" + "rows", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_SCALES = connecting("certus_quartz_block" + "_" + "scales", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_SMALL_TILES = connecting("certus_quartz_block" + "_" + "small_tiles", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_SQUARES = connecting("certus_quartz_block" + "_" + "squares", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_STRIPES = connecting("certus_quartz_block" + "_" + "stripes", CERTUS_QUARTZ);
        CERTUS_QUARTZ_BLOCK_TILES = connecting("certus_quartz_block" + "_" + "tiles", CERTUS_QUARTZ);

        SKY_STONE_BIG_TILES = connecting("sky_stone" + "_" + "big_tiles", SKY_STONE);
        SKY_STONE_BORDERED = connecting("sky_stone" + "_" + "bordered", SKY_STONE);
        SKY_STONE_BRICK_PATTERN = connecting("sky_stone" + "_" + "brick_pattern", SKY_STONE);
        SKY_STONE_BRICK_PAVING = connecting("sky_stone" + "_" + "brick_paving", SKY_STONE);
        SKY_STONE_CHISELED_BRICKS = connecting("sky_stone" + "_" + "chiseled_bricks", SKY_STONE);
        SKY_STONE_COBBLED = block("sky_stone" + "_" + "cobbled", SKY_STONE);
        SKY_STONE_CRUSHED = connecting("sky_stone" + "_" + "crushed", SKY_STONE);
        SKY_STONE_DIAGONAL_BRICKS = connecting("sky_stone" + "_" + "diagonal_bricks", SKY_STONE);
        SKY_STONE_PATH = connecting("sky_stone" + "_" + "path", SKY_STONE);
        SKY_STONE_ROTATED_BRICKS = connecting("sky_stone" + "_" + "rotated_bricks", SKY_STONE);
        SKY_STONE_SLATED = block("sky_stone" + "_" + "slated", SKY_STONE);
        SKY_STONE_SMALL_BRICKS = connecting("sky_stone" + "_" + "small_bricks", SKY_STONE);
        SKY_STONE_SMALL_TILES = connecting("sky_stone" + "_" + "small_tiles", SKY_STONE);
        SKY_STONE_SMOOTH = connecting("sky_stone" + "_" + "smooth", SKY_STONE);
        SKY_STONE_SMOOTH_BRICK_PAVING = connecting("sky_stone" + "_" + "smooth_brick_paving", SKY_STONE);
        SKY_STONE_SMOOTH_LARGE_TILES = connecting("sky_stone" + "_" + "smooth_large_tiles", SKY_STONE);
        SKY_STONE_SMOOTH_ROTATED_BRICKS = connecting("sky_stone" + "_" + "smooth_rotated_bricks", SKY_STONE);
        SKY_STONE_SMOOTH_TILES = connecting("sky_stone" + "_" + "smooth_tiles", SKY_STONE);
        SKY_STONE_SQUARES = connecting("sky_stone" + "_" + "squares", SKY_STONE);
        SKY_STONE_TILES = connecting("sky_stone" + "_" + "tiles", SKY_STONE);
        SKY_STONE_WAVES = connecting("sky_stone" + "_" + "waves", SKY_STONE);
    }

    private static DeferredHolder<Block, Block> connecting(String name, BlockBehaviour.Properties blockProperties) {
        DeferredHolder<Block, Block> block = BlockRegistry.BLOCKS.register(name, () -> new BaseBlock(blockProperties));
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

        DeferredHolder<Block, Block> block_connecting = BlockRegistry.BLOCKS.register(name + "_connecting", () -> new BaseBlock(blockProperties));
        ItemRegistry.ITEMS.register(name + "_connecting", () -> new ConnectingBlockItem(block_connecting.get(), new Item.Properties()));
        return block;
    }

    private static DeferredHolder<Block, Block> block(String name, BlockBehaviour.Properties blockProperties) {
        DeferredHolder<Block, Block> block = BlockRegistry.BLOCKS.register(name, () -> new BaseBlock(blockProperties));
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

}
