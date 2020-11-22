package com.example.service.Iimpl;

import org.springframework.data.domain.Page;



public abstract interface AbstractFacade <T, V>{
	
	
	public Page<T> listarPaginadoFacade(boolean lazy, int page, int size);
	public  T listarPooIdFacede(boolean lazy, V id);
	public void gusardarFacade(T clase);
	public void editarFacade(T clase);
	public void eliminarFacade(V id);

}
