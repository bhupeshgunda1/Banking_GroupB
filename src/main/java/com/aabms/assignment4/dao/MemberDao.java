package com.aabms.assignment4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.aabms.assignment4.beans.Member;

public class MemberDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save1(Member p) {
		String sql = "insert into member(name,address,membtype,membdate,expdate,loginid) values('" + p.getName() + "','"
				+ p.getAddress() + "','" + p.getMembtype() + "','" + p.getMembdate() + "','" + p.getExpdate() + "',"
				+ p.getLoginid() + ")";
		return template.update(sql);
	}

	public int update1(Member p) {
		String sql = "update member set name='" + p.getName() + "', address='" + p.getAddress() + "',membtype='"
				+ p.getMembtype() + "', membdate='" + p.getMembdate() + "', expdate='" + p.getExpdate() + "', loginid="
				+ p.getLoginid() + " where membid=" + p.getMembid() + "";
		return template.update(sql);
	}

	public int delete1(int membid) {
		String sql = "delete from member where membid=" + membid + "";
		return template.update(sql);
	}

	@SuppressWarnings("deprecation")
	public Member getMemberById(int membid) {
		String sql = "select * from member where membid=?";
		return template.queryForObject(sql, new Object[] { membid }, new BeanPropertyRowMapper<Member>(Member.class));
	}

	public List<Member> getMembers() {
		return template.query("select * from member", new RowMapper<Member>() {
			public Member mapRow(ResultSet rs, int row) throws SQLException {
				Member e = new Member();
				e.setMembid(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAddress(rs.getString(3));
				e.setMembtype(rs.getString(4));
				e.setMembdate(rs.getString(5));
				e.setExpdate(rs.getString(6));
				e.setLoginid(rs.getInt(7));

				return e;
			}
		});
	}
}