package org.jrichardsz.app.speechbot.common;

public class StringUtil{

    public static String convertNumberToStringWhitZeros(int codigo, int length) {
        String cadena_numero_ini = "" + codigo;// representa el codigo pasado a cadena
        String cadena_con_ceros = "";
        if (cadena_numero_ini.length() > length) {//si el codigo pasado a cadena es mayor al limite establecido
            //lanzar alerta
        } else {
            int numero_ceros = length - cadena_numero_ini.length();
            for (int a = 0; a < numero_ceros; a++) {
                cadena_con_ceros += "0";//crea un acadena con tantos ceros como se necesita
            } //ahora lo concatenamos con el numero
            cadena_con_ceros += cadena_numero_ini;
        }
        return cadena_con_ceros;
    }	
    
	public static String cleanSentence(String sentenceInitial){
		return sentenceInitial.replaceAll("\t", "").replaceAll("\\s\\s", "");
	}
    
	
}
