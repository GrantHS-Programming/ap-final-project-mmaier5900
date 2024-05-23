package org.work.work.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.network.message.MessageHandler;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.gui.hud.ChatHudLine;


//package org.work.work.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
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

import java.util.UUID;
import org.work.work.handleMessage.*;

@Mixin(MessageHandler.class)

public class testMixin {

    @Inject(at = @At("HEAD"), method = "onChatMessage()V", cancellable = true)
    private void onChatMessage(SignedMessage message, GameProfile sender, MessageType.Parameters params, CallbackInfo info) {
        SignedMessage thing = new SignedMessage(message.link(), message.signature(), message.signedBody(), message.unsignedContent(), message.filterMask());
        assert message.unsignedContent() != null;
        System.out.println(sender.getName());

        handleMessage.handleMessage(message, sender, params);

        //info.cancel();

    }

    @Inject(at = @At("HEAD"), method = "onGameMessage(Lnet/minecraft/text/Text;ZLorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;)V", cancellable = true)
    private void onGameMessage(Text message, boolean overlay, CallbackInfo info) {
        System.out.println("Game message:");



        handleMessage.handleMessage(message);
        //info.cancel();
    }


    /*@Inject(at = @At("HEAD"), method = "onUnverifiedMessage(Ljava/util/UUID;Lnet/minecraft/network/message/MessageType$Parameters;Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;)V", cancellable = true)
    private void onUnverifiedMessage(UUID sender, MessageType.Parameters params, CallbackInfo info) {
        handleMessage.handleMessage();
        info.cancel();

    }*/

    @Inject(at = @At("HEAD"), method = "onProfilelessMessage", cancellable = true)
    private void onProfilelessMessage(Text message, MessageType.Parameters params, CallbackInfo info) {
        handleMessage.handleMessage(message, params);
        //info.cancel();
    }







}

