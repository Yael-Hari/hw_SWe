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
        List<StorageItem> mergeList = new ArrayList<StorageItem>();
        mergeList.addAll(folder.folderList);
        mergeList.addAll(folder.fileList);
        mergeList.sort(Comparator.comparing(StorageItem::getName));
        return mergeList;
    }

//    //Compare by first name and then last name
//    Comparator<Employee> compareByName = Comparator
//            .comparing(Employee::getFirstName)
//            .thenComparing(Employee::getLastName);

    public static List<StorageItem> sortByDate(Folder folder){
        List<StorageItem> mergeList = new ArrayList<StorageItem>();
        mergeList.addAll(folder.folderList);
        mergeList.addAll(folder.fileList);
        mergeList.sort(Comparator
                .comparing(StorageItem::getDate)
                .thenComparing(StorageItem::getName));
        return mergeList;
    }

    public static List<StorageItem> sortBySize(Folder folder){
        List<StorageItem> mergeList = new ArrayList<StorageItem>();
        mergeList.addAll(folder.folderList);
        mergeList.addAll(folder.fileList);
        mergeList.sort(Comparator
                .comparing(StorageItem::getSize)
                .thenComparing(StorageItem::getName));
        return mergeList;
    }
}



