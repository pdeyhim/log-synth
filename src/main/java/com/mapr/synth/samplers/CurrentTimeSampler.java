package com.mapr.synth.samplers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.mapr.synth.FancyTimeFormatter;

public class CurrentTimeSampler extends FieldSampler {
    FancyTimeFormatter df = new FancyTimeFormatter("yyyy-MM-dd HH:mm:ss");

    @Override
    public JsonNode sample() {
        long epoch = System.currentTimeMillis();
        return new TextNode(df.format(epoch));
    }
}
