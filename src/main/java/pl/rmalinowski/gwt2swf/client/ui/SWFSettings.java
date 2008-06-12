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

import java.util.HashMap;
import java.util.Map;

import pl.rmalinowski.gwt2swf.client.ui.exceptions.GWT2SWFRuntimeException;
import pl.rmalinowski.gwt2swf.client.utils.PlayerVersion;
import pl.rmalinowski.gwt2swf.client.utils.SWFObjectUtil;

// http://www.adobe.com/cfusion/knowledgebase/index.cfm?id=tn_12701
public class SWFSettings {
	// swf, id, w, h, ver, c, useExpressInstall, quality, xiRedirectUrl,
	// redirectUrl, detectKey
	// public static final String DEFAULT_BGCOLOR = "ffffff";

	public static final String DEFAULT_INNER_DIV_TEXT_FOR_FLASH_PLAYER_NOT_FOUND = "Here should be a swf movieclip. "
			+ "You probably don't have FlashPlayer installed or have a PlayerVersion lower than ${flashPlayer.version}.";

	public static final PlayerVersion DEFAULT_MIN_PLAYER_VERSION = new PlayerVersion(7, 0, 14); // = "7.0.14";

	public static final SWFSettings DEFAULT_SWF_SETTINGS = new SWFSettings();
  	
	
	private String innerDivTextForFlashPlayerNotFound = DEFAULT_INNER_DIV_TEXT_FOR_FLASH_PLAYER_NOT_FOUND;
	
	private PlayerVersion minPlayerVersion = DEFAULT_MIN_PLAYER_VERSION;	

	//String bgcolor = DEFAULT_BGCOLOR;


	//String quality;

	//String xiRedirectUrl, redirectUrl, detectKey;

	public static SWFSettings getDefaultSWFSettings() {
	  return DEFAULT_SWF_SETTINGS;
	}
	
	public SWFSettings() {
	}

	public PlayerVersion getMinPlayerVersion() {
		return minPlayerVersion;
	}

	public void setMinPlayerVersion(PlayerVersion version) {
		this.minPlayerVersion = version;
	}
	
	/**
   * @return the innerDivTextForFlashPlayerNotFound
   */
  public String getInnerDivTextForFlashPlayerNotFound() {
    return innerDivTextForFlashPlayerNotFound;
  }

  /**
   * @param innerDivTextForFlashPlayerNotFound
   *            the innerDivTextForFlashPlayerNotFound to set
   */
  public void setInnerDivTextForFlashPlayerNotFound(
      String text) {
    this.innerDivTextForFlashPlayerNotFound = text;
  }

  // public String getRedirectUrl() {
  // return redirectUrl;
  // }
  //
  // public void setRedirectUrl(String redirectUrl) {
  // this.redirectUrl = redirectUrl;
  // }
  // public String getWidth() {
  // return width;
  // }

  // public String getXiRedirectUrl() {
  // return xiRedirectUrl;
  // }

  // public void setXiRedirectUrl(String xiRedirectUrl) {
  // this.xiRedirectUrl = xiRedirectUrl;
  //	}
  // public String getQuality() {
  // return quality;
  // }
  //
  // public void setQuality(String quality) {
  // this.quality = quality;
  //  }
  // public String getBgcolor() {
  // return bgcolor;
  // }
  //
  // public void setBgcolor(String bgcolor) {
  // if (bgcolor == null)
  // throw new NullPointerException();
  // this.bgcolor = bgcolor;
  // }
  //
  // public String getDetectKey() {
  // return detectKey;
  // }
  //
  // public void setDetectKey(String detectKey) {
  // this.detectKey = detectKey;
  //	  }
	/**
	 * Sets the swf object's height.
	 * 
	 * @param height
	 *            the swf object's new height, in CSS units (e.g. "10px", "2em" ,
	 *            "100%")
	 * @throws RuntimeException
	 *             if height < 0
	 */
//	public void setHeight(String height) {
//		if (!(parseLength(height.trim().toLowerCase()) >= 0))
//			throw new RuntimeException("CSS heights should not be negative");
//		this.height = height;
//	}

	/**
	 * Sets the swf object's size, in pixels.
	 * 
	 * @param width
	 *            the swf object's new width, in pixels
	 * @param height
	 *            the swf object's new height, in pixels
	 */
//	public void setPixelSize(int width, int height) {
//		if (width >= 0) {
//			setWidth(width + "px");
//		}
//		if (height >= 0) {
//			setHeight(height + "px");
//		}
//	}

	/**
	 * Sets the swf object's size.
	 * 
	 * @param width
	 *            the swf object's new width, in CSS units (e.g. "10px", "2em",
	 *            "100%")
	 * @param height
	 *            the swf object's new height, in CSS units (e.g. "10px", "2em",
	 *            "100%")
	 */
//	public void setSize(String width, String height) {
//		setWidth(width);
//		setHeight(height);
//	}

	/**
	 * Sets the swf object's width.
	 * 
	 * @param width
	 *            the swf object's new width, in CSS units (e.g. "10px", "2em",
	 *            "100%")
	 * @throws RuntimeException
	 *             if width < 0
	 */
//	public void setWidth(String width) {
//		if (!(parseLength(width.trim().toLowerCase()) >= 0))
//			throw new RuntimeException("CSS widths should not be negative");
//		this.width = width;
//	}

	



}
