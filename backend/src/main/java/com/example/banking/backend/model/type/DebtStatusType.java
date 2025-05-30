package com.example.banking.backend.model.type;

import lombok.Getter;

@Getter
public enum DebtStatusType {
    PENDING("PENDING"),
    PAID("PAID"),
    CANCELLED("CANCELLED");

    private final String value;

    DebtStatusType(String value) {
        this.value = value;
    }

    public static DebtStatusType fromValue(String value) {
        for (DebtStatusType type : DebtStatusType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
