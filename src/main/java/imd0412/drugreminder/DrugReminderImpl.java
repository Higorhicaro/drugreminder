package imd0412.drugreminder;

import java.util.ArrayList;
import java.util.List;

public class DrugReminderImpl implements IReminder {
	
	int dia, mes, ano, hora, min;
	
	public List<String> createReminders(String startTime, Frequency frequency,
			Integer duration) {
		
		List<String> lista = new ArrayList<String>();
		
		lista.add(startTime);
		
		dia = Integer.parseInt(startTime.substring(0,1));
		mes = Integer.parseInt(startTime.substring(3,4));
		ano = Integer.parseInt(startTime.substring(6,7));
		hora = Integer.parseInt(startTime.substring(9,10));
		min = Integer.parseInt(startTime.substring(11,12));
		
		int cont = 0;		
		
		switch (frequency) {
			case SIX_HOURS:
				cont = 4*duration;
				for(int i=1; i<cont; i++) {
					hora += 6;
					checkHora();
					lista.add(saveString());
				}
				break;
			case EIGHT_HOURS:
				cont = 3*duration;
				for(int i=1; i<cont; i++) {
					hora += 8;
					checkHora();
					lista.add(saveString());
				}
				break;
			case TWELVE_HOURS:
				cont = 2*duration;
				for(int i=1; i<cont; i++) {
					hora += 12;
					checkHora();
					lista.add(saveString());
				}
				break;
			default:
				for(int i=1; i<duration; i++) {
					dia += 1;
					checkDia();
					lista.add(saveString());
				}
				break;
		}
		
		return lista;
	}
	
	public void checkHora() {
		if(hora > 23) {
			hora -= 24;
			dia += 1;
			if(dia > 28) {
				checkDia();
			}
		}
	}
	
	public void checkDia() {
		if(dia == 32) {
			addMes();
			checkMes();
		} else if(dia == 31) {
			if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				addMes();
			}
		} else if(dia == 30 && mes == 2) {
			addMes();
		} else if(dia == 29 && mes == 2) {
			addMes();
		}
	}
	
	public void checkMes() {
		if(mes == 13) {
			mes = 1;
			ano += 1;
		}
	}
	
	public void addMes() {
		dia = 1;
		mes += 1;
	}
	
	public String saveString() {
		String aux, diaS, mesS, horaS, minS;
		if(dia < 10) {
			diaS = "0" + dia;
		} else {
			diaS = Integer.toString(dia);
		}
		if(mes < 10) {
			mesS = "0" + mes;
		} else {
			mesS = Integer.toString(mes);
		}
		if(hora < 10) {
			horaS = "0" + hora;
		} else {
			horaS = Integer.toString(hora);
		}
		if(min < 10) {
			minS = "0" + min;
		} else {
			minS = Integer.toString(min);
		}
		aux = diaS + "/" + mesS + "/" + Integer.toString(ano) + " " + horaS + ":" + minS;
		return aux;
	}
	
}
