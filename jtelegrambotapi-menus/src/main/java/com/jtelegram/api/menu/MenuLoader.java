package com.jtelegram.api.menu;

import com.jtelegram.api.TelegramBot;
import com.jtelegram.api.events.inline.keyboard.CallbackQueryEvent;
import com.jtelegram.api.menu.impl.MenuImpl;
import com.jtelegram.api.requests.message.framework.ParseMode;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Bootstraps the creation of menus.
 */
public class MenuLoader {

    /**
     * Registers the menu listener to a given bot.
     *
     * @param bot The bot instance
     */
    public static void registerListeners(@Nonnull TelegramBot bot) {
        bot.getEventRegistry().registerEvent(CallbackQueryEvent.class, MenuImpl::handleEvent);
    }

    /**
     * Creates a new menu, ready for use.
     *
     * @param loadingMessage The message to display while loading the first state
     * @param textSupplier The text supplier
     * @param parseMode The parse mode used by the first state
     *
     * @return The new menu
     */
    @Nonnull
    public static Menu createMenu(@Nonnull String loadingMessage, @Nonnull Supplier<String> textSupplier, @Nullable ParseMode parseMode) {
        return new MenuImpl(loadingMessage, textSupplier, parseMode);
    }

}