/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BookManagedBean;

/**
 *
 * @author archi
 */
public class BookController {
    public static Connection conn=null;
    public static PreparedStatement pstmt=null;
    public static ResultSet rs=null;
    public static String str="";
    public ArrayList<BookManagedBean> getAllStudent(){
        
        ArrayList<BookManagedBean> list= new ArrayList<>();
        ConnectDB connect = new ConnectDB();
        str="Select Name from book where book.Name in (select Name \n" +
"FROM student,book\n" +
"WHERE book.studentid=1);";
        Connection conn= connect.getConnection();
        try {
            pstmt=conn.prepareStatement(str);
            rs=pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(rs.next()){
                BookManagedBean book = new BookManagedBean();
                book.setBookName(rs.getString("Name"));
                list.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            connect.closeAll(conn, pstmt, rs);
        }
        return list;
    }
    
     public static void main(String[] args) {
        BookController controller= new BookController();
        ArrayList<BookManagedBean> list;
        list = controller.getAllStudent();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getBookName());       
        }
    }
}
