package Lotto;

import java.util.ArrayList;

import Lotto_Read_JSON.Lotto_read;
import Lotto_Write_JSON.Lotto_write;

public class Lotto_Main {

	public static void main(String[] args) {

		// a ȸ�翡�� �ζǹ�ȣ �������� - Ư�� 3�� ��ȣ
		// b ȸ�翡�� �ζǹ�ȣ �������� - Ư�� 2�� ��ȣ
		
		Lotto_process lottoprocess = new Lotto_process(); // �ζ������ ������
		lottoprocess.lottoprovide(); // �ζ������ ����

	}

}
