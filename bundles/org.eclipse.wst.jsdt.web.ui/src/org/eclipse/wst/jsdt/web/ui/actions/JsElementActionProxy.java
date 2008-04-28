/**
 * 
 */
package org.eclipse.wst.jsdt.web.ui.actions;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.wst.jsdt.core.IJavaScriptElement;
import org.eclipse.wst.jsdt.web.ui.views.contentoutline.IJavaWebNode;

/**
 * @author childsb
 * 
 */
public class JsElementActionProxy extends SimpleJSDTActionProxy {
	/* Util method to get all the java elements in a selection */
	public static IJavaScriptElement[] getJsElementsFromSelection(ISelection selection) {
		if (selection == null) {
			return new IJavaScriptElement[0];
		}
		ArrayList elements = new ArrayList();
		if (selection instanceof IStructuredSelection) {
			Iterator itt = ((IStructuredSelection) selection).iterator();
			while (itt.hasNext()) {
				Object element = itt.next();
				if (element instanceof IJavaScriptElement) {
					elements.add(element);
				}
				if (element instanceof IJavaWebNode) {
					elements.add(((IJavaWebNode) element).getJavaElement());
				}
			}
			return (IJavaScriptElement[]) elements.toArray(new IJavaScriptElement[elements.size()]);
		}
		return new IJavaScriptElement[0];
	}
	
	
	public Object[] getRunArgs(IAction action) {
		/*
		 * Needs to return an array of IJavaElements. Since its one arg of type
		 * IJavaScriptElement[] need to put into an object array
		 */
		return new Object[] { JsElementActionProxy.getJsElementsFromSelection(getCurrentSelection()) };
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.jsdt.web.ui.actions.SimpleJSDTActionProxy#getRunArgTypes()
	 */
	
	public Class[] getRunArgTypes() {
		return new Class[] { (new IJavaScriptElement[0]).getClass() };
	}
}
