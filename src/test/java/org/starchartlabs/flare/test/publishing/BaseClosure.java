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
package org.starchartlabs.flare.test.publishing;

import java.util.Objects;
import java.util.function.Function;

import groovy.lang.Closure;

public class BaseClosure<T> extends Closure<T> {

    private static final long serialVersionUID = 1L;

    private final Function<T, T> operation;

    public BaseClosure(Object owner, Function<T, T> operation) {
        super(owner);
        this.operation = Objects.requireNonNull(operation);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T call() {
        T delegate = (T) getDelegate();

        return operation.apply(delegate);
    }

}
