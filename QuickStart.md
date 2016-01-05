#Quick start for newbies

# Quick start #

For newbies here is a quick tutorial on how to create a new project GWT and use the library gwt2swf.

# Details #

  1. Let's create new project in eclipse, name it 'gwt2swf-helloworld'.

> Using gwt tool create project

```
./projectCreator 
     -eclipse gwt2swf-helloworld 
     -ant gwt2swf-helloworld 
     -out ~/workspace/java-eclipse/gwt2swf-helloworld 
     -overwrite      
```

> and create new application

```
./applicationCreator 
        -eclipse gwt2swf-helloworld 
        -out ~/workspace/java-eclipse/gwt2swf-helloworld 
        pl.rmalinowski.gwt2swf.client.GWT2SWFHelloWorld
```

  1. Open Eclipse and import gwt2swf-helloworld project into workspace.

  1. Add gwt2swf library to project (Eclipse menu-> Project propertis -> java build files -> librarys -> Add Jar -> gwt2swf.jar

  1. Put reference to gwt2swf library into your  GWT2SWFHelloWorld.gwt.xml:

> 

&lt;inherits name='pl.rmalinowski.gwt2swf.GWT2SWF' /&gt;



> GWT2SWFHelloWorld.gwt.xml should looks like this:

```
<module>
        <inherits name='com.google.gwt.user.User'/>
        <inherits name='pl.rmalinowski.gwt2swf.GWT2SWF' />
        <entry-point class='pl.rmalinowski.gwt2swf.client.GWT2SWFHelloWorld'/>  
</module>   
```

# Put some SWF file into your pl.rmalinowski.gwt2swf.public folder, for example "hello.swf".


# Implement entrypoint

```
package pl.rmalinowski.gwt2swf.client;

import pl.rmalinowski.gwt2swf.client.ui.SWFWidget;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class GWT2SWFHelloWorld implements EntryPoint, ClickListener {

    private final Button addNewSwf = new Button("Add new SWF");

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        RootPanel.get().add(addNewSwf);
        addNewSwf.addClickListener(this);

    }

    public void onClick(Widget sender) {
        
        SWFWidget swfWidget = new SWFWidget("hello.swf",200,150);
        swfWidget.addFlashVar("bridgeName", "example");

        RootPanel.get().add(swfWidget);       
        
    }

}
```


You can also download applications helloworld to see a greater number of examples