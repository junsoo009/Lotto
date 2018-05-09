package Lotto;

import java.util.ArrayList;

import Lotto_Read_JSON.Lotto_read;
import Lotto_Write_JSON.Lotto_write;

public class Lotto_Main {

	public static void main(String[] args) {

		// a 회사에서 로또번호 추출해줘 - 특정 3개 번호
		// b 회사에서 로또번호 추출해줘 - 특정 2개 번호
		
		Lotto_process lottoprocess = new Lotto_process(); // 로또추출기 생성자
		lottoprocess.lottoprovide(); // 로또추출기 실행

	}

}
