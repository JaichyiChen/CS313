public class Node<T>{
	private T data;
	private Node<T> next;

	public Node(){
		data=null;
		next=null;
	}

	public Node(T d, Node<T> n){
		data=d;
		next=n;
	}

	public T getData(){return data;}
	public Node<T> getNext(){return next;}

	public void setData(T d){data=d;}
	public void setNext(Node<T> n){next=n;}

	public String toString() {
		String ans = "";
		//Node<T> node = this;
		if (this != null) {
			ans += this.data;
			Node<T> node = this.next;
			if(node != null) ans = ans + "-->" + node.data;
		}
		return ans;
	}

	
}