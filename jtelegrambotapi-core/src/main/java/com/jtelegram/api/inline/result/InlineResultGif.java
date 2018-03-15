package com.jtelegram.api.inline.result;

import com.google.gson.annotations.SerializedName;
import com.jtelegram.api.inline.keyboard.InlineKeyboardMarkup;
import com.jtelegram.api.inline.result.framework.InlineResult;
import com.jtelegram.api.inline.input.InputMessageContent;
import com.jtelegram.api.inline.result.framework.ThumbableInlineResult;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InlineResultGif extends ThumbableInlineResult implements InlineResult.Urlable, InlineResult.Visual,
        InlineResult.Titled, InlineResult.Captioned, InlineResult.Duratable {
    private String title;
    private String caption;
    @SerializedName("gif_url")
    private String url;
    @SerializedName("gif_width")
    private Integer width;
    @SerializedName("gif_height")
    private Integer height;
    @SerializedName("gif_duration")
    private Integer duration;

    @Builder
    private InlineResultGif(String id, InlineKeyboardMarkup replyMarkup, InputMessageContent inputMessageContent, String thumbUrl, String title, String caption, String url, Integer width, Integer height, Integer duration) {
        super(id, replyMarkup, inputMessageContent, thumbUrl);
        this.title = title;
        this.caption = caption;
        this.url = url;
        this.width = width;
        this.height = height;
        this.duration = duration;
    }
}
