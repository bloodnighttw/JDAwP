package io.github.bloodnighttw.JDAwP.Plugin;

public class PluginLoader {

    private static PluginLoader pluginLoader;

    private PluginLoader(){}

     public static PluginLoader getInstance(){
         if(pluginLoader==null)
             pluginLoader=new PluginLoader();
         return pluginLoader;
     }

     public void startLoading(){





     }

}
