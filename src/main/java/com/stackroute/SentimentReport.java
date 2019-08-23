package com.stackroute;

public class SentimentReport {
    double sentimentScore;
    String sentimentType;
    SentimentClassifier sentimentClassifier;

    public double getSentimentScore() {
        return sentimentScore;
    }

    public void setSentimentScore(double sentimentScore) {
        this.sentimentScore = sentimentScore;
    }

    public String getSentimentType() {
        return sentimentType;
    }

    public void setSentimentType(String sentimentType) {
        this.sentimentType = sentimentType;
    }

    public SentimentClassifier getSentimentClassifier() {
        return sentimentClassifier;
    }

    public void setSentimentClassifier(SentimentClassifier sentimentClassifier) {
        this.sentimentClassifier = sentimentClassifier;
    }
}
