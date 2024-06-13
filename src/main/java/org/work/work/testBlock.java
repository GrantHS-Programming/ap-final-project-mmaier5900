package org.work.work;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class testBlock implements ModInitializer {
    public static final Block FIRST_BLOCK = new Block(AbstractBlock.Settings.create().strength(4.0f).requiresTool());
    @Override
    public void appendTooltip(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("block.tutorial.first_block.tooltip"));
    }


    public void onInitialize() {
        Registry.register(Registries.BLOCK, new Identifier("tutorial", "first_block"), FIRST_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("tutorial", "first_block"), new BlockItem(FIRST_BLOCK, new Item.Settings()));
    }


}
