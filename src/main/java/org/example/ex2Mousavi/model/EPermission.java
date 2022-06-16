package org.example.ex2Mousavi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.security.Permission;


@Getter
@AllArgsConstructor
public enum EPermission {
    READ(1),
    WRITE(2),
    READ_WRITE(3),
    UPDATE(4),
    UPDATE_READ(5),
    UPDATE_WRITE(6),
    UPDATE_WRITE_READ(7);

    private Integer value;

    public static String binaryValue(EPermission permission) {

        return Integer.toBinaryString(permission.getValue());
    }


}
