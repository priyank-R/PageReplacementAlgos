package PageReplacementAlgorithms;      //Creating a package is optional. 
                                    //If you don't wish to create a package, call the method of FIFO directly in the mainClass (Given below)
import java.util.Scanner;
public class FIFO
{
    int PageRef;
    int front=-1, rear=-1;
    int[] frames = {99,99,99}; //For now, the size of the frames would be fixed 
    Scanner s = new Scanner(System.in);
    boolean queFlag = true;

    public void Operation()
    {
        int i = 0;
        int init3 = 0;
    
        int pageFaults = 0, pageHits = 0;
    
        
        try
        {
            while(PageRef!=-1)
            {
                System.out.println("Please enter a page number (Enter -1 to exit): ");
                PageRef = s.nextInt();
                queCheck(PageRef);
                System.out.println(queFlag);
                if(queFlag == false)
                {
                    
                    pageHits++;
                    queFlag=true;
                }
                else
                {

                    if(init3 == 3)
                    {
                        System.out.println("Jumped to here");

                           //Main Manips
                           frames[front] = PageRef; 
                           rear = front;
                           if(front == 2)
                           {
                               front =0;
                           }
                           else
                           {
                            front++;
                           }
                            pageFaults++;

                    }
                    else 
                    {
                        if(front == -1 && rear == -1 )
                        {
                            front = rear = 0;
                            frames[0] = PageRef; 
                            init3++;  
                            pageFaults++;
                        }
                        else
                        {
                            ++rear;
                            frames[rear] = PageRef;
                            init3++;
                            pageFaults++;
                        }
                    }  
                }         
            }
            System.out.println("Number of PageFaults = " + (pageFaults-1));
            System.out.println("Number of PageHits = " + pageHits);

            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Jumped to catch");
            System.out.println(e);
        }
        
      
    }
    private void queCheck(int a)
    {
        for(int k : frames)
        {
            if(a == k)
            {
                queFlag = false;
            }
        }
    }


}

/*class mainClass-> If one doesn't want to create the whole package
{
    FIFO obj = new FIFO();
    public static void main(String args[])
    {
        obj.Operation();
     }
 }
