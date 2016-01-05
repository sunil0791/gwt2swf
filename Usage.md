## Adding gwt2swf to your project ##

To add gwt2swf to your project you need to update your projectName.gwt.xml file and add:



&lt;inherits name='pl.rmalinowski.gwt2swf.GWT2SWF' /&gt;



into xml node 'module'.
And of course gwt2swf.jar file should be in your project classpath.

## Basic usage ##

```
  SWFWidget swfWidget = new SWFWidget(swfFileName, width, height);

  RootPanel.get().add(swfWidget);
```

Other examples:

```
  SWFWidget swfWidget = new SWFWidget("my.swf");
  SWFWidget swfWidget = new SWFWidget("my.swf", 50, 100);
  SWFWidget swfWidget = new SWFWidget("my.swf", "50px", "100px");
```


## Changing SWFWidget size and visibility ##

You can dynamically change the size and visibility of SWFWidget.

```
  SWFWidget swfWidget = new SWFWidget("my.swf");
  swfWidget.setPixelSize(20, 10);
  RootPanel.get().add(swfWidget);
  
  RootPanel.get().add(new Button("resize", new ClickListener() {
    public void onClick(Widget sender) {
      swfWidget.setSize("400px", "300px");
    }
  }));

  RootPanel.get().add(new Button("hide", new ClickListener() {
    public void onClick(Widget sender) {
      swfWidget.setVisible(false);
    }
  }));
```

## Setting swf properties, flashvars and DOM attributes ##

```
  SWFWidget swfWidget = new SWFWidget("my.swf", 100, 100);

  swfWidget.addFlashVar("var1", "value1");
  swfWidget.addFlashVar("var2", "value2");
  
  swfWidget.addAttribute("attributeName1", "attributeValue1");
  swfWidget.addAttribute("attributeName2", "attributeValue2");
  
  swfWidget.addParam("paramName1", "paramValue1");
  swfWidget.addParam("paramName2", "paramValue2");

  RootPanel.get().add(swfWidget);
```

The generated code will look like this (for firefox):

```
  <object style="visibility: visible;"
          id="swfID_0"
          data="my.swf"
          attributename2="attributeValue2"
          attributename1="attributeValue1"
          type="application/x-shockwave-flash"
          height="100"
          width="100">
      <param value="paramValue1" name="paramName1" >
      <param value="paramValue2" name="paramName2" >
      <param value="vr1=value1&amp;var2=value2" name="flashvars" >
  </object>
```

Setting flash parameter 'wmode' to value 'transparent' will look like this:

```
  SWFWidget swfWidget = new SWFWidget("my.swf", 100, 100);
  
  swfWidget.addParam("wmode", "transparent");

  RootPanel.get().add(swfWidget);
```


## Forbidden attributes and parameters ##

> Forbidden attributes :
    * id - GWT2SWF generates this automatically
    * classid - SWFObject publishes this automatically for Internet Explorer on Windows
    * type - SWFObject publishes this automatically for all browsers except Internet Explorer on Windows
    * codebase - deprecated

> Forbidden parameters :
    * movie - use the object element's data attribute instead, SWFObject publishes this automatically for Internet Explorer on Windows

## SWFObjectUtil ##

Using SWFObjectUtil you can obtain the current version of flash player .

```
  SWFObjectUtil.getPlayerVersion();  
```

You can also check if your required version of flash player is installed.

```
  PlayerVersion minPlayerVersion = new PlayerVersion(999, 0, 14);
  boolean isVersionIsValid = SWFObjectUtil.isVersionIsValid(minPlayerVersion);

  if (!versionIsValid) {
    if (!SWFObjectUtil.isFlashPlayerInstalled()) {
      Window.alert("flash player not installed");

    } else {
      Window.alert("not valid version of installed "
          + "flash player, needed version min: "
          + minPlayerVersion.toString());

    }
  }

```

## Setting required version of flash player ##

You can set the minimum version of Flash Player. If the version of Flash Player will be less than that minimum then SWFWidget wont be injected into web page and will be shown on page DEFAULT\_INNER\_DIV\_TEXT\_FOR\_FLASH\_PLAYER\_NOT\_FOUND text.

```
  SWFWidget swfWidget = new SWFWidget("my.swf");
  swfWidget.setMinPlayerVersion(new PlayerVersion(9, 0, 14));

  RootPanel.get().add(swfWidget);

```

## SWFSettings ##

With SWFSetting you can set common parameters for various sfwWidgets:

```

  SWFSettings commonSettings = new SWFSettings();

  PlayerVersion minPlayerVersion = new PlayerVersion(9, 0, 14);
 
  commonSettings.setMinPlayerVersion(minPlayerVersion);

  commonSettings.setInnerDivTextForFlashPlayerNotFound("Here should be a my.swf movieclip.");
  
  SWFWidget swfWidget = new SWFWidget("my.swf", "100", "100", commonSettings);
```

If you will not set SWFSettings for particular swfWidget then the default values will be taken.

Defalut values for SWFSettings are:

```
public static final String DEFAULT_INNER_DIV_TEXT_FOR_FLASH_PLAYER_NOT_FOUND 
  = "Here should be a swf movieclip. "
  + "You probably don't have FlashPlayer installed " 
  + "or have a PlayerVersion lower than ${flashPlayer.version}.";

public static final PlayerVersion DEFAULT_MIN_PLAYER_VERSION 
   = new PlayerVersion(7, 0, 14); // = "7.0.14";
```

The ${flashPlayer.version} parameter will be automatically converted to required versions of flashplayera

## More ##

You can set the size of swfWidget using percentages, such as "100%"
```
  SWFWidget swfWidget = new SWFWidget("my.swf");
  swfWidget.setWidth("100%");
```