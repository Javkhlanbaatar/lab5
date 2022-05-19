package lab5;

import java.util.Scanner;

import com.google.java.contract.*;

@Invariant("size < 0")
public class StackList<T> implements Stack <T> {
 
    private int size;
    private T[] SNode;
    private int top;
    private int i=0;
   
    
    
    @SuppressWarnings("unchecked")
    public StackList(int newSize) {
        this.size = newSize;
        this.SNode = (T[]) new Object[size];
        this.top = -1;
        
    }
    
    @Requires("size() <= 1")
    public void push(T entry){
    	assert size() <= 1 : "Stack is empty";
        if(this.isStackFull()){
            System.out.println(("Stack is full."));
            this.increaseStackCapacity();
        }
        i++;
        this.SNode[++top] = entry;
    }
 
  
    @Requires("size > 0")
    @Ensures("entry!=null")
    @SuppressWarnings("unchecked")
	public T pop() {
    	
    	assert size>0 : "Stack is empty";
    	
        if(this.isStackEmpty()){
        }
        i--;
        T entry = this.SNode[top--];
        System.out.println("Removed entry: "+entry);
        assert entry!=null : "Can't poped";
        return entry;
        
    }
   
    @SuppressWarnings("unchecked")
	public T peek() {
        return SNode[top];
    }
 
    private void increaseStackCapacity(){
         
    	
    	
        @SuppressWarnings("unchecked")
        T[] newStack = (T[]) new Object[this.size*2];
        for(int i=0;i<size;i++){
            newStack[i] = this.SNode[i];
        }
        this.SNode = newStack;
        this.size = this.size*2;
    }
    
    @Requires("size > 0")
    public int size(){
        if(this.isStackEmpty()) {
        	assert size>0 : "Size is not counted";
            return i;
        }
        else {
        	assert size>0 : "Size is not counted";
            return i;
        }
    }
     
    @Requires("size > 0")
    public boolean isStackEmpty() {
    	assert size>0 : "Size is not counted";
       return (top == -1);
    }
    
    
    public boolean isStackFull() {
    	assert top != size - 1 : "Is stack not full";
        return (top == size - 1);
    }

	public static void menu() {
		System.out.println("Menu:\t 0. Exit" + "\n\t1. isEmpty" + "\n\t2. Push" + "\n\t3. Peek" + "\n\t4. Pop" + "\n\t5. Size "
				+ "\n\t6. Menu ");
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		StackList <String> sll2 = new StackList<String>(0);
		StackList<Integer> sll = new StackList<Integer>(1000);

		Scanner sc = new Scanner(System.in);
		StackList.menu();

		while (true) {

			System.out.println("\n ENTER THE MENU NUMBER: ");
				int songolt = sc.nextInt();

				switch (songolt) {
				case 0: {
					System.out.print("Exit");
					sc.close();
					System.exit(1);
				}
					break;
				case 1: {
					if (sll.isStackEmpty())
						System.out.println("\t Stack is Empty");
					else
						System.out.println("\t Stack is not Empty" + sll.toString());
				}
					break;
				case 2: {
					try {
						System.out.print("Enter a value: ");
						int elements = sc.nextInt();
						sll.push(elements);
						System.out.println( elements + "\t : pushed to stack");
					} catch (Exception e) {
						System.out.println("Stack takes only int value!!");
					}
				}
					break;
				case 3: {
					if (sll.isStackEmpty()) {
						System.out.println("\t Stack is Empty");

					} else {
						System.out.println("\t Top element: " + sll.peek());

					}
				}
					break;
				case 4: {
					
						System.out.println("\t " + sll.pop() + " popped from stack");


				}
					break;
				case 5: {
					System.out.println("\t Size of Stack:" + sll.size() );
				}
					break;
				case 6: {
					StackList.menu();
					break;
				}
				
				}
			
		}

	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
