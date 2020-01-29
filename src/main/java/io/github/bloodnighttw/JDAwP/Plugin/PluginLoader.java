package io.github.bloodnighttw.JDAwP.Plugin;


import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginLoader {

    private static PluginLoader pluginLoader;


    private PluginLoader(){}

     public static PluginLoader getInstance(){
         if(pluginLoader==null)
             pluginLoader=new PluginLoader();
         return pluginLoader;
     }

     public void startLoading(String path) throws MalformedURLException, ClassNotFoundException {

         URLClassLoader urlClassLoader=URLClassLoader.newInstance(new URL[]{new URL("jar:file:"+path+"!/")});
         InfoFilieManager ifm=InfoFilieManager.getInstance();
         PluginInfo pi=ifm.getInfoFile(path);
         Class<?> clazz=urlClassLoader.loadClass(pi.getMainClass());



         ExtendPoint ep = null;

         try {
             ep= (ExtendPoint) clazz.getDeclaredConstructor().newInstance();
         } catch (InstantiationException e) {
             e.printStackTrace();
             return;
         } catch (IllegalAccessException e) {
             e.printStackTrace();
             return;
         } catch (NoSuchMethodException e) {
             e.printStackTrace();
         } catch (InvocationTargetException e) {
             e.printStackTrace();
         }

         assert ep != null;
         ep.loading();


     }

}
