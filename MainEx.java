package kr.co.ca;

import java.util.Scanner;

import com.naver.Command;
import com.naver.InsertCommand;
import com.naver.deleteCommand;
import com.naver.getListCommand;
import com.naver.getMemberDTOByIdCommand;
import com.naver.updateCommand;

public class MainEx {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);			//스캐너 사용 선언

		Command[] com = { new InsertCommand(),new getListCommand(),new getMemberDTOByIdCommand(),new updateCommand(),new deleteCommand()};		// 커맨드배열 형의 com 변수에 각 방마다 사용할 메서드들을 입력 
		
		/*
		 * new getMemberDTOByIdCommand(), new updateCommand(), new
		 * deleteCommand()
		 */
		
		boolean istrue = true;	// 기본값을 true 로 초기화 해서
				
		while (istrue) {	//istrue 가 false 가 될때 까지 무한 루프 반복
			System.out.println("메뉴를 선택 하세요.");
			System.out.println(" 0:등록 , 1:조회 , 2: 회원조회 ,3: 수정 , 4: 삭제 ,5: 종료  ");
			int menu = sc.nextInt();	//사용 메뉴 번호를 입력받아 menu 에 넣고
			sc.nextLine();				// 엔터키까지 인식하지 않도록 작성...
			
			if(menu != com.length) {	// 위에 선언한 com 변수의 요소의 길이가 사용할 메뉴의 값인 menu 변수의 값과 같지 않다면 
				com[menu].execute(sc);	// com[입력한 메뉴] 의 메서드가 실행.. 0 이라면 지금코드상 InsertCommand() 얘가 실행됨..
			}else {						// 위에 선언한 com 변수의 요소의 길이가 사용할 메뉴의 값인 menu 변수의 값과 같다면
				istrue = false;			//istrue 가 false 가 될때 까지 무한 루프 반복 되는 while 문이기에 코드 종료..
			}
		}
		sc.close();					// 입력 종료.
	}
}
