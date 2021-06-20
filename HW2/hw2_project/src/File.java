public class File extends StorageItem{
    private String extension;
    private String fileContent;

    public File(String name, String extension) {
        super(name);
        this.extension = extension;
        this.fileContent = "";
    }

    @Override
    public String getName(){
        return this.name + "." + this.extension;
    }

    public int getSize(){
        this.size = this.fileContent.length();
        return this.size;
    }

    public void addContent(String content) {
        this.fileContent = content;
    }

    public void printContent(){
        System.out.println(this.getName() + " Size: " + this.getSize() + "MB" +
                " Created" + this.getDate());
    }

    void printTree(SortingField field){}
}
