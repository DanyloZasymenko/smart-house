package com.smarthouse.smarthouse.dto;

import com.smarthouse.smarthouse.dto.utils.annotations.Dto;

@Dto
public class HouseShortDto<T extends HouseShortDto> {

    protected Long id;
    protected String name;

    public Long getId() {
        return id;
    }

    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }

    public String getName() {
        return name;
    }

    public T setName(String name) {
        this.name = name;
        return (T) this;
    }

    @Override
    public String toString() {
        return "HouseShortDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
