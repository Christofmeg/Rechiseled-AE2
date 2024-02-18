package com.christofmeg.rechiseledae2.client.data;

import com.christofmeg.rechiseledae2.RechiseledAE2;
import com.christofmeg.rechiseledae2.common.init.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, RechiseledAE2.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        String locale = this.getName().replace("Languages: ", "");
        if (locale.equals("en_us")) {
            add("itemGroup." + RechiseledAE2.MOD_ID, RechiseledAE2.MOD_NAME);

            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_BORDERED, "Bordered Certus Quartz Block");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_BRICK_PAVING, "Certus Quartz Brick Paving");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_CHISELED_PILLAR, "Chiseled Certus Quartz Pillar");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_CHISELED_SQUARES, "Chiseled Certus Quartz Block Squares");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_CONNECTING, "Certus Quartz Block");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_CROSSES, "Certus Quartz Block Crosses");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_DIAGONAL_TILES, "Diagonal Certus Quartz Block Tiles");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_PATTERN, "Certus Quartz Block Pattern");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_ROTATED_BRICKS, "Rotated Certus Quartz Bricks");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_ROWS, "Certus Quartz Block Rows");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_SCALES, "Certus Quartz Block Scales");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_SMALL_TILES, "Small Certus Quartz Block Tiles");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_SQUARES, "Certus Quartz Block Squares");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_STRIPES, "Certus Quartz Block Stripes");
            blockWithConnecting(BlockRegistry.CERTUS_QUARTZ_BLOCK_TILES, "Certus Quartz Block Tiles");

            blockWithConnecting(BlockRegistry.SKY_STONE_BIG_TILES, "Large Sky Stone Tiles");
            blockWithConnecting(BlockRegistry.SKY_STONE_BORDERED, "Bordered Sky Stone");
            blockWithConnecting(BlockRegistry.SKY_STONE_BRICK_PATTERN, "Sky Stone Brick Pattern");
            blockWithConnecting(BlockRegistry.SKY_STONE_BRICK_PAVING, "Sky Stone Brick Paving");
            blockWithConnecting(BlockRegistry.SKY_STONE_CHISELED_BRICKS, "Chiseled Sky Stone Bricks");
            blockWithConnecting(BlockRegistry.SKY_STONE_COBBLED, "Cobbled Sky Stone");
            blockWithConnecting(BlockRegistry.SKY_STONE_CRUSHED, "Crushed Sky Stone");
            blockWithConnecting(BlockRegistry.SKY_STONE_DIAGONAL_BRICKS, "Diagonal Sky Stone Bricks");
            blockWithConnecting(BlockRegistry.SKY_STONE_PATH, "Sky Stone Path");
            blockWithConnecting(BlockRegistry.SKY_STONE_ROTATED_BRICKS, "Rotated Sky Stone Bricks");
            blockWithConnecting(BlockRegistry.SKY_STONE_SLATED, "Slated Sky Stone");
            blockWithConnecting(BlockRegistry.SKY_STONE_SMALL_BRICKS, "Small Sky Stone Bricks");
            blockWithConnecting(BlockRegistry.SKY_STONE_SMALL_TILES, "Small Sky Stone Tiles");
            blockWithConnecting(BlockRegistry.SKY_STONE_SMOOTH, "Smooth Sky Stone");
            blockWithConnecting(BlockRegistry.SKY_STONE_SMOOTH_BRICK_PAVING, "Smooth Sky Stone Brick Paving");
            blockWithConnecting(BlockRegistry.SKY_STONE_SMOOTH_LARGE_TILES, "Large Smooth Sky Stone Tiles");
            blockWithConnecting(BlockRegistry.SKY_STONE_SMOOTH_ROTATED_BRICKS, "Rotated Smooth Sky Stone Bricks");
            blockWithConnecting(BlockRegistry.SKY_STONE_SMOOTH_TILES, "Smooth Sky Stone Tiles");
            blockWithConnecting(BlockRegistry.SKY_STONE_SQUARES, "Sky Stone Squares");
            blockWithConnecting(BlockRegistry.SKY_STONE_TILES, "Sky Stone Tiles");
            blockWithConnecting(BlockRegistry.SKY_STONE_WAVES, "Sky Stone Waves");

        }
    }

    public void blockWithConnecting(Supplier<? extends Block> block, String name) {
        addBlock(block, name);

        ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block.get());
        if (location != null) {
            add("block." + location.toLanguageKey() + "_connecting", name);
        }

    }

}