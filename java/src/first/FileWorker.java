package first;

import java.io.File;
import java.util.HashMap;

public class FileWorker
{

    private String pathToFolder;

    private Boolean isRecursive = true;

    public void setIsREcursive(Boolean exp){
        isRecursive = exp;
    }

    public Boolean getIsRecursive(){
        return isRecursive;
    }

    public FileWorker(String path){
        pathToFolder = path;
    }

    private HashMap<File,String> fileList = new HashMap<File, String>();

     public HashMap<File,String> execute(IExecutable command){

        try {
            File mainFile = new File(pathToFolder);

            if (getIsRecursive()){
                recurse(mainFile);
            }
            else{
                for(File file: mainFile.listFiles()) {
                    fileList.put(file, "");
                }

            }

            for (HashMap.Entry<File,String> entry: fileList.entrySet()){
                fileList.put(entry.getKey(),command.proceess(entry.getKey()));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
         for (HashMap.Entry<File,String> entry: fileList.entrySet()){
             System.out.println(entry.getKey() + ":     "+ entry.getValue());
         }

         return fileList;
    }

        public void recurse(File f){
            for(File file: f.listFiles()){
                if (file.isDirectory()){
                    fileList.put(file,"");
                    recurse(file);
                }
                else fileList.put(file,"");

            }
        }

}
