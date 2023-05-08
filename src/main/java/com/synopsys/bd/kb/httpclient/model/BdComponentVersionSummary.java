/*
 * Copyright (C) 2023 Synopsys Inc.
 * http://www.synopsys.com/
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Synopsys ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Synopsys.
 */
package com.synopsys.bd.kb.httpclient.model;

import java.time.OffsetDateTime;

import com.synopsys.kb.httpclient.model.ComponentVersionSummary;
import com.synopsys.kb.httpclient.model.Meta;

/**
 * Black Duck-centric component version summary.
 * 
 * Used to provide a default version when none is provided.
 * 
 * @author skatzman
 */
public class BdComponentVersionSummary extends ComponentVersionSummary {
    protected static final String UNKNOWN_VERSION = "unknown";

    public BdComponentVersionSummary(String version,
            OffsetDateTime releasedOn,
            Boolean deleted,
            Meta meta) {
        super(version, releasedOn, deleted, meta);
    }

    public BdComponentVersionSummary(ComponentVersionSummary bdComponentVersionSummary) {
        super(bdComponentVersionSummary);
    }

    public String getVersionOrDefault() {
        // Assign default for absent version.
        return getVersion().orElseGet(() -> UNKNOWN_VERSION);
    }
}
