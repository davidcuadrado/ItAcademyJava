package s106n1e1;

public class NoGenericMethods {
	
	private String subjecte;
	private String verb;
	private String predicat;
	
	
	public NoGenericMethods(String subjecte,String verb, String predicat) {
		this.subjecte = subjecte;
		this.verb = verb;
		this.predicat = predicat;
	}
	
	
	public Object getSubjecte() {
		return subjecte;
	}
	public void setSubjecte(String subjecte) {
		this.subjecte = subjecte;
	}
	public Object getVerb() {
		return verb;
	}
	public void setVerb(String verb) {
		this.verb = verb;
	}
	public Object getPredicat() {
		return predicat;
	}
	public void setPredicat(String predicat) {
		this.predicat = predicat;
	}
	
	
	@Override
	public String toString() {
		return "NoGenericMethods Prints: " + subjecte + " " + verb + " " + predicat + ". ";
	}
	
	
	
	

}
