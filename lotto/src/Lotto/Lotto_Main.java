package Lotto;

import Lotto_Number.Lotto_number;
import Lotto_Provide.Lotto_provide;
import Lotto_Provide.Lotto_provide_num;

public class Lotto_Main {

	public static void main(String[] args) {

		Lotto_provide lottoprovide = new Lotto_provide_num(); // ��ȣ ���� �϶�� ���

		Lotto_process lottoprocess = new Lotto_process(lottoprovide); // �ζ������ ������

		lottoprocess.lottoprovide(); // �ζ������ ����

	}

}
