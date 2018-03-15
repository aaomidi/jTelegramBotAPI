package com.jtelegram.api.message.impl;

import com.jtelegram.api.message.CaptionableMessage;
import com.jtelegram.api.message.media.PhotoSize;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@ToString(callSuper = true)
public class PhotoMessage extends CaptionableMessage<List<PhotoSize>> {
    private List<PhotoSize> photo = new ArrayList<>();
    /**
     * This field does not exist in the Telegram Docs, however is
     * non-zero whenever a photo is a fragment of an album. Albums
     * are collection of images and videos that have a max size of
     * 10. The Telegram Bot has no evident way of checking when it
     * has received the whole album, so do with this as you will
     */
    private long mediaGroupId;

    @Override
    public List<PhotoSize> getContent() {
        return photo;
    }

    public PhotoSize getHighestResolutionPhoto() {
        return photo.stream()
                .sorted(Comparator.comparingInt((p) -> p.getWidth() + p.getHeight()))
                .findFirst()
                .orElse(null);
    }
}
