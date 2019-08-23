package com.stackroute;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import org.ejml.simple.SimpleMatrix;

import java.util.Properties;

public class SentimentAnalyzer {
    static Properties properties;
    static StanfordCoreNLP pipeline;

    public void setPipeline() {
        properties = new Properties();
        properties.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        pipeline = new StanfordCoreNLP(properties);
    }

    public SentimentReport getSentimentReport(String review) {
        SentimentReport sentimentReport = new SentimentReport();
        SentimentClassifier sentimentClassifier = new SentimentClassifier();
        if (review != null && review.length() > 0) {
            Annotation annotation = pipeline.process(review);
            for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)
            ) {
                Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                SimpleMatrix sm = RNNCoreAnnotations.getPredictions(tree);
                String sentimentType = sentence.get(SentimentCoreAnnotations.SentimentClass.class);

                sentimentClassifier.setVeryPositive((double) Math.round(sm.get(4) * 100d));
                sentimentClassifier.setPositive((double) Math.round(sm.get(3) * 100d));
                sentimentClassifier.setNeutral((double) Math.round(sm.get(2) * 100d));
                sentimentClassifier.setNegative((double) Math.round(sm.get(1) * 100d));
                sentimentClassifier.setVeryNegative((double) Math.round(sm.get(0) * 100d));

                sentimentReport.setSentimentScore(RNNCoreAnnotations.getPredictedClass(tree));
                sentimentReport.setSentimentType(sentimentType);
                sentimentReport.setSentimentClassifier(sentimentClassifier);
            }
        }
        return sentimentReport;
    }

}
