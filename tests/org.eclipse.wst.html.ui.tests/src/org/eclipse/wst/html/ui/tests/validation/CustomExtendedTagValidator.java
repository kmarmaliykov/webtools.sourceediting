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
package org.eclipse.wst.html.ui.tests.validation;

import org.eclipse.wst.html.core.internal.validate.Segment;
import org.eclipse.wst.html.core.validate.extension.CustomValidatorUtil;
import org.eclipse.wst.html.core.validate.extension.IHTMLCustomTagValidator;
import org.eclipse.wst.sse.core.internal.validate.ValidationMessage;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMElement;

public class CustomExtendedTagValidator implements IHTMLCustomTagValidator{

	public boolean canValidate(IDOMElement target) {
		if (target.getLocalName().startsWith("eclipse")) {
			return true;
		}
		return false;
	}

	public void init() {
		//do nothing
	}

	public ValidationMessage validateTag(IDOMElement target) {
		String tagName = target.getLocalName();
		if (tagName.contains("thym")) {
			Segment segment = CustomValidatorUtil.getTagSegment(target, CustomValidatorUtil.SEG_START_TAG_NAME);
			return new ValidationMessage("Thym is available only with external installation", segment.getOffset(), segment.getLength(), ValidationMessage.ERROR);
		}
		return null;
	}
}
