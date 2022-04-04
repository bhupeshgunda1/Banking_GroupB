package com.aabms.assignment4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.aabms.assignment4.beans.Publisher;

public class PublisherDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save1(Publisher p) {
		String sql = "insert into publisher(name,address) values('" + p.getName() + "','" + p.getAddress() + "')";
		return template.update(sql);
	}

	public int update1(Publisher p) {
		String sql = "update publisher set name='" + p.getName() + "', address='" + p.getAddress()
				+ "' where publisherid=" + p.getPublisherid() + "";
		return template.update(sql);
	}

	public int delete1(int publisherid) {
		String sql = "delete from publisher where publisherid=" + publisherid + "";
		return template.update(sql);
	}

	@SuppressWarnings("deprecation")
	public Publisher getPublisherById(int publisherid) {
		String sql = "select * from publisher where publisherid=?";
		return template.queryForObject(sql, new Object[] { publisherid },
				new BeanPropertyRowMapper<Publisher>(Publisher.class));
	}

	public List<Publisher> getPublishers() {
		return template.query("select * from publisher", new RowMapper<Publisher>() {
			public Publisher mapRow(ResultSet rs, int row) throws SQLException {
				Publisher e = new Publisher();
				e.setPublisherid(rs.getString(1));
				e.setName(rs.getString(2));
				e.setAddress(rs.getString(3));

				return e;
			}
		});
	}
}