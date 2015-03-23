package br.com.cespec.java.ordenacao;

import java.util.Comparator;

public class ComparadorDoMaiorParaMenor implements Comparator<String> {

	@Override
	public int compare(String pStringI, String pStringII) {
		if(pStringI.length() > pStringII.length())
			return -1;
		if(pStringI.length() < pStringII.length())
			return 1;
		return 0;
	}

}
