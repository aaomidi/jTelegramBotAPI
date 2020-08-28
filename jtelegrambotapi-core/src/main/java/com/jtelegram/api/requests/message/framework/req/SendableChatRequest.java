package com.jtelegram.api.requests.message.framework.req;

import com.jtelegram.api.chat.id.ChatId;
import com.jtelegram.api.ex.TelegramException;
import com.jtelegram.api.requests.framework.QueryTelegramRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

@Getter
@EqualsAndHashCode(callSuper = true)
public class SendableChatRequest<T> extends QueryTelegramRequest<T> {
    @Setter
    private ChatId chatId;

    protected SendableChatRequest(String endPoint, Class<T> callbackType, Consumer<T> callback, Consumer<TelegramException> errorHandler, ChatId chatId) {
        super(endPoint, callbackType, callback, errorHandler);
        this.chatId = chatId;
    }

    @Override
    protected boolean isValid() {
        return chatId != null;
    }
}
