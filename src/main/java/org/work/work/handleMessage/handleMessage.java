package org.work.work.handleMessage;

import ca.weblite.objc.Message;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.text.Text;

public class handleMessage {
    public static void handleMessage(Text message) {
        sendClientChat("[testing] " + message.getString());
    }

    public static void handleMessage(SignedMessage message, GameProfile sender, MessageType.Parameters params) {
        sendClientChat(params.applyChatDecoration(message.getContent()) + "[" + sender.getName() + "] " + message.getContent().getString());
        sendClientChat(params.applyChatDecoration(message.getContent()));
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
