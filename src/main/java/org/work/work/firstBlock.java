package org.work.work;


import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class firstBlock extends Block {
    public firstBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBlockAdded(BlockState blockState, World world, BlockPos pos, BlockState oldState, boolean notify) {
        System.out.println((pos.getX()) + ", " + pos.getY() + ", " + pos.getZ());
        PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 5, false);
        if (player != null) {
            CommandManager commandManager = Objects.requireNonNull(player.getServer()).getCommandManager();
            ServerCommandSource commandSource = player.getServer().getCommandSource();
            commandManager.executeWithPrefix(commandSource, "summon tnt " + (pos.getX()) + " " + pos.getY() + " " + pos.getZ());
        }
        return;
    }
}
