package hu.innobyte.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.simmetrics.StringMetric;
import org.simmetrics.metrics.StringMetrics;

public class Tester {
	public static void checkSentence(String sentence,String sentence2) throws Exception  {
		HashMap<String,Float> sentences = new HashMap<String, Float>(); 
		
		for (Method method : StringMetrics.class.getMethods()) {

		    if (method.getReturnType().equals(StringMetric.class)
			    && method.getParameterTypes().length == 0) {
		    	
		    	StringMetric metric = (StringMetric) method.invoke(null);
		    	try {
		    		sentences.put(method.getName(), metric.compare(sentence, sentence2));
		    	} catch (Exception e) {
		    		
		    	}
		    }
		}
		
		List<Float> values =  new ArrayList<Float>(sentences.values());
		
		Collections.sort(values);
		 
		for(Float value : values) {
			for(String key: sentences.keySet()) {
				if (sentences.get(key).floatValue() == value) {
					System.out.println("Method name: " + key + " " + value);
					sentences.remove(key);
					break;
				}
			}
		}
	}
}
