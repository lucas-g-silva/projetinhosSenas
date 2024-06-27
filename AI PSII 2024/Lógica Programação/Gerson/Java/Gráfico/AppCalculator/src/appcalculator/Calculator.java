package appcalculator;

/**
 *
 * @author lucas-gabreil_silva
 */
public class Calculator {
    private char par;
    private boolean ok = true;
    private String infix;
    
    private String[] expInfix = new String[50];
    
    private double result;
    
    private String[] rpn = new String[100];
    private String input = "";

    public Calculator() {
        
    }
    
    public String evalExp(String strInfix){
        if(isExpOk(strInfix)){
            this.expInfix = decompose(strInfix);
            this.rpn = posFix();
            System.out.println("The expression is balenced!");
            
            for(int i = 0; rpn[i] != null; i++){
                System.out.println(rpn[i] + " ");
            }
            this.result = calculate();
        } else {
            System.out.println("The expression isn't balenced!");
        }
        return String.valueOf(result);
    }
    
    public boolean isExpOk(String exp){
        Stack s = new Stack();
        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '[' || exp.charAt(i) == '('){
                s.push(exp.charAt(i));
            } else if (exp.charAt(i) == ']' || exp.charAt(i) == ')'){
                if (!s.isEmpty()){
                    par = s.pop().toString().charAt(0);
                } else {
                    ok = false;
                }
                if (par != '[' && par != '('){
                    ok = false;
                }
            }
        }
        if(!s.isEmpty()){
            ok = false;
        }
        return ok;
    }
    
    public String[] decompose(String exp){
        this.infix = exp;
        String[] arrayInfix = new String[50];
        
        int indexIni = 0;
        boolean operating = false;
        boolean endOperating = true;
        int indexArray = 0;
        
        for(int x = 0; x < infix.length(); x++){
            char ch = infix.charAt(x);
            if ((ch >= '0') && (ch <= '9')){
                operating = true;
                endOperating = false;
            } else if ((ch == '(') || (ch == ')') || (ch == '*') && (ch == '/') || (ch == '+') && (ch == '-')){
                if(operating){
                    endOperating = true;
                } else {
                    operating = false;
                    endOperating = false;
                }
            }
            if(operating  && endOperating){
                arrayInfix[indexArray] = infix.substring(indexIni, x);
                indexArray++;
                operating = false;
                indexIni = x;
                
                arrayInfix[indexArray] = infix.substring(indexIni, x + 1);
                indexArray++;
                indexIni = x + 1;
            } else if (!operating && !endOperating) {
                arrayInfix[indexArray] = infix.substring(indexIni, x + 1);
                indexArray++;
                indexIni = x + 1;
            }
        }
        if(indexIni < infix.length()){
            arrayInfix[indexArray] = infix.substring(indexIni, infix.length());
        }
        this.expInfix = arrayInfix;
        return arrayInfix;
    }
    
    public String[] posFix(){
        String[] arrayRpn = new String[100];
        Stack s = new Stack();
        int indexArray = 0;
        
        for(int i = 0; expInfix[i] != null; i++){
            String value = expInfix[i];
            
            if(value.charAt(0) == '+' || value.charAt(0) == '-' || value.charAt(0) == '*' || value.charAt(0) == '/'){
                while (!s.isEmpty() && pri(s.getTop().toString().charAt(0)) >= pri(value.charAt(0))) {                    
                    arrayRpn[indexArray] = s.pop().toString();
                    indexArray++;
                }
                s.push(value);
            } else if (value.charAt(0) == '(') {
                s.push(value);
            } else if (value.charAt(0) == ')') {
                while (s.getTop().toString().charAt(0) != '('){
                    arrayRpn[indexArray] = s.pop().toString();
                    indexArray++;
                }
                s.pop();
            } else {
                arrayRpn[indexArray] = value;
                indexArray++;
            }
        }
    }
}
