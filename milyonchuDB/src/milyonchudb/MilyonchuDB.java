/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milyonchudb;

import Models.Question;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sevinc
 */
public class MilyonchuDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         DAO.DB db = new DAO.DB();
       Question q1 = new Question("Yanvar ayinda neche gun var?", "29", "32","21", "31");
        //db.saveQuestion(q1);
        int start = 1;
        while(start ==1 ){
            System.out.println("Welcome to game 'Milyonchu'!");
            System.out.println("Do you want to add new questions to game or start the game? (A/S)");
            String ans = in.next();
            if(ans.equals("A") || ans.equals("a")){
                String x = in.nextLine();
                System.out.println(x);
                System.out.println("Please, enter the question: ");
               String a = in.nextLine();
                if(a.isEmpty()) System.out.println("Please, enter the question2:");
                else{
                     System.out.println("Please, enter the first variant :");
                    String var1 = in.nextLine();
                      if(var1.isEmpty()) System.out.println("Please, enter the first variant :");
                      else {
                           System.out.println("Please, enter the second variant :");
                           String var2 = in.nextLine();
                      if(var2.isEmpty()) System.out.println("Please, enter the second variant :");
                      else{
                           System.out.println("Please, enter the third variant :");
                           String var3 = in.nextLine();
                      if(var3.isEmpty()) System.out.println("Please, enter the third variant :");
                      else{
                          System.out.println("Please, enter the right answer :");
                           String answer = in.nextLine();
                      if(answer.isEmpty()) System.out.println("Please, enter the right answer :");
                      else{
                          System.out.println("Thank you!");
                          Question new_question = new Question(a, var1, var2, var3, answer);
                          if(db.saveQuestion(new_question)) System.out.println("Question added successfully!");
                          else System.out.println("Sorry, something went wrong");
                           start = 0;
                System.out.println("Do you want play again? Y/N");
                String cavab = in.next();
                if(cavab.equals("Y") || cavab.equals("y")) start = 1;
                else {
                    System.out.println("See you again!");
                    return;
                    }
                      }
                      }
                      }
                      }
                }
            }
            else if (ans.equals("S") || ans.equals("s")){
                int general_score = 0;
                List <Question> list = new ArrayList<>();
                list = db.getAllQuestions();
                for (Question question : list) {
                    System.out.println(question.toString());
                    String answer = in.next();
                    if(answer.equals(question.getAnswer())){
                        System.out.println("You are right! ");
                        general_score ++;
                    }
                    else System.out.println("You answered wrong");
                    
                }
                System.out.println("Game is over! Your score is: "+ general_score + " !");
                start = 0;
                System.out.println("Do you want play again? Y/N");
                String cavab = in.next();
                if(cavab.equals("Y") || cavab.equals("y")) start = 1;
                else {
                    System.out.println("See you again!");
                    return;
                    }
                
            }
            else System.out.println("Please, enter A or S!");
        }
        
    }
    
}
