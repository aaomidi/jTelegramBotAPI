package com.jtelegram.api.chat;

import com.jtelegram.api.user.User;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "user")
public class ChatMember {
    private User user;
    private ChatMemberStatus status;
    private boolean canBeEdited;
    private boolean canChangeInfo;
    private boolean canPostMessages;
    private boolean canEditMessages;
    private boolean canDeleteMessages;
    private boolean canInviteUsers;
    private boolean canRestrictMembers;
    private boolean canPinMessages;
    private boolean canPromoteMembers;
    private boolean canSendMessages;
    private boolean canSendMediaMessages;
    private boolean canSendOtherMessages;
    private boolean canAddWebPagePreviews;
}
