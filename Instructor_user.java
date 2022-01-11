import java.util.ArrayList;

public class Instructor_user implements users{
    private String name;
    private int id;
    private ArrayList<Instructor_user> list = new ArrayList<>();
    @Override
    public void add_user(String name)
    {
        int id = list.size();
        Instructor_user temp = new Instructor_user();
        temp.name = name;
        temp.id = id;
        list.add(temp);
    }
    @Override
    public String get_name(int id) {
        for(Instructor_user temp : list)
        {
            if(temp.get_id() == id)
                return temp.name;
        }
        return null;
    }
    @Override
    public int get_id() {
        return id;
    }
    
    @Override
    public void print_list() {
        System.out.println("Instructors:");
        for(Instructor_user temp : list){
            System.out.println(temp.id + " - " + temp.name);
        }
    }
}