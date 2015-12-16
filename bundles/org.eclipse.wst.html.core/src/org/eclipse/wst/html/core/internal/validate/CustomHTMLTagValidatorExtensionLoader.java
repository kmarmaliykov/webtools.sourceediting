/*******************************************************************************
 * Copyright (c) 2015 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.html.core.internal.validate;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.wst.html.core.validate.extension.HTMLCustomTagValidator;
import org.eclipse.wst.sse.core.internal.Logger;

public class CustomHTMLTagValidatorExtensionLoader {
	private List<HTMLCustomTagValidator> validators;
	
	public List<HTMLCustomTagValidator> getValidators() {
		return validators;
	}
	
	private CustomHTMLTagValidatorExtensionLoader() {
		validators = new ArrayList<HTMLCustomTagValidator>();
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.wst.html.core.customTagValidator");
		for (IConfigurationElement e : configurationElements) {
			try {
				HTMLCustomTagValidator validator = (HTMLCustomTagValidator) e.createExecutableExtension("class");
				validators.add(validator);
				validator.init();
			} catch (CoreException e1) {
				Logger.logException(e1);
			}
		}
	}

	private static class UnknownValidatorExtensionLoaderHolder {
		public static final CustomHTMLTagValidatorExtensionLoader instance = new CustomHTMLTagValidatorExtensionLoader();
	}

	public static CustomHTMLTagValidatorExtensionLoader getInstance() {
		return UnknownValidatorExtensionLoaderHolder.instance;
	}
}
