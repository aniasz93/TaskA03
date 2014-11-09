package taskA03;

public class Edge {
	
	Vertex startVer;
	Vertex endVer;
	Character value;

	public Edge(Vertex startVer, Vertex endVer, Character value) {
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
	
	public Character getCharacter() {
		return value;
	}
}
