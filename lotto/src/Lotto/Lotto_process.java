package Lotto;

import java.util.ArrayList;

import Lotto_Number.Lotto_number;
import Lotto_Provide.Lotto_provide;
import Lotto_Provide.Lotto_provide_num;
import Lotto_json_parse.Lotto_json;
import Lotto_json_parse.Lotto_json_process;

public class Lotto_process {

	private Lotto_json lottojson;

	private Lotto_provide lottoprovide;
	private Lotto_number lottonum;

	public Lotto_process() {
		lottonum = new Lotto_number();
		lottojson = new Lotto_json_process();
		lottoprovide = new Lotto_provide_num();
	}

	public Lotto_process(Lotto_provide lottoprovide) {
		lottojson.first_list_add();
	}

	public void lottoprovide() { // 로또 추출기 실행 메소드

		ArrayList readlist = lottojson.read(); // 로또번호 읽기 ( 파일 읽기 )
		
		lottonum = lottoprovide.result(readlist); // 결과물

	}
}
