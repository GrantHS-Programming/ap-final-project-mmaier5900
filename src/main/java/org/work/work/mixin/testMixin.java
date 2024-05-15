package org.work.work.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.network.message.MessageHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MessageHandler.class)

public class testMixin {
    @Inject(at = @At("HEAD"), method = "onChatMessage()V")
    private void init(CallbackInfo info) {
        System.out.println("This line is printed by an example mod mixin!");
    }
}