import java.util.ArrayList;
import java.util.Scanner;

public class SelectCom implements Command{
	@Override
	public void execute(Scanner sc) {
		ArrayList<MemberDTO> list = new MemberDAO().select();
		
		if (list != null) {
			System.out.println("ID\tNAME\tAGE\tDNAME");
			for (int i = 0; i < list.size(); i++) 
				System.out.println(list.get(i));
		}else
			System.out.println("등록된 정보가 없습니다.");
	}
}
