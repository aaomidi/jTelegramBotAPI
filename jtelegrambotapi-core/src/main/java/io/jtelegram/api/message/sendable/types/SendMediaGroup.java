package io.jtelegram.api.message.sendable.types;

import io.jtelegram.api.chat.Chat;
import io.jtelegram.api.chat.id.ChatId;
import io.jtelegram.api.chat.id.LongChatId;
import io.jtelegram.api.ex.TelegramException;
import io.jtelegram.api.message.Message;
import io.jtelegram.api.message.sendable.InputFileMessageRequest;
import io.jtelegram.api.message.sendable.input.file.InputFile;
import io.jtelegram.api.message.sendable.input.media.InputMedia;
import io.jtelegram.api.message.sendable.ReplyMarkup;
import io.jtelegram.api.message.sendable.SendableMessageRequest;
import lombok.Builder;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SendMediaGroup extends InputFileMessageRequest<Message[]> {
    private final List<InputMedia> media;

    @Builder
    protected SendMediaGroup(Consumer<Message[]> callback, Consumer<TelegramException> errorHandler, ChatId chatId, Integer replyToMessageId, Boolean disableNotification, ReplyMarkup replyMarkup, List<InputMedia> media) {
        super("sendMediaGroup", Message[].class, callback, errorHandler, chatId, replyToMessageId, disableNotification, replyMarkup);
        this.media = media;
    }

    @Override
    protected boolean isValid() {
        return super.isValid() && media != null && media.size() != 0;
    }

    @Override
    public List<InputFile> getInputFiles() {
        return media.stream().map(InputMedia::getMedia).collect(Collectors.toList());
    }

    public static class SendMediaGroupBuilder {
        public SendMediaGroup.SendMediaGroupBuilder chatId(Chat chat) {
            this.chatId = new LongChatId(chat.getId());
            return this;
        }

        public SendMediaGroup.SendMediaGroupBuilder chatId(ChatId chatId) {
            this.chatId = chatId;
            return this;
        }
    }
}
