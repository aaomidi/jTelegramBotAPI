package com.jtelegram.api.menu.viewer;

import com.jtelegram.api.chat.id.ChatId;
import com.jtelegram.api.menu.Menu;
import com.jtelegram.api.menu.MenuViewer;
import com.jtelegram.api.requests.message.edit.EditMessageReplyMarkup;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class RegularMenuViewer implements MenuViewer {
    private ChatId chatId;
    private int messageId;

    @Builder
    public RegularMenuViewer(ChatId chatId, int messageId) {
        this.chatId = chatId;
        this.messageId = messageId;
    }

    @Override
    public void sendMenu(Menu menu) {
        menu.getBot().perform(EditMessageReplyMarkup.builder()
                .chatId(chatId)
                .messageId(messageId)
                .replyMarkup(menu.toKeyboard())
                .build());
    }
}
