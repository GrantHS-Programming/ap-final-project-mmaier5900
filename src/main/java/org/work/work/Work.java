package org.work.work;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.time.ZonedDateTime;

public class Work implements ModInitializer {

    // * Runs the mod initializer.

    public static final testItem CUSTOM_ITEM = new testItem(new Item.Settings());
    public static final Block DOT_BLOCK = new Block(AbstractBlock.Settings.create().strength(4.0f).requiresTool());

    @Override
    public void onInitialize() {
        System.out.println(ZonedDateTime.now());
        Registry.register(Registries.ITEM, new Identifier("tutorial", "custom_item"), CUSTOM_ITEM);
        Registry.register(Registries.BLOCK, new Identifier("tutorial", "first_block"), DOT_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("tutorial", "first_block"), new BlockItem(DOT_BLOCK, new Item.Settings()));
    }


}
