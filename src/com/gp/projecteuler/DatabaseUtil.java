/*
    Project Euler Solutions
    Copyright (C) 2012-2013, Gary Paduana, gary.paduana@gmail.com
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.gp.projecteuler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

	public static void execute(List<String> sql){
		Connection conn = null;
		Statement statement = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "gary", "12345");
			conn.setAutoCommit(false);
			statement = conn.createStatement();
			
			int count = 0;
			for(String s : sql){
				statement.addBatch(s);
				count++;
				
				if(count > 1000){
					statement.executeBatch();
					count = 0;
				}
			}
			
			statement.executeBatch();
			conn.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try{
				conn.close();
			} 
			catch (SQLException e) {

			}
		}
	}
	
	public static List<List<String>> executeImmediate(String sql){
		List<List<String>> results = new ArrayList<List<String>>();
		
		Connection conn = null;
		Statement statement = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "gary", "12345");
			conn.setAutoCommit(false);
			statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = statement.executeQuery(sql);
			int columnCount = resultSet.getMetaData().getColumnCount();
			
			while(resultSet.next()){
				List<String> row = new ArrayList<String>();
				for(int i = 0; i < columnCount; i++){
					row.add(resultSet.getObject(i+1).toString());
				}
				results.add(row);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try{
				conn.close();
			} 
			catch (SQLException e) {

			}
		}
		
		return results;
	}
}
