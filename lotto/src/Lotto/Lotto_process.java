package Lotto;

import java.util.ArrayList;

import Lotto_Number.Lotto_number;
import Lotto_Provide.Lotto_provide;
import Lotto_Provide.Lotto_provide_num;
import Lotto_json_parse.Lotto_json;
import Lotto_json_parse.Lotto_json_process;

public class Lotto_process {

	private Lotto_json lottojson;

	private Lotto_number lottonum;

	public Lotto_process() {

	}

	public Lotto_process(Lotto_provide lottoprovide) { // 기본으로 설정된 분석으로 추출함

		lottonum = new Lotto_number();
		lottojson = new Lotto_json_process();

		lottojson.first_list_add();

		ArrayList readlist = lottojson.read(); // 로또번호 읽기 ( 파일 읽기 )

		lottoprovide(readlist, lottoprovide);
	}

	public void lottoprovide(ArrayList readlist, Lotto_provide lottoprovide) { // 로또 추출기 실행 메소드

		lottonum = lottoprovide.result(readlist); // 결과물

	}

	public int[] getLottonum() {
		return lottonum.getLottonum();
	}

}
