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

import org.starchartlabs.flare.publishing.model.Scm;
import org.starchartlabs.flare.test.publishing.BaseClosure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScmTest {

    @Test
    public void constructEmpty() throws Exception {
        Scm result = new Scm();

        Assert.assertNull(result.getUrl());
        Assert.assertNull(result.getConnection());
        Assert.assertNull(result.getDeveloperConnection());
    }

    @Test
    public void configure() throws Exception {
        Scm result = new Scm();
        result.configure(new BaseClosure<>(result, this::closureCall));

        Assert.assertEquals(result.getUrl(), "url");
        Assert.assertEquals(result.getConnection(), "connection");
        Assert.assertEquals(result.getDeveloperConnection(), "developerConnection");
    }

    @Test
    public void github() throws Exception {
        Scm result = new Scm();
        result.github("owner", "repo");

        Assert.assertEquals(result.getUrl(), "https://github.com/owner/repo");
        Assert.assertEquals(result.getConnection(), "scm:git:git://github.com/owner/repo.git");
        Assert.assertEquals(result.getDeveloperConnection(), "scm:git:ssh://github.com/owner/repo.git");
    }

    @Test
    public void setFields() throws Exception {
        Scm result = new Scm();
        result.setUrl("url");
        result.setConnection("connection");
        result.setDeveloperConnection("developerConnection");

        Assert.assertEquals(result.getUrl(), "url");
        Assert.assertEquals(result.getConnection(), "connection");
        Assert.assertEquals(result.getDeveloperConnection(), "developerConnection");
    }

    private Scm closureCall(Scm delegate) {
        delegate.setUrl("url");
        delegate.setConnection("connection");
        delegate.setDeveloperConnection("developerConnection");

        return delegate;
    }

}
