package com.example.encryptedHashing.model;

import java.util.List;

public class Encrypted {
    private String algorithm;
    private List<EncryptedDates> documents;

    public Encrypted(String algorithm, List<EncryptedDates> documents) {
        super();
        this.algorithm = algorithm;
        this.documents = documents;
    }

    public String getAlgorithm() {
        return algorithm;
    }
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
    public List<EncryptedDates> getDocuments() {
        return documents;
    }
    public void setDocuments(List<EncryptedDates> documents) {
        this.documents = documents;
    }
}
