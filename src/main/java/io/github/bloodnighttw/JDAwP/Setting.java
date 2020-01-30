package io.github.bloodnighttw.JDAwP;

import io.github.bloodnighttw.JDAwP.Error.SecondSettingObjectExpection;

public class Setting {

    private static Setting instance;
    private String token="";

    public Setting() throws SecondSettingObjectExpection {
        if(instance!=null)
            throw new SecondSettingObjectExpection("Setting Object can't be Declare twice!!");
        else
            instance=this;
    }


    public String getToken() {
        return token;
    }

    public Setting getInstance(){
        return instance;
    }

}
