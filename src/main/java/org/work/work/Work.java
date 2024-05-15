package org.work.work;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class Work implements ModInitializer {
    /**
     * Runs the mod initializer.
     */
    public static final testItem CUSTOM_ITEM = new testItem(new Item.Settings());

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier("tutorial", "custom_item"), CUSTOM_ITEM);
    }
}
