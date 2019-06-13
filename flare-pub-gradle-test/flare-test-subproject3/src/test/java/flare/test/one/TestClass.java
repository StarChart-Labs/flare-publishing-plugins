/*
 * Copyright (c) Jun 19, 2017 Corona IDE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    "romeara" - initial API and implementation and/or initial documentation
 */
package flare.test.one;

import org.testng.annotations.Test;

public class TestClass {

    @Test
    public void test() throws Exception {
        TestTarget.doNothing();
    }

}
