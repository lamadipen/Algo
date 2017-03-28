package interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dipen on 3/15/2017.
 */
public class TryWithResourceExample {
    public static void main(String[] args)
    {
        try(BufferedReader br=new BufferedReader(new FileReader("d:\\myfile.txt")))
        {
            String str;
            while((str=br.readLine())!=null)
            {
                System.out.println(str);
            }
        }catch(IOException ie)
        {  System.out.println("exception");  }
    }

}
