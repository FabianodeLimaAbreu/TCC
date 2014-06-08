package br.com.tio.mesindex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class mes_index {
	
	public mes_index () {
		
}				
	public String Mes_Index() {		
				
		int mesdoano = Integer.parseInt((new SimpleDateFormat("MM")).format(new Date()));
        String mesRetorno = "";
        switch(mesdoano) {
            case 1:mesRetorno = "Janeiro";break;
            case 2:mesRetorno = "Fevereiro";break;
            case 3:mesRetorno = "Março";break;
            case 4:mesRetorno = "Abril";break;
            case 5:mesRetorno = "Maio";break;
            case 6:mesRetorno = "Junho";break;   
            case 7:mesRetorno = "Julho";break;
            case 8:mesRetorno = "Agosto";break;
            case 9:mesRetorno = "Setembro";break;
            case 10:mesRetorno = "Outubro";break;
            case 11:mesRetorno = "Novembro";break;
            case 12:mesRetorno = "Dezembro";break;       
        }
        return mesRetorno;
    }

}
