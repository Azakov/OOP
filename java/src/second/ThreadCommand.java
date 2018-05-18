package second;

import first.FileWorker;
import third.Commands;

import java.io.*;
import java.net.Socket;

public class ThreadCommand extends  ThreadedTask {

    private Socket socket;
    private FileWorker fileWorker;
    public ThreadCommand(Socket socket, FileWorker fw){
        this.socket = socket;
        this.fileWorker = fw;
    }
    @Override
    public void work() {
        Boolean isWork = true;
        while (isWork){
            try{
                InputStream sin = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();
                DataInputStream in = new DataInputStream(sin);
                DataOutputStream out = new DataOutputStream(sout);
                Commands commands = new Commands(fileWorker);
                String command = in.readUTF();
                String result = "WRONG COMMAND: Choose one of the command:\nlist\nhash PATH_TO_FILE\nstop";
                String[] commandSplit = command.split(" ",2);
                switch (commandSplit[0].toLowerCase()){
                    case "list":
                        result = commands.list();
                        break;
                    case "hash":
                        System.out.println(commandSplit[1]);
                        if (commandSplit[1].length() > 1)
                            result = commands.hash(commandSplit[1]);
                        else
                            result = "Hash has not path";
                        break;
                    case "stop":{
                        result = "Stop client";
                        isWork = false;
                    }
                }
                out.writeUTF(result);
                Thread.sleep(1000);
            }  catch (IOException|InterruptedException e){
                e.printStackTrace();
            }
        }


    }
}
