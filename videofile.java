public class videofile{
    private String topic, filename;
    public void print(class_material temp)
    {
        System.out.println("Title of video: " + topic + "\nVideo file: " + filename + "\nDate of upload: " + temp.get_date(temp) + "\nUploaded by: " + temp.get_name(temp));
        System.out.println();
    }
    public void set_topic(String topic){
        this.topic = topic;
    }
    public void set_filename(String filename)
    {
        this.filename = filename;
    }
}
