// BasicGetRequest.java
// GetNPost
//
// Created by mscndle on 3/25/14

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Basic get request to get first 100 emails from gmail
public class BasicGetRequest {

    public static void main(String[] args) {

        try {
            sendPost();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            System.out.println("GET process complete");
        }

    }



    public static void sendGet() throws IOException {

//        HttpURLConnection
        String url = "https://www.google.com/#q=mandeep";

        URL obj = new URL(url);

        // connection is opened at this line
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        //con.setRequestProperty();
        //Not setting request property for now, let's see what happens

        int responseCode = con.getResponseCode();

        /*
        RESPONSE_CODE

        protected int responseCode
        An int representing the three digit HTTP Status-Code.
        1xx: Informational
        2xx: Success
        3xx: Redirection
        4xx: Client Error
        5xx: Server Error
        */

        System.out.println("\nsending GET request to url: " + url);
        System.out.println("Response code: " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String input;
        StringBuilder response = new StringBuilder();

        while ((input = in.readLine()) != null) {
            response.append(input);
        }

        //close the connection
        in.close();

        System.out.println(response.toString());
    }


    public static void sendPost() throws IOException {

        String url = "https://www.google.com/#q=mandeep";
        URL obj = new URL(url);

        HttpURLConnection postConn = (HttpURLConnection) obj.openConnection();
        postConn.setRequestMethod("POST");

        int responseCode = postConn.getResponseCode();

        System.out.println("\nSENDING POST REQUEST");
        System.out.println("Response code: " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(postConn.getInputStream()));
        String input;
        StringBuilder response = new StringBuilder();

        while ((input = in.readLine()) != null) {
            response.append(input);
        }
        in.close();

        System.out.println(response.toString());
    }



}
