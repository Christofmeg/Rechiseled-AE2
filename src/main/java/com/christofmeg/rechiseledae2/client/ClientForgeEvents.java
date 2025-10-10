package com.christofmeg.rechiseledae2.client;

import appeng.items.parts.FacadeItem;
import com.christofmeg.rechiseledae2.RechiseledAE2;
import com.christofmeg.rechiseledae2.common.item.ConnectingBlockItem;
import com.supermartijn642.rechiseled.blocks.RechiseledBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = RechiseledAE2.MOD_ID, value = Dist.CLIENT)
public class ClientForgeEvents {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.getItem() instanceof FacadeItem facadeItem) {
            BlockState state = facadeItem.getTextureBlockState(stack);
            Item item = state.getBlock().asItem();
            Block block = state.getBlock();
            if (item instanceof ConnectingBlockItem || block instanceof RechiseledBlock) {
                event.getToolTip().add(Component.translatable("rechiseled.tooltip.connecting").withStyle(ChatFormatting.GRAY));
            }
        }
    }
}
