package com.example.encryptedHashing.controller;

import java.util.List;
import com.example.encryptedHashing.service.EncryptedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EncryptedController {
    @Autowired
    private EncryptedService encryptedService;

    /**Endpoint que permite cargar archivos a traves de FORM-DATA y por parametro en la URL para determinar 
     * el algor. hash a aplicar sobre los archivos */
    @PostMapping("/api/hash{algorithm}")
    public ResponseEntity<?> hashing(@RequestParam("algorithm") String algorithm, @RequestBody List<MultipartFile> files){
        List<String> filesNames = encryptedService.returnFilesNames(files);
        ResponseEntity<?> result = encryptedService.selectedHash(filesNames, algorithm);
        return result;
    }
}