/*
 *    Copyright 2007 Rafal M.Malinowski
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *   
 */

package pl.rmalinowski.gwt2swf.client.ui;

import java.util.Map;

import pl.rmalinowski.gwt2swf.client.utils.SWFObjectUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author Rafal M.Malinowski
 * 
 */
public class SWFWidget extends Widget {

	private final SWFSettings swfSettings;

	private static int count = 0;

	private final static String divPrefix = "swfDivID_";

	private final String swfDivId;

	private final static String idPrefix = "swfID_";

	private final String swfId;

	private boolean isSWFInjected = false;

	protected native void injectSWF(String swf, String id, String w, String h,
			String ver, Map<String, String> flashvars,
			Map<String, String> params, Map<String, String> attributes) /*-{
	       
	        var _vars = @pl.rmalinowski.gwt2swf.client.utils.SWFObjectUtil::convertHashMapToJSArray(Ljava/util/Map;)(flashvars);
	        var _params = @pl.rmalinowski.gwt2swf.client.utils.SWFObjectUtil::convertHashMapToJSArray(Ljava/util/Map;)(params);
	        var _attributes = @pl.rmalinowski.gwt2swf.client.utils.SWFObjectUtil::convertHashMapToJSArray(Ljava/util/Map;)(attributes);
	         
	        $wnd.swfobject.embedSWF(swf, id, w, h, ver, null , _vars, _params, _attributes);
	         
	     }-*/;

	public SWFWidget() {
		this(new SWFSettings());
	}

	public SWFWidget(String src, Integer width, Integer height) {
		this(new SWFSettings(src, width, height));
	}

	public SWFWidget(String src, Integer width, Integer height, String bgcolor) {
		this(new SWFSettings(src, width, height, bgcolor));
	}

	public SWFWidget(String src, int width, int height) {
		this(new SWFSettings(src, width, height));
	}

	public SWFWidget(String src, String width, String height) {
		this(new SWFSettings(src, width, height));
	}

	public SWFWidget(String src, int width, int height, String bgcolor) {
		this(new SWFSettings(src, width, height, bgcolor));
	}

	public SWFWidget(String src, String width, String height, String bgcolor) {
		this(new SWFSettings(src, width, height, bgcolor));
	}

	public SWFWidget(SWFSettings settings) {
		swfSettings = settings;
		swfId = idPrefix + count;
		swfDivId = divPrefix + count;
		++count;
		Element element = DOM.createElement("div");
		DOM.setElementProperty(element, "id", swfDivId);

		// add new div which will be replaced by SWFObject
		
		setElement(element);

	}

	private void initEmptyInnerDiv() {
		String notifyText = swfSettings.getInnerTextDivForFlashPlayerNotFound()
				.replaceAll("\\$flashPlayer.version",
						getSwfSettings().getVersion().toString());
		getElement().setInnerHTML(
				"<div id=\"" + swfId + "\">" + notifyText + "</div>");
	}

	protected void onLoad() {
		if (!isSWFInjected) {
			initEmptyInnerDiv();
			onBeforeSWFInjection();
			injectSWF(swfSettings.getSrc(), getSwfId(), swfSettings.getWidth(),
					swfSettings.getHeight(), swfSettings.getVersion()
							.toString(), swfSettings.getFlashVars(), swfSettings
							.getParams(), swfSettings.getAttributes());
			isSWFInjected = true;
			onAfterSWFInjection();
		}
		super.onLoad();
	}

	/**
	 * Override this method to catch information about swf injected. The default
	 * implementation does nothing and need not be called by subclasses.
	 */
	protected void onAfterSWFInjection() {

	}

	/**
	 * Override this method to catch information about swf injection. The
	 * default implementation does nothing and need not be called by subclasses.
	 */
	protected void onBeforeSWFInjection() {

	}

	protected void onUnload() {
		//GWT.log("onUnload", null);
		getElement().removeChild(DOM.getFirstChild(getElement()));
		isSWFInjected = false;
		super.onUnload();
	}

	/**
	 * 
	 * @Deprecated use setVisible(true)
	 */
	public void show() {
		setVisible(true);
	}

	/**
	 * 
	 * @Deprecated use setVisible(false)
	 */
	public void hide() {
		setVisible(false);

	}

	/**
	 * auto generated swf div ID
	 * 
	 * @return
	 */
	protected String getSwfDivId() {
		return swfDivId;
	}

	/**
	 * auto genereted swf ID
	 * 
	 * @return
	 */
	protected String getSwfId() {
		return swfId;
	}

	/**
	 * @return the swfSettings
	 */
	public SWFSettings getSwfSettings() {
		return swfSettings;
	}

	/**
	 * Sets the swf object's height.
	 * 
	 * @param height
	 *            the swf object's new height, in CSS units (e.g. "10px", "1em" ,
	 *            "100%")
	 */
	public void setHeight(String height) {
		getSwfSettings().setHeight(height);
		if (isSWFInjected) {
			Element elem = DOM.getFirstChild(getElement());
			DOM.setElementAttribute(elem, "height", height);
		}

		super.setHeight(height);
	}

	/**
	 * Sets the swf object's size, in pixels.
	 * 
	 * @param width
	 *            the swf object's new width, in pixels
	 * @param height
	 *            the swf object's new height, in pixels
	 */
	public void setPixelSize(int width, int height) {
		super.setPixelSize(width, height);
	}

	/**
	 * Sets the swf object's width.
	 * 
	 * @param width
	 *            the swf object's new width, in CSS units (e.g. "10px", "1em",
	 *            "100%")
	 */
	public void setWidth(String width) {
		getSwfSettings().setWidth(width);
		if (isSWFInjected) {
			Element elem = DOM.getFirstChild(getElement());
			DOM.setElementAttribute(elem, "width", width);
		}
		super.setWidth(width);
	}

}
