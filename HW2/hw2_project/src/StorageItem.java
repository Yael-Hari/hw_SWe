import java.sql.Timestamp;

abstract class StorageItem {
    protected String name;
    protected long date;
    protected int size;

    public StorageItem(String name){
        /**
         * builder
         */
        this.name = name;
        this.setDate();
        this.size = 0;
    }
    public String getName() {
        return this.name;
    }

    public Timestamp getDate() {
        /** return the date in a Timestamp object
         *
         */
        Timestamp dateObj = new Timestamp(this.date);
        return dateObj;
    }

    public void setName(String new_name){
        this.name = new_name;
    }

    abstract int getSize();

    public void setDate(){
        /**set date in milliseconds since 2017
         *
         */
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

    }

    abstract void printTree(SortingField field);
}
