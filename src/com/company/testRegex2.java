package com.company;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.*;


/**
 * Created by jfpons on 11/09/2015.
 */
public class testRegex2 {
    private static Pattern pattern;
    private static Matcher matcher;

    public static void main(String args[]) throws IOException{

        /** Déclaration de la regex à utiliser */
        pattern = Pattern.compile("([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3})\\s+webapp.local");

        /** Fichier host d'origine */
        Path fHost = Paths.get("C:\\Users\\jfpons\\Desktop\\hosts.txt");

        /** Encodage à utiliser pour le nouveau fichier*/
        Charset charset = Charset.forName(System.getProperty("file.encoding"));

        /**Creation du nouveau fichier */
        Path newHost= Paths.get("C:\\Users\\jfpons\\Desktop\\newhosts.txt");
        List<String> fileArray = Files.readAllLines(fHost);


        System.out.println(fileArray.get(1));

        for (String line : fileArray) {
            matcher = pattern.matcher(line);
            if (matcher.find()) {
              fileArray.set(fileArray.indexOf(line), "172.15.11.11 webapp.local");
            }
        }
        String line = null;

        /** Backup du fichier host */
        Path bHost = Paths.get("C:\\Users\\jfpons\\Desktop\\hosts.backup");
       /** Path file = Files.copy(fHost, bHost);*/
        Path file = Files.move(fHost, bHost);

        /** Ecriture du nouveau fichier */
        Files.write(fHost, fileArray, charset, StandardOpenOption.CREATE);



        }
    }

