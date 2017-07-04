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
import org.starchartlabs.flare.publishing.model.DeveloperContainer;
import org.starchartlabs.flare.test.publishing.BaseClosure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeveloperContainerTest {

    @Test
    public void constructEmpty() throws Exception {
        DeveloperContainer result = new DeveloperContainer();

        Assert.assertNotNull(result.getDevelopers());
        Assert.assertTrue(result.getDevelopers().isEmpty());
    }

    @Test
    public void configure() throws Exception {
        DeveloperContainer result = new DeveloperContainer();
        result.configure(new BaseClosure<>(result, this::closureCall));

        Assert.assertNotNull(result.getDevelopers());
        Assert.assertEquals(result.getDevelopers().size(), 1);

        Developer developer = result.getDevelopers().stream().findAny().orElse(null);

        Assert.assertNotNull(developer);
        Assert.assertEquals(developer.getId(), "id");
        Assert.assertEquals(developer.getName(), "name");
        Assert.assertEquals(developer.getUrl(), "url");
    }

    @Test
    public void addDeveloper() throws Exception {
        DeveloperContainer result = new DeveloperContainer();
        result.developer("id", "name", "url");

        Assert.assertNotNull(result.getDevelopers());
        Assert.assertEquals(result.getDevelopers().size(), 1);

        Developer developer = result.getDevelopers().stream().findAny().orElse(null);

        Assert.assertNotNull(developer);
        Assert.assertEquals(developer.getId(), "id");
        Assert.assertEquals(developer.getName(), "name");
        Assert.assertEquals(developer.getUrl(), "url");
    }

    @Test
    public void addDeveloperClosure() throws Exception {
        DeveloperContainer result = new DeveloperContainer();
        result.developer(new BaseClosure<>(result, this::developerClosureCall));

        Assert.assertNotNull(result.getDevelopers());
        Assert.assertEquals(result.getDevelopers().size(), 1);

        Developer developer = result.getDevelopers().stream().findAny().orElse(null);

        Assert.assertNotNull(developer);
        Assert.assertEquals(developer.getId(), "id");
        Assert.assertEquals(developer.getName(), "name");
        Assert.assertEquals(developer.getUrl(), "url");
    }

    @Test
    public void addGitHubDeveloper() throws Exception {
        DeveloperContainer result = new DeveloperContainer();
        result.github("id", "name");

        Assert.assertNotNull(result.getDevelopers());
        Assert.assertEquals(result.getDevelopers().size(), 1);

        Developer developer = result.getDevelopers().stream().findAny().orElse(null);

        Assert.assertNotNull(developer);
        Assert.assertEquals(developer.getId(), "id");
        Assert.assertEquals(developer.getName(), "name");
        Assert.assertEquals(developer.getUrl(), "https://github.com/id");
    }

    @Test
    public void addGitHubDeveloperClosure() throws Exception {
        DeveloperContainer result = new DeveloperContainer();
        result.github(new BaseClosure<>(result, this::githubClosureCall));

        Assert.assertNotNull(result.getDevelopers());
        Assert.assertEquals(result.getDevelopers().size(), 1);

        Developer developer = result.getDevelopers().stream().findAny().orElse(null);

        Assert.assertNotNull(developer);
        Assert.assertEquals(developer.getId(), "id");
        Assert.assertEquals(developer.getName(), "name");
        Assert.assertEquals(developer.getUrl(), "https://github.com/id");
    }

    @Test
    public void addGitHubDeveloperClosureUrlSet() throws Exception {
        DeveloperContainer result = new DeveloperContainer();
        result.github(new BaseClosure<>(result, this::developerClosureCall));

        Assert.assertNotNull(result.getDevelopers());
        Assert.assertEquals(result.getDevelopers().size(), 1);

        Developer developer = result.getDevelopers().stream().findAny().orElse(null);

        Assert.assertNotNull(developer);
        Assert.assertEquals(developer.getId(), "id");
        Assert.assertEquals(developer.getName(), "name");
        Assert.assertEquals(developer.getUrl(), "url");
    }

    private DeveloperContainer closureCall(DeveloperContainer delegate) {
        delegate.developer("id", "name", "url");

        return delegate;
    }

    private Developer developerClosureCall(Developer delegate) {
        delegate.setId("id");
        delegate.setName("name");
        delegate.setUrl("url");

        return delegate;
    }

    private Developer githubClosureCall(Developer delegate) {
        delegate.setId("id");
        delegate.setName("name");

        return delegate;
    }

}
