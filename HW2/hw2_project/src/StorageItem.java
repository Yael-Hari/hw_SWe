import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

abstract class StorageItem {
    private String name;
    private long date;

    public StorageItem(String name){
        /** builder **/
        this.name = name;
        this.setDate();
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






}
