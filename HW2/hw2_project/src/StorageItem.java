import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

class StorageItem {
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

//    abstract int getSize();

    public void setDate(){

        String strDate = "2021-12-31 23:59:59";
        Timestamp endOfTimesStamp= Timestamp.valueOf(strDate);
        Long milliseconds = endOfTimesStamp.getTime();
        System.out.println("milliseconds: " + milliseconds);

        Random rnd = new Random(42);
        long longLottery = rnd.nextLong(); //Main.rnd...
        System.out.println("longLottery: " + longLottery);

        long rightLimit = milliseconds;
        long generatedLong = (long) (Math.random() * rightLimit);

        this.date = longLottery % milliseconds;
        System.out.println("this.date = " + this.getDate());

    }


    public static void main(String[] args) {
        StorageItem item = new StorageItem("josh");

    }






}
