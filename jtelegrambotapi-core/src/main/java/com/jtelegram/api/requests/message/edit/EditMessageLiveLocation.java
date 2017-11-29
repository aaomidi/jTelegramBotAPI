package com.jtelegram.api.requests.message.edit;

import com.jtelegram.api.chat.id.ChatId;
import com.jtelegram.api.message.Message;
import com.jtelegram.api.ex.TelegramException;
import com.jtelegram.api.requests.message.framework.req.SendableInlineRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Consumer;

@Getter
@ToString
public class EditMessageLiveLocation extends SendableInlineRequest<Message> {
    private final Float latitude;
    private final Float longitude;
    private final Integer livePeriod;

    @Builder
    protected EditMessageLiveLocation(Consumer<Message> callback, Consumer<TelegramException> errorHandler, ChatId chatId, Integer messageId, String inlineMessageId, Float latitude, Float longitude, Integer livePeriod) {
        super("editMessageLiveLocation", Message.class, callback, errorHandler, chatId, messageId, inlineMessageId);
        this.latitude = latitude;
        this.longitude = longitude;
        this.livePeriod = livePeriod;
    }


    @Override
    protected boolean isValid() {
        boolean valid = super.isValid() && latitude != null && longitude != null;
        if (livePeriod != null) {
            valid = valid & livePeriod >= 60;
            valid = valid & livePeriod <= 86400;
        }
        return valid;
    }
}
