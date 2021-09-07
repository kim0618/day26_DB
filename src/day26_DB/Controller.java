package day26_DB;

import java.net.URL;
import java.util.ResourceBundle;

import Auser.LoginService;
import Auser.LoginServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller implements Initializable{

	Parent root;
	public static DBClass db;	// 공통으로 써야하니까 static
	public common.db.DBClass comDB;
	private LoginService ls;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new DBClass();
		comDB = new common.db.DBClass();
		ls = new LoginServiceImpl();
	}
	
	public void membership() {
		TextField id = (TextField)root.lookup("#memberId");
		TextField name = (TextField)root.lookup("#memberName");
		TextField pwd = (TextField)root.lookup("#memberPwd");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id.getText());
		dto.setPwd(pwd.getText());
		dto.setName(name.getText());
		
		int result = db.insert(dto);
		if(result == 1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("회원가입 성공");
			alert.show();
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("동일한 아이디 존재");
			alert.show();
		}
	}
	
	public void login() {
		ls.loginChk(root);
	/*	TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPwd");
		MemberDTO dto = db.loginchk( id.getText() );
		
		if(dto == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("존재하지 않는 아이디");
			alert.show();
		}else {
			if(dto.getPwd().equals(pwd.getText())) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("인증성공");
				alert.show();
			}else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("비밀번호가 다릅니다");
				alert.show();
			}
		}*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
