import java.io.IOException;
import java.util.ArrayList;

public class class_material implements viewable, addition {
    private videofile video;
    private slides sl;
    private int type;
    private java.util.Date date;
    private String name;
    private static ArrayList<class_material> list = new ArrayList<>();
    
    class_material(){
        video = new videofile();
        sl = new slides();
    }
    @Override
    public void add(String name) throws IOException {
        Reader.init(System.in);
        System.out.println("1. Add Lecture slide\n2. Add Lecture Video");
        int choice = Reader.nextint();
        if(choice == 1)
        {
            class_material temp = new class_material();
            temp.type = 0;
            System.out.print("Enter topic of slides: ");
            String ans = Reader.nextline();
            temp.sl.set_topic(ans);
            System.out.print("Enter number of slides: ");
            int n = Reader.nextint();
            temp.sl.set_number(n);
            System.out.println("Enter content of slides");
            String[] str = new String[n];
            for(int i = 0; i<n ; i++)
            {
                System.out.print("Content of slide " + (i+1) + ": ");
                str[i] = Reader.nextline();
            }
            temp.name = name;
            temp.date = java.util.Calendar.getInstance().getTime();
            temp.sl.set_content(str);
            list.add(temp);
        }
        else if(choice == 2)
        {
            class_material temp = new class_material();
            temp.type = 1;
            System.out.print("Enter topic of video: ");
            String ans = Reader.nextline();
            temp.video.set_topic(ans);
            System.out.print("Enter filename of video: ");
            ans = Reader.nextline();
            if(!ans.substring(ans.length() - 4).equals(".mp4"))
            {
                System.out.println("Enter a valid video file!");
                return;
            }
            temp.video.set_filename(ans);
            temp.name = name;
            temp.date = java.util.Calendar.getInstance().getTime();
            list.add(temp);
        }   
        else
        {
            System.out.println("Enter a valid choice");
            return;
        }
    }

    @Override
    public void view() {
        if(list.size() == 0)
        {
            System.out.println("No class/lecture material added");
            return;
        }
        for(class_material temp : list)
        {
            if(temp.type == 0)
                temp.sl.print(temp);
            else
                temp.video.print(temp);
        }
    }

    public java.util.Date get_date(class_material temp) {
        return temp.date;
    }

    public String get_name(class_material temp) {
        return temp.name;
    }
    
}
