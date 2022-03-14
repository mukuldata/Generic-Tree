// 1. ****Representation of Node in a tree *******
import java .util.*;


class Main{
private class Node{
       int data;
       ArrayList<Node> children =new ArrayList<>();
   }
}
// *****************

//Constructor of generic tree and display:
import java.util.*;

class GFG {
    private static class Node{
        int data;
        //ArrayList of nodes:
        ArrayList<Node> children =new ArrayList<>();
    }
    // d(10)  -> 10 will print itself and its family(expectation)
    //d( 20) ,d(30),d(40)  will print themselves and their family(faith)
    //d(10)  -> s(10)+d(20)+d(30)+d(40);   (Meeting expectation using faith)
    public static void display(Node node){
        String str=node.data+"->"+"";
        for(Node child:node.children){
            str+=child.data+",";
        }
        str+=".";
        System.out.println(str);
        
        //faith:
        for(Node child:node.children){
            display(child);
        }
    }
	public static void main (String[] args) {
	   
		int [] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		//Stack of nodes:
		Stack<Node>st=new Stack<>();   
		int n=arr.length;
		Node root=null;
	    
	    for(int i=0;i<n;i++){
	       if(arr[i]==-1){
	           st.pop();
	       }
	       else{
	       Node t=new Node();
	       t.data=arr[i];
	       
	       if(st.size()>0){
	           //Making child of topmost element in stack:
	          st.peek().children.add(t);
	       }
	       else{
	           root=t;
	       }
	       //Then push in stack
	       st.push(t);   
	       }
	    }
	    display(root);
	}
}





