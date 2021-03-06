package io.github.bloodnighttw.JDAwP.ServerTool;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;

public class Path {

    private String path=null;
    private static Path instance;
    private String syntax="/";

    private Path() throws URISyntaxException {
        if(System.getProperty("os.name").equals("Windows"))
            syntax="\\";

        File file=new File(getPath()+"plugins");
        file.mkdir();
    }

    public static Path getInstance() throws URISyntaxException {
        if(instance==null)
            instance=new Path();
        return  instance;
    }

    public String getPath() throws URISyntaxException {

        if(path==null) {

            path = Path.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            String[] cache=path.split(syntax);
            StringBuilder cache2= new StringBuilder();
            for(String st:cache){
                if(!st.endsWith(".jar")){
                    cache2.append(st).append(syntax);
                }
            }
            path= cache2.toString();
        }
        return path;
    }

    public String getPluginFolderPath(){
        return path+"plugins";
    }

    public String[] getAllJarPathList()  {
        File[] listFile=new File(getPluginFolderPath()).listFiles();
        LinkedList<String> linkedList=new LinkedList<String>();

        for(File f:listFile) {


            if (f.getPath().endsWith(".jar")) {

                File file = new File("jar:file:" + f.getPath());

                InputStream ip;

                try {
                    URL url = new URL(file.getPath() + "!"+syntax+"info.json");
                    ip=url.openStream();
                    ip.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    continue;
                } catch (IOException e) {
                    System.out.println("Not found info.json in " + file.getName());
                    e.printStackTrace();
                    continue;
                }

                linkedList.add(f.getPath());

            }
        }

        return (String[]) linkedList.toArray(new String[0]);

    }
}
