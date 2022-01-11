import java.io.IOException;
import java.util.ArrayList;

public class assignment implements addition, viewable, assignemnt_task, quiz, close, submission, grade {
    private int marks, type, id;
    private String content, name;
    private boolean isclose;
    private final ArrayList<String> slist = new ArrayList<>();
    private final ArrayList<assignment_complex_functions> flist = new ArrayList<>();
    private static final ArrayList<assignment> list = new ArrayList<>();
    assignment(){
        isclose = false;
    }

    @Override
    public void add(String name) throws IOException {
        System.out.println("1. Add Assignment\n" + "2. Add Quiz");
        int choice = Reader.nextint();
        if (choice == 1)
            assignment_task(name);
        else
            quiz_task(name);
    }

    @Override
    public void view() {
        for(assignment temp : list){
            if(temp.type == 1)
                print_assignment_task(temp);
            else
                print_task(temp);
        }
    }

    @Override
    public void assignment_task(String name) throws IOException {
        assignment temp = new assignment();
        temp.type = 1;
        System.out.print("Enter problem statement: ");
        temp.content = Reader.nextline();
        System.out.print("Enter max marks: ");
        temp.marks = Reader.nextint();
        temp.name = name;
        temp.id = list.size();
        list.add(temp);
    }

    @Override
    public void print_assignment_task(assignment temp) {
        System.out.println("ID: " + temp.id + " Assignment: " + temp.content + " Max Marks: " + temp.marks);
        System.out.println("----------------------------");
    }

    @Override
    public void quiz_task(String name) throws IOException {
        assignment temp = new assignment();
        temp.type = 2;
        System.out.print("Enter quiz question: ");
        temp.content = Reader.nextline();
        temp.marks = 1;
        temp.name = name;
        temp.id = list.size();
        list.add(temp);
    }

    @Override
    public void print_task(assignment temp) {
        System.out.println("ID: " + temp.id + " Question: " + temp.content);
        System.out.println("----------------------------");
    }

    @Override
    public void close(int text) throws IOException {
        System.out.println("List of Open Assignments: ");
        viewable temp = new assignment_complex_functions();
        temp.view();
        System.out.print("Enter id of assignment to close: ");
        int id = Reader.nextint();
        for(assignment temp2 : list) {
            if (temp2.id == id)
                temp2.isclose = true;
        }
    }

    public int get_type() {
        return type;
    }

    public ArrayList<assignment> get_list() {
        return list;
    }

    public boolean get_isclose() {
        return isclose;
    }

    @Override
    public boolean submit(String name) throws IOException {
        assignment_complex_functions acf = new assignment_complex_functions();
        if(!acf.submit(name))
            return false;
        for(assignment temp : list) {
            if (temp.id == acf.get_id())
            {
                temp.slist.add(name);
                temp.flist.add(acf);
            }
        }
        return true;
    }

    public ArrayList<String> get_slist() {
        return slist;
    }

    @Override
    public void grading(String name) throws IOException {
        view();
        System.out.print("Enter ID of assessment to view submissions: ");
        int id = Reader.nextint();
        System.out.println("Choose ID from these ungraded submissions");
        for(assignment temp : list) {
            if(temp.id == id)
            {
                show(temp, name);
                break;
            }
        }
    }

    public void show(assignment temp, String instrcutor_name) throws IOException {
        int flag = 0;
        if(temp.flist.size() <= temp.id)
            return;
        assignment_complex_functions acf = temp.flist.get(temp.id);
        for(int i = 0; i<temp.slist.size(); i++){
            if(acf.isgraded())
                continue;
            System.out.println(i + ". " + temp.slist.get(i));
            flag = 1;
        }
        if(flag == 0)
            return;
        int id = Reader.nextint();
        String name = temp.slist.get(id);

        System.out.println("Submission: " + acf.get_file());
        System.out.println("-------------------------------");
        System.out.println("Max Marks: " + temp.marks);
        System.out.print("Marks scored: ");
        int grade = Reader.nextint();
        acf.set_grade(grade);
        acf.set_gradingby(instrcutor_name);
    }

    public void view_grade(String name)
    {
        System.out.println("Graded submissions\n");
        graded_submission(name);
        System.out.println("Ungraded submissions\n");
        ungraded_submission(name);
    }

    private void ungraded_submission(String name) {
        for(assignment assg : list)
        {
            if(assg.slist.contains(name))
            {
                int i;
                for(i = 0; i<assg.slist.size(); i++) {
                    if (assg.slist.get(i).equals(name))
                        break;
                }
                assignment_complex_functions temp = assg.flist.get(i);
                if(!temp.get_graded_status())
                {
                    System.out.println("Submission: " + temp.get_file());
                    System.out.println("----------------------------");
                }
            }
        }
    }

    private void graded_submission(String name) {
        for(assignment assg : list)
        {
            if(assg.slist.contains(name))
            {
                int i;
                for(i = 0; i<assg.slist.size(); i++) {
                    if (assg.slist.get(i).equals(name))
                        break;
                }
                assignment_complex_functions temp = assg.flist.get(i);
                if(temp.get_graded_status()) {
                    System.out.println("Submission: " + temp.get_file());
                    System.out.println("Marks scored: " + temp.get_marks());
                    System.out.println("Graded by: " + temp.get_gradedby());
                    System.out.println("----------------------------");
                }
            }
        }
    }

    public String get_content() {
        return content;
    }

    public int get_id() {
        return id;
    }
}
