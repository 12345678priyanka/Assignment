package customers.usermanagent.modules;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import customers.usermanagent.modules.*;
public class dbHandler {
 
		private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
		private static final String user="system";
		private static final String pass="system";
		
		private static final String sql="INSERT INTO Customelist VALUES(?,?,?,?,?,?,?,?)";
	    static {
	    try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    }catch(ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    }
	    public static Connection getConnection()throws SQLException{
	    	return DriverManager.getConnection(url,user,pass);
	    }
	    public static void createCustomerTable() {
	    	try(Connection connection=getConnection();
	    			Statement statement=connection.createStatement()){
	    			String createTableSQL="CREATE TABLE Customerlist("+
	    				"uuid VARCHAR2(36) PRIMARY KEY,"+
	    				"FirstName VARCHAR2(50) NOT NULL,"+
	    				"LastName VARCHAR2(50) NOT NULL,"+
	    				"Address VARCHARCHAR2(100),"+
	    				"City VARCHARCHAR2(50),"+
	    				"State VARCHARCHAR2(50),"+
	    				"Email VARCHAR2(100),"+
	    				"Phone VARCHAR2(20)"+
	    				")";
	    			statement.executeUpdate(createTableSQL);
	    			System.out.println("Table customers created successfully"));
	    			}catch(SQLException e) {
	    				e.printStackTrace();
	    				}
	    	}
	    	public static String authenticateUser(String Username,String Password) {
	    		try(Connection connection=getConnection();
	    				PreparedStatement preparedStatemenet=connection.prepareStatement("SELECT bearer_token FROM CustomerList WHERE Username=? AND password=?")){
	    					preparedStatement.setString(1,Username);
	    					preparedStatement.setString(2,Password); 
	    					
	    					try(ResultSet resultSet=preparedStatement.executeQuery()){
	    						if(resultSet.next()){
	    							return resultSet.getString("bearer_token");
	    						}
	    					}
	    					}catch(SQLException e) {
	    						e.printStackTrace();
	    					}
	    					return null;
	    		}
	    				public static  boolean createCustomer(String FirstName,String LastName, String Address, String City, String State,String Email,String Phone) {
	    					try(Connection connection=getConnection();
	    							PreparedStatement preparedStatement=connection.prepareStatement(
	    							"INSERT INTO customers (uuid,FirsName,LastName,Address,City,State,Email,Phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

	    						            String uuid = generateUUID();

	    						            preparedStatement.setString(1, uuid);
	    						            preparedStatement.setString(2, FirstName);
	    						            preparedStatement.setString(3, LastName);
	    						            preparedStatement.setString(4, Address);
	    						            preparedStatement.setString(5, City);
	    						            preparedStatement.setString(6, State);
	    						            preparedStatement.setString(7, Email);
	    						            preparedStatement.setString(8, Phone);
	    							int rowsInserted = preparedStatement.executeUpdate();

	    				            return rowsInserted > 0;

	    				        } catch (SQLException e) {
	    				            e.printStackTrace();
	    				        }

	    				        return false;
	    				    }

	    				    // Get customer list
	    				    public static List<Customer> getCustomerList() {
	    				        List<Customer> CustomerList= new ArrayList<>();

	    				        try (Connection connection = getConnection();
	    				             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CustomerList");
	    				             ResultSet resultSet = preparedStatement.executeQuery()) {

	    				            while (resultSet.next()) {
	    				                Customer customer = new Customer();
	    				                customer.setUuid(resultSet.getString("uuid"));
	    				                customer.setFirstName(resultSet.getString("FirstName"));
	    				                customer.setLastName(resultSet.getString("LastName"));
	    				                customer.setAddress(resultSet.getString("Address"));
	    				                customer.setCity(resultSet.getString("City"));
	    				                customer.setState(resultSet.getString("State"));
	    				                customer.setEmail(resultSet.getString("Email"));
	    				                customer.setPhone(resultSet.getString("Phone"));

	    				                CustomerList.add(customer);
	    				            }

	    				        } catch (SQLException e) {
	    				            e.printStackTrace();
	    				        }

	    				        return CustomerList;
	    				    }

	    				    // Delete a customer
	    				    public static boolean deleteCustomer(String uuid) {
	    				        try (Connection connection = getConnection();
	    				             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM CustomerList WHERE uuid=?")) {

	    				            preparedStatement.setString(1, uuid);

	    				            int rowsDeleted = preparedStatement.executeUpdate();

	    				            return rowsDeleted > 0;

	    				        } catch (SQLException e) {
	    				            e.printStackTrace();
	    				        }

	    				        return false;
	    				    }

	    				    // Update a customer
	    				    public static boolean updateCustomer(String uuid, String FirstName, String LastName, String Address,
	    				                                         String City, String State, String Email, String Phone) {
	    				        try (Connection connection = getConnection();
	    				             PreparedStatement preparedStatement = connection.prepareStatement(
	    				                     "UPDATE customers SET FirstName=?, LastName=?, Address=?, City=?, State=?, Email=?, Phone=? WHERE uuid=?")) {

	    				            preparedStatement.setString(1, FirstName);
	    				            preparedStatement.setString(2, LastName);
	    				            preparedStatement.setString(3, Address);
	    				            preparedStatement.setString(4, City);
	    				            preparedStatement.setString(5, State);
	    				            preparedStatement.setString(6, Email);
	    				            preparedStatement.setString(7, Phone);
	    				            preparedStatement.setString(6, uuid);

	    				            int rowsUpdated = preparedStatement.executeUpdate();

	    				            return rowsUpdated > 0;

	    				        } catch (SQLException e) {
	    				            e.printStackTrace();
	    				        }
	    				        // Update a customer
	    				        public static boolean updateCustomer(String uuid, String firstName, String lastName, String street, String address,
	    				                                             String city, String state, String email, String phone) {
	    				            try (Connection connection = getConnection();
	    				                 PreparedStatement preparedStatement = connection.prepareStatement(
	    				                         "UPDATE customers SET first_name=?, last_name=?,address=?, city=?, state=?, email=?, phone=? WHERE uuid=?")) {

	    				                preparedStatement.setString(1, firstName);
	    				                preparedStatement.setString(2, lastName);
	    				                preparedStatement.setString(4, address);
	    				                preparedStatement.setString(5, city);
	    				                preparedStatement.setString(6, state);
	    				                preparedStatement.setString(7, email);
	    				                preparedStatement.setString(8, phone);
	    				                preparedStatement.setString(9, uuid);

	    				                int rowsUpdated = preparedStatement.executeUpdate();

	    				                return rowsUpdated > 0;

	    				            } catch (SQLException e) {
	    				                e.printStackTrace();
	    				            }

	    				            return false;
	    				        }
	    				        private String generated() {
	    				        	return java.util.UUID.randomUUID().toString();
	    				        }
	    					}