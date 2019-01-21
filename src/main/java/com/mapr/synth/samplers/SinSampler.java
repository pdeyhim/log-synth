package com.mapr.synth.samplers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class SinSampler extends FieldSampler {
    @Override
    public JsonNode sample() {
        long epoch = System.currentTimeMillis();
        double sinValue = Math.sin(epoch/1000);

        return new DoubleNode(sinValue + 2);
    }
}
