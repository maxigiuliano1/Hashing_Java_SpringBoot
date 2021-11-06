package com.example.encrypted.model;

import java.util.List;

public class Encrypted {
    private String algorithm;
    private List<String> documents;

    public Encrypted(String algorithm, List<String> documents) {
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
    public List<String> getDocuments() {
        return documents;
    }
    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }
    
}
