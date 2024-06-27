package appcalculator;

/**
 *
 * @author lucas-gabreil_silva
 */
public class Stack {

    public static final int maxItems = 100;
    private int items;
    private Object stack[];
    private int top = -1;

    public Stack() {
        this.items = maxItems;
        stack = new Object[items];
    }

    public Stack(int items) {
        this.items = items;
        stack = new Object[items];
    }

    public void print() {
        if (!isEmpty()) {
            String answer = "";
            for (int i = 0; i <= top; i++) {
                answer += " [" + stack[i].toString() + "] ";
            }
            System.out.println(answer);
        } else {
            System.out.println("Stack's empty!");
        }
    }

    public boolean isEmpty() {
        return (top < 0);
    }
    
    public int getLength() {
        return (top + 1);
    }
    
    public Object getTop() {
        if(!isEmpty()){
            return stack[top];
        } else {
            return null;
        }
    }
    
    public void push(Object object){
        if(top < items - 1){
            top++;
            stack[top] = object;
        } else {
            System.out.println("Stack's full!");
        }
    }
    
    public Object pop(){
        if (!isEmpty()){
            return stack[top--];
        } else {
            return null;
        }
    }
}
