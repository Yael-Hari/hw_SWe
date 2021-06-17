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
             if (Folder.getName() == path_list[i])
                 return find_file_secondary(path_list,i+1, folder.folderList, folder.fileList)
         return null;
     }

     int getSize (){
        sum = 0;
        for(File file : this.fileList)
            sum += file.getsize();
        for (Folder folder : this.folderList){
            sum += getSize_secondary (folder);
        return sum;
        }
     }

     int getSize_secondary( Folder folder){
        sum = 0;
         for(File file : folder.fileList)
             sum += file.getsize();
         if (! folder.isEmpty())
             for (Folder i : folder.folderList)
                 sum +=  getSize_secondary (folder);
         return sum;
     }



}
