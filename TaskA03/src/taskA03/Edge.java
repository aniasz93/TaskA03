package taskA03;

public class Edge {
	
	Vertex startVer;
	Vertex endVer;
	String value;

	public Edge(Vertex startVer, Vertex endVer, String value) {
		this.startVer = startVer;
		this.endVer = endVer;
		this.value = value;
	}
	
	public boolean checkIfExist(int state) {
		
		return false;
	}
	
	public Vertex getCurrentState() {
		return startVer;
	}
	
	public Vertex getNextState() {
		return endVer;
	}
	
	public String getCharacter() {
		return value;
	}
	
	public boolean checkIfEdgeHasSpecificCharacter(String character) {
		
		if (value.equals(character))
			return true;
		
		return false;
	}
}
