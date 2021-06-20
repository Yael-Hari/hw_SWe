import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

enum SortingField
{
    SIZE,
    NAME,
    DATE;
}


class sortingMethods {

    void sort(Folder folder){
        List<StorageItem> mergeList = new ArrayList<StorageItem>();
        mergeList.addAll(folder.folderList);
        mergeList.addAll(folder.fileList);
        mergeList.sort(Comparator.comparing(StorageItem::getSize));
    }

    List<StorageItem> sortByName(Folder folder){
        List<StorageItem> mergeList = new ArrayList<StorageItem>();
        mergeList.addAll(folder.folderList);
        mergeList.addAll(folder.fileList);
        mergeList.sort(Comparator.comparing(StorageItem::getName));
        return mergeList;
    }

    List<StorageItem> sortByDate(Folder folder){
        List<StorageItem> mergeList = new ArrayList<StorageItem>();
        mergeList.addAll(folder.folderList);
        mergeList.addAll(folder.fileList);
        mergeList.sort(Comparator.comparing(StorageItem::getDate));
        return mergeList;
    }

    List<StorageItem> sortBySize(Folder folder){
        List<StorageItem> mergeList = new ArrayList<StorageItem>();
        mergeList.addAll(folder.folderList);
        mergeList.addAll(folder.fileList);
        mergeList.sort(Comparator.comparing(StorageItem::getSize));
        return mergeList;
    }
}

