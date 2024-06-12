package s106n2e2;


public class UndefinedTypeParameterization {
	
	public <T> void genericMethodUndefinedParameters(T... args) {

		for(T arg : args){
			System.out.println(arg);
		}
	}

}
