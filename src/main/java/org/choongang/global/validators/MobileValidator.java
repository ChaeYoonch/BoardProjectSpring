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
         * 예) 0101111111111111 // "01[016]\\d{3,4}\\d{4}" 이면 왼쪽 것도 문제 없다고 판단하기 때문에 뒤에 $ 추가!!
         */

        mobile = mobile.replaceAll("\\D", ""); // 1. 숫자만 남긴다.
        String pattern = "01[016]\\d{3,4}\\d{4}$"; // 010, 011, 016 | 3 ~ 4자리 | 4자리

        return false;
    }
}