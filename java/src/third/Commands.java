package third;

import first.FileWorker;
import first.Md5Executor;

import java.io.File;
import java.util.HashMap;

public class Commands implements ICommand {

    private static FileWorker fw;
    public Commands(FileWorker fw){
        this.fw = fw;
    }

    public static String hash(String file) {
        Md5Executor md5Executor = new Md5Executor();
        HashMap<File, String> fileList = fw.execute(md5Executor);
        System.out.println(fileList);
        String hashCode = fileList.get(new File(file));
        if (hashCode == "null")
            hashCode = "hashcode is null,it`s fail hash";
        return "ANSWER:\n" + file + " " +  hashCode;
    }


    public static String list() {
        Md5Executor md5Executor = new Md5Executor();
        HashMap<File, String> fileList = fw.execute(md5Executor);
        StringBuilder resultList = new StringBuilder();
        for (HashMap.Entry<File,String> entry: fileList.entrySet()){
            resultList.append(entry.getKey() +"\n");
        }

        return "ANSWER:\n" + resultList.toString();
    }


}