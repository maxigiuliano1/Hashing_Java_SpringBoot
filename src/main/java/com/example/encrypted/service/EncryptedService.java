package com.example.encrypted.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.example.encrypted.model.Encrypted;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EncryptedService {
    
  public Encrypted SHA256(final String strText){
    return SHA(strText, "SHA-256");
  }
 
  public Encrypted SHA512(final String strText){
    return SHA(strText, "SHA-512");
  }
  
  public String ConvertFileToFilePath(MultipartFile file){
      String name = file.getOriginalFilename();
      String filePath = ClassLoader.getSystemResource(name).getFile();
      return filePath;
  }

  public Encrypted SHA(final String strText, final String strType){
    // valor de devolución
    String strResult = null; 
    Encrypted encrypted = null;
    // Si es una cadena válida
    if (strText != null && strText.length() > 0){
      try{
        // cifrado sha
        // Crear un objeto encriptado e incorporar el tipo de cifrado
        MessageDigest messageDigest = MessageDigest.getInstance(strType);
        // Entrando la cadena a encriptada
        messageDigest.update(strText.getBytes());
        // obtener el resultado del tipo de byte
        byte byteBuffer[] = messageDigest.digest();
 
        // convertir byte a cadena
        StringBuffer strHexString = new StringBuffer();
        // Transverso byte buffer
        for (int i = 0; i < byteBuffer.length; i++){
          String hex = Integer.toHexString(0xff & byteBuffer[i]);
          if (hex.length() == 1){
            strHexString.append('0');
          }
          strHexString.append(hex);
        }
        // obtener el resultado de retorno
        strResult = strHexString.toString();
        List<String> list = new ArrayList<String>();
        list.add("fileName: "+ strText);
        list.add("hash: " + strResult);
        encrypted = new Encrypted(strType, list);

      }
      catch (NoSuchAlgorithmException e){
        e.printStackTrace();
      }
    }
    return encrypted;
  }

}
