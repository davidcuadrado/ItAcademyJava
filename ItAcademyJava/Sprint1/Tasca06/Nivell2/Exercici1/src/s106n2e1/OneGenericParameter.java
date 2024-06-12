package s106n2e1;

public class OneGenericParameter {

	
	public <T, U> void genericMethodOneString(String parameter1, T parameter2, U parameter3) {

		System.out.println(parameter1);
		System.out.println(parameter2);
		System.out.println(parameter3 + "\n");

	}

}
