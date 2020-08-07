package com.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Validate {
	  public static String checkUser(String username,String password){   
		  String SQL = "SELECT * FROM users where userName=? and userPassword=?";
			try (Connection connection = DButil.getDataSource().getConnection(); PreparedStatement st = connection.prepareStatement(SQL);) {
				st.setString(1, username);
				st.setString(2, password);
				ResultSet rs = st.executeQuery();
				if(rs.next())
					return rs.getString("userRole");
				else
					return null;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	    }
	  public static boolean addUser(String username,String password,String email){
		  String SQL = "INSERT INTO users(userName,userPassword,userRole,email) Values(?,?,'user',?)";
			try (Connection connection = DButil.getDataSource().getConnection(); PreparedStatement st = connection.prepareStatement(SQL);) {
				st.setString(1, username);
				st.setString(2, password);
				st.setString(3, email);
				int i = st.executeUpdate();
				connection.commit();
				if(i>0)
					return true;
				else
					return false;
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		  return false;
	  }
	  public static String getEmail(String username,String password){
		  String SQL = "SELECT * FROM users where userName=? and userPassword=?";
			try (Connection connection = DButil.getDataSource().getConnection(); PreparedStatement st = connection.prepareStatement(SQL);) {
				st.setString(1, username);
				st.setString(2, password);
				ResultSet rs = st.executeQuery();
				if(rs.next())
					return rs.getString("email");
				else
					return null;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	  }
	  public static int rowCount(){
		  String SQL = "SELECT count(*) FROM tempInfo";
			try (Connection connection = DButil.getDataSource().getConnection(); PreparedStatement st = connection.prepareStatement(SQL);) {
			ResultSet rs = st.executeQuery();
				if(rs.next())
					return rs.getInt("count(*)");
				else
					return -1;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
	  }
	  public static boolean insertData(tempInfo obj){
		  String SQL = "INSERT INTO tempInfo Values(?,?,?,?,?,?,?,?,?)";
			try (Connection connection = DButil.getDataSource().getConnection(); PreparedStatement st = connection.prepareStatement(SQL);) {
				st.setString(1,obj.getName());
				st.setString(2,obj.getAccountNumber());
				st.setString(3,obj.getReason());
				st.setString(4,obj.getRepaymentDate());
				st.setString(5,obj.getCurrentState());
				st.setString(6,obj.getConfirmation());
				st.setString(7, Long.toString(obj.getMobileNumber()));
				st.setString(8, obj.getEmail());
				st.setString(9, Long.toString(obj.getLoanNumber()));
				int i = st.executeUpdate();
				connection.commit();
				if(i>0)
					return true;
				else
					return false;
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		  return false;
	  }
	  public static ArrayList<userInfo> getUsersData(){
		  ArrayList<userInfo> al=new ArrayList<userInfo>();
		  String SQL = "SELECT * FROM users";
			try (Connection connection = DButil.getDataSource().getConnection(); PreparedStatement st = connection.prepareStatement(SQL);) {
				ResultSet rs = st.executeQuery();
				
				while(rs.next()){
					userInfo ui=new userInfo();
					ui.setEmail(rs.getString("email"));
					ui.setUrole(rs.getString("userRole"));
					ui.setUpass(rs.getString("userPassword"));
					ui.setUname(rs.getString("userName"));
					al.add(ui);
				}
					
			} 
			catch (Exception e) {
				e.printStackTrace();
			}		  
		  return al;
	  }
	  
	  public static ArrayList<tempInfo> getData(){
		  ArrayList<tempInfo> al=new ArrayList<tempInfo>();
		  String SQL = "SELECT * FROM tempInfo";
			try (Connection connection = DButil.getDataSource().getConnection(); PreparedStatement st = connection.prepareStatement(SQL);) {
				ResultSet rs = st.executeQuery();
				
				while(rs.next()){
					tempInfoBuilder tb=new tempInfoBuilder();
					tb=tb.setName(rs.getString("Name"));
					tb=tb.setAccountNumber(rs.getString("Accountnumber"));
					tb=tb.setReason(rs.getString("reason"));
					tb=tb.setRepaymentDate(rs.getString("repaymentdata"));
					tb=tb.setCurrentState(rs.getString("currentstatus"));
					tb=tb.getConfirmation(rs.getString("confirmation"));
					tb=tb.setEmail(rs.getString("email"));                         
					tb=tb.setLoanNumber(Long.parseLong(rs.getString("loannumber")));
					tb=tb.setMobileNumber(Long.parseLong(rs.getString("mobile")));
					al.add(tb.getObj());
					//System.out.println(al.get(0).getEmail());
				}
					
			} 
			catch (Exception e) {
				e.printStackTrace();
			}		  
		  return al;
	  }
	  public static boolean deleteComplaint(String AccountNumber){
		  String SQL = "Delete from tempInfo where AccountNumber=?";
			try (Connection connection = DButil.getDataSource().getConnection(); PreparedStatement st = connection.prepareStatement(SQL);) {
				st.setString(1,AccountNumber);
				int i = st.executeUpdate();
				connection.commit();
				if(i>0)
					return true;
				else
					return false;
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		  return false;
	  }
	  public static boolean deleteUser(String AccountNumber){
		  String SQL = "Delete from users where email=?";
			try (Connection connection = DButil.getDataSource().getConnection(); PreparedStatement st = connection.prepareStatement(SQL);) {
				st.setString(1,AccountNumber);
				int i = st.executeUpdate();
				connection.commit();
				if(i>0)
					return true;
				else
					return false;
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		  return false;
	  }
	  public static String getEmail(String AccountNumber){
		  String SQL = "select email from tempInfo where AccountNumber=?";
			try (Connection connection = DButil.getDataSource().getConnection(); PreparedStatement st = connection.prepareStatement(SQL);) {
				st.setString(1,AccountNumber);
				ResultSet rs = st.executeQuery();
				if(rs.next())
					return rs.getString("email");
				else
					return null;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	  }

}
