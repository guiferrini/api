package com.guiferrini.apizup.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	//metoto p Decodificar parametro URL, String vem Encodada (Estatico, p n instanciar objeto URL)
	public static String decodeURL(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8"); //retorna String decodificado ou caso erro retorna vazio
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return "";
		}
	}
}
