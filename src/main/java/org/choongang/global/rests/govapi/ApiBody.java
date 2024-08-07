package org.choongang.global.rests.govapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.choongang.global.rests.govapi.ApiItems;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiBody {
    private ApiItems items;
    private Integer numOfRows;
    private Integer pageNo;
    private Integer totalCount;
}