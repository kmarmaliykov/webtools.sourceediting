package org.eclipse.wst.html.ui.tests.validation;

import org.eclipse.wst.html.core.internal.validate.Segment;
import org.eclipse.wst.html.core.validate.extension.HTMLCustomAttributeValidator;
import org.eclipse.wst.sse.core.internal.validate.ValidationMessage;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMElement;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;

public class CustomExtendedAttributeValidator extends HTMLCustomAttributeValidator {

	public void init() {
		// do nothing		
	}

	public boolean canValidate(IDOMElement target) {
		if (target.getLocalName().startsWith("eclipse")) {
			return true;
		}
		return false;
	}


	public ValidationMessage validateAttribute(IDOMElement target, String attrName) {
		if ("plugins".equals(attrName)) {
			try {
				String attrValue = target.getAttribute(attrName);
				Integer.parseInt(attrValue);
			} catch (NumberFormatException e) {
				Segment segment = getAttributeSegment((IDOMNode)target.getAttributeNode(attrName), REGION_NAME);
				return new ValidationMessage("Attribute should be integer", segment.getOffset(), segment.getLength(), ValidationMessage.ERROR);				
			}
		}
		return null;
	}
}
