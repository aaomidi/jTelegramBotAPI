package com.jtelegram.api.requests;

import com.jtelegram.api.requests.framework.QueryTelegramRequest;
import com.jtelegram.api.ex.TelegramException;
import com.jtelegram.api.user.UserProfilePhotos;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Consumer;

@Getter
@ToString
public class GetUserProfilePhotos extends QueryTelegramRequest<UserProfilePhotos> {
    private Long userId;
    private Integer offset;
    private Integer limit;

    @Builder
    protected GetUserProfilePhotos(Consumer<UserProfilePhotos> callback, Consumer<TelegramException> errorHandler, Long userId, Integer offset, Integer limit) {
        super("getUserProfilePhotos", UserProfilePhotos.class, callback, errorHandler);
        this.userId = userId;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    protected boolean isValid() {
        return userId != null && (offset == null || offset >= 0) &&
                (limit == null || limit >= 1 && limit <= 100);
    }
}
