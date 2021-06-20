import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

enum SortingField
{
    SIZE,
    NAME,
    DATE;
}

class SortingMethods {

    public static List<StorageItem> sortByName(Folder folder){
        /**sort by name
         * return sorted List
         */
        List<StorageItem> mergeList = new ArrayList<StorageItem>();
        mergeList.addAll(folder.folderList);
        mergeList.addAll(folder.fileList);
        mergeList.sort(Comparator.comparing(StorageItem::getName));
        return mergeList;
    }

    public static List<StorageItem> sortByDate(Folder folder){
        /**sort by date
         * return sorted List
         */
        List<StorageItem> mergeList = new ArrayList<StorageItem>();
        mergeList.addAll(folder.folderList);
        mergeList.addAll(folder.fileList);
        mergeList.sort(Comparator
                .comparing(StorageItem::getDate)
                .thenComparing(StorageItem::getName));
        return mergeList;
    }

    public static List<StorageItem> sortBySize(Folder folder){
        /**sort by size
         * return sorted List
         */
        List<StorageItem> mergeList = new ArrayList<StorageItem>();
        mergeList.addAll(folder.folderList);
        mergeList.addAll(folder.fileList);
        mergeList.sort(Comparator
                .comparing(StorageItem::getSize)
                .thenComparing(StorageItem::getName));
        return mergeList;
    }
}



