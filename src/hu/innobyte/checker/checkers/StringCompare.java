package hu.innobyte.checker.checkers;

import static org.simmetrics.builders.StringMetricBuilder.with;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.simmetrics.StringMetric;
import org.simmetrics.metrics.JaroWinkler;
import org.simmetrics.simplifiers.Simplifiers;

public class StringCompare implements Checker {
    private List<String> words = new ArrayList<String>();
    private float distance;

    public StringCompare() {
    }

    public String check(String word) {
		float minDistance = 0;
		String foundWord = word;
	
		for (String nextWord : words) {
		    StringMetric metric = with(new JaroWinkler())
								 .simplify(Simplifiers.toLowerCase())
								 .build();
	
		    float actDistance = metric.compare(word, nextWord);
	
		    if (actDistance == 1) {
		    	return word;
		    }
	
		    if (actDistance > distance && minDistance < actDistance) {
			minDistance = actDistance;
			foundWord = nextWord;
		    }
		}
		return foundWord;
    }

    public void setDistance(float distance) {
    	this.distance = distance;
    }

    @Override
    public void init(CheckerInitData checkerInit) {
    	if (checkerInit.getFilePath() != null) {
	    	File file = new File(checkerInit.getFilePath());
	    	try {
		    	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    		String line = "";
		
		    		while ((line = br.readLine()) != null) {
		    		    words.add(line);
		    		}
	    	    }
	    	} catch (IOException e) {
	    	    System.err.println(String.format("Error in CheckerInit. Exception: %s, message: %s",e.getClass(),e.getMessage()));
	    	}
    	}
    }

    @Override
    public CheckerType getCheckerType() {
	return CheckerType.StringComparator;
    }

	@Override
	public float checkTwoSentence(String sentenceOne, String sentenceTwo) {
	    StringMetric metric = with(new JaroWinkler())
				 .simplify(Simplifiers.toLowerCase())
				 .build();
	    
		return metric.compare(sentenceOne, sentenceTwo);
	}
}
