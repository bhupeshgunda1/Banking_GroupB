package com.aabms.assignment4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.aabms.assignment4.beans.Accounts;
import com.aabms.assignment4.beans.Customers;
import com.aabms.assignment4.beans.Login;

public class LoginDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save1(Login p) {
		String sql = "insert into login(username,password) values('" + p.getUsername() + "','" + p.getPassword() + "')";
		return template.update(sql);
	}

	public boolean loginchecking(Login p) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment4", "root", "1234");
		String sql = "select * from login where username = '" + p.getUsername() + "' and password = '" + p.getPassword()
				+ "'";

		PreparedStatement ps = connection.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		boolean status = rs.next();
		return status;
	}

	public List<Login> getUsers() {
		return template.query("select * from login", new RowMapper<Login>() {
			public Login mapRow(ResultSet rs, int row) throws SQLException {
				Login e = new Login();
				e.setLoginid(rs.getString(1));
				e.setUsername(rs.getString(2));
				e.setPassword(rs.getString(3));

				return e;
			}
		});
	}

	public int update1(Login p) {
		String sql = "update login set username='" + p.getUsername() + "', password='" + p.getPassword()
				+ "' where loginid=" + p.getLoginid() + "";
		return template.update(sql);
	}

	public int delete1(int loginid) {
		String sql = "delete from login where loginid=" + loginid + "";
		return template.update(sql);
	}

	@SuppressWarnings("deprecation")
	public Login getUserById(int loginid) {
		String sql = "select * from login where loginid=?";
		return template.queryForObject(sql, new Object[] { loginid }, new BeanPropertyRowMapper<Login>(Login.class));
	}
	

	@SuppressWarnings("deprecation")
	public Float getBalance(String cust_ID) {
		String sql = "select A.Balance from Accounts A, Customers C  where A.Cust_ID = C.Cust_ID and C.Cust_ID = ?";
		return template.queryForObject(sql, new Object[] { cust_ID }, Float.class);
	}

	@SuppressWarnings("deprecation")
	public Customers customerLoginCheck(Customers c) {
		String sql = "select * from Customers where username=? and password=?";
		return template.queryForObject(sql, new Object[] { c.getUsername(), c.getPassword() }, new BeanPropertyRowMapper<Customers>(Customers.class));
	}
	
	@SuppressWarnings("deprecation")
	public String isCustomerAdmin(Customers c) {
		String sql = "select isAdmin from Customers where username=? and password=?";
		return template.queryForObject(sql, new Object[] { c.getUsername(), c.getPassword() }, String.class);
	}
	
	@SuppressWarnings("deprecation")
	public String isAdminCheck(Login p) {
		String sql = "select isAdmin from login where username=? and password=?";
		return template.queryForObject(sql, new Object[] { p.getUsername(), p.getPassword() }, String.class);
	}
	
	public int depositMoney(Accounts p) {
		String sql = "update Accounts set balance = (balance+ " +p.getBalance() + ") "+
	    "where Cust_ID= " + p.getCust_ID();
		return template.update(sql);
	}
	
}


