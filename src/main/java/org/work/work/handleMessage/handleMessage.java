package org.work.work.handleMessage;

import ca.weblite.objc.Message;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;
import net.minecraft.text.TranslatableTextContent;
import org.spongepowered.asm.mixin.Mutable;

import java.util.Arrays;

public class handleMessage {
    public static void handleMessage(Text message) {
        sendClientChat("[testing] " + message.getString());
    }

    public static void handleMessage(SignedMessage message, GameProfile sender, MessageType.Parameters params) {

        //sendClientChat(params.applyChatDecoration(message.getContent()));
        //System.out.println(message.getContent());
        //System.out.println(params.applyChatDecoration(message.getContent()));
        //System.out.println(params.applyChatDecoration(message.getContent()).getContent().getType());

        //System.out.println(params.applyChatDecoration(message.getContent()).getContent());
       /// //System.out.println(params.applyChatDecoration(message.getContent()).getContent().toString());
       // Object TranslatableTextContent = new Object();

        System.out.println(Arrays.toString(params.applyChatDecoration(message.getContent()).getContent().getClass().getFields()));
        System.out.println(params.applyChatDecoration(message.getContent()).getContent());
      //  System.out.println(params.applyChatDecoration(message.getContent()).getStyle());
    }
    public static void handleMessage(Text message, MessageType.Parameters params) {
        sendClientChat(params.applyChatDecoration(message) + "[" + "] " + message.getString());
        sendClientChat(params.applyChatDecoration(message));
    }

    public static void sendClientChat(String message) {
        if (MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.sendMessage(Text.literal(message));
        }
    }
    public static void sendClientChat(Text message) {
        if (MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.sendMessage(message);
        }
    }
}
