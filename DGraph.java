package finalProject;

public class DGraph<T> extends WDGraph<T> {

	
	public DGraph() {
		
		super();
	}
	
	
	public void addEdge(T vertex1, T vertex2) {
		if(isValidVertex(vertex1)  && isValidVertex(vertex2) && vertex1 != vertex2){
			if(!this.existEdge(vertex1, vertex2))
				super.addEdge(vertex1, vertex2, 1);
			
			
		}
	}
	
	
	@Override
	public void addEdge(T vertex1, T vertex2 double weight) {
		
		this.addEdge(vertex1, vertex2);
		
	}
	
	
}
