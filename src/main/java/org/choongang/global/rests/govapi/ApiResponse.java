package org.choongang.global.rests.govapi;

import lombok.Data;

@Data
public class ApiResponse {
    private ApiHeader header;
    private ApiBody body;

}