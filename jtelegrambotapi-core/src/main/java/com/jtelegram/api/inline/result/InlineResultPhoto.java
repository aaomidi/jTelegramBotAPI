package com.jtelegram.api.inline.result;

import com.google.gson.annotations.SerializedName;
import com.jtelegram.api.inline.input.InputMessageContent;
import com.jtelegram.api.inline.keyboard.InlineKeyboardMarkup;
import com.jtelegram.api.inline.result.framework.InlineResult;
import com.jtelegram.api.inline.result.framework.ThumbableInlineResult;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InlineResultPhoto extends ThumbableInlineResult implements InlineResult.Visual,
        InlineResult.Titled, InlineResult.Captioned, InlineResult.Describeable {
    private String caption;
    private String title;
    private String description;
    @SerializedName("photo_url")
    private String url;
    @SerializedName("photo_width")
    private Integer width;
    @SerializedName("photo_height")
    private Integer height;

    @Builder
    private InlineResultPhoto(String id, InlineKeyboardMarkup replyMarkup, InputMessageContent inputMessageContent, String thumbUrl,
                              String caption, String title, String description, String url, Integer width, Integer height) {
        super(id, replyMarkup, inputMessageContent, thumbUrl);
        this.caption = caption;
        this.title = title;
        this.description = description;
        this.url = url;
        this.width = width;
        this.height = height;
    }
}
