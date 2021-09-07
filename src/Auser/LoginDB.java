package Auser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.db.DBClass;
import day26_DB.MemberDTO;

public class LoginDB {
	public MemberDTO loginchk(String inputId) {
		// select * from fx_member where id=?
		String sql = "select * from fx_member where id=?";
		MemberDTO dto = null;
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ps.setString(1, inputId);
			// ResultSet는 배열과 비슷한 방식으로 가져온다.
			// ResultSet는 select 문에는 무조건 사용한다.
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dto;
	}
}
