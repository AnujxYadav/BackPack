import java.util.*;

public class student_user implements users {
    private String name;
    private int id;
    private ArrayList<student_user> list = new ArrayList<>();
    @Override
    public void add_user(String name)
    {
        int id = list.size();
        student_user temp = new student_user();
        temp.name = name;
        temp.id = id;
        list.add(temp);
    }
    @Override
    public String get_name(int id) {
        for(student_user temp : list)
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
        System.out.println("Students:");
        for(student_user temp : list){
            System.out.println(temp.id + " - " + temp.name);
        }
    }
}
