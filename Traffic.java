

/*  
 *  ##Best if it's run in the CMD, powershell or any other command Line interface (Linux)
 */
public class Traffic{
    String color;
     int duration;
    Traffic(int a){
        
         duration = a;

    }
    static String changeColor(int a){
        /*
         * a ==1 -> green
         * a ==2 -> red
         * a ==3 ->yellow
         */
        if (a==1) {
            return ("green");
        }
        else if(a==2)
        return ("red");
        else if(a==3)
        return ("yellow");
        return ("no color");

    }
    
    static void isRedOrGreen(int b){
        if(b==1){
            System.out.println("The traffic light is green");
            System.out.println("The traffic light isn't red");
        }
       else{System.out.println("The traffic light is red");
       System.out.println("The traffic light isn't green");
   }}
        
    

}