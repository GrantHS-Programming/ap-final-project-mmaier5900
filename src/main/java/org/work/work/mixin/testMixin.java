package org.work.work.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.network.message.MessageHandler;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.gui.hud.ChatHudLine;


@Mixin(MessageHandler.class)

public class testMixin {
    @Inject(at = @At("HEAD"), method = "onChatMessage()V", cancellable = true)

    private void onChatMessage(SignedMessage message, GameProfile sender, MessageType.Parameters params, CallbackInfo info) {
        SignedMessage thing = new SignedMessage(message.link(), message.signature(), message.signedBody(), message.unsignedContent(), message.filterMask());
        assert message.unsignedContent() != null;
        System.out.println("[=] " + message.getContent().getString());

        info.cancel();

    }
}