/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.BookController;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author archi
 */
@Named(value = "book")
@Dependent
public class BookManagedBean {

   private int id, studentid;
   private String bookName;
   private BookController controller=null;
    
   public int getId() {
        return id;
    }

    public int getStudentid() {
        return studentid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public BookController getController(){
        if(controller == null ){
            controller= new BookController();
            return controller;
        }
        return null;
    }
}
