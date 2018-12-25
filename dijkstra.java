
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class dijkstra {

   
    public static void main(String[] args) 
    {   /*I am initially creating 2 different array list, My array list a1 will have all vertices and my array list a2 will have vertices included in my dijkstra*/
        ArrayList<Integer> a1=new ArrayList<Integer>();
        ArrayList<Integer> a2=new ArrayList<Integer>();
        System.out.println("Enter the number of vertices:");
        Scanner sc=new Scanner(System.in);
         int a=sc.nextInt();
        System.out.println("Enter the integer value of all vertices:");
        int arr[]=new int[a];
        for(int i=0;i<a;i++)
        {
        a1.add(i);
        }
        System.out.println("Select a particular vertex");
        int ver=sc.nextInt();
        a2.add(ver);
       int dist[][]=new int[a][a];
       int[][] result = new int[a][a]; 
       System.out.println("Enter the distance of vertex 0 to 0, 0 to 1, 0 to 2 and so on, for distance from 0 to 0 ,1 to 1 or distance between 2 not joint vertices enter 999 ");
       for(int i=0;i<a;i++)
       {
           for(int j=0;j<a;j++)
           {
               dist[i][j]=sc.nextInt();
		result[i][j] = 99999999;
           }
       }
/*Here i have stored the distance between all vertices*/

	 for(int i=0;i<a;i++)
       {
System.out.println(Arrays.toString(dist[i]));
         
       }

        a1.remove(a1.indexOf(ver));
        int x = ver;
        
        int count = 0;
/*My code, first checks if a1 containing all remaining nodes(nodes not included in dijsktra)is empty or no, if not empty it will traverse the array to find distance*/
        while( !a1.isEmpty())
        {
            for(int j =0;j<a;j++)
                if(!a2.contains(j))
              
            {
                
                            result[count][j] = dist[x][j];
                            
                            if(count!=0) 
                            {    result[count][j] = dist[x][j]+result[count-1][x];
                                if(result[count-1][j] < result[count][j]) {
                                    result[count][j] = result[count-1][j];
                                                                          }
                            }
                 
            }

           
	for(int j = 0;j<a;j++) {
		System.out.print(result[count][j] + "  ");
}
System.out.println(a2);

            x = FindMin(result[count], a);
		 count++;
            a2.add(x);
            a1.remove(a1.indexOf(x));
	
           
       }
/* printing the result*/
for(int j = 0;j<a;j++) {
		System.out.print(result[count][j] + "  ");
}
System.out.println(a2);
            
    }

/* finding the minimum distance*/
     public static  int FindMin(int []result,int a)
    {   int min=0;
        for(int i=0;i<a;i++)
        {
            if(result[i] < result[min])
            {
                min=i;
            }
        }
        return min;
    }
    
}


