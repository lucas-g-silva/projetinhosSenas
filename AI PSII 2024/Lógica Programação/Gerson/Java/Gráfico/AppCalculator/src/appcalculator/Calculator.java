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
                System.out.print(rpn[i] + " ");
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
            if(operating && endOperating){
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
        while (!s.isEmpty()){
            arrayRpn[indexArray] = s.pop().toString();
            indexArray++;
        }
        return arrayRpn;
    }
    
    public double calculate(){
        Stack s = new Stack();
        double res = 0;
        for (int i = 0; rpn[i] != null; i++){
            input = rpn[i];
            
            if(isOperand(input)) {
                s.push(Double.parseDouble(input));
            } else if (isOperator(input)){
                double current = doOperation(input, s);
                s.push(current);
                res = current;
            }
        }
        return res;
    }
    
    public double doOperation(String oparator, Stack s){
        double temp;
        if(s.isEmpty()) {
            temp = 0;
        } else {
            temp = Double.parseDouble(s.pop().toString());
        }
        if (!s.isEmpty()){
            temp = calcValues(oparator, Double.parseDouble(s.pop().toString()), temp);
        }
        return temp;
    }
    
    public double calcValues(String operator, double left, double right){
        if (operator.equals("+")){
            return left + right;
        } else if (operator.equals("-")){
            return left - right;
        } else if (operator.equals("*")){
            return left * right;
        } else if (operator.equals("/")){
            if(right == 0){
                System.out.println("Error: Dividing by 0 isn't possible!");
                return left;
            }
            return left / right;
        } else {
            return left;
        }
    }
    
    public boolean isOperator(String input){
        if (input == null){
            return false;
        }
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }
    
    public boolean isOperand(String input){
        if (input == null) {
            return false;
        }
        
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public int pri(char op){
        int nPri = 0;
        if(op == '/' || op == '*'){
            nPri = 3;
        }
        if(op == '+' || op == '-'){
            nPri = 2;
        }
        if(op == '('){
            nPri = 1;
        }
        return nPri;
    }
}
public class Calculator {
    private char par;           // verifica se os pares de "(", "[" ou "{" estão corretos
    private boolean ok = true;  // retorno do método expOk()
    private String infix;      // Recebe a expressão INFIXA para decompor
   
    private String[] expInfix = new String[50];    // Guarda a expressão infixa decomposta em um valor
   
    private double result;   // guarda o resultado da expressão calculada
   
    private String[] rpn = new String[100];
    private String input = "";
   
    // constructor
    public Calculator() {
    }
   
    // ========= Métodos para converter e avaliar a expressão =========
    // avaliar a expressão
    public String evalExp(String strInFixa){
        if(expOk(strInFixa)){
            this.expInfix = decompose(strInFixa);
            this.rpn = posFix();
            System.out.println("Balenced expression!");
           
            for (int i = 0; rpn[i] != null; i++) {
                System.out.print(rpn[i] + " ");
            }
            this.result = calculate();
        }
        else{
            System.out.println("Unbalenced expression!");
        }
        return String.valueOf(result);
    }
   
    // verifica se a expressão está balanceada (OK)
    public boolean expOk(String str){
        Stack s = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == '(') {
                s.push(str.charAt(i));
            }
            else if (str.charAt(i) == ']' || str.charAt(i) == ')') {
                if (!s.isEmpty()) {
                    par = s.pop().toString().charAt(0);
                }
                else {
                    ok = false;
                }
                if (par != '[' && par != '(') {
                    ok = false;
                }
            }
        }
        if(!s.isEmpty()){
            ok = false;
        }
        return ok;
    }
   
    public String[] decompose(String str){
        this.infix = str;
        String[] arrayInfix = new String[50];
       
        int indexStart = 0;
        boolean operating = false;
        boolean endOperating = true;
        int indexArray = 0;
       
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if ((ch >= '0') && (ch <= '9')) {
                operating = true;
                endOperating = false;
            }
            else if ((ch == '(') || (ch == ')') || (ch == '*')
                    || (ch == '/') || (ch == '+') || (ch == '-')) {
                if (operating) {
                    endOperating = true;
                }
                else {
                    operating = false;
                    endOperating = false;
                }
            }
            if (operating && endOperating) { // se era um operando e terminou
                // coloca os operandos na matriz
                arrayInfix[indexArray] = infix.substring(indexStart, i);
                indexArray++;
                operating = false;
                indexStart = i;
               
                // coloca o operador na matriz
                arrayInfix[indexArray] = infix.substring(indexStart, i+1);
                indexArray++;
                indexStart = i + 1;
            }
            else if (!endOperating && !operating) { // se era um operador coloca na matriz
                arrayInfix[indexArray] = infix.substring(indexStart, i+1);
                indexArray++;
                indexStart = i + 1;
            }
        }
        if (indexStart < infix.length()) { // atualiza o restante da expressão
            arrayInfix[indexArray] = infix.substring(indexStart, infix.length());
        }
        this.expInfix = arrayInfix;
       
        return arrayInfix;
    }
   
    // converter arrayInfixa para Notação Polonesa Reversa (pós-fixa)
    public String[] posFix(){
        String[] arrayRpn = new String[100];
        Stack s = new Stack();
        int indexArray = 0;
       
        for (int i = 0; expInfix[i] != null; i++) {
            String value = expInfix[i];
           
            if(value.charAt(0) == '+' || value.charAt(0) == '-' || value.charAt(0) == '*' || value.charAt(0) == '/'){
                while (!s.isEmpty() && pri(s.getTop().toString().charAt(0)) >= pri(value.charAt(0))) {
                    arrayRpn[indexArray] = s.pop().toString();
                    indexArray++;
                }
                s.push(value);
            }
            else if (value.charAt(0) == '(') {
                s.push(value);
            }
            else if (value.charAt(0) == ')') {
                while (s.getTop().toString().charAt(0) != '(') {
                    arrayRpn[indexArray] = s.pop().toString();
                    indexArray++;
                }
                s.pop();
            }
            else {
                arrayRpn[indexArray] = value;
                indexArray++;
            }
        }
        while (!s.isEmpty()) {            
            arrayRpn[indexArray] = s.pop().toString();
            indexArray++;
        }
        return arrayRpn;
    }

    // === Métodos para executar a operação ===
    // Criar a operação
    public double calculate(){
        Stack s = new Stack();
        double res = 0;
        for (int i = 0; rpn[i] != null; i++) {
            input = rpn[i];
           
            // 1º verificar se é um operando ou um operador
            // criar a operação ==> Resultado = esquerdo OPERA Direito (res = x + y)
            // Calcular a operação e retornar o valor
            if (isOperand(input)) {
                s.push(Double.parseDouble(input));
            }
            else if (isOperator(input)) {
                double atual = doOperation(input, s);
                s.push(atual);
                res = atual;
            }
        }
        return res;
    }

    // preparar os operandos
    public double doOperation(String operator, Stack s){
        double temp;
        if (s.isEmpty()) {
            temp = 0;
        }
        else {
            temp = Double.parseDouble(s.pop().toString());
        }
        if (!s.isEmpty()) {
            temp = calcValores(operator, Double.parseDouble(s.pop().toString()), temp);
        }
        return temp;
    }

    // calcular valores
    public double calcValores(String operador, double esquerdo, double direito){
        if (operador.equals("+")) {
            return esquerdo + direito;
        }
        else if (operador.equals("-")) {
            return esquerdo - direito;
        }
        else if (operador.equals("*")) {
            return esquerdo * direito;
        }
        else if (operador.equals("/")) {
            if (direito == 0) {
                System.out.println("Erro: não pode dividir por zero");
                return esquerdo;
            }
            return esquerdo / direito;
        }
        else {
            return esquerdo;
        }
    }

    // === Métodos auxiliares ===
    // verificar se é um operador
    public boolean isOperator(String input){
        if (input == null) {
            return false;
        }
        return input.equals("+") || input.equals("-") || input.equals("/") || input.equals("*");
    }
   
    // verificar se é um operando
    public boolean isOperand(String input){
        if (input == null) {
            return false;
        }
       
        try {
            Double.parseDouble(input);
            return true;
        }
        catch(NumberFormatException ex){
            return false;
        }
    }
   
    // verificar e retornar a prioridade do operador
    private int pri(char op){
        int nPri = 0;
        if (op == '/' || op == '*') {
            nPri = 3;
        }
        if (op == '+' || op == '-') {
            nPri = 2;
        }
        if (op == '(') {
            nPri = 1;
        }
        return nPri;
    }
}
