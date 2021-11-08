package com.example.encryptedHashing.service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.encryptedHashing.model.Encrypted;
import com.example.encryptedHashing.model.EncryptedDates;
import com.example.encryptedHashing.util.Message;
import com.google.common.hash.Hashing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EncryptedService {

    /**Metodo de encriptacion sha256, recibe una lista con los nombres de los archivos que se desean encriptar, y
     * mediante una propiedad que otorga la libreria guava de google se realiza la encriptacion a sha 256*/
    public Encrypted sha256(final List<String> fileName){
        Encrypted encrypted = null;
        List<EncryptedDates> document = new ArrayList<EncryptedDates>();
        for (String filename : fileName) {            
            String sha256hex = Hashing.sha256()
            .hashString(filename, StandardCharsets.UTF_8)
            .toString();
            EncryptedDates dates = new EncryptedDates(filename, sha256hex);
            document.add(dates);
        }
        encrypted = new Encrypted("SHA256", document);
        return encrypted;
    }

    /**Metodo de encriptacion sha512, recibe una lista con los nombres de los archivos que se desean encriptar, y
     * mediante una propiedad que otorga la libreria guava de google se realiza la encriptacion a sha 512*/
    public Encrypted sha512(final List<String> fileName){
        Encrypted encrypted = null;
        List<EncryptedDates> document = new ArrayList<EncryptedDates>();
        for (String filename : fileName) {   
            String sha512hex = Hashing.sha512()
            .hashString(filename, StandardCharsets.UTF_8)
            .toString();
            EncryptedDates dates = new EncryptedDates(filename, sha512hex);
            document.add(dates);
        }
        encrypted = new Encrypted("SHA512", document);
        return encrypted;
    }

    /**Seleccion de metododo algoritmico de encriptacion recibe una lista con los nombres de los archivos que se desean encriptar, y
     * el algoritmo en el que se desea encriptar, solo se admite sha256 y sha512 en caso contrario se valido mediante un mensaje
     * personalizado que el algoritmo ingresado no existe
    */
    public ResponseEntity<?> selectedHash(final List<String> fileName, final String algorithm){
        Optional<Encrypted> encrypted = null;
        ResponseEntity<?> result = null;
        switch (algorithm) {
            case "SHA256":
                encrypted = Optional.ofNullable(sha256(fileName));
                break;
            case "SHA512":
                encrypted = Optional.ofNullable(sha512(fileName));
                break;
            default:
                break;
        }
        if (encrypted == null){
            Message messageResult = new Message("The algorithm doesnt exists");
            result = new ResponseEntity(messageResult, HttpStatus.NOT_FOUND);
        } else {
            result = ResponseEntity.ok(encrypted);
        }
        return result;
    }

    /**Retorna la lista con los nombres de los archivos que deseo encriptar*/
    public List<String> returnFilesNames(List<MultipartFile> files){
        List<String> filesNames = new ArrayList<String>();
        for (MultipartFile archivo : files) {
            filesNames.add(archivo.getOriginalFilename());
        }
        return filesNames;
    }
}
