package com.kusithm.partstudybackend.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomExceptionContext implements ExceptionContext {
    NOT_FOUND_ARTICLE("존재하지 않는 게시글입니다.", 1000);
    private final String message;
    private final int code;
}
