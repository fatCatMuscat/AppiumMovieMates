package Utils;



//rest calls collection


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerManager extends BaseTest {

    String base_url = "https://moviemates-prod.herokuapp.com/api/v1/";

    public String getMovies() throws IOException {
        String url = base_url + "movies?days=1";
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        request.addHeader("Authorization", "Token " + prop.getProperty("TOKEN"));
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }


    public String getUserDetails() throws IOException {
        //1 Add url
        String resourceUrl = "users/";
        String id = prop.getProperty("ID");
        String url = base_url + resourceUrl + id;
        //2 Add HTTP client
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        request.addHeader("Authorization", "Token " + prop.getProperty("TOKEN"));
        //3 execute request
        HttpResponse response = client.execute(request);
        // parse response
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) !=null) {
            result.append(line);
        }

        return result.toString();
    }






}
