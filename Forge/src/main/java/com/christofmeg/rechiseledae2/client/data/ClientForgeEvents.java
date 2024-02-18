package com.christofmeg.rechiseledae2.client.data;

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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = RechiseledAE2.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
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
