package br.eti.gadelha.ejb.controle.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

@Interceptor
public class TerceiroInterceptador {

	//Permite todas as 4 Call-backs
	public TerceiroInterceptador() {
		// TODO Auto-generated constructor stub
	}
	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		Logger.getLogger(this.getClass()).info("Terceiro Interceptador");
		Logger.getLogger(this.getClass()).info("Terceiro Interceptador, método interceptado: "+ic.getMethod());
		return null;
	}

}
