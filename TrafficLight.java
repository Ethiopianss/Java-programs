/* The Programmers 
 * @author Yezid Abdullahi --> ugr/54335/16
 * @author Rahma Jamal --> Ugrr/52265/15
 * @author Yohanes Mitiku --> ugrr/52992/15
 * @author Netsanet worku --> ugrr/52166/15
 * @author  Shmelis Solomon --> ugr/54825/17
 * @author Nasru Abu --> ugrr/52156/15
 *  ##Best if it's run in the CMD, powershell or any other command Line interface (Linux)
 */
public class TrafficLight{
    public static void main(String[] args) {
        // Duration of each traffic light
        Traffic yellow = new Traffic(1000);
        Traffic red = new Traffic(1500);
        Traffic green = new Traffic(2000);
        int loop =10;
        // "\033[0;31m";  // RED
        // "\033[0;32m";  // GREEN
        // "\033[0;33m";  // YELLOW
        // "\033[0m"     // Reset
        Traffic.isRedOrGreen(2);
        System.out.println("\033[0;31mRed light, stop\033[0m");
        System.out.println();
        if (Traffic.changeColor(2).equals("red")) {
            System.out.println("Counter 15sec");
            for (int i = 0; i < loop; i++) {
                for (int j = loop-1; j>i; j-- ){
                    System.out.print(" ");
                }
                for (int j = 1; j < i; j++) {
                  
                    System.out.print("\033[0;31m *\033[0m");   
                }
                
                System.out.println("");
                try {
                    Thread.sleep(red.duration);
                   } catch (Exception e) {
                    // TODO: handle exception
                   }
        }
        Traffic.isRedOrGreen(1);
        System.out.println("\033[0;32mGreen Light, go\033[0m");
        System.out.println();
        System.out.println("Counter: 20sec");
        if (Traffic.changeColor(1).equals("green")) {
            for (int i = 0; i < loop; i++) {
                for (int j = loop-1; j>i; j-- ){
                    System.out.print(" ");
                }
                for (int j = 1; j < i; j++) {
                  
                    System.out.print("\033[0;32m *\033[0m");   
                }
                
                System.out.println("");
                try {
                    Thread.sleep(green.duration);
                   } catch (Exception e) {
                    // TODO: handle exception
                   }
        }
        System.out.println("\033[0;33mYellow light, speed up\033[0m");
        System.out.println();
        System.out.println("Counter 10sec");
        if (Traffic.changeColor(3).equals("yellow")) {
            for (int i = 0; i < loop; i++) {
                for (int j = loop-1; j>i; j-- ){
                    System.out.print(" ");
                }
                for (int j = 1; j < i; j++) {
                  
                    System.out.print("\033[0;33m *\033[0m");   
                }
                
                System.out.println("");
                try {
                    Thread.sleep(yellow.duration);
                   } catch (Exception e) {
                    // TODO: handle exception
                   }
        }
        }
        }
    }


}}

/*
 * The keyword try and catch are part of the error handling mechanism
 * The Thread.sleep() might throws an InterruptedException if another threads interrupts the current thread while it's sleeping
 * the try keyword contain the exception and the catch keyword handle the exception.
 * Since ANSI color code escape aren't supported in NetBeans, I used powershell to run the program
 */