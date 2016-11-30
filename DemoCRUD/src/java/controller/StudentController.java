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
import model.StudentManagedBean;
import connection.ConnectDB;
/**
 *
 * @author archi
 */
public class StudentController {
    public static Connection conn=null;
    public static PreparedStatement pstmt=null;
    public static ResultSet rs=null;
    public static String str="";
    
    public ArrayList<StudentManagedBean> getAllStudent(){
        
        ArrayList<StudentManagedBean> list= new ArrayList<>();
        ConnectDB connect = new ConnectDB();
        str="SELECT * FROM student";
        Connection conn= connect.getConnection();
        try {
            pstmt=conn.prepareStatement(str);
            rs=pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(rs.next()){
                StudentManagedBean student = new StudentManagedBean();
                student.setId(rs.getInt("id"));
                student.setLastName(rs.getString("lastName"));
                student.setFirstName(rs.getString("firstName"));
                list.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            connect.closeAll(conn, pstmt, rs);
        }
        return list;
    }
    
    public static void main(String[] args) {
        StudentController controller= new StudentController();
        ArrayList<StudentManagedBean> list;
        list = controller.getAllStudent();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getId()+" ");
            System.out.print(list.get(i).getFirstName()+" ");
            System.out.println(list.get(i).getLastName());       
        }
    }
}
