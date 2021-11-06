package com.example.encryptedHashing.controller;

import java.util.List;

import com.example.encryptedHashing.model.Encrypted;
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

    @PostMapping("/app/hash{algorithm}")
    public ResponseEntity<Encrypted> setSha(@RequestParam("algorithm") String algorithm, @RequestBody List<MultipartFile> file){
        Encrypted encrydted = null;
        for (MultipartFile multipartFile : file) {
            String fileName = multipartFile.getOriginalFilename();
            encrydted = encryptedService.selectedHash(fileName, algorithm);
            System.out.println(fileName);
            System.out.println(encrydted.getDocuments());
            
        }
        //String filePath = ClassLoader.getSystemResource(".../texto.txt").getFile();

        return ResponseEntity.ok(encrydted);
    }
}
