package br.eti.gadelha.ejb.controle.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

@Interceptor
public class SegundoInterceptador {

	public SegundoInterceptador() {
		// TODO Auto-generated constructor stub
	}
	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		Logger.getLogger(this.getClass()).info("Segundo Interceptador");
		return null;
	}
}