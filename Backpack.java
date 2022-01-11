import java.io.*;

public class Backpack{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);
        while(true)
        {
            System.out.println("Welcome to Backpack\n1. Enter as instructor\n2. Enter as student\n3. Exit");
            int choice = Reader.nextint();
            login s = new student();
            login i = new Instructor();
            student_user usr_s = new student_user();
            Instructor_user usr_i = new Instructor_user();
            usr_s.add_user("S0");
            usr_s.add_user("S1");
            usr_s.add_user("S2");
            usr_i.add_user("I0");
            usr_i.add_user("I1");
            int id, flag = 0;
            switch (choice) {
                case 1 -> {
                    usr_i.print_list();
                    id = Reader.nextint();
                    i.operation(usr_i.get_name(id));
                }
                case 2 -> {
                    usr_s.print_list();
                    id = Reader.nextint();
                    s.operation(usr_s.get_name(id));
                }
                default -> flag = 1;
            }
            if(flag == 1)
                break;
        }
    }
}
