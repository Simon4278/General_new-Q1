import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
public class Main{
    
    public static void main(String[] args) {
        System.out.println("please input userid");
        // User can input the wanted user id
        Scanner sc = new Scanner(System.in);
        String userid = sc.nextLine();
        getURLContent("http://fg-69c8cbcd.herokuapp.com/user/"+userid);
    }
    /*
     * getURLContent is used to do http connection
     * */
    public static String getURLContent(String urlStr) {               
        // the address of the internet       
        URL url = null;              
        // Input Stream   
        BufferedReader in = null;   
        StringBuffer sb = new StringBuffer();   
        try{     
            url = new URL(urlStr);     
            in = new BufferedReader( new InputStreamReader(url.openStream(),"UTF-8") );   
            String str = null;    
            while((str = in.readLine()) != null) {    
                sb.append( str );     
            }     
        } 
        catch (Exception ex) {   
             
        } 
        finally{    
            try{
                if (in != null) {
                    in.close();     
                }     
            }
            catch(IOException ex) {      
            }     
        }     
        String result =sb.toString();     
        System.out.println(result);     
        return result;    
    }    
}
