package com.selcuk.helpers.logger;

import com.selcuk.utils.ResourceHelper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {
    private static boolean root = false;
    public static Logger getLogger(Class clas){
        if (root){
            return Logger.getLogger(clas);
        }
        PropertyConfigurator.configure(ResourceHelper.getResourcePath("/src/main/resources/log4j.properties"));
        root = true;
        return Logger.getLogger(clas);

    }
}
