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
package pl.rmalinowski.gwt2swf.client;

import pl.rmalinowski.gwt2swf.client.ui.SWFSettings;
import pl.rmalinowski.gwt2swf.client.ui.SWFWidget;
import pl.rmalinowski.gwt2swf.client.utils.PlayerVersion;
import pl.rmalinowski.gwt2swf.client.utils.SWFObjectUtil;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author rmalinowski
 * 
 */
public class GWTFlash implements EntryPoint {
  Button showBtn = new Button("show");

  Button hideBtn = new Button("hide");

  Button removeBtn = new Button("remove");

  Button addBtn = new Button("add");

  Button doubleSizeBtn = new Button("double size");

  Button normalSizeBtn = new Button("normal size");

  Button pixelSizeBtn = new Button("pixel size");

  Button toStringBtn = new Button("to string");

  Button procSizeBtn = new Button("proc size");
  
  TextArea traceArea = new TextArea();
  
  Panel panel = new VerticalPanel();

  public void onModuleLoad() {

    PlayerVersion minPlayerVersion = new PlayerVersion(9, 0, 14);

    boolean versionIsValid = SWFObjectUtil.isVersionIsValid(minPlayerVersion);
    if (!versionIsValid) {
      if (!SWFObjectUtil.isFlashPlayerInstalled()) {
        Window.alert("flash player not installed");
      } else {
        Window.alert("not valid version of installed "
            + "flash player, needed version min: "
            + minPlayerVersion.toString());
      }
    }

    String swfFile = "pasek.swf";
    SWFSettings commonSettings = new SWFSettings();
    commonSettings.setVersion(minPlayerVersion);

    final SWFWidget swfWidget = new SWFWidget(swfFile, "100%", "100%", commonSettings);

    swfWidget.addFlashVar("var1", "value1");
    swfWidget.addFlashVar("var2", "value2");

    swfWidget.addAttribute("attributeName1", "attributeValue1");
    swfWidget.addAttribute("attributeName2", "attributeValue2");

    swfWidget.addParam("paramName1", "paramValue1");
    swfWidget.addParam("paramName2", "paramValue2");

    // desc.setVersion(new PlayerVersion(12));

    // swfWidget.setSize("150", "150");
    panel.setSize("600", "600");
    panel.add(swfWidget);

    RootPanel.get().add(addBtn);
    RootPanel.get().add(removeBtn);
    RootPanel.get().add(showBtn);
    RootPanel.get().add(hideBtn);
    RootPanel.get().add(doubleSizeBtn);
    RootPanel.get().add(normalSizeBtn);
    RootPanel.get().add(pixelSizeBtn);
    RootPanel.get().add(toStringBtn);
    RootPanel.get().add(procSizeBtn);

    RootPanel.get().add(panel);
    traceArea.setSize("750", "400");
    RootPanel.get().add(traceArea);

    // GWT.log(""+swfWidget, null);
    // final SWFPopupPanel popupPanel = new SWFPopupPanel(swfWidget);
    showBtn.addClickListener(new ClickListener() {

      public void onClick(Widget sender) {
        // GWT.log(""+swfWidget, null);
        // swfWidget.setSize("100", "100");
        // GWT.log(""+swfWidget.getElement(), null);
        // popupPanel.show();
        // panel.add(swfWidget);
        swfWidget.setVisible(true);
      }

    });

    hideBtn.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        // panel.remove(swfWidget);
        swfWidget.setVisible(false);
        // popupPanel.hide();
      }
    });

    doubleSizeBtn.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        swfWidget.setSize("400px", "300px");
      }
    });
    normalSizeBtn.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        swfWidget.setSize("200px", "150px");
      }
    });
    pixelSizeBtn.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        swfWidget.setPixelSize(300, 230);
      }
    });
    addBtn.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        panel.add(swfWidget);
      }
    });
    removeBtn.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        panel.remove(swfWidget);
        // swfWidget = null;
      }
    });
    toStringBtn.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        traceArea.setText(swfWidget.getElement().getInnerHTML());
      }
    });
    procSizeBtn.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        swfWidget.setSize("100%", "100%");
      }
    });
  }

}
