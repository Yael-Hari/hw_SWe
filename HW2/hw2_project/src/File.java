public class File extends StorageItem{
    private String extension;
    private String fileContent;

    public File(String name, String extension) {
        super(name);
        this.extension = extension;
        this.fileContent = "";
    }

    public String getName(){
        return this.getName() + "." + this.extension;
    }

    public int getSize(){
        return this.fileContent.length();
    }

    public void addContent(String content) {
        this.fileContent = content;
    }

    public void printContent(){
        System.out.println(this.getName() + " Size: " + this.getSize() + "MB" +
                " Created" + this.getDate());
    }
}
