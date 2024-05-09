
import net.fabricmc.api.*;
public class ExampleMod implements ModInitializer {

    /* Declare and initialize our custom block instance.
       We set our block material to `METAL`.

       `strength` sets both the hardness and the resistance of a block to the same value.
       Hardness determines how long the block takes to break, and resistance determines how strong the block is against blast damage (e.g. explosions).
       Stone has a hardness of 1.5f and a resistance of 6.0f, while Obsidian has a hardness of 50.0f and a resistance of 1200.0f.

       You can find the stats of all vanilla blocks in the class `Blocks`, where you can also reference other blocks.
    */

    // For versions below 1.20:
    // public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    // For versions below 1.20.5:
    // public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.create().strength(4.0f));
    // For versions since 1.20.5:
    public static final Block EXAMPLE_BLOCK = new Block(Block.Settings.create().strength(4.0f));

    @Override
    public void onInitialize() {
        Registry.register(Registries.BLOCK, new Identifier("tutorial", "example_block"), EXAMPLE_BLOCK);

    }
}