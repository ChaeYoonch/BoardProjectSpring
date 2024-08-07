package org.choongang.global.rests.govapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiItems {
    private List<org.choongang.global.rests.govapi.ApiItem> item;
}
