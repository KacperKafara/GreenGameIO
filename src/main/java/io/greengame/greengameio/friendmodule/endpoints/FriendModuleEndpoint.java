package io.greengame.greengameio.friendmodule.endpoints;

import io.greengame.greengameio.friendmodule.dto.GroupUpdateDTO;
import io.greengame.greengameio.friendmodule.managers.FriendManager;
import io.greengame.greengameio.friendmodule.model.Friend;
import io.greengame.greengameio.friendmodule.model.Group;
import io.greengame.greengameio.friendmodule.model.UserFM;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friend-module")
public class FriendModuleEndpoint {
    private final FriendManager friendManager;

    @GetMapping
    public List<UserFM> findAllUserFMs() {
        return friendManager.findAllUserFMs();
    }
    @PatchMapping("/{userId}/send-friend-request")
    public void sendFriendRequest(@PathVariable Long userId, Long receiverId) {
        friendManager.sendFriendRequest(userId, receiverId);
    }
    @PatchMapping("/{userId}/accept-friend-request")
    public void acceptFriendRequest(@PathVariable Long userId,Long senderId) {
        friendManager.acceptFriendRequest(senderId, userId);
    }
    @PatchMapping("/{senderId}/remove-friend")
    public void removeFriend(@PathVariable Long senderId, Long receiverId) {
        friendManager.removeFriend(senderId, receiverId);
    }
    @GetMapping("/{userId}/get-friends")
    public List<Friend> findAllFriends(@PathVariable Long userId) {
        return friendManager.findAllFriends(userId);
    }
    @GetMapping("/{userId}/get-friend-requests")
    public Map<Long, String> findAllFriendRequests(@PathVariable Long userId) {
        return friendManager.findAllFriendRequests(userId);
    }
    @GetMapping("/{userId}/groups")
    public List<Group> findAllGroups(@PathVariable Long userId) {
        return friendManager.findAllGroups(userId);
    }
    @PostMapping("/{userId}/groups")
    public Group createGroup(@PathVariable Long userId, @RequestBody GroupUpdateDTO group) {
        return friendManager.createGroup(userId, group);
    }
    @PutMapping("/{userId}/groups/{groupId}")
    public Group updateGroup(@PathVariable Long userId, @PathVariable String groupId, @RequestBody GroupUpdateDTO group) {
        return friendManager.updateGroup(userId, groupId, group);
    }
    @DeleteMapping("/{userId}/groups/{groupId}")
    public void deleteGroup(@PathVariable Long userId, @PathVariable String groupId) {
        friendManager.deleteGroup(userId, groupId);
    }
    @PatchMapping("/{userId}/groups/{groupId}/add-member")
    public void addMemberToGroup(@PathVariable Long userId, @PathVariable String groupId, Long memberId) {
        friendManager.addGroupMember(userId, groupId, memberId);
    }
    @PatchMapping("/{userId}/groups/{groupId}/remove-member")
    public void removeMemberFromGroup(@PathVariable Long userId, @PathVariable String groupId, Long memberId) {
        friendManager.removeGroupMember(userId, groupId, memberId);
    }



}
