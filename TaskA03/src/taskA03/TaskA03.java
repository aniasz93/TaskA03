package taskA03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskA03 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int currentState;
		int nextState;
		int firstSpace;
		int secondSpace;
		Character value;
		Map<Vertex, List<Edge>> automata = new HashMap<Vertex, List<Edge>>();
		Vertex state = new Vertex(0);
		Vertex state2 = new Vertex(0);
		Map<Integer, Vertex> createdStates = new HashMap<Integer, Vertex>();
		Map<Integer, Vertex> finalStates = new HashMap<Integer, Vertex>();
		
		// read automata from standard in
		while ((line = reader.readLine()) != null && line.length() != 0) {
			
			firstSpace = line.indexOf(" ");
			
			if (firstSpace > -1) {
				
				currentState = Integer.parseInt(line.substring(0, firstSpace));
				
				secondSpace = line.lastIndexOf(" ");
				nextState = Integer.parseInt(line.substring(firstSpace + 1, secondSpace));
				
				value = new Character(line.substring(secondSpace));
				
				if (!state.checkIfExists(createdStates, currentState)) {
					state = new Vertex(currentState);
					createdStates.put(currentState, state);
				} else {
					state = state.getVertex(createdStates, currentState);
				}
				
				if (!state2.checkIfExists(createdStates, nextState)) {
					state2 = new Vertex(nextState);
					createdStates.put(nextState, state2);
				} else {
					state2 = state2.getVertex(createdStates, nextState);
				}
				
				automata.put(state, Arrays.asList(new Edge(state, state2, value)));
			} else {
				currentState = Integer.parseInt(line);
				
				if (!state.checkIfExists(createdStates, currentState)) {
					state = new Vertex(currentState);
					createdStates.put(currentState, state);
				} else {
					state = state.getVertex(createdStates, currentState);
				}
				finalStates.put(currentState, state);
			}
		}
		
		// read words from file
		File words = null;
		BufferedReader br = null;
		Automata aut;// = new Automata();
		
		if (0 < args.length) {
		   words = new File(args[0]);
		}/* else {
		   System.err.println("Invalid arguments count:" + args.length);
		   System.exit();
		}*/

	    try {
	        String word;
	        br = new BufferedReader(new FileReader(words));

	        while ((word = br.readLine()) != null) {
	            aut = new Automata(automata, finalStates, word);
	            aut.checkIfWordExists();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (br != null)br.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}
