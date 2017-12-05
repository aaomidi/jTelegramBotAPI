package com.jtelegram.api.requests.message;

import com.jtelegram.api.chat.id.ChatId;
import com.jtelegram.api.ex.TelegramException;
import com.jtelegram.api.message.Message;
import com.jtelegram.api.requests.message.framework.ReplyMarkup;
import com.jtelegram.api.requests.message.framework.req.SendableMessageRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Consumer;

@ToString
@Getter
public class ForwardMessage extends SendableMessageRequest<Message> {
    private final ChatId fromChatId;
    private final Integer messageId;

    @Builder
    protected ForwardMessage(Consumer<Message> callback, Consumer<TelegramException> errorHandler, ChatId chatId, Integer replyToMessageId, Boolean disableNotification, ChatId fromChatId, Integer messageId, ReplyMarkup replyMarkup) {
        super("forwardMessage", Message.class, callback, errorHandler, chatId, replyToMessageId, disableNotification, replyMarkup);
        this.fromChatId = fromChatId;
        this.messageId = messageId;
    }


    @Override
    protected boolean isValid() {
        return super.isValid() && fromChatId != null && messageId != null;
    }

}
