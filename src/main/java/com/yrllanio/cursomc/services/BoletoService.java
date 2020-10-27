package com.yrllanio.cursomc.services;


import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.yrllanio.cursomc.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		//Aqui em casos normais é usado para chamar um WebService de pagamento de boleto.
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
		
	}
}
