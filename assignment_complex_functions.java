import java.io.IOException;
import java.util.ArrayList;

public class assignment_complex_functions implements viewable, submission{
    private boolean graded;
    private int grade, id;
    private String file, gradedby;
    private final assignment assg = new assignment();
    @Override
    public void view() {
        ArrayList<assignment> list = assg.get_list();
        for (assignment temp : list) {
            if (temp.get_isclose())
                continue;
            if (temp.get_type() == 1)
                temp.print_assignment_task(temp);
            else
                temp.print_task(temp);
        }
    }

    @Override
    public boolean submit(String name) throws IOException {
        int flag = 0, counter = 0;
        ArrayList<assignment> list = assg.get_list();
        for (assignment temp : list) {
            if (temp.get_isclose())
                continue;
            ArrayList<String> slist = temp.get_slist();
            if(slist.contains(name))
                continue;
            flag = 1;
            if(counter == 0) {
                System.out.println("Pending assessments ");
                counter++;
            }
            if (temp.get_type() == 1)
                temp.print_assignment_task(temp);
            else
                temp.print_task(temp);
        }
        if(flag == 0) {
            System.out.println("No pending assessments ");
            return false;
        }
        System.out.print("Enter ID of assessment: ");
        id = Reader.nextint();
        int ty = 0;
        assignment temp = new assignment();
        for(assignment temp1 : list)
            if(temp1.get_id() == id) {
                ty = temp1.get_type();
                temp = temp1;
                break;
            }
        if(ty == 2)
        {
            System.out.print(temp.get_content() + " ");
            file = Reader.next();
            graded = false;
            grade = -1;
            return true;
        }
        System.out.print("Enter filename of assignment: ");
        String ans = Reader.next();
        if(!ans.substring(ans.length() - 4).equals(".zip")) {
            System.out.println("Enter a valid submission file!");
            return false;
        }
        file = ans;
        graded = false;
        grade = -1;
        return true;
    }

    public int get_id() {
        return id;
    }

    public String get_file() {
        return file;
    }

    public void set_grade(int marks)
    {
        this.grade = marks;
        this.graded = true;
    }

    public boolean isgraded() {
        return graded;
    }

    public void set_gradingby(String instrcutor_name) {
        gradedby = instrcutor_name;
    }

    public boolean get_graded_status() {
        return graded;
    }

    public int get_marks() {
        return grade;
    }

    public String get_gradedby() {
        return gradedby;
    }
}
