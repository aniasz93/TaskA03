package taskA03;

import java.util.List;
import java.util.Map;

public class Automata {
	
	String word;
	Vertex currentState;
	String character;
	Map<Vertex, List<Edge>> automata;
	Map<Integer, Vertex> finalStates;
	Map<Integer, Vertex> createdStates;
	List<Edge> edgesList;

	public Automata(Map<Vertex, List<Edge>> automata, Map<Integer, Vertex> createdStates, Map<Integer, Vertex> finalStates, String word) {
		this.word = word;
		this.automata = automata;
		this.createdStates = createdStates;
		this.finalStates = finalStates;
	}
	
	public boolean checkIfWordExists() {
		Vertex state = new Vertex(0);
		boolean multiple = false;
		int branch = 0;
		
		currentState = state.getVertex(createdStates, 0);
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			
			character = new StringBuilder().append(c).toString();
			
			edgesList = automata.get(currentState);
			if (edgesList == null)
				return false;
			if (edgesList.isEmpty())
				return false;
			
			for (int j = branch; j < edgesList.size(); j++) {
				Edge edge = edgesList.get(j);
				
				multiple = checkIfMultipleEdges(currentState, character);
				
				if (edge.checkIfEdgeHasSpecificCharacter(character)) {
					currentState = edge.getNextState();
					break;
				}
			}
		}
		
		if (finalStates.containsValue(currentState))
			return true;
		
		return false;
	}
	
	public boolean checkIfMultipleEdges(Vertex currentState, String character) {
		
		int counter = 0;
		
		for (int i = 0; i < edgesList.size(); i++) {
			Edge edge = edgesList.get(i);
			
			if (edge.checkIfEdgeHasSpecificCharacter(character))
				counter++;
		}
		
		if (counter > 1)
			return true;
		
		return false;
	}
	
	public void checkWord() {
		
	}
}
