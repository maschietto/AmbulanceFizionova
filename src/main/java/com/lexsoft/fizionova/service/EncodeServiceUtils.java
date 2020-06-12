package com.lexsoft.fizionova.service;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Maschietto on 2/16/17.
 */

public class EncodeServiceUtils {


     public static String encodeFileToString(File f){
       String encodedFile = "";
         try{
            byte[] fileBytes = Base64.encodeBase64(FileUtils.readFileToByteArray(f));
             encodedFile = new String(fileBytes, "UTF-8");
        }catch (IOException ex){
            ex.printStackTrace();
        }
         return encodedFile;
    }

    public static File decodeStringToBase64File(String s,String pathToFile){

        File f  = new File(pathToFile);
        try{
            byte[] fileBytes = Base64.decodeBase64(s.getBytes("UTF-8"));
            FileUtils.writeByteArrayToFile(f, fileBytes);

        }catch (IOException ex){
            ex.printStackTrace();
        }
        return f;
    }


}
