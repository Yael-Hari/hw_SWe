abstract class StorageItem {
    private String name;
    private long date;

    public StorageItem(String name){
        /** builder **/
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public long getDate() {
        return this.date;
    }

    public void setName(String new_name){
        this.name = new_name;
    }

    abstract int getSize();








}
