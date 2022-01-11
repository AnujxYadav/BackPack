import java.io.IOException;
import java.util.ArrayList;

public class comments implements addition, viewable {
    private String name, data;
    private java.util.Date date;
    private static ArrayList<comments> list = new ArrayList<>();
    @Override
    public void view() {
        if(list.size() == 0)
        {
            System.out.println("No comments");
            return;
        }
        for(comments temp : list)
        {
            System.out.println(temp.data + " - " + temp.name);
            System.out.println(temp.date + "\n");
        }
    }

    @Override
    public void add(String name) throws IOException {
        Reader.init(System.in);
        System.out.print("Enter comment: ");
        comments temp = new comments();
        temp.data = Reader.nextline();
        temp.name = name;
        temp.date = java.util.Calendar.getInstance().getTime();
        list.add(temp);
    }
    
}
