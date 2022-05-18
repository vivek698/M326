package log;

import java.io.*;
import java.util.Vector;

public class LogBook {
    private Vector<String> entries;
    static LogBook instance;
    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;
    private boolean fileWritingEnabled = false;

    private LogBook() throws IOException {
        File f = new File("logbook.log");
        if(f.createNewFile() == false){
            BufferedReader reader = new BufferedReader(new FileReader(f));
            readFile();
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        }
    }

    public static LogBook getLogBookInstace() throws IOException {
        if(instance == null){
            new LogBook();
        }
        return instance;
    }

    public void addEntry(UserAction entry){}

    public UserAction getEntry(int index){
        return null;
    }

    public int getSize(){
        return entries.size();
    }

    public void LogBookClose(){}

    public void printLog(){}

    public void writeFile(){}

    public void readFile() throws IOException {
        while(reader.ready() == true){
            reader.readLine();
        }
    }
}
