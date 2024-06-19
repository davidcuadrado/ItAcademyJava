package s104n2e1;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.Matcher;


import org.junit.jupiter.api.Test;

class PersonalitzatMatcherTest {

    public static PersonalitzatMatcher stringLength(Matcher<? super Integer> matcher) {    	
		PersonalitzatMatcher personalitzat = new PersonalitzatMatcher(matcher, "La longitud esperada", "La longitud recibida");
		
    	return personalitzat;
    }
    
    @Test
    public void mordorLengthTest() {
       assertThat("Mordor", stringLength(is(6)));
    }

}
