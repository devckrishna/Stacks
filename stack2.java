import java.util.*;
class stack2{
    
    public static int[] nextLargest(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] greater=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                greater[i]=-1;
            }else{
                greater[i]=st.peek();
            }
            st.push(i);
        }
        return greater;
    }

    public static int[] nextSmallest(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] smaller=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                smaller[i]=-1;
            }else{
                smaller[i]=st.peek();
            }
            st.push(i);
        }
        return smaller;
    }


    public static boolean balanceBracktes(String s){
        Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {     
                stack.push(c);
            } else if(c == ']'|| c==')' || c=='}') {
                while(stack.peek() == c){
                    stack.pop();
                }
            } 

        }
        return stack.isEmpty();
    }

    public static int[] funGame(int[] arr){
        Stack<Integer> a=new Stack<>();
        Stack<Integer> b=new Stack<>();
        int[] ans=new int[arr.length];
        int i=0;
        int j=arr.length-1;
        while(i<arr.length){
            b.push(arr[i]);
            a.push(arr[j]);
            i++;
            j--;
        }
        int k=0;
        while(a.size()>0 && b.size()>0){
            if(a.peek()<b.peek()){
                a.pop();
                ans[k]=2;
                k++;
            }else if(a.peek()>b.peek()){
                b.pop();
                ans[k]=1;
                k++;
            }
            else if(a.peek()==b.peek()){
                a.pop();
                b.pop();
                arr[k]=0;
                k++;
            }
        }
        // System.out.println(a.isEmpty());
        // System.out.println(b.isEmpty());
        return ans;

    }

    public static int findMax(Stack<Integer> st){
        Stack<Integer> temp=st;
        int max=temp.peek();
        while(temp.size()>0){
            if(max<temp.pop()){
                max=temp.pop();
            }
        }
        return max;
    }
    public static void main(String[] args) {
        // int[] arr={3,7,1,7,8,4,5,2};
        // int[] fx=nextLargest(arr);
        // int[] gx=nextSmallest(arr);
        // int[] ans=new int[arr.length];
        // for(int i=0;i<arr.length;i++){
        //     int f=fx[i];
        //     if(f==-1){
        //         ans[i]=-1;
        //         continue;
        //     }
        //     int g=gx[f];
        //     if(g==-1){
        //         ans[i]=-1;
        //         continue;
        //     }
        //     ans[i]=arr[g];
        // }
        // for(int i=0;i<ans.length;i++){
        //     System.out.print(ans[i]+" ");
        // }
        // String str="{[()]}";
        // System.out.println(balanceBracktes(str));
        // int[] arr={3,6,5,2,4,1};
        // int[] ans=funGame(arr);
        // for(int i=0;i<ans.length;i++){
        //     System.out.print(ans[i]+" ");
        // }
        Stack<Integer> stack=new Stack<>();
        stack.push(20);
        stack.push(30);
        stack.push(10);
        stack.push(5);
        System.out.println(findMax(stack));
    }
}