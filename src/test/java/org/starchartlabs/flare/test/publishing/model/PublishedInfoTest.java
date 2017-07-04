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

import org.starchartlabs.flare.publishing.model.Developer;
import org.starchartlabs.flare.publishing.model.DeveloperContainer;
import org.starchartlabs.flare.publishing.model.License;
import org.starchartlabs.flare.publishing.model.LicenseContainer;
import org.starchartlabs.flare.publishing.model.PublishedInfo;
import org.starchartlabs.flare.publishing.model.Scm;
import org.starchartlabs.flare.test.publishing.BaseClosure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PublishedInfoTest {

    @Test
    public void construct() throws Exception {
        PublishedInfo result = new PublishedInfo();

        Assert.assertNotNull(result.getScm());

        Assert.assertNotNull(result.getLicenses());
        Assert.assertTrue(result.getLicenses().isEmpty());

        Assert.assertNotNull(result.getDevelopers());
        Assert.assertTrue(result.getDevelopers().isEmpty());
    }

    @Test
    public void scm() throws Exception {
        PublishedInfo result = new PublishedInfo();
        result.scm(new BaseClosure<>(result, this::scmClosureCall));

        Assert.assertEquals(result.getScm().getUrl(), "url");
        Assert.assertEquals(result.getScm().getConnection(), "connection");
        Assert.assertEquals(result.getScm().getDeveloperConnection(), "developerConnection");
    }

    @Test
    public void licenses() throws Exception {
        PublishedInfo result = new PublishedInfo();
        result.licenses(new BaseClosure<>(result, this::licensesClosureCall));

        Assert.assertEquals(result.getLicenses().size(), 1);

        License license = result.getLicenses().stream().findAny().orElse(null);

        Assert.assertNotNull(license);
        Assert.assertEquals(license.getName(), "name");
        Assert.assertEquals(license.getTag(), "tag");
        Assert.assertEquals(license.getUrl(), "url");
        Assert.assertEquals(license.getDistribution(), "distribution");
    }

    @Test
    public void developers() throws Exception {
        PublishedInfo result = new PublishedInfo();
        result.developers(new BaseClosure<>(result, this::developersClosureCall));

        Assert.assertEquals(result.getDevelopers().size(), 1);

        Developer developer = result.getDevelopers().stream().findAny().orElse(null);

        Assert.assertNotNull(developer);
        Assert.assertEquals(developer.getId(), "id");
        Assert.assertEquals(developer.getName(), "name");
        Assert.assertEquals(developer.getUrl(), "url");
    }

    private Scm scmClosureCall(Scm delegate) {
        delegate.setUrl("url");
        delegate.setConnection("connection");
        delegate.setDeveloperConnection("developerConnection");

        return delegate;
    }

    private LicenseContainer licensesClosureCall(LicenseContainer delegate) {
        delegate.license("name", "tag", "url", "distribution");

        return delegate;
    }

    private DeveloperContainer developersClosureCall(DeveloperContainer delegate) {
        delegate.developer("id", "name", "url");

        return delegate;
    }

}
