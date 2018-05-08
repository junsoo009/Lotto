package Lotto_Provide;

import java.util.ArrayList;
import java.util.Random;

import Lotto_Number.Lotto_number;

public class Lotto_provide_num implements Lotto_provide {

	final int LOTTO = 46;

	private int wei[]; // 로또번호 가중치
	private int wei_bns[]; // 보너스번호 가중치

	private int select[]; // 추출할 로또번호
	private int select_bns[]; // 추출한 보너스 번호

	private Lotto_number lottoresult; // 로또번호 결과
	
	public Lotto_provide_num() {
		wei = new int[LOTTO];
		wei_bns = new int[LOTTO];

		select = new int[LOTTO];
		select_bns = new int[LOTTO];
		lottoresult = new Lotto_number();
		
	}

	public Lotto_number result(ArrayList lottolist) {
		System.out.println("=======================================================");
		System.out.println("데이터 추출 시작\n");

		System.out.println(lottolist);

		int cnt = 0, cnt_bns = 0;

		for (int i = 0; i < lottolist.size(); i++) { // 가중치
			int temp[] = (int[]) lottolist.get(i);
			wei_bns[(int) temp[6]]++;

			for (int j = 0; j < 6; j++) {
				wei[(int) temp[j]]++;
			}
		}

		for (int i = 1; i < LOTTO; i++) { // 가중치에 따른 로또번호 선택
			if (wei[i] == 0)
				select[cnt++] = i;
			if (wei_bns[i] == 0)
				select_bns[cnt_bns++] = i;

			System.out.print(wei[i] + " ");
			if (i % 10 == 0)
				System.out.println();
		}

		System.out.println();
		System.out.println("==================  6자리 번호  ==================");
		for (int i = 0; i < cnt; i++)
			System.out.print(select[i] + " ");
		System.out.println("\n");

		System.out.println("==================  보너스 번호  ==================");
		for (int i = 0; i < cnt_bns; i++)
			System.out.print(select_bns[i] + " ");
		System.out.println();

		int rot = 0;
		int lottocnt = 0;
		int bns = 0;

		for (int i = 1; i <= 45; i++) { // 보너스번호 선택
			if (bns <= wei_bns[i])
				bns = wei_bns[i];
		}
		System.out.println("bns = " + bns);
		System.out.println("===============================================");

		while (rot < 6) {
			sort(select, 0, cnt - 1);

			Random random = new Random();

			int temp = random.nextInt(LOTTO - cnt);
			System.out.print(temp + " ");

			System.out.println(lottosearch(select, temp, 0, cnt - 1));

			if (!lottosearch(select, temp, 0, cnt - 1) && temp != 0
					&& !lottosearch(lottoresult.getLottonum(), temp, 0, lottocnt - 1)) {

				lottoresult.setLottonum(temp, lottocnt++);
				rot++;

			}
			sort(lottoresult.getLottonum(), 0, lottocnt - 1);
		}

		lottoresult.setLottonum(bns, lottocnt++);
		for (int i = 0; i < lottocnt; i++) {

			if (i == lottoresult.getLottonum().length - 1) {
				System.out.print("[" + lottoresult.getLottonum(i) + "]");
				break;
			}
			System.out.print(lottoresult.getLottonum(i) + " ");
		}
		
		System.out.println();

		System.out.println("=======================================================");
		System.out.println("데이터 추출 종료");
		System.out.println("=======================================================\n");

		return lottoresult;
	}

	public boolean lottosearch(int arr[], int num, int left, int right) { // 로또번호 탐색
		if (left > right)
			return false;
		int mid = (left + right) / 2;

		if (arr[mid] == num)
			return true;
		else if (arr[mid] > num)
			return lottosearch(arr, num, left, mid - 1);
		else
			return lottosearch(arr, num, mid + 1, right);

	}

	public void mergeSort(int arr[], int left, int right, int mid) {
		int temp[] = new int[arr.length];

		int l = left;
		int r = mid + 1;
		int t = left;

		while (l <= mid && r <= right) {
			if (arr[l] > arr[r])
				temp[t++] = arr[r++];
			else
				temp[t++] = arr[l++];
		}

		while (l <= mid)
			temp[t++] = arr[l++];
		while (r <= right)
			temp[t++] = arr[r++];

		for (int i = left; i <= right; i++)
			arr[i] = temp[i];

	}

	public void sort(int arr[], int left, int right) {
		if (left >= right)
			return;

		int mid = (left + right) / 2;

		sort(arr, left, mid);
		sort(arr, mid + 1, right);
		mergeSort(arr, left, right, mid);

	}
}
