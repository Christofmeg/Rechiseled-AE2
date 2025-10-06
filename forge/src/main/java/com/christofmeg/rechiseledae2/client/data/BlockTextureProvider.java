package com.christofmeg.rechiseledae2.client.data;

import com.christofmeg.rechiseledae2.RechiseledAE2;
import com.supermartijn642.rechiseled.api.ChiseledTextureProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlockTextureProvider extends ChiseledTextureProvider {

    private final ExistingFileHelper existingFileHelper;
    private final Set<String> outputLocations = new HashSet<>();
    private final List<String> quartzSuffixes;
    private final List<String> stoneSuffixes;

    public BlockTextureProvider(DataGenerator generator, ExistingFileHelper existingFileHelper){
        super(RechiseledAE2.MOD_ID, generator, existingFileHelper);
        this.existingFileHelper = existingFileHelper;
        this.quartzSuffixes = List.of("bordered", "brick_paving", "chiseled_pillar", "chiseled_squares", "connecting", "crosses",
                "diagonal_tiles", "pattern", "rotated_bricks", "rows", "scales", "small_tiles", "squares", "stripes", "tiles");

        this.stoneSuffixes = List.of("big_tiles", "bordered", "brick_pattern", "brick_paving", "chiseled_bricks", "cobbled",
                "crushed", "diagonal_bricks", "path", "rotated_bricks", "slated_end", "slated_side", "small_bricks", "small_tiles", "smooth", "smooth_brick_paving",
                "smooth_large_tiles", "smooth_rotated_bricks", "smooth_tiles", "squares", "tiles", "waves");
    }

    private final ResourceLocation QUARTZ = new ResourceLocation("block/quartz_block_top");
 //   private final ResourceLocation CERTUS_QUARTZ = new ResourceLocation("rechiseledae2", "block/certus_quartz_palette");
    private final ResourceLocation CERTUS_QUARTZ = new ResourceLocation("rechiseledae2", "block/quartz_block");
    private final ResourceLocation CERTUS_QUARTZ_128X = new ResourceLocation("rechiseledae2", "block/certus_quartz_palette128x3");

    private final ResourceLocation STONE = new ResourceLocation("block/stone");
    private final ResourceLocation SKY_STONE = new ResourceLocation("rechiseledae2", "block/smooth_sky_stone_block");
    private final ResourceLocation SKY_STONE_128X = new ResourceLocation("rechiseledae2", "block/smooth_sky_stone_block128x");

    @Override
    protected void createTextures() {
    //    this.createBlockTextures(QUARTZ, CERTUS_QUARTZ_128X, "block/certus_quartz_block");
    //    this.createBlockTextures(STONE, SKY_STONE_128X, "block/sky_stone");
    }

    protected void createBlockTextures(ResourceLocation fromTexture, ResourceLocation toTexture, String outputLocation) {
        if (!this.validateTexture(fromTexture)) {
            throw new IllegalStateException("Could not find texture '" + fromTexture + "'!");
        } else if (outputLocation != null && !outputLocation.trim().isEmpty()) {
            if (!this.outputLocations.add(outputLocation)) {
                throw new IllegalStateException("Two or more textures have the same output location: " + outputLocation);
            } else {

                if (fromTexture.equals(QUARTZ)) {
                    for (String suffix : this.quartzSuffixes) {
                        PaletteMap paletteMap = this.createPaletteMap(new ResourceLocation(RechiseledAE2.MOD_ID, "block/quartz_block" + "_" + suffix), toTexture);
                        if (suffix.equals("chiseled_squares")) {
                            paletteMap = this.createPaletteMap(new ResourceLocation(RechiseledAE2.MOD_ID, "block/quartz_block" + "_" + suffix), CERTUS_QUARTZ);
                        }
                        paletteMap.applyToTexture(new ResourceLocation(RechiseledAE2.MOD_ID, "block/quartz_block" + "_" + suffix), outputLocation + "_" + suffix);
                    }
                }
                else {
                    for (String suffix : this.stoneSuffixes) {
                        PaletteMap paletteMap = this.createPaletteMap(new ResourceLocation(RechiseledAE2.MOD_ID, "block/stone" + "_" + suffix), toTexture);
                        if (suffix.equals("cobbled") || suffix.equals("slated_end") || suffix.equals("slated_side")) {
                            paletteMap = this.createPaletteMap(new ResourceLocation(RechiseledAE2.MOD_ID, "block/stone" + "_" + suffix), SKY_STONE);
                        }
                        paletteMap.applyToTexture(new ResourceLocation(RechiseledAE2.MOD_ID, "block/stone" + "_" + suffix), outputLocation + "_" + suffix);
                    }
                }

            }
        } else {
            throw new IllegalArgumentException("Output location must not be empty!");
        }
    }

    private boolean validateTexture(ResourceLocation texture) {
        return this.existingFileHelper.exists(texture, PackType.CLIENT_RESOURCES, ".png", "textures");
    }
}