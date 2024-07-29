package org.choongang.global.validators;

public interface MobileValidator { // 전화번호
    default boolean checkMobile(String mobile) {
        /**
         * 01[016]-0000/000-0000
         * 01[016]-\d{3,4}-\d{4} : 3/4자리 - 4자리
         * 010.1111.1111
         * 010-1111-1111
         * 010 1111 1111
         * 01011111111
         * 1. 숫자만 남긴다. 2. 패턴 만들기 3. 체크
         */

        mobile = mobile.replaceAll("\\D", ""); // 1. 숫자만 남긴다.

        return false;
    }
}