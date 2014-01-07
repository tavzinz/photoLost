/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package photoLost;

import com.dropbox.client2.DropboxAPI.Config;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ricardo
 */
public class dropbox {

    public void DBmain() {
        System.setProperty("java.net.useSystemProxies", "true");
        Map configuration= new HashMap();
        configuration.put("consumer_key", "XXXXXXXXXXXXXXXX");
        configuration.put("consumer_secret", "XXXXXXXXXXXXXXXX");
        configuration.put("request_token_url", "http://api.dropbox.com/0/oauth/request_token");
        configuration.put("access_token_url", "http://api.dropbox.com/0/oauth/access_token");
        configuration.put("authorization_url", "http://api.dropbox.com/0/oauth/authorize");
        configuration.put("port",80);
        //configuration.put("trusted_access_token_url","http://api.getdropbox.com/0/token");
        configuration.put("server","api.getdropbox.com");
        configuration.put("content_server","api-content.dropbox.com");
        String username="myMailAddress@domain.com";
        String password="myPassword";
        try {
           Authenticator auth = new Authenticator(configuration);
           String url = auth.retrieveRequestToken("");
           String access_key = auth.getTokenKey();
           String access_secret = auth.getTokenSecret();
           System.out.println(access_key);
           System.out.println(access_secret);

           DropboxAPI api = new DropboxAPI();
           DropboxAPI.Config conf = api.new Config(configuration);
           api.authenticateToken("XXXXXXXXXXXX", "XXXXXXXXXXX", conf);
           System.out.println(api.isAuthenticated());
           URL resource = this.getClass().getResource("/config/testing.json");

           File f= new File(resource.toURI());
           api.putFile("dropbox", "/Project", f);

           //api.accountInfo(); //even this method gives me a exception
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}