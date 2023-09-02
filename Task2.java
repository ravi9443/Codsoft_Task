import java.io.*;
import java.util.*;

public class Task2 {
    static void fileExist(String s)
    {
        String sb="";
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        File f=new File(s);
        if(f.exists())
        {
            try{
                FileInputStream fis=new FileInputStream(f);
                BufferedInputStream bis=new BufferedInputStream(fis);
                int ch;
                while((ch=bis.read())!=-1)
                    sb+=(char)ch;
                    String temp[]=sb.split("[&*.,;:#+-^?/{}@ !$%<>|()]");
                    for(String it:temp)
                    {
                        if(!it.equals(""))
                        {
                            set.add(it);
                          //  map.put(it, map.containsKey(it) ? (Integer) map.get(it) + 1 : 1);
                        }
                    }
                    System.out.println("Total no of unique words are "+set.size());
                    for(String it:set)
                    System.out.println(it);
                    // System.out.println("Words   "+   "   Frequencies");
                    // for (String word : set) {
                    //     System.out.println(word + "      " + map.get(word));
                    // }
                    bis.close();

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]) {
        Console con = System.console();
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        System.out.println("Enter the Text or File Path:");
        String path = con.readLine();
        File f1 = new File(path);
        if(!f1.exists())
        {
            String temp[]=path.split("[&*.,;:#+-^?/{}@ !$%<>|()]");
            for(String it:temp)
            {
                if(!it.equals(""))
                {
                    set.add(it);
                    //map.put(it, map.containsKey(it) ? (Integer) map.get(it) + 1 : 1);
                }
            }
            System.out.println("Total no of unique words are "+set.size());
            for(String it: set)
            System.out.println(it);
            // System.out.println("Words   "+   "   Frequencies");
            // for (String word : set) {
            //     System.out.println(word + "      " + map.get(word));
            // }

        }
        else
        {
            fileExist(path);
        }
    }
}
