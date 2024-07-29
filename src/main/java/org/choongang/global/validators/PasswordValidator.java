package org.choongang.global.validators;

public interface PasswordValidator {
    /**
     * 알파벳 복잡성 체크
     * @param password
     * @param caseInsensitive - 기본값이 false 가 되면 : 대,소문자 각각 1개 이상 포함 / true : 대,소문자 구분 X
     * @return
     */
    default boolean alphaCheck(String password, boolean caseInsensitive) { // 알파벳 체크

        return false;
    }

    /**
     * 숫자 복잡성 체크
     * @param password
     * @return
     */
    default boolean numberCheck(String password) { // 숫자 체크

        return false;
    }

    /**
     * 특수 문자 복잡성 체크
     * @param password
     * @return
     */
    default boolean specialCharsCheck(String password) { // 특수 문자 체크

        return false;
    }
}