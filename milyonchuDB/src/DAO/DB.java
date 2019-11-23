/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sevinc
 */
public class DB {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
         public DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://40.114.28.193:3306/milyonchu?useEncoding=true&characterEncoding=UTF-8", "root", "p@ssw0rd123");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Can't connect");

        }
    

     
}
    public void close(){
       try{
            conn.close();
            ps.close();
       }
       catch(Exception e){
           System.out.println("Error occured during close: " + e.toString() );
           
       }
    }
    public boolean saveQuestion(Question question){
        try{
            ps = conn.prepareStatement("insert into questions (question, variant1, variant2, variant3, answer) values (?, ?, ?, ?,?)");
            ps.setString(1, question.getQuestion());
            ps.setString(2, question.getVariant1());
            ps.setString(3, question.getVariant2());
            ps.setString(4, question.getVariant3());
            ps.setString(5, question.getAnswer());
            ps.execute();
            return true;
            
        }
        catch(Exception e){
            System.out.println(e.toString());
            return false;
            
        }
    }
    public List<Question> getAllQuestions(){
        try{
            List <Question> list = new ArrayList<>();
            String sql = "SELECT * FROM questions";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Question q = new Question(rs.getString("question"), rs.getString("variant1"), rs.getString("variant2"), rs.getString("variant3"), rs.getString("answer"));
            list.add(q);
            }
            return list;
        }
        catch(Exception e){
            System.out.println("Error occured in to get all questions");
            return null;
        }
    }  //p@ssw0rd123
    // sudo mysql -u root -h 40.114.28.193 -P 3306 -p
 
    
   /*create table questions(
    question_id INT(100) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(1000),
     variant1 VARCHAR(30),
    variant2 VARCHAR(30),
    variant3 VARCHAR(30),
    answer VARCHAR(30)
     );

    }
*/
}
