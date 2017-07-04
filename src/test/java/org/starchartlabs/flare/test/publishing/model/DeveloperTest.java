/*
 * Copyright (c) Jul 2, 2017 Corona IDE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    "romeara" - initial API and implementation and/or initial documentation
 */
package org.starchartlabs.flare.test.publishing.model;

import org.starchartlabs.flare.publishing.model.Developer;
import org.starchartlabs.flare.test.publishing.BaseClosure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeveloperTest {

    @Test
    public void constructEmpty() throws Exception {
        Developer result = new Developer();

        Assert.assertNull(result.getId());
        Assert.assertNull(result.getName());
        Assert.assertNull(result.getUrl());
    }

    @Test
    public void constructFields() throws Exception {
        Developer result = new Developer("id", "name", "url");

        Assert.assertEquals(result.getId(), "id");
        Assert.assertEquals(result.getName(), "name");
        Assert.assertEquals(result.getUrl(), "url");
    }

    @Test
    public void configure() throws Exception {
        Developer result = new Developer();

        result.configure(new BaseClosure<>(result, this::closureCall));

        Assert.assertEquals(result.getId(), "id");
        Assert.assertEquals(result.getName(), "name");
        Assert.assertEquals(result.getUrl(), "url");
    }

    @Test
    public void setFields() throws Exception {
        Developer result = new Developer();

        result.setId("id");
        result.setName("name");
        result.setUrl("url");

        Assert.assertEquals(result.getId(), "id");
        Assert.assertEquals(result.getName(), "name");
        Assert.assertEquals(result.getUrl(), "url");
    }

    private Developer closureCall(Developer delegate) {
        delegate.setId("id");
        delegate.setName("name");
        delegate.setUrl("url");

        return delegate;
    }

}
