package taskA03;

import java.util.List;
import java.util.Map;

public class Automata {
	
	String word;
	Vertex currentState;

	public Automata(Map<Vertex, List<Edge>> automata, Map<Integer, Vertex> finalStates, String word) {
		this.word = word;
	}
	
	public boolean checkIfWordExists() {
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			
			
		}
		
		return false;
	}
}
