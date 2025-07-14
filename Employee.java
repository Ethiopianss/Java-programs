import java.util.Scanner;
/* 
 *  ##Best if it's run in the CMD, powershell or any other command Line interface (Linux)
 */
public class Employee {
    String  name;
    double salary;
    int hireDate;
    static void yearsOfService( int a){
        if(a>=1990 && a<=2024)
        System.out.println("Years of service: "+(2024-a));
        else
        System.out.println("Invalid Hire date");
    }
    public static void main(String[] args) {
        int a=0 ;
        Scanner input = new Scanner(System.in);
        Employee mycompany = new Employee();
        
           
           
           System.out.println("Type your name");
           mycompany.name = input.nextLine();
           System.out.println("Type your salary");
           mycompany.salary = input.nextDouble();
           System.out.println("Type your hiredate");
           mycompany.hireDate = input.nextInt();
           yearsOfService(mycompany.hireDate);
          System.out.println("would you like  to continue with the registering employees,\nTo continue =0\nTo not continue=1");
            int Answer = input.nextInt();

         while ( a <=4) {
            if(Answer == 0){
           System.out.println("Type your name");
           mycompany.name = input.next();
           System.out.println("Type your salary");
           mycompany.salary = input.nextDouble();
           System.out.println("Type your hiredate");
           mycompany.hireDate = input.nextInt();
           yearsOfService(mycompany.hireDate);
           System.out.println("would you like  to continue with the registering employees,\nTo continue =0\nTo not continue=1");
             Answer = input.nextInt();
                a++;
            }
            else if (Answer==1){
                break;
            }
            else{
                System.out.println("Invalid input, try again\nTo continue =0\nTo not continue=1");
            }

        }
        
    }
  

}
