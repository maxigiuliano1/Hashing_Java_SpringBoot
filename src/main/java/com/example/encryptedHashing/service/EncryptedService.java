package com.example.encryptedHashing.service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.example.encryptedHashing.model.Encrypted;
import com.google.common.hash.Hashing;

import org.springframework.stereotype.Service;

@Service
public class EncryptedService {
    /**hacer una lista de string texto para que los agregue al document */
    public Encrypted sha256(final String strText, final String algorithm){
        Encrypted encrypted = null;
        String sha256hex = Hashing.sha256()
        .hashString(strText, StandardCharsets.UTF_8)
        .toString();
        List<String> list = new ArrayList<String>();
        list.add("fileName: "+ strText);
        list.add("hash: " + sha256hex);
        encrypted = new Encrypted(algorithm, list);
        return encrypted;
    }
    /**hacer una lista de string texto para que los agregue al document */
    public Encrypted sha512(final String strText, final String algorithm){
        Encrypted encrypted = null;
        String sha512hex = Hashing.sha512()
        .hashString(strText, StandardCharsets.UTF_8)
        .toString();
        List<String> document = new ArrayList<String>();
        document.add("fileName: "+ strText);
        document.add("hash: " + sha512hex);
        encrypted = new Encrypted(algorithm, document);
        return encrypted;
    }

    public Encrypted selectedHash(final String strText, final String algorithm){
        Encrypted encrypted = null;
        if(algorithm == "SHA256"){
           encrypted = sha256(strText, algorithm);
        }else{
            encrypted = sha512(strText, algorithm);
        }
        return encrypted;
    }
    /*
    public Encrypted selectedHash(final String strText, final String algorithm){
        Encrypted encrypted = null;
        if(algorithm == "SHA256" || algorithm == "SHA512"){
            try {
                if (algorithm == "SHA256") {
                    encrypted = sha256(strText, algorithm);
                }
                else{
                    encrypted = sha512(strText, algorithm);
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return encrypted;
    }*/
}
