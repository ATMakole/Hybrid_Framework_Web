package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig()  {
        File src = new File("./Configuration/config.properties");

        try
        {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();

            try
            {
                pro.load(fis);
            }
            catch (IOException e)
            {
                System.out.println("Exception is " + e.getMessage());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL()
    {
        String url =pro.getProperty("baseURL");
        return url;
    }

    public String getUsername()
    {
        String username =pro.getProperty("username");
        return username;
    }

    public String getPassword()
    {
        String password =pro.getProperty("password");
        return password;
    }

    public String getChromePath()
    {
        String chromePath =pro.getProperty("chromepath");
        return chromePath;
    }

    public String getFireFoxPath()
    {
        String firefoxPath =pro.getProperty("firefoxpath");
        return firefoxPath;
    }

    public String getIEPath()
    {
        String iePath =pro.getProperty("iepath");
        return iePath;
    }

    public String getEdgePath()
    {
        String edgepath =pro.getProperty("edgepath");
        return edgepath;
    }
}
