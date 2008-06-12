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


package pl.rmalinowski.gwt2swf.client.ui.exceptions;

/**
 * @author Rafal Malinowski 
 *
 */
public class GWT2SWFRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3894636978597293493L;

	/**
	 * 
	 */
	public GWT2SWFRuntimeException() {
	}

	/**
	 * @param message
	 */
	public GWT2SWFRuntimeException(String message) {
		super(message);
	}

	/**
	 * @param couse
	 */
	public GWT2SWFRuntimeException(Throwable couse) {
		super(couse);
	}

	/**
	 * @param message
	 * @param couse
	 */
	public GWT2SWFRuntimeException(String message, Throwable couse) {
		super(message, couse);
	}

}
