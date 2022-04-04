package com.aabms.assignment4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.aabms.assignment4.beans.Book;

public class BookDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Book p) {
		String sql = "insert into book (author,title,price,available,publisherid) " + "values('" + p.getAuthor() + "','"
				+ p.getTitle() + "','" + p.getPrice() + "','" + p.getAvailable() + "','" + p.getPublisherid() + "')";
		return template.update(sql);
	}

	public int borrowsave(Book p) {
		String sql = "insert into issuebook (bookid,author,title,price,available,membid,issuedate,returndate) "
				+ "values('" + p.getBookid() + "','" + p.getAuthor() + "','" + p.getTitle() + "','" + p.getPrice()
				+ "','" + p.getAvailable() + "','" + p.getMembid() + "','" + p.getIssuedate() + "','"
				+ p.getReturndate() + "')";
		return template.update(sql);
	}

	public int update(Book p) {
		int count = 0;
		try {
			String sql = "update book set author='" + p.getAuthor() + "', title='" + p.getTitle() + "',price='"
					+ p.getPrice() + "',available='" + p.getAvailable() + "',publisherid='" + p.getPublisherid()
					+ "' where bookid=" + p.getBookid() + "";
			count = template.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int delete(int bookid) {
		String sql = "delete from book where bookid=" + bookid + "";
		return template.update(sql);
	}

	public int updateIssueBook(Book p) {
		String sql = "update issuebook set bookid='" + p.getBookid() + "', author='" + p.getAuthor() + "', title='"
				+ p.getTitle() + "',price='" + p.getPrice() + "',available='" + p.getAvailable() + "',membid='"
				+ p.getMembid() + "',issuedate='" + p.getIssuedate() + "',returndate='" + p.getReturndate()
				+ "' where issuebookid=" + p.getIssuebookid() + "";
		return template.update(sql);
	}

	public int deleteIssueBook(int issuebookid) {
		String sql = "delete from issuebook where issuebookid=" + issuebookid + "";
		return template.update(sql);
	}

	@SuppressWarnings("deprecation")
	public Book getBookById(int bookid) {
		String sql = "select * from book where bookid=?";
		return template.queryForObject(sql, new Object[] { bookid }, new BeanPropertyRowMapper<Book>(Book.class));
	}

	@SuppressWarnings("deprecation")
	public Book getIssueBookById(int issuebookid) {
		String sql = "select * from issuebook where issuebookid=?";
		return template.queryForObject(sql, new Object[] { issuebookid }, new BeanPropertyRowMapper<Book>(Book.class));
	}

	public List<Book> getBooks() {
		return template.query("select * from book", new RowMapper<Book>() {
			public Book mapRow(ResultSet rs, int row) throws SQLException {
				Book e = new Book();
				e.setBookid(rs.getString(1));
				e.setAuthor(rs.getString(2));
				e.setTitle(rs.getString(3));
				e.setPrice(rs.getFloat(4));
				e.setAvailable(rs.getString(5));
				e.setPublisherid(rs.getString(6));
				return e;
			}
		});
	}

	public List<Book> getBorrowBooks() {
		return template.query("select * from issuebook", new RowMapper<Book>() {
			public Book mapRow(ResultSet rs, int row) throws SQLException {
				Book e = new Book();

				e.setIssuebookid(rs.getString(1));
				e.setBookid(rs.getString(2));
				e.setAuthor(rs.getString(3));
				e.setTitle(rs.getString(4));
				e.setPrice(rs.getFloat(5));
				e.setAvailable(rs.getString(6));
				e.setMembid(rs.getString(7));
				e.setIssuedate(rs.getString(8));
				e.setReturndate(rs.getString(9));
				return e;
			}
		});
	}
}