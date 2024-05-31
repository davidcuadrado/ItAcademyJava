package s104n2e1;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

public class PersonalitzatMatcher extends FeatureMatcher<String, Integer>{
	
	public PersonalitzatMatcher(Matcher<? super Integer> subMatcher, String featureDescription, String featureName) {
		super(subMatcher, featureDescription, featureName);
	}

	@Override
    protected Integer featureValueOf(String palabra) {
        return palabra.length();
    
    }

	

}
