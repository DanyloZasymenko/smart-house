package com.smarthouse.smarthouse.dto.utils.builder;

import com.smarthouse.smarthouse.dto.utils.DtoMapper;
import com.smarthouse.smarthouse.dto.utils.impl.DtoMapperImpl;

public class Builder {

    private static DtoMapper dtoMapper = new DtoMapperImpl();
    private static Object orElse;

    private Builder() {

    }

    @SafeVarargs
    public static <T> T map(Object dtoObject, Class<T>... parsingClasses) {
        return parsingClasses[0].cast(dtoMapper.parseFromDTOtoObject(dtoObject, parsingClasses));
    }
}