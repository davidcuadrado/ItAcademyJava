package s106n1e1;

public class Main {

	public static void main(String[] args) {
		
		NoGenericMethods instancePhrase1 = new NoGenericMethods("en Pau", "volia", "llaminadures");
		NoGenericMethods instancePhrase2 = new NoGenericMethods("volia", "llaminadures", "en Pau");
		NoGenericMethods instancePhrase3 = new NoGenericMethods("llaminadures", "volia", "en Pau");
		NoGenericMethods instancePhrase4 = new NoGenericMethods("volia", "en Pau", "llaminadures");
		NoGenericMethods instancePhrase5 = new NoGenericMethods("en Pau", "llaminadures", "volia");
		
		System.out.println(instancePhrase1);
		System.out.println(instancePhrase2);
		System.out.println(instancePhrase3);
		System.out.println(instancePhrase4);
		System.out.println(instancePhrase5);
		

	}

}
