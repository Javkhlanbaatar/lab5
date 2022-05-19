package lab5;

public interface Stack<T>{
	   public boolean empty();
	   @SuppressWarnings("hiding")
	   public<T>  T peek();
	   public void push(T theObject);
	   @SuppressWarnings("hiding")
	   public<T> T pop();
}
