// 1. ****Representation of Node in a tree *******
import java .util.*;


class Main{
private class Node{
       int data;
       ArrayList<Node> children =new ArrayList<>();
   }
}
// *****************END**********

// 2. *****Constructor of generic tree and display****
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

//***************END***********

// 3. *********Size of tree********

//s(10)--> 1+s(20)+s(30)+s(40)
public static int size(Node node){
    int s=0;
    // System.out.println("Node is "+node.data);
    //faith: 20 ,30 and 40 will give size of their children

    for(Node child:node.children){
      int cs= size(child);
     
      s+=cs;
    }
    //for root itself:
    s=s+1;  

    return s;
  }
// ******************END********


// 4 *********Maximum of a tree******


//Faith: max of(m(20),m(30),m(40))
//Maximum of root and all other max:
public static int max(Node node){
    int mx=Integer.MIN_VALUE;

    //Faith:
    for(Node child:node.children){
        int cm=mx(child);
        mx=Math.max(cm,mx);
    }
    //Checking with root:
    mx=Math.max(node.data,mx);

    
    return mx;
}

// ******************END********


// 5 *********Height of tree***********

//Height:Edges distance bw deepest node and root
// Or    distance in terms of nodes 

  public static int height(Node node) {
    //In terms of edges the height of single node will be 1 if h=0;
    //So h=-1 so height can be correct;
    int ht=-1;
    //faith:
    for(Node child:node.children){
      int ch=height(child);  //child height
      ht=Math.max(ch,ht);

    }
    ht+=1;

    return ht;
  }

// ******************END***********

// 6 *****************Traversal in generic tree ****************
   

// ******************END***********





