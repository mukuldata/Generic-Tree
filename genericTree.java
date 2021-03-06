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


// @@5 *********Height of tree***********

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
   public static void traversals(Node node){
    //euler's left ,on the way deep in recursion ,node's pre area
    System.out.println("Node Pre "+node.data);
    for(Node child:node.children){
      //edge pre
      System.out.println("Edge Pre "+node.data+"--"+child.data);
      traversals(child);
      //edge post                     --IMP(at this point if time node is 10)
       System.out.println("Edge Post "+node.data+"--"+child.data);
    }
    //euler's right ,on the way out of recursion ,node's post area
    System.out.println("Node Post "+node.data);
   

    return;
  }

// ******************END***********

//7 ******************Level Order Traversal*********
	public static void levelOrder(Node node){
    //Using queue: No recursion
    Queue<Node>q=new ArrayDeque<>();
    q.add(node);

    //RPA algo: Remove-Print-Add;
      while(q.size()>0){
        node=q.remove();
        System.out.print(node.data+" ");

        for(Node child:node.children){
          q.add(child);
        }

      }
      System.out.print(".");
  }

// ******************END***********

//@@8**********Level Order Linewise ***************

//Using two queues : Main queue and child queue
  public static void levelOrderLinewise(Node node){
   Queue<Node> mq=new ArrayDeque<>();
   Queue<Node> cq=new ArrayDeque<>();
   mq.add(node);

   while(mq.size()>0){
     node=mq.remove();   
     System.out.print(node.data+" ");

     for(Node child:node.children){
       cq.add(child);
       }

       if(mq.size()==0){
       mq=cq;
       cq=new ArrayDeque<>();
       System.out.println();
       }
   }
}

// ******************END***********

//9 Level order Linewise :More approaches
//Approach2:  Using null after a level:
private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();

    Node(){

  }
   Node(int data){
    this.data=data;
  }
}
   //using null after a level:
public static void levelOrderLinewise2(Node node){
  Queue<Node>q=new ArrayDeque<>();
  q.add(node);
  q.add(new Node(-1)); //calling a parameterized constructor

  while(q.size()>0){
    node=q.remove();
    //if removed node is not null;
    if(node.data!=-1){
      System.out.print(node.data+" ");
      for(Node child:node.children){
        q.add(child);
      }
    }
    else{
      if(q.size()>0){
        q.add(new Node (-1));    //adding null
        System.out.println();
      }
    }
  }
}

//***************************************
// Approach 3:Using count variable: 
public static void levelOrderLinewise3(Node node){
  Queue<Node>q=new ArrayDeque<>();
  q.add(node);
 
  while(q.size()>0){
  int count=q.size();
  //After a level ,it will print a line:
   for(int i=1;i<=count;i++){
     node =q.remove();
     System.out.print(node.data+" ");
  
    for(Node child:node.children){
      q.add(child);
    }
  }
  System.out.println();
    
  }
}

// *************************************

// Approach 4: Using pair of level and node:
private static class Pair{
  Node node;
  int level;


  Pair(){

  }
  Pair(Node node,int level){
    this.node=node;
    this.level=level;
  }
}

public static void levelOrderLinewise4(Node node){
      Queue<Pair> q=new ArrayDeque<>();
      q.add(new Pair(node,1));
      int level=1;
      while(q.size()>0){
        Pair p=q.remove();
        if(p.level>level){
          level=p.level;
          System.out.println();
        }
        System.out.print(p.node.data+" ");

        for(Node child:p.node.children){
          Pair cp=new Pair(child,p.level+1);
          q.add(cp);
        }
      }
}

// ****************************END**********************

// 10 Mirror of generic tree:







