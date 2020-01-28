package io.github.bloodnighttw.JDAwP.Plugin;

public class PluginInfo {

    private final String MainClass;
    private final String PluginName;
    private final String version;
    private final String loadAfter;

    /*
     *
     *  =========================================================
     *              The Format of String "loadAfter"
     *          [PluginName1][PluginName2][PluginName3].....
     *          And this Plugin won't load after Plugin1,
     *          Plugin2,Plugin3 has been loaded.
     *  =========================================================
     *
     */

    public PluginInfo(String mainClass, String pluginName, String version, String loadAfter) {
        MainClass = mainClass;
        PluginName = pluginName;
        this.version = version;
        this.loadAfter = loadAfter;
    }

    public String getMainClass() {
        return MainClass;
    }

    public String getPluginName() {
        return PluginName;
    }

    public String getVersion() {
        return version;
    }


    public String[] getLoadAfter() {
        String cache=loadAfter.replace("[","");
        String[] loadAfterArray=cache.split("]");
        return loadAfterArray;
    }

}
