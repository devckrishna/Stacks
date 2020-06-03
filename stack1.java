import java.util.*;
class stack1{

    public static int priority(char ch){
        if(ch=='^'){
            return 3;
        }else if(ch=='/' || ch=='*'){
            return 2;
        }else if(ch=='+' || ch=='-'){
            return 1;
        }else{
            return 0;
        }
    }


    public static String infixToPostfix(String str){
        String res="";
        Stack<Character> optrs=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch>='a' && ch<='z'){
                res+=ch;
            }else if(ch=='('){
                optrs.push(ch);
            }else if(ch==')'){
                while( optrs.size()>0&& optrs.peek()!='('){
                    char opt=optrs.pop();
                    res+=opt;
                }
                optrs.pop();
            }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^'){
                while(optrs.size()>0 && optrs.peek()!='(' && priority(optrs.peek())>=priority(ch)){
                    char opt=optrs.pop();
                    res+=opt;
                }
                optrs.push(ch);
            }
        }
        while( optrs.size()>0 ){
            char opt=optrs.pop();
            res+=opt;
        }
        
        return res;
    }

    public static String postFixToInfix(String str){
        Stack<String> oprnds=new Stack<>();
        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);
            if(ch>='a' && ch<='z'){
                oprnds.push(""+ch);
            }
            else if( ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^'){
                String op1=oprnds.pop();
                String op2=oprnds.pop();
                oprnds.push("("+op1+ch+op2+")");
            }
        }
        return oprnds.peek();
    }
    public static void main(String[] args) {
        String str="*+ab-cd";
        System.out.println(postFixToInfix(str));
    }
}