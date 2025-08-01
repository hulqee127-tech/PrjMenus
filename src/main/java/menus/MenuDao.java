package menus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Dao : Data Access Object
// CRUD 작업 : Create(Insert), Read(Select), Update(Update), Delete(Delete)
public class MenuDao {
	// 데이터 추가(C)
	public void addMenu(String menu_id, String menu_name, int menu_seq) {	// void 를 안쓰면 return 을 쓰고 void 를 쓰면 return 을 제외해도 된다.
		DBConn db = new DBConn();
		Connection conn = db.getConnection(); 
		String sql = "";
		sql += "insert into menus values (?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu_id);
			pstmt.setString(2, menu_name);
			pstmt.setInt(3, menu_seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 데이터 조회(R)-목록전체
	public ArrayList<MenuDto> getMenuList() {
		DBConn db = new DBConn();
		Connection conn = db.getConnection();
		String sql = "";
		sql += " select * from menus order by menu_seq asc ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MenuDto> menuList = new ArrayList<>();
		//MenuDto menuDto = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();			// 실제로 조회되는 부분
			//MenuDto [] menuList = new MenuDto{}	// 배열의 SIZE를 알수 없기때문에 이구문은 사용할 수 없음.
			while (rs.next()) {
				String menu_id = rs.getString("menu_id");
				String menu_name = rs.getString("menu_name");
				int menu_seq = rs.getInt("menu_seq");
				//MenuDto menuDto = new MenuDto(menu_id, menu_name, menu_seq);
				MenuDto menuDto = new MenuDto();
				menuDto.setMenu_id(menu_id);
				menuDto.setMenu_name(menu_name);
				menuDto.setMenu_seq(menu_seq);
				menuList.add(menuDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return menuList;
	}
	
	// 데이터 조회(R)-메뉴한개
	public MenuDto getMenu(String menu_id) {
		DBConn db = new DBConn();
		Connection conn = db.getConnection(); 
		String sql = "";
		sql += " select * from menus where menu_id = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		ArrayList<MenuDto> menuList = new ArrayList<>();
		MenuDto menuDto = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString( 1, menu_id );
			rs = pstmt.executeQuery();
//			while (rs.next()) {
			if (rs.next()) {
				//String menu_id = rs.getString("menu_id");
				String menu_name = rs.getString("menu_name");
				int menu_seq = rs.getInt("menu_seq");
				//MenuDto menuDto = new MenuDto(menu_id, menu_name, menu_seq);
				menuDto = new MenuDto();
				//menuDto.setMenu_id(menu_id);
				menuDto.setMenu_name(menu_name);
				menuDto.setMenu_seq(menu_seq);
//				menuList.add(menuDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(menuDto == null) {
			throw new RuntimeException("존재하지 않는 값 입니다.");
		}
		return menuDto;
	}
	// 데이터 수정(U)
	public void updateMenu(String menu_id, String menu_name, int menu_seq) {
		DBConn db = new DBConn();
		Connection conn = db.getConnection(); 
		String sql = "";
		sql += " update menus set menu_name = ? , menu_seq = ? where menu_id = ? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu_name);
			pstmt.setInt(2, menu_seq);
			pstmt.setString(3, menu_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// 데이터 삭제(D)
	public void delMenu(String menu_id) {
		DBConn db = new DBConn();
		Connection conn = db.getConnection(); 
		String sql = "";
		sql += " delete from menus where menu_id = ? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}





















