package com.haris.android.trade.data.entity;

import com.google.gson.JsonElement;

public class GraphEntity {

    private JsonElement graphData;

    public GraphEntity(JsonElement graphData) {
        this.graphData = graphData;
    }

    public JsonElement getGraphData() {
        return graphData;
    }

    public void setGraphData(JsonElement graphData) {
        this.graphData = graphData;
    }
}
