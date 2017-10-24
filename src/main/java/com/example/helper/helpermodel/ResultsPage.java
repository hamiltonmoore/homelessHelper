package com.example.helper.helpermodel;
import com.example.helper.helpermodel.Helper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsPage {
    List<ApiResult> results;

    public List<ApiResult> getResults() {
        return results;
    }

    public void setResults(List<ApiResult> results) {
        this.results = results;
    }
}



