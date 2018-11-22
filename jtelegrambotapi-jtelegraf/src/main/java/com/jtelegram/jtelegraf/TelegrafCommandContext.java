package com.jtelegram.jtelegraf;

import com.jtelegram.api.TelegramBot;
import com.jtelegram.api.commands.Command;
import com.jtelegram.api.message.impl.TextMessage;
import com.jtelegram.api.update.Update;
import javax.annotation.Nonnull;
import lombok.Getter;

/**
 * @author Nick Robson
 */
@Getter
public class TelegrafCommandContext extends TelegrafMessageContext<TelegrafCommandContext, String, TextMessage> {

    @Nonnull
    private final Command command;

    public TelegrafCommandContext(@Nonnull TelegramBot bot, @Nonnull Update.MessageUpdate update, @Nonnull TextMessage message, @Nonnull Command command) {
        super(bot, update, message);
        this.command = command;
    }

}