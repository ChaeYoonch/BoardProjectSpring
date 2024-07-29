package org.choongang.global.validators;

public interface MobileValidator { // 전화번호
    default boolean checkMobile(String mobile) {
        /**
         * 01[016]-0000/000-0000
         */
        return false;
    }
}