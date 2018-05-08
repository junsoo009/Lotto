package lotto;

import java.util.ArrayList;

import Lotto_Number.Lotto_number;
import Lotto_Provide.Lotto_provide;
import Lotto_Provide.Lotto_provide_num;
import Lotto_Read_JSON.Lotto_read;
import Lotto_Read_JSON.Lotto_read_json;
import Lotto_Write_JSON.Lotto_write;
import Lotto_Write_JSON.Lotto_write_json;

public class Lotto_process {

	private Lotto_read lottoread; 
	private Lotto_write lottowrite;

	private Lotto_provide lottoprovide;
	private Lotto_number lottonum;

	public Lotto_process() {
		lottonum = new Lotto_number();
	}

	public void lottoprovide() { // 로또 추출기 실행 메소드
		lottowrite = new Lotto_write_json(); 
		lottoread = new Lotto_read_json(); 
		lottoprovide = new Lotto_provide_num(); 

		// lottowrite.first_list_add(); // 로또번호 가져오기 ( 파일 쓰기 )

		ArrayList readlist = lottoread.read(); // 로또번호 읽기 ( 파일 읽기 )
		lottonum = lottoprovide.result(readlist); // 결과물

	}
}
