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

import com.synopsys.kb.httpclient.model.ComponentVariant;
import com.synopsys.kb.httpclient.model.LicenseDefinition;
import com.synopsys.kb.httpclient.model.Meta;

/**
 * Black Duck-centric component variant representation.
 * 
 * Used to have a default external namespace and/or external id when none is provided.
 * 
 * @author skatzman
 */
public class BdComponentVariant extends ComponentVariant {
    protected static final String DEFAULT_EXTERNAL_NAMESPACE = "unknown";

    protected static final String DEFAULT_EXTERNAL_ID = "unknown";

    public BdComponentVariant(String version,
            String externalNamespace,
            String externalId,
            Boolean externalNamespaceDistribution,
            String packageUrl,
            String type,
            LicenseDefinition licenseDefinition,
            Boolean deleted,
            Boolean componentIntelligence,
            Meta meta) {
        super(version, externalNamespace, externalId, externalNamespaceDistribution, packageUrl, type, licenseDefinition, deleted, componentIntelligence, meta);
    }

    public BdComponentVariant(ComponentVariant componentVariant) {
        super(componentVariant);
    }

    public String getExternalNamespaceOrDefault() {
        // Assign default for absent external namespace.
        return getExternalNamespace().orElseGet(() -> DEFAULT_EXTERNAL_NAMESPACE);
    }

    public String getExternalIdOrDefault() {
        // Assign default for absent external id.
        return getExternalId().orElseGet(() -> DEFAULT_EXTERNAL_ID);
    }
}
