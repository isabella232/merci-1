/*
 * Copyright 2018 Medallia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 *     http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.medallia.merci.core.metrics;

import com.medallia.merci.core.ConfigurationLoader;

import java.util.concurrent.atomic.LongAdder;

/**
 * Metrics container for {@link ConfigurationLoader}.
 */
public class ConfigurationLoaderMetrics implements ConfigurationLoaderMetricsMBean {

    private final LongAdder requests;
    private final LongAdder failures;

    /**
     * Constructs ConfigurationLoaderMetrics.
     */
    public ConfigurationLoaderMetrics() {
        failures = new LongAdder();
        requests = new LongAdder();
    }

    /** Increment counter for failures when reading and storing configurations. */
    public void incrementConfigurationFailures() {
        failures.increment();
    }

    /** Increment counter for configuration requests. */
    public void incrementConfigurationRequests() {
        requests.increment();
    }

    @Override
    public long getConfigurationFailures() {
        return failures.sum();
    }

    @Override
    public long getConfigurationRequests() {
        return requests.sum();
    }
}
