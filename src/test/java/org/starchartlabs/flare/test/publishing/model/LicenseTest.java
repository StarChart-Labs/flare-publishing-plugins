/*
 * Copyright (c) Jul 3, 2017 Corona IDE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    "romeara" - initial API and implementation and/or initial documentation
 */
package org.starchartlabs.flare.test.publishing.model;

import org.starchartlabs.flare.publishing.model.License;
import org.starchartlabs.flare.test.publishing.BaseClosure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LicenseTest {

    @Test
    public void constructEmpty() throws Exception {
        License result = new License();

        Assert.assertNull(result.getName());
        Assert.assertNull(result.getTag());
        Assert.assertNull(result.getUrl());
        Assert.assertNull(result.getDistribution());
    }

    @Test
    public void construct() throws Exception {
        License result = new License("name", "tag", "url", "distribution");

        Assert.assertEquals(result.getName(), "name");
        Assert.assertEquals(result.getTag(), "tag");
        Assert.assertEquals(result.getUrl(), "url");
        Assert.assertEquals(result.getDistribution(), "distribution");
    }

    @Test
    public void configure() throws Exception {
        License result = new License();
        result.configure(new BaseClosure<>(result, this::configureCall));

        Assert.assertEquals(result.getName(), "name");
        Assert.assertEquals(result.getTag(), "tag");
        Assert.assertEquals(result.getUrl(), "url");
        Assert.assertEquals(result.getDistribution(), "distribution");
    }

    @Test
    public void setFields() throws Exception {
        License result = new License();
        result.setName("name");
        result.setTag("tag");
        result.setUrl("url");
        result.setDistribution("distribution");

        Assert.assertEquals(result.getName(), "name");
        Assert.assertEquals(result.getTag(), "tag");
        Assert.assertEquals(result.getUrl(), "url");
        Assert.assertEquals(result.getDistribution(), "distribution");
    }

    private License configureCall(License delegate) {
        delegate.setName("name");
        delegate.setTag("tag");
        delegate.setUrl("url");
        delegate.setDistribution("distribution");

        return delegate;
    }

}
