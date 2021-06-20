import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

abstract class StorageItem {
    protected String name;
    protected long date;
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

    public Timestamp getDate() {
        Timestamp dateObj = new Timestamp(this.date);
        return dateObj;
    }

    public void setName(String new_name){
        this.name = new_name;
    }

    abstract int getSize();

    public void setDate(){
        //find milliseconds from 2017 to 2021
        String strDate = "2017-01-01 00:00:00";
        Timestamp startOfTimesStamp = Timestamp.valueOf(strDate);
        long millisecondsStart = startOfTimesStamp.getTime();

        strDate = "2021-12-31 23:59:59";
        Timestamp endOfTimesStamp = Timestamp.valueOf(strDate);
        long millisecondsEnd = endOfTimesStamp.getTime();

        long milliseconds = millisecondsEnd - millisecondsStart;

        //generate random long
        long longLottery = Main.rnd.nextLong();

        //set date
        if (longLottery < 0) {
            this.date = millisecondsStart + (-longLottery % milliseconds);
        } else {
            this.date = millisecondsStart + (longLottery % milliseconds);
        }

//        Calendar cal1 = Calendar.getInstance();
//        cal1.set(Calendar.DATE, 30);
//        cal1.set(Calendar.MONTH, 11);
//        cal1.set(Calendar.YEAR, 2021);
//        cal1.set(Calendar.HOUR, 23);
//        cal1.set(Calendar.MINUTE, 59);
//        cal1.set(Calendar.SECOND, 59);
//        Date date1 = cal1.getTime();
//
//        System.out.println("date: " + date1);

    }


    abstract void printTree(SortingField field);







}
