package com.mapr.synth.samplers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.mapr.synth.FancyTimeFormatter;

public class IncreasingDateSampler extends FieldSampler {
    FancyTimeFormatter df = new FancyTimeFormatter();

    @Override
    public JsonNode sample() {
        long epoch = System.currentTimeMillis();
        return TextNode();
    }
}
