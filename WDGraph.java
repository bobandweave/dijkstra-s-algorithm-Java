package finalProject;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sun.javafx.collections.MappingChange.Map;

public class WDGraph<T> implements GraphADT<T> {

	
	private int CAPACITY = 2;
	private final double INFINITY = Double.POSITIVE_INFINITY;
	private int numVertices;
	private int numEdges;
	private double[][] adjMatrix;
	private T[] vertices;
	private T[][] info;
	
	
	
	public WDGraph() {
		numVertices = 0;
		numEdges = 0;
		adjMatrix = new double[CAPACITY][CAPACITY];
		vertices = (T[]) new Object[CAPACITY];
		
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				adjMatrix[i][j] = INFINITY;
			}
		}
	
	}
	
		
		
	
		
public String toString(){
		int GAP = 5;
		if(numVertices == 0)
			return "Graph is empty";
		String result = "";
		
		result += String.format("%7s", "");
		for (int i = 0; i < numVertices; i++)
			result += String.format("%7s", vertices[i]);
		result += "\n";
		
		for (int i = 0; i < numVertices; i++) {
			result += String.format("%7s", vertices[i]);
			
			for (int j = 0; j < numVertices; j++) {
				if(adjMatrix[i][j] == INFINITY)
					//result += String.format("%7s", "inf");
					result += String.format("%7c", '\u221e');
				else
				    result += String.format("%7.2f", adjMatrix[i][j]);
			}
			result += "\n";
		}
		
		
		return result;
		
	}
	












	@Override
	public int numVertices() {
		return numVertices;
	}

	@Override
	public int numEdges() {
		return numEdges;
	}

	@Override
	public void addVertex(T vertex) {
		if(!isValidVertex(vertex)) {
			if(numVertices == CAPACITY)
				expand();
			vertices[numVertices] = vertex;    //check to see if expansion is needed
			numVertices++;
		}
		//need to throw exception or assertion if vertex already exists
		
	}
	
	/**
	 * 		
	 * @param vertex
	 * @return  the index of the vertex.  return -1 if not found
	 */
	protected int vertexIndex(T vertex){
		for(int i = 0; i < numVertices; i++)
			if(vertices[i].equals(vertex))
				return i;
		return -1;
	}
	
	protected ArrayList VertexList() {
		
		
		ArrayList arrayL = new ArrayList();
		 for(int i = 0; i < listOfLists.size(); i++) {
			 
			 
			 for(int z = 0; z < listOfLists.get(i).size(); z++) {
				 
				  arrayL.add(listOfLists.get(i).get(z));
			 }
		 }
		 return arrayL;
		
	}
	protected boolean isValidVertex(T vertex){
		for(int i = 0; i < numVertices; i++)
			if(vertices[i].equals(vertex))
				return true;
		return false;
	}
	

	/**
	 * add or update an edge
	 */
	
	
	
	String[][] newArray;
		@Override
		public void addEdge(T vertex1, T vertex2, double weight) {
			if(isValidVertex(vertex1)  && isValidVertex(vertex2) && vertex1 != vertex2 && weight >= 0){
				if(!this.existEdge(vertex1, vertex2))
					numEdges++;
				adjMatrix[vertexIndex(vertex1)][vertexIndex(vertex2)] = weight;
				
				
				
				
			}
		}
		
	public void edgeList(){
		
			
		
		for(int i = 0; i < newArray.length; i++) {
			
			
			for(int z = 0; z < newArray[i].length; z++) {
				
				System.out.println(newArray[i][z]);
				
			}
		}
		
		
	}

	@Override
	public void removeVertex(T vertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEdge(T vertex1, T vertex2) {
		if(existEdge(vertex1, vertex2)){
			adjMatrix[vertexIndex(vertex1)][vertexIndex(vertex2)] = INFINITY;
			numEdges--;
		}
	}

	@Override
	public boolean isEmpty() {
		return numVertices == 0;
	}

	@Override
	public boolean existEdge(T vertex1, T vertex2) {
		return isValidVertex(vertex1) && 
				isValidVertex(vertex2) && 
				(adjMatrix[vertexIndex(vertex1)][vertexIndex(vertex2)] != INFINITY);
	}

	@Override
	public int numComponents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	private void expand() {
		int newCapacity = CAPACITY * 2;
		
		//System.out.println("Expanding: old capacity = " + CAPACITY);
		double[][] newAdjMatrix = new double[newCapacity][newCapacity];
		T[] newVertices = (T[]) new Object[newCapacity];
		
		for(int i = 0; i < numVertices; i++)
			newVertices[i] = vertices[i];
		
		for (int i = 0; i < newAdjMatrix.length; i++) 
			for(int j = 0; j < newAdjMatrix.length; j++)
				newAdjMatrix[i][j] = INFINITY;
			
		for (int i = 0; i < numVertices; i++) 
			for(int j = 0; j < numVertices; j++)
				newAdjMatrix[i][j] = adjMatrix[i][j];
		
		adjMatrix = newAdjMatrix;
		vertices = newVertices;
		CAPACITY = newCapacity;
		
		
	}
	
	/**
	 * lists all the beighbors of the gioven vertex
	 * @param vertex
	 * @return
	 */
	public List<T> neighbors(T vertex) {
		if(!isValidVertex(vertex))
			return null;
		int row = vertexIndex(vertex);
		ArrayList<T> list = new ArrayList();
		for(int i = 0; i < numVertices; i++)
			if(adjMatrix[row][i] != INFINITY)
				list.add(vertices[i]);
		return list;
		
	}
	
	T sourceV;
	public T sourceVertex() {
		
		return sourceV;
		
		
	}
	/**
	 * returns the next neighbor after the current neighbor, if exists
	 * @param vertex
	 * @param currNeighbor
	 * @return
	 */
	public T nextNeighbor(T vertex, T currNeighbor) {
		if(!isValidVertex(vertex) || !isValidVertex(currNeighbor))
			return null;
		int row = vertexIndex(vertex);
		int col = vertexIndex(currNeighbor);
		for(int i = col + 1; i < numVertices; i++)
			if(adjMatrix[row][i] != INFINITY)
				return vertices[i];
		return null;
		
	}
	
	/**
	 * method uses Dijksra's single source shortest path algorithm
	 * It returns the previous array containing the shortest previous 
	 * vertices from the given source vertex to all other 
	 * vertices.
	 * 
	 * @param sourceVertex
	 * @return
	 */
	
	
	int count = 0;
	int count_2 = 0;
	
	List<List<String>> listOfLists = new ArrayList<List<String>>();
	public void helphandler(ArrayList NewArray) {
			
		listOfLists.add(NewArray);
		//System.out.println(NewArray);
		
	}
	
	
	
	/**
	 * 
	 *Handlers are created to create vertex's and edge's from the graph.dat file.
	 *
	 *
	 *handler
	 * operationhandle
	 * helphandle
	 *
	 */
	public void operationhandle(String name_1, String name_2, List list) {
		
		
		double distance;
		int x = 0;
		int x_1 = 0;
		int y = 0;
		int y_1 = 0;
		
		
		
		try {
		for(int i = 0; i < listOfLists.size(); i++) {
			
			for(int z = 0; i < listOfLists.get(i).size(); z++) {
				
				if(listOfLists.get(z).get(2).equals(name_1)) {
				
					x = Integer.parseInt(listOfLists.get(z).get(0));
					y = Integer.parseInt(listOfLists.get(z).get(1));
					
					
			}
				else if(listOfLists.get(z).get(2).equals(name_2)) {
					
					x_1 = Integer.parseInt(listOfLists.get(z).get(0));
					y_1 = Integer.parseInt(listOfLists.get(z).get(1));
					//System.out.println(x_1);
					
				}
			
		}
		}
		}
		catch(IndexOutOfBoundsException e) {
			
			
		}
		
		
		distance = Math.sqrt(((int)y_1 - (int)y) * ((int)y_1 - (int)y) + ((int)x_1 - (int)x) * ((int)x_1 - (int)x));
		
		
		if(count == 1) {
			
			sourceV = (T)name_1;
		}
		addEdge((T)name_1, (T)name_2, distance);
		
		
		
	}
	
	/**
	 *  This method is a handler for scanning through the file, it calls other methods as well and tokenizes the lines.
	 * 
	 * 	 Other method:  helphandler
	 * 					operationhandler
	 *
	 */
	
	int ct = 0;
	public void handler(File file, Scanner filescan) {
		
		int v = 0;
		v = filescan.nextInt();
		String line = "";
		int edges = 0;
		
		while(filescan.hasNextLine()) {
			
			line = filescan.nextLine();
			StringTokenizer Tokenizer = new StringTokenizer(line);
			
			try {
			if(Tokenizer.countTokens() == 3) {
				
				
				
				
				
				String[] split = line.split(" ");
				addVertex((T)split[2]);
				
				ArrayList<String> NewArray = new ArrayList<String>();
				NewArray.add(split[0]);
				NewArray.add(split[1]);
				NewArray.add(split[2]);
				helphandler(NewArray);
				
			}
			
			else if(Tokenizer.countTokens() == 2) {
				
				count += 1;
				
				
				operationhandle(Tokenizer.nextToken(), Tokenizer.nextToken(), listOfLists);
			}
			
		}
			catch(NoSuchElementException e) {
				
				continue;
				
				
			}
		
		}

	}
	
	
	
	
	
	
		
	public int[] singleSourceShortestPath(T sourceVertex) {
		
		
		// Create distance array...
		double [] distance = new double[numVertices];
		
		Arrays.fill(distance, INFINITY);
		// Set all the distances to infinity
		System.out.println(vertexIndex(sourceVertex));
		
		
		distance[vertexIndex(sourceVertex)] = 0.0;
		boolean [] track = new boolean[numVertices()];
		Arrays.fill(track, false);
		int [] position = new int[numVertices()];
		Arrays.fill(position, -1);
		boolean end = true;
		

		

	
		
		while(end == true) {
			
			System.out.println(sourceVertex);
		
			T V;
			
			double weight;
			int temp = 0;
			double smallest = INFINITY;
		
			
			
			
			for(int i = 0; i < distance.length; i++) {
				
				
				  
				  if(track[i] == false && distance[i] < smallest) {
					 
					  
					  temp = i;
					  smallest = distance[i];
					  
					  
				  }
				
			}
			
		
		//fix this	
			List<T> L = neighbors(vertices[temp]);
			track[temp] = true;
			
			T vertex = vertices[temp];
			
			for(int i = 0; i < L.size(); i++) {
				
				System.out.println(L.get(i));
				V = L.get(i);
			
				weight = adjMatrix[vertexIndex(vertices[temp])][vertexIndex(V)];
				
				if((weight + distance[vertexIndex(vertex)]) < distance[temp]) {
					
				
					distance[vertexIndex(V)] = weight + distance[vertexIndex(vertex)];
					position[vertexIndex(V)] = vertexIndex(vertex); 
					
				}
			}
			
			
			
			System.out.println(track.length);
			int r = 0;
			for(int z = 0; z < track.length; z++) {
					
					if(track[z] == false) r++;
					
				}
			if(r == 0)
					end = false;
			System.out.println(Arrays.toString(position));
		}
			return position;
		
				
			}
		
			
			
		
		
			
			
		
			
				
				
				// Check if neighbor distance is less than the distance of V plus the edge weight of V->N
				
			
		
			
			
			//V = pick an unprocessed vertex with smallest distance
			// if V doesn't exist...Break out!
			// Get all neighbors(n) of V....
			   //Go through list with for loop...For every neighbor in list
						// ask yourself... Is the distance of the V plus the edge weight of the neighbor(n) smaller than the distance of n
						// if that is smaller you found a better way to n
					    //update... and set previous [n] to v...
		
		
		
		/*
		
	
	public List<T> shortestPath(T sourceV, T destinationVertex){
		
	 //return array of objects
		
		return null;
	}
	
    */
	
		
		
		
	

		

	
}
