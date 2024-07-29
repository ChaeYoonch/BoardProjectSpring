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
        return password.matches(".*\\d+.*"); // 아래 2줄과 동일 | 정규 표현식 사용
        /* boolean matched = password.matches(".*\\d+.*"); // matches = 숫자 포함 여부 체크 | ".*[0-9]" = ".*\\d+.*"
        return matched; */
    }

    /**
     * 특수 문자 복잡성 체크
     * @param password
     * @return
     */
    default boolean specialCharsCheck(String password) { // 특수 문자 체크
        String pattern = ".*[^0-9a-zA-Zㄱ-ㅎ가-힣]+.*"; // ^0-9 : 숫자가 아닌 경우 | ^a-zA-Z : 알파벳이 아닌 경우 | ^ㄱ-ㅎ가-힣 : 한글이 아닌 경우 | ".*\\D.*"
        return false;
    }
}