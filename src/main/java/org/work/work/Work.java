package org.work.work;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.kyrptonaught.customportalapi;
import java.time.ZonedDateTime;

public class Work implements ModInitializer {

    // * Runs the mod initializer.
CustomPortalBuilder.beginPortal()
        .frameBlock(Blocks.DIAMOND_BLOCK)
        .lightWithItem(Items.ENDER_EYE)
        .destDimID(new Identifier("nowhere"))
            .tintColor(45,65,101)
        .registerPortal();
    public static final testItem CUSTOM_ITEM = new testItem(new Item.Settings());
    public static final firstBlock DOT_BLOCK = new firstBlock(AbstractBlock.Settings.create().strength(4.0f).requiresTool());

    @Override
    public void onInitialize() {
        System.out.println(ZonedDateTime.now());
        Registry.register(Registries.ITEM, new Identifier("tutorial", "custom_item"), CUSTOM_ITEM);
        Registry.register(Registries.BLOCK, new Identifier("tutorial", "first_block"), DOT_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("tutorial", "first_block"), new BlockItem(DOT_BLOCK, new Item.Settings()));
    }


}
