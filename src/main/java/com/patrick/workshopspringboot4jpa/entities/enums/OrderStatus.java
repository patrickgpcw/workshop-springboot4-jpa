package com.patrick.workshopspringboot4jpa.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {
    WAITING_PAYMENT(1,"Waiting Payment"),
    PAID(2,"Paid"),
    SHIPPED(3,"Shipped"),
    DELIVERED(4,"Delivered"),
    CANCELED(5,"Canceled");

    private final int code;
    private final String label;

    OrderStatus(int code, String label) {
        this.label = label;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    public static OrderStatus fromCode(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus: " + code);
    }

    @JsonCreator
    public static OrderStatus fromLabel(String label) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getLabel().equalsIgnoreCase(label)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus: " + label);
    }

}
