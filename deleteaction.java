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


public class deleteaction{
private String BookName;
public String[] booktitle=new String[10];
    public  String execute(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        int aid=0;
        try {//dlfpsjfposdj
            System.out.println(BookName);
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("delete from book where name=\"" + BookName+"\"");
            return "sucess";
        } catch (Exception e) {
            System.out.println("error!");
            return "fail";
        } finally {
            ConnectionManager.close(conn, stmt, result);
        }
    }
    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName=BookName;
    }
}
