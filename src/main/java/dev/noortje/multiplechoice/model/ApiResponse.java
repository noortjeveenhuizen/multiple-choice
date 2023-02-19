package dev.noortje.multiplechoice.model;

import java.util.List;

public class ApiResponse {
    private List<ApiResult> results;

    public List<ApiResult> getResults() {
        return results;
    }

    public void setResults(List<ApiResult> results) {
        this.results = results;
    }
}
