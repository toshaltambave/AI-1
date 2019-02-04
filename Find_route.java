


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/**
 *
 * @author tambavetoshalrajendra
 */
public class Find_route {
    
    
    public static void main(String[] args)
            
    {
        
        ReadInput r = new ReadInput();
        HashMap<Integer, Integer> parent;
        parent = new HashMap<Integer, Integer>();
        Integer flag=0;
        r.openFile();
        r.readFile();
        
        
        int som = r.getsizeofmatrix();
        int soc = r.getsizeofcitiA();
        List l1 = r.getCitiA(); // get all inputs about matrix
        List l2 = r.getCitiB();
        List fs = r.getSorted();
        List Distance = r.getDistance();

        
        int[][] adjMatrix = new int[som][som]; // create matrix
        int i;
        Integer rootnode = fs.indexOf(r.startNode);
        
        System.out.println("Root Node found at Index : "+rootnode);
        Integer finalnode = fs.indexOf(r.destNode);
        System.out.println("Destination of Search at node :"+finalnode);
        System.out.println("");
        System.out.println(""); 
        //System.out.println("Creating Adjecency Matrix using weights");
        
            for(i=0;i<soc;i++)
            
            {

                adjMatrix[fs.indexOf(l1.get(i))][fs.indexOf(l2.get(i))]=Integer.valueOf(String.valueOf(Distance.get(i)));
                adjMatrix[fs.indexOf(l2.get(i))][fs.indexOf(l1.get(i))]=Integer.valueOf(String.valueOf(Distance.get(i)));

            }
        
        /*/trying to print adjMat
        int i1,j1,k1;
        for(k1=0;k1<som;k1++){
                    System.out.printf(fs.get(k1)+" ");
                                  }
                            System.out.println("");
        for(i1=0;i1<som;i1++){
            
            for(j1=0;j1<som;j1++){
                
                System.out.print(adjMatrix[i1][j1]+"\t");
            }   
                System.out.println();
                
            
                
        }
            */
        // start ucs
        
                
        Queue<Integer> myQueue = new LinkedList<Integer>();
        List<Integer> Visited = new LinkedList<Integer>();
        Integer currentnode;
        myQueue.add(rootnode);//added root node
        break_outer_loop:
        while(!myQueue.isEmpty()){
            
            Integer poppedind =myQueue.remove();//remove first node from queue
            currentnode=poppedind;
            //System.out.println("popped node: "+poppedind);
            //Integer poppedind =fs.indexOf(popped);//find index of pooped node
            //System.out.println(poppedind+"poppedind : ");
            
            
            Visited.add(poppedind);//add the popped node into new list called visited
            //System.out.println("Visited node : "+Visited);
            int i2,j2;
            try{
            for(i2=0;i2<som;i2++)
            
            {
                //System.out.println("Current value of i2: "+i2);
            
                if(adjMatrix[poppedind][i2]>0)
                
                {
                    Integer a = i2;
                    
                    //System.out.println("Edge found from "+poppedind+" to "+a);
                    
                    if(!myQueue.contains(a)&&!Visited.contains(a)){
                    
                            if(a.equals(finalnode))
                                {
                
                                    
                                    myQueue.add(a);
                                    Visited.add(a);
                                    //System.out.println("Print final myQueue: "+myQueue);
                                    flag=1;
                                    break break_outer_loop;
            
                                }
                            //System.out.println("Adding "+a+" to myQueue");
                            myQueue.add(a);
                            //System.out.println("Print myQueue: "+myQueue);
                    }
                    //else if(myQueue.contains(a)){
                        //
                        
                }
            }
            }
            catch(Exception e)
            {
                System.out.println("Error in Input");
                flag=2;
                break break_outer_loop;
            }
            /*
            for(j2=0;j2<no;j2++){
                
                if(adjMatrix[poppedind][j2]>0)
                {
                    Integer a = j2;
                    if(!myQueue.contains(a)&&!Visited.contains(a)){
                    
                        if(a.equals(noden)){
                            return;
                        }
                        myQueue.add(a);
                }
            }
// found index of neighbours of popped nodes in Neighbour
            
            
        */    
                    
                    
               
        
        
        
        
        
        
    }
        System.out.println("");
     if(myQueue.isEmpty()||flag==0){
         if(flag==2)
             {
                 System.out.println("Check input and re run"); 
             }
         else
         System.out.println("Search Fails as Path does not exist between "+rootnode+" & "+finalnode);
     }
     
     else
        System.out.println("Sucess ! Path Exists Between "+rootnode+" & "+finalnode);
        
     
     /* . Code below could not be completed, it finds the path between bfs Visited nodes and sorts them
        However is is unimplemented
     
        LinkedList ls = new LinkedList();
        int[][] xyz = new int[som][som];
        int bestcost= 999,j,cost=0,savej;
        for(i=0;i<Visited.size();i++){
            for(j=0;j<som;j++)
            {
                
                
                if(adjMatrix[Visited.get(i)][j]>0)
               {
           
                 
                    xyz[Visited.get(i)][j]=j;
                   System.out.println("Added into Array xyz : "+xyz[i][j]);
               }
       }
        
        }
        for(i=0;i<xyz.length;i++)
        {
            
        System.out.println("");
            for(j=0;j<xyz.length;j++)
            {
        System.out.print(xyz[i][j]);
         
        }
        }
        int temp;
        int node=finalnode;
        for(i=node;i<xyz.length;i++)
        {
            if(xyz[node][i]>0||xyz[i][node]>0)
            {
                temp = xyz[node][i];
                ls.add(temp);
            }
        }
     */
    }
    
    
}


// class2 Starts



class ReadInput {
    

            public Integer sizeofcitiA, sizeofmatrix;
            private Scanner sc;
            public String filename,startNode,destNode;
            List<String> citiA = new ArrayList<String>();
            List<String> citiB = new ArrayList<String>();
            List<Integer> Distance = new ArrayList<Integer>();
            List<String> finalsort = new ArrayList<String>();
            Assignment1 one= new Assignment1();
    
    public void openFile(){
        
        
        System.out.println("Please provide input in following format");
        System.out.println("input_filename origin_city destination_city");
        
        sc = new Scanner(System.in);
        
        filename= sc.next();
        startNode = sc.next();
        destNode = sc.next();
        
        
        try {
                
                //System.out.println("Reading "+filename);
                File file = new File(filename);
                sc = new Scanner(file);
                
                
            }
                catch(Exception e){
                System.out.println(e);
        }
    }
    
    public void readFile(){
        
        
            while(sc.hasNext())
            {
                
                    
                
                String a= sc.next();
                if(a.equals("END"))//ENDs if the string 'END' is found in input file
                    {
                    break;
                    }
                
                citiA.add(a);//Add the values of First Column from input file to List CitiA
                String b= sc.next();
                citiB.add(b);//Add the values of Second Column from input file to List CitiB
                Integer c = Integer.valueOf(sc.next());
                Distance.add(c);//Add the values of Third Column from input file to List Distance
                
                
            
            }
                //System.out.println("Printing citiA entries: "+citiA);
                //System.out.println("Printing citiB entries: "+citiB);
                //System.out.println("Printing Distance entries: "+Distance);
                        
                
                        /*Following lines are responsible for String Handling i.e mainly converting the
                          Lists citiA, citiB & Distance into a format that will be used in formation of 
                          an Adjecency Matrix 
                            */
      
          Set<String> hs1 = new HashSet<String>();
           hs1.addAll(citiA);               //Adding citiA and citiB List into HashSet to remove possible duplicates
           hs1.addAll(citiB);
           TreeSet<String> sorted = new TreeSet<String>(hs1); // Converting Hashset into TreeSet to sort nodes Alphabetically for easy reading
           //System.out.println("HashSet sorted using TreeSet : " + sorted);
           finalsort.addAll(sorted);// Converting back into List as all operations have been performed
           sizeofcitiA = citiA.size();
           sizeofmatrix = sorted.size();
           
        
        //System.out.println("Size of Input columns(CitiA & CitiB) :  " +sizeofcitiA);
        //System.out.println("Size of Matrix :  " +sizeofmatrix);
        //System.out.println(finalsort);
        
        
    }
    public void closeFile(){
        sc.close();
    }
    
    
    public int getsizeofmatrix()
    {
        
        return sizeofmatrix;
        
    }
    public int getsizeofcitiA()
    {
        
        return sizeofcitiA;
        
    }
    
    public List getCitiA(){
        
        return citiA;
            
        }
    public List getCitiB(){
        
        return citiB;
            
        }
    public List getDistance(){
        
        return Distance;
            
        }
    
    
    public List getSorted(){
        
        return finalsort;
            
        }
    
    
    
}







