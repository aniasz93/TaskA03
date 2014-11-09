package taskA03;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Vertex {

	int state;
	
	public Vertex (int state) {
		this.state = state;
	}
	
	public boolean checkIfExists(Map<Integer, Vertex> vertexes, int state) {
		
		if (vertexes.containsKey(state))
			return true;
		
		return false;
	}
	
	public Vertex getVertex(Map<Integer, Vertex> vertexes, int state) {

		return vertexes.get(state);
	}
	
	/*public void createVertex(Map<Integer, Vertex> createdStates, int currentState) {
		
		if (!checkIfExists(createdStates, currentState)) {
			state = new Vertex(currentState);
			createdStates.put(currentState, state);
		} else {
			state = state.getVertex(createdStates, currentState);
		}
	}*/
}
