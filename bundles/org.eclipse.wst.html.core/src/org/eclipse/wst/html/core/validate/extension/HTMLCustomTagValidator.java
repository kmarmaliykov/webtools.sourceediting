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
package org.eclipse.wst.html.core.validate.extension;

import org.eclipse.wst.html.core.internal.validate.FMUtil;
import org.eclipse.wst.html.core.internal.validate.Segment;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;

public abstract class HTMLCustomTagValidator implements IHTMLCustomTagValidator{
	public final static int SEG_NONE = FMUtil.SEG_NONE;
	public final static int SEG_WHOLE_TAG = FMUtil.SEG_WHOLE_TAG;
	public final static int SEG_START_TAG = FMUtil.SEG_START_TAG;
	public final static int SEG_END_TAG = FMUtil.SEG_END_TAG;
	public final static int SEG_START_TAG_NAME = FMUtil.SEG_START_TAG_NAME;
	public final static int SEG_END_TAG_NAME = FMUtil.SEG_END_TAG_NAME;
	
	/**Error segment for tag validation
	 * 
	 * @param target tag with error
	 * @param segType type of segment where error marker should be placed
	 * @return {@link Segment} which determines error marker location
	 */
	public final static Segment getTagSegment(IDOMNode target, int segType) {
		return FMUtil.getSegment(target, segType);
	}
}
