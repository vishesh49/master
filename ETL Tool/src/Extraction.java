import java.sql.*;
import java.util.*;
import java.io.*;

public class Extraction
{
    public static void main(String[] args){
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=data.mdb;";
            Connection c = DriverManager.getConnection(database, "", "");
            Statement s = c.createStatement();
            
            // create a table for demographics

            String createDemographicsTable = "CREATE TABLE demographicsData" + " (ID Integer, Address Text(40), Phone Double, Age Integer, Gender Text(1), Marital_Status Text(15))";
            s.execute(createDemographicsTable); 

            //for text file to access

            FileReader txt = new FileReader("demographics.txt");
			Scanner sctxt = new Scanner(txt);
			
			while(sctxt.hasNext()){
				
				String line = sctxt.nextLine();
				String split[] = line.split(" ");
				
				String addRow = "INSERT INTO demographicsData VALUES (" + (Integer.parseInt(split[0])) + ",'" + split[1].toString() + "'," + (Double.parseDouble(split[2])) + "," + (Integer.parseInt(split[3])) + ",'" + split[4].toString() + "','" + split[5].toString() + "');";
				s.execute(addRow);

				
			}

			//for csv file to access
            
            FileReader csv = new FileReader("demographics.csv");
			Scanner sccsv = new Scanner(csv);
			
			while(sccsv.hasNext()){
				
				String line = sccsv.nextLine();
				String split[] = line.split(",");
				
				String addRow = "INSERT INTO demographicsData VALUES (" + (Integer.parseInt(split[0])) + ",'" + split[1].toString() + "'," + (Double.parseDouble(split[2])) + "," + (Integer.parseInt(split[3])) + ",'" + split[4].toString() + "','" + split[5].toString() + "');";
				s.execute(addRow);

				
			}


            
            // close and cleanup
            s.close();
            c.close();
            txt.close();
            csv.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}