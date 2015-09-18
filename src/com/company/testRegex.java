package com.company;
import java.io.IOException;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.*;


/**
 * Created by jfpons on 11/09/2015.
 */
public class testRegex {
    private static Pattern pattern;
    private static Matcher matcher;

    public static void main(String args[]) throws IOException{

        File hosts = new File("C:\\Users\\jfpons\\Desktop\\hosts.txt");
        BufferedReader reader = new BufferedReader(new FileReader(hosts));
        pattern = Pattern.compile("([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3})\\s+webapp.local");
        String line = null;

        while((line = reader.readLine()) != null) {
            matcher = pattern.matcher(line);
            if (matcher.find()) {

                System.out.println(matcher.group(1));
            }
        }
    }
}
