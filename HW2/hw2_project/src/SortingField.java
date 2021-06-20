import java.util.ArrayList;
import java.util.Arrays;

enum SortingField
{
    SIZE,
    NAME,
    DATE;
}

void sort(Folder folder){
    List<StorageItem> mergeList = new ArrayList<StorageItem>();
    mergeList.addAll(folder.folderList());
    mergeList.addAll(folder.fileList());
    mergeList.sort(Comparator.comparing(StorageItem::size));
}

