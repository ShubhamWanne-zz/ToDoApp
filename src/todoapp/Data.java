/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoapp;

import java.util.Calendar;

/**
 *
 * @author shubham
 */
public class Data {
         private String todo;
     private String date_string ;

     public String getTodo() {
        return todo;
    }
    public void setTodo(String todo){
        this.todo = todo;
    }
    public void setTodoDate(String date){
        this.date_string = date;
    }
    
    public String getToDoDate(){
        return date_string;
    }
    public static void main(String[] args) {

    }
}
