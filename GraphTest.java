package finalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphTest<T> {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		File file = new File("graph.dat");

		Scanner filescan = new Scanner(file);
		Scanner nextscan = new Scanner(file);
		WDGraph<String> graph = new WDGraph();
		graph.handler(file, filescan);
		//System.out.println(graph.numVertices());
		System.out.print(graph);
		//graph.singleSourceShortestPath("John");
		String V = graph.sourceVertex();
		
		
		//graph.singleSourceShortestPath(V);
		
		
		
		
	
		
		//graph.edgeList();
	/*	
		graph.addVertex("LAX");
		graph.addVertex("ORD");
		graph.addVertex("SFO");
		graph.addVertex("BWI");
		graph.addVertex("ATL");
		graph.addVertex("ORD");

		
		graph.addEdge("LAX",  "SFO",  600);
		graph.addEdge("ORD",  "SFO",  1200);
		graph.addEdge("ORD",  "ATL",  900);
		graph.addEdge("ORD",  "LAX",  1800);
		
		System.out.println(graph);
		
		for(String s : graph.neighbors("ORD"))
			System.out.print(s + " ");

		System.out.println();
		
		System.out.println(graph.nextNeighbor("ORD",  "LAX"));
		System.out.println(graph.nextNeighbor("ORD",  "SFO"));
		
		//graph.removeEdge("LAX", "SFO");

		//System.out.println(graph);

		
		
		
		WGraph<String> graph2 = new WGraph();

		graph2.addVertex("LAX");
		graph2.addVertex("ORD");
		graph2.addVertex("SFO");
		graph2.addVertex("BWI");
		graph2.addVertex("ATL");
		graph2.addVertex("ORD");
		
		graph2.addEdge("LAX",  "SFO",  600);

		
		System.out.println(graph2);
		
		for(String s : graph2.neighbors("LAX"))
			System.out.print(s + " ");
		
		
		System.out.println(graph2.numEdges());
		
		*/
		
		
		/*
		Graph<String> graph3 = new Graph();

		graph3.addVertex("LAX");
		graph3.addVertex("ORD");
		graph3.addVertex("SFO");
		graph3.addVertex("BWI");
		graph3.addVertex("ATL");
		graph3.addVertex("ORD");
		
		graph3.addEdge("LAX",  "SFO");
		graph3.addEdge("LAX",  "ATL");
		graph3.addEdge("ATL",  "ORD");

		
		System.out.println(graph3);
		
		for(String s : graph3.neighbors("LAX"))
			System.out.print(s + " ");
		
		
		System.out.println(graph3.numEdges());
	
		*/
	}

}
