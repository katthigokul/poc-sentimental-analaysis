package com.stackroute;


public class SentimentAnalysisApplication {

    public static void main(String[] args) {

        String review = "This is a bad ";
        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
        sentimentAnalyzer.setPipeline();
        SentimentReport sentimentResult = sentimentAnalyzer.getSentimentReport(review);
        System.out.println("Sentiment Score: " + sentimentResult.getSentimentScore());
        System.out.println("Sentiment Type: " + sentimentResult.getSentimentType());
        System.out.println("Very positive: " + sentimentResult.getSentimentClassifier().getVeryPositive() + "%");
        System.out.println("Positive: " + sentimentResult.getSentimentClassifier().getPositive() + "%");
        System.out.println("Neutral: " + sentimentResult.getSentimentClassifier().getNeutral() + "%");
        System.out.println("Negative: " + sentimentResult.getSentimentClassifier().getNegative() + "%");
        System.out.println("Very negative: " + sentimentResult.getSentimentClassifier().getVeryNegative() + "%");


    }

}
