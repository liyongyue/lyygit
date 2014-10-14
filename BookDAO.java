/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.com;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;


public class BookDAO{
private String authorName;
public String[] booktitle=new String[10];
    public  String execute(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        int aid=0;
        try {
            System.out.println(authorName);
            int i=0;
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from author where name=\"" + authorName+"\"");
            result = stmt.executeQuery();
            result.next();
System.out.println("Author id: " + result.getInt(1) + "\nName: " + result.getString(2) + "\nAge: " + result.getInt(3) + "\nCountry: " + result.getString(4));
           aid=result.getInt(1);
           System.out.println(aid);
           stmt = conn.prepareStatement("select * from book where authorid="+aid);
           result = stmt.executeQuery();
            while (result.next()){
                booktitle[i]=result.getString(2);
                System.out.println(booktitle[i]);
                i++;
            }

            return "sucess";
        } catch (Exception e) {
            System.out.println("error!");
            return "fail";
        } finally {
            ConnectionManager.close(conn, stmt, result);
        }
    }
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName=authorName;
    }
}
