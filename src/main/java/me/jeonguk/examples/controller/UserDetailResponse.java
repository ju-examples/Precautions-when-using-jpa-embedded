package me.jeonguk.examples.controller;

public record UserDetailResponse(
        Long userId,
        String name,
        String email
) {
}
