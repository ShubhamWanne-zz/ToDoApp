/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shubham
 */
public class DataManager {
    List<Data> list;
    private final String fileName = "ToDoData.dat";
    public List<Data> getData(){
        list = new ArrayList<>();
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(fileName));
            String line;
            while((line=buffer.readLine())!=null){
                String line_arr[]=line.split("\\|");
                System.out.println(Arrays.toString(line_arr));
                Data data = new Data();
                list.add(data);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(list);
        return list; 
    }
    public void AddData(String todo,Date date){
        Calendar cal= Calendar.getInstance();
        cal.setTime(date);
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName, true));
            buffer.write(todo+"|"+cal.get(cal.DAY_OF_MONTH)+""+cal.get(cal.MONTH)+""+cal.get(cal.YEAR));
            buffer.newLine();
            buffer.close();
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        DataManager du=new DataManager();
        du.AddData("Shubham", Calendar.getInstance().getTime());
        du.AddData("Arun",Calendar.getInstance().getTime());
        du.AddData("Wanne",Calendar.getInstance().getTime());
        du.getData();
    }
}
