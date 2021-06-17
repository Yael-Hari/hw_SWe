import java.util.Arrays;

public class Folder extends StorageItem {
    super.name();
    List<Folder> folderList;
    List<file> fileList =;

    public Folder(String name) {
        super(name);
        this.folderList = new ArrayList<Folder>();
        this.fileList = new ArrayList<File>();
    }

    boolean add_item (Folder folder){
        if (this.folderList.contains(folder))
            return false;
        else{
            this.folderList.add(folder);
            return true;
        }
    }

    boolean add_item (File file){
        if (this.fileList.contains(file))
            return false;
        else{
            this.fileList.add(folder);
            return true;
        }
    }

     File findFile (string path){
         String[] path_list = path.split("/");
         return find_file_secondary(path_list, 0, this.folderList, this.fileList);
    }

     File find_file_secondary(Sting [] path_list, int i, List<Folder> folder_list, List<file> file_list){
         for (File file : file_list)
             if (file.getName() == path_list[i])
                 return file;
         for (Folder folder : folder_list)
             if (Folder.getName() == path_list[i])
                 return find_file_secondary(path_list,i+1, folder.folderList, folder.fileList)
         return null;
     }



}
