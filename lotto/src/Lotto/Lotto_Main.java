package Lotto;

import java.util.ArrayList;

import Lotto_Read_JSON.Lotto_read;
import Lotto_Write_JSON.Lotto_write;

public class Lotto_Main {

	public static void main(String[] args) {

		Lotto_process lottoprocess = new Lotto_process(); // 로또추출기 생성자
		lottoprocess.lottoprovide(); // 로또추출기 실행

	}

}
