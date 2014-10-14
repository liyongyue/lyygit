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


public class showdetailaction{
private String book;
public String[] detail=new String[6];
public String[] booktitle=new String[10];
    public  String execute(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        int aid=0;
        try {
            int i=0;
            conn = ConnectionManager.getConnection();
           stmt = conn.prepareStatement("select * from book where title=\""+book+"\"");
           result = stmt.executeQuery();
           result.next();
           detail[0]=result.getString(1);
           detail[1]=result.getString(2);
           detail[2]=result.getString(3);
           detail[3]=result.getString(4);
           detail[4]=result.getString(5);
           detail[5]=result.getString(6);
            return "sucess";
        } catch (Exception e) {
            System.out.println("error!");
            return "fail";
        } finally {
            ConnectionManager.close(conn, stmt, result);
        }
    }
    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book=book;
    }
}
