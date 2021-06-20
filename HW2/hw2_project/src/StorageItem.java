import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

abstract class StorageItem {
    private String name;
    private long date;
    protected int size;

    public StorageItem(String name){
        /** builder **/
        this.name = name;
        this.setDate();
        this.size = 0;
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

    public void setDate(){
        //find milliseconds from 1970 to 2021
        String strDate = "2021-12-31 23:59:59";
        Timestamp endOfTimesStamp= Timestamp.valueOf(strDate);
        Long milliseconds = endOfTimesStamp.getTime();

        //generate random long
        long longLottery = Main.rnd.nextLong();

        //set date
        if (longLottery < 0) {
            this.date = -longLottery % milliseconds;
        } else {
            this.date = longLottery % milliseconds;
        }
    }

    void printTree(SortingField field) {
        switch (field){
            case SIZE:
                //code
                break;
            case NAME:
                //code
                break;
            case DATE:
                //code
                break;

        }

    }

    void printree(Folder folder){
        printree_secondary(folder, 0);
        }
    }
    void printree_secondary (Folder folder, int i){
        for (int j=0; j<i; j++)
            System.out.print("| ") ;
        System.out.println();
        System.out.println(folder.getName());
        List<StorageItem> itemList;
        itemList = sortBy (folder);
        for (StorageItem item : folder){
            if (value.getClass() == File.class) {
                for (int j = 0; j < i; j++)
                    System.out.print("| ");
                System.out.println(item.getName());
            }
            if (value.getClass() == Folder.class)
                printree_secondary (item, i+1);
        }
    }





}
