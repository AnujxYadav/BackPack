import java.io.IOException;

public class Instructor implements login{

    @Override
    public void show_table() {
        System.out.println("1. Add class material");
        System.out.println("2. Add assessments");
        System.out.println("3. View lecture materials");
        System.out.println("4. View assessments");
        System.out.println("5. Grade assessments");
        System.out.println("6. Close assessment");
        System.out.println("7. View comments");
        System.out.println("8. Add comments");
        System.out.println("9. Logout");
    }

    @Override
    public void operation(String name) throws IOException {
        Reader.init(System.in);
        while(true)
        {
            System.out.println("Welcome " + name);
            show_table();
            int choice = Reader.nextint();
            if(choice == 1)
            {
                addition temp = new class_material();
                temp.add(name);
            }
            if(choice == 2)
            {
                addition temp = new assignment();
                temp.add(name);
            }
            if(choice == 3)
            {
                viewable temp = new class_material();
                temp.view();
            }
            if(choice == 4)
            {
                viewable temp = new assignment();
                temp.view();
            }
            if(choice == 5)
            {
                grade temp = new assignment();
                temp.grading(name);
            }
            if(choice == 6)
            {
                close temp2 = new assignment();
                temp2.close(2);
            }
            if(choice == 7)
            {
                viewable temp = new comments();
                temp.view();
            }
            if(choice == 8)
            {
                addition temp = new comments();
                temp.add(name);
            }
            if(choice == 9)
            {
                break;
            }
        }
        
    }
    
}
