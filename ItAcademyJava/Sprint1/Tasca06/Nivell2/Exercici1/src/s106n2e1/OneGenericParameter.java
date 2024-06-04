package s106n2e1;

public class OneGenericParameter {

	
	public <T> void genericMethodOneString(String parameter1, T parameter2, T parameter3) {

		System.out.println(parameter1);
		System.out.println(parameter2);
		System.out.println(parameter3 + "\n");

	}

}
