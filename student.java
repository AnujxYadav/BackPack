import java.io.IOException;

public class student implements login {

    @Override
    public void show_table() {
        System.out.println("1. View lecture materials");
        System.out.println("2. View assessments");
        System.out.println("3. Submit assessment");
        System.out.println("4. View grades");
        System.out.println("5. View comments");
        System.out.println("6. Add comments");
        System.out.println("7. Logout");
    }

    @Override
    public void operation(String name) throws IOException{
        Reader.init(System.in);
        while(true)
        {
            System.out.println("Welcome " + name);
            show_table();
            int choice = Reader.nextint();
            if(choice == 1)
            {
                viewable temp = new class_material();
                temp.view();
            }
            if(choice == 2)
            {
                viewable temp = new assignment_complex_functions();
                temp.view();
            }
            if(choice == 3)
            {
                submission temp = new assignment();
                temp.submit(name);
            }
            if(choice == 4)
            {
                assignment temp = new assignment();
                temp.view_grade(name);
            }
            if(choice == 5)
            {
                viewable temp = new comments();
                temp.view();
            }
            if(choice == 6)
            {
                addition temp = new comments();
                temp.add(name);
            }
            if(choice == 7)
            {
                break;
            }
        }
    }

    public void test(){

    }
    
}
