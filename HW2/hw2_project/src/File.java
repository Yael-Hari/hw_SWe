public class File extends StorageItem{
    private String extension;
    private String fileContent;

    public File(String name, String extension) {
        /**
         * builder
         */
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

    public String getContent(){
        return this.fileContent;
    }

    public void addContent(String content) {
        this.fileContent = content;
    }

    public void printContent(){
        System.out.println(this.getName() + " Size: " + this.getSize() + "MB" +
                " Created: " + this.getDate() +
                "\n" + getContent());
    }

    void printTree(SortingField field){
        System.out.println(this.getName());
    }
}
