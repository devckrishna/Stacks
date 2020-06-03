import java.util.*;
class stack3{
    static Scanner scn=new Scanner(System.in);

    public static int maxSum(int[] stack1,int[] stack2,int[] stack3,int n1,int n2,int n3 ){
        int s1=0;
        int s2=0;
        int s3=0;
        for(int i=0;i<n1;i++){
            s1+=stack1[i];
        }
        for(int i=0;i<n2;i++){
            s2+=stack2[i];
        }
        for(int i=0;i<n3;i++){
            s3+=stack3[i];
        }
        int top1=0;
        int top2=0;
        int top3=0;
        while(true){
            if(s1==s2 && s2==s3){
                return s1;
            }

            if(top1==n1 || top2==n2 || top3==n3){
                return 0;
            }

            if(s1>=s2 && s1>=s3){
                s1-=stack1[top1++];
            }else if(s2>=s1 && s2>=s3){
                s2-=stack2[top2++];
            }
            else if(s3>=s1 && s3>=s2){
                s3-=stack3[top3++];
            }
        }
    }

    public static int gameOfTwoStacks(int[] a,int[] b,int x){
        int sizeb=0;
        int sum=0;
        while(sizeb<b.length && sum+b[sizeb]<=x){
            sum+=b[sizeb];
            sizeb++;
        }
        int maxScore=sizeb;
        for(int sizea=1;sizea<=a.length-1;sizea++){
            sum+=a[sizea-1];
            while(sum>x && sizeb>0){
                sizeb--;
                sum-=b[sizeb];
            }
            if(sum>x){
                break;
            }
            maxScore=Math.max(maxScore,sizea+sizeb);
        }
        return maxScore;
    }

    public static int largestRectangle(int[] h){
        Stack<Integer> stack=new Stack<>();
        int[] nSOL=new int[h.length];
        int[] nSOR=new int[h.length];
        for(int i=0;i<h.length;i++){
            while(stack.size()>0 && h[stack.peek()]>=h[i]){
                stack.pop();
            }
            if(stack.size()==0){
                nSOL[i]=-1;
            }else{
                nSOL[i]=stack.peek();
            }
            stack.push(i);
        }
        stack=new Stack<>();
        for(int i=h.length-1;i>=0;i--){
            while(stack.size()>0 && h[stack.peek()]>=h[i]){
                stack.pop();
            }
            if(stack.size()==0){
                nSOR[i]=h.length;
            }else{
                nSOR[i]=stack.peek();
            }
            stack.push(i);
        }
        int maxArea=h[0]*(nSOR[0]-nSOL[0]-1);
        for(int i=1;i<h.length;i++){
            int height=h[i];
            int width=nSOR[i]-nSOL[i]-1;
            int currA=height*width;
            if(currA>maxArea){
                maxArea=currA;
            }
        }
        return maxArea;
    }

    public static void textEditor(){
        Stack<String> stack=new Stack<>();
        int n=scn.nextInt();
        String s="";
        String s1="";
//--------USE SWITCH CASES INSTEAD OF ELSE IF----------------------------------------------->
        for(int i=0;i<n;i++){
            int x=scn.nextInt();
            if(x==1){
                stack.push(s);
                s1=scn.next();
                s=s+s1;
            }else if(x==2){
                stack.push(s);
                int k=scn.nextInt();
                s=s.substring(0,s.length()-k);
            }else if(x==3){
                int w=scn.nextInt();
                System.out.println(s.charAt(w-1));
            }else if(x==4){
                s=stack.peek();
                stack.pop();
            }
        }

    }

    public static void main(String[] args) {
        // int stack1[] = { 3, 2, 1, 1, 1 }; 
        // int stack2[] = { 4, 3, 2 }; 
        // int stack3[] = { 1, 1, 4, 1 }; 
         
        // int n1 = stack1.length; 
        // int n2 = stack2.length; 
        // int n3 = stack3.length; 
         
        // System.out.println(maxSum(stack1, stack2,  
        //                      stack3, n1, n2, n3));
        // int[] a={4,2,4,6,1};
        // int[] b={2,1,8,5};
        // System.out.println(gameOfTwoStacks(a, b, 10));
        // int[] arr={1,2,3,4,5};
        // System.out.println(largestRectangle(arr));

    }
}