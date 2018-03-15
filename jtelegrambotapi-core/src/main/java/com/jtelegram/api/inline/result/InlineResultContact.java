package com.jtelegram.api.inline.result;

import com.jtelegram.api.inline.input.InputMessageContent;
import com.jtelegram.api.inline.keyboard.InlineKeyboardMarkup;
import com.jtelegram.api.inline.result.framework.DimensionalThumbableInlineResult;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InlineResultContact extends DimensionalThumbableInlineResult {
    private String phoneNumber;
    private String firstName;
    private String lastName;

    @Builder
    private InlineResultContact(String id, InlineKeyboardMarkup replyMarkup, InputMessageContent inputMessageContent,
                                String thumbUrl, Integer thumbWidth, Integer thumbHeight, String phoneNumber, String firstName,
                                String lastName) {
        super(id, replyMarkup, inputMessageContent, thumbUrl, thumbWidth, thumbHeight);
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
