import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Folder extends StorageItem {
    List<Folder> folderList;
    List<File> fileList;

    public Folder(String name) {
        super(name);
        this.folderList = new ArrayList<Folder>();
        this.fileList = new ArrayList<File>();
    }

    boolean addItem(Folder folder){
        if (this.folderList.contains(folder))
            return false;
        else{
            this.folderList.add(folder);
            return true;
        }
    }

    boolean addItem(File file){
        if (this.fileList.contains(file))
            return false;
        else{
            this.fileList.add(file);
            return true;
        }
    }

     File findFile (String path){
         String[] path_list = path.split("/");
         return find_file_secondary(path_list, 0, this.folderList, this.fileList);
    }

     File find_file_secondary(String [] path_list, int i, List<Folder> folder_list, List<File> file_list){
         for (File file : file_list)
             if (file.getName() == path_list[i])
                 return file;
         for (Folder folder : folder_list)
             if (folder.getName() == path_list[i])
                 return find_file_secondary(path_list,i+1, folder.folderList, folder.fileList);
         return null;
     }

     int getSize (){
        int sum = 0;
        for(File file : this.fileList)
            sum += file.getSize();
        for (Folder folder : this.folderList){
            sum += getSize_secondary (folder);
        }
        this.size = sum;
        return sum;
     }

     int getSize_secondary( Folder folder){
        int sum = 0;
         for(File file : folder.fileList)
             sum += file.getSize();
         if (! folder.folderList.isEmpty())
             for (Folder i : folder.folderList)
                 sum +=  getSize_secondary (folder);
         return sum;
     }

    void printTree(SortingField field){
        printTreeSecondary(0, field);
    }

    void printTreeSecondary (Folder folder, int i, SortingField field){
        for (int j=0; j<i; j++)
            System.out.print("| ") ;
        System.out.println();
        System.out.println(folder.getName());
        List<StorageItem> itemList;
        Folder.sortFolder(field, folder);
        for (StorageItem item : folder){
            if (item.getClass() == File.class) {
                for (int j = 0; j < i; j++)
                    System.out.print("| ");
                System.out.println(item.getName());
            }
            if (item.getClass() == Folder.class)
                printTreeSecondary(item, i+1);
        }

    }




    static void sortFolder(SortingField field, Folder folder) {
        switch (field){
            case SIZE:
                SortingMethods.sortBySize(folder);
                break;
            case NAME:
                SortingMethods.sortByName(folder);
                break;
            case DATE:
                SortingMethods.sortByDate(folder);
                break;
            default:
                break;
        }

    }

}

