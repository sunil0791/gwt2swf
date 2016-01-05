### version 0.6.0 ###

  * compatibility with GWT 1.5 has been ensured (but for backward compatibility Java generics are not used)
  * Embedded SWFObject has been upgraded to version 2.0.
  * Class SWFParams has been changed to SWFSettings.
  * The ability to set swf attributes and parameters has been added.
  * Resizing of swf has been fixed


### version 0.4.0 ###

  * SWFWidget is now a real Widget (it was composite before).
  * An isFlashPlayer installed method in SWFObjectUtil has been added.
  * The ability to set the size of swf as string in CSS units (e.g. "10px", "2em", "100%") has been added.
  * The ability to add variables has been added.
  * An error with FlashPlayer version checking and validation has been fixed.
  * Protected methods have been added to SWFWidget: onBeforeSWFInjection and onAfterSWFInjection (these help in extending SWFWidget).
  * Documentation has been added.