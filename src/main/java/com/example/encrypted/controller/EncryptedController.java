package com.example.encrypted.controller;

import java.io.File;

import com.example.encrypted.model.Encrypted;
import com.example.encrypted.service.EncryptedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/app")
public class EncryptedController {
    
    @Autowired
    private EncryptedService encryptedService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("/hash")
    public ResponseEntity<Encrypted> setSha( @RequestParam("archivos") MultipartFile file, RedirectAttributes model){
        String fileName = file.getOriginalFilename();
        //String filePath = ClassLoader.getSystemResource(".../texto.txt").getFile();
        Encrypted encrydted = null;
        /*
        encrydted = encryptedService.SHA512(fileName);
        model.addFlashAttribute("sha512", encrydted.getDocuments());
        encrydted = encryptedService.SHA256(fileName);
        model.addFlashAttribute("sha256", encrydted.getDocuments());*/

        encrydted = encryptedService.sha256(fileName);
        model.addFlashAttribute("sha256", encrydted.getDocuments());

        encrydted = encryptedService.sha512(fileName);
        model.addFlashAttribute("sha512", encrydted.getDocuments());
        System.out.println(fileName);
        System.out.println(encrydted.getDocuments());
        return ResponseEntity.ok(encrydted);
    }
}
