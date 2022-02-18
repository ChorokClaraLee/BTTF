package kr.co.bttf.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.bttf.DTO.UserDTO;
import kr.co.bttf.mybatis.SqlMapConfig;

public class ManagerDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public ManagerDAO() {
		sqlsession = factory.openSession(true);
	}

	// 1. 리스트 출력
	public List<UserDTO> getUserAllList(int startRow, int endRow) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<UserDTO> userList = sqlsession.selectList("Manager.getUserAllList", datas);
		return userList;
	}

	public int getUserCnt() {
		return sqlsession.selectOne("Manager.getUserCnt");
	}
	
}
