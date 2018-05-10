package Lotto_analysis;

import java.util.ArrayList;

import Lotto_Number.Lotto_select_number;
import Lotto_Number.Lotto_weigh_number;

public interface Lotto_analysis {
	public Lotto_weigh_number lotto_weight(ArrayList lottolist);
		
	public Lotto_select_number lotto_select(ArrayList lottolist);

	
}
