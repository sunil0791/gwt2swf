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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

public class SWFCallableWidget extends SWFWidget{



/**
   * @param src
   */
  public SWFCallableWidget(String src) {
    super(src);
    // TODO Auto-generated constructor stub
  }

//	To działa prawidłowo 
	private native JavaScriptObject _call(Element flashObject,String methodName)/*-{

 return flashObject[methodName]();

	}-*/;
	
	//To dzilaa prawidlowo
	private native void  _callForFlashInfo(Element flashObject) /*-{
		var flash = flashObject;
		var flashInfo = flash.getFlashInfo();
		var str = "";
		for(var key in flashInfo) {
			str += key + ": " + flashInfo[key] + "\n";
		}
		$wnd.alert(str);

	}-*/;

	
	public JavaScriptObject call(String methodName) {
		
		//_callForFlashInfo(DOM.getElementById(super.getSwfId()));
		
		return _call(DOM.getElementById(super.getSwfId()), methodName);
//		_call(DOM.getElementById(super.getSwfId()), "getFlashInfo");
	}
}
