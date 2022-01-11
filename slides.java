public class slides {
    private String topic;
    private int number;
    private String[] content;
    public void print(class_material temp)
    {
        System.out.println("Title: " + topic);
        for(int i = 0; i<number; i++)
        {
            System.out.println("Slide " + (i+1) + ": " + content[i]);
        }
        System.out.println("Number of slides: " + number + "\nDate of upload: " + temp.get_date(temp) + "\nUploaded by: " + temp.get_name(temp));
        System.out.println();
    }
    public void set_topic(String topic){
        this.topic = topic;
    }
    public void set_number(int number)
    {
        this.number = number;
    }
    public void set_content(String[] content)
    {
        this.content = content;
    }
}
