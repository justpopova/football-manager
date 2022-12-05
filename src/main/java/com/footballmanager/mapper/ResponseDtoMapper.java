package com.footballmanager.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
