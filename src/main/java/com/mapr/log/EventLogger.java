/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mapr.log;

import org.apache.mahout.math.random.Sampler;

import java.util.Map;

/**
 *
 * @author andrewserff
 */
public interface EventLogger {
    public void logEvent(Sampler event, Map<String, Object> producerConfig);
    public void shutdown();
}
