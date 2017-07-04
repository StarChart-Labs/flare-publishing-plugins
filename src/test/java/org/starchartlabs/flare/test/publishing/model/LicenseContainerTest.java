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
import org.starchartlabs.flare.publishing.model.LicenseContainer;
import org.starchartlabs.flare.test.publishing.BaseClosure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LicenseContainerTest {

    @Test
    public void constructEmpty() throws Exception {
        LicenseContainer result = new LicenseContainer();

        Assert.assertNotNull(result.getLicenses());
        Assert.assertTrue(result.getLicenses().isEmpty());
    }

    @Test
    public void configure() throws Exception {
        LicenseContainer result = new LicenseContainer();

        result.configure(new BaseClosure<>(result, this::closureCall));

        Assert.assertNotNull(result.getLicenses());
        Assert.assertEquals(result.getLicenses().size(), 1);

        License license = result.getLicenses().stream().findAny().orElse(null);

        Assert.assertNotNull(license);
        Assert.assertEquals(license.getName(), "name");
        Assert.assertEquals(license.getTag(), "tag");
        Assert.assertEquals(license.getUrl(), "url");
        Assert.assertEquals(license.getDistribution(), "distribution");
    }

    @Test
    public void addLicense() throws Exception {
        LicenseContainer result = new LicenseContainer();

        result.license("name", "tag", "url", "distribution");

        Assert.assertNotNull(result.getLicenses());
        Assert.assertEquals(result.getLicenses().size(), 1);

        License license = result.getLicenses().stream().findAny().orElse(null);

        Assert.assertNotNull(license);
        Assert.assertEquals(license.getName(), "name");
        Assert.assertEquals(license.getTag(), "tag");
        Assert.assertEquals(license.getUrl(), "url");
        Assert.assertEquals(license.getDistribution(), "distribution");
    }

    @Test
    public void addLicenseClosure() throws Exception {
        LicenseContainer result = new LicenseContainer();

        result.license(new BaseClosure<>(result, this::licenseClosureCall));

        Assert.assertNotNull(result.getLicenses());
        Assert.assertEquals(result.getLicenses().size(), 1);

        License license = result.getLicenses().stream().findAny().orElse(null);

        Assert.assertNotNull(license);
        Assert.assertEquals(license.getName(), "name");
        Assert.assertEquals(license.getTag(), "tag");
        Assert.assertEquals(license.getUrl(), "url");
        Assert.assertEquals(license.getDistribution(), "distribution");
    }

    @Test
    public void addMitLicense() throws Exception {
        LicenseContainer result = new LicenseContainer();

        result.mit("distribution");

        Assert.assertNotNull(result.getLicenses());
        Assert.assertEquals(result.getLicenses().size(), 1);

        License license = result.getLicenses().stream().findAny().orElse(null);

        Assert.assertNotNull(license);
        Assert.assertEquals(license.getName(), "The MIT License");
        Assert.assertEquals(license.getTag(), "MIT");
        Assert.assertEquals(license.getUrl(), "https://opensource.org/licenses/MIT");
        Assert.assertEquals(license.getDistribution(), "distribution");
    }

    @Test
    public void addEplLicense() throws Exception {
        LicenseContainer result = new LicenseContainer();

        result.epl("distribution");

        Assert.assertNotNull(result.getLicenses());
        Assert.assertEquals(result.getLicenses().size(), 1);

        License license = result.getLicenses().stream().findAny().orElse(null);

        Assert.assertNotNull(license);
        Assert.assertEquals(license.getName(), "Eclipse Public License 1.0");
        Assert.assertEquals(license.getTag(), "EPL");
        Assert.assertEquals(license.getUrl(), "https://opensource.org/licenses/EPL-1.0");
        Assert.assertEquals(license.getDistribution(), "distribution");
    }

    private LicenseContainer closureCall(LicenseContainer delegate) {
        delegate.license("name", "tag", "url", "distribution");

        return delegate;
    }

    private License licenseClosureCall(License delegate) {
        delegate.setName("name");
        delegate.setTag("tag");
        delegate.setUrl("url");
        delegate.setDistribution("distribution");

        return delegate;
    }
}
