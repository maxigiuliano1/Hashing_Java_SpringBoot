package com.example.encryptedHashing.model;

public class EncryptedDates {
    private String fileName;
    private String hash;
    
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    public EncryptedDates(String fileName, String hash) {
        super();
        this.fileName = fileName;
        this.hash = hash;
    }   
}
