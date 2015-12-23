package org.eclipse.wst.html.core.validate.extension;

import org.eclipse.wst.html.core.internal.validate.HTMLAttributeValidator;
import org.eclipse.wst.html.core.internal.validate.Segment;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;

public abstract class HTMLCustomAttributeValidator implements IHTMLCustomAttributeValidator {
	public static final int REGION_NAME = HTMLAttributeValidator.REGION_NAME;
	public static final int REGION_VALUE = HTMLAttributeValidator.REGION_VALUE;
	
	/**Error segment for attribute validation
	 * 
	 * @param errorNode attribute with error
	 * @param regionType type of region where error marker should be placed
	 * @return {@link Segment} which determines error marker location
	 */
	public final static Segment getAttributeSegment(IDOMNode errorNode, int regionType) {
		return HTMLAttributeValidator.getErrorSegment(errorNode, regionType);
	}

}
