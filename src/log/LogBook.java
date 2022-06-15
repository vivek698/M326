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

    public void addEntry(String entry) throws IOException {
        if(fileWritingEnabled == true){
            writeFile(entry);
        }
    }

    public String  getEntry(int index){
        return entries.get(index);
    }

    public Vector<String> getAllEntries(int index){
        for (int i = 0; i < index; i++) {
            entries.get(index);
        }
        return entries;
    }

    public int getSize(){
        return entries.size();
    }

    public void LogBookClose() throws IOException {
            writer.close();
    }

    public void printLog(){
        for (String entry : entries) {
            System.out.println(entry);
        }
    }

    public void writeFile(String entry) throws IOException {
        writer.append(entry);
        writer.newLine();
        writer.flush();
    }

    public void readFile() throws IOException {
        while(reader.ready() == true){
            reader.readLine();
        }
    }
}
