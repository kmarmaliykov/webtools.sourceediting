package org.eclipse.wst.html.core.validate.extension;

import org.eclipse.wst.sse.core.internal.validate.ValidationMessage;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMElement;

public interface IHTMLCustomAttributeValidator {
	/**
	 * Validator initialization. This method is called before validator loading.
	 */
	public void init();
	
	/**
	 * 
	 * @param target tag to be validated
	 * @return <code>true</code> if validator can validate tag
	 */
	public boolean canValidate(IDOMElement target);
	
	/**Validates specified attribute of specified tag
	 * 
	 * @param target tag to be validated
	 * @param attrName attribute to be validated
	 * @return <code>null</code> if no error happens or {@link ValidationMessage} with error message and error region
	 */
	public ValidationMessage validateAttribute(IDOMElement target, String attrName);
}
