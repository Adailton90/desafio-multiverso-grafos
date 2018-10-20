package com.adailton.multiverso.entity;

import java.util.ArrayList;
import java.util.List;

public class CalculosMultiverso {
	private List<Caminho> listaCaminho = new ArrayList<>();
	
	
	
	
	public void calculaCaminho(UniversoVertice verticeOrigem, UniversoVertice verticeDestino,List<Caminho> listaCaminho) {
		
		
		//for(int i= 0; i<5; i++) {
			for(Aresta v:verticeOrigem.getRotas()) {
				Caminho cam = new Caminho();//por conta disso não consegui fazer recursividade 
				if(cam.getQtdParada() == 3 || !cam.isCaminhoValido()) {
					if(v.getDestino().getNome().equals(verticeDestino.getNome())) {//comparando se tem uma aresta do mesmo nome do destino
						cam.setCaminhoValido(true);
						cam.somaTotalEP(v.getespaco_tempo());
						cam.setletrasDoCaminho(v.getDestino().getNome());
						cam.setQtdParada(cam.getLetrasDoCaminho().size());
						listaCaminho.add(cam);
					}else {
						cam.somaTotalEP(v.getespaco_tempo());
						cam.setletrasDoCaminho(v.getDestino().getNome());
						UniversoVertice verticeAuxiliar = v.getDestino();
						
						for(Aresta v2:verticeAuxiliar.getRotas()) {//segundo nó
							if(cam.getQtdParada() == 3 || !cam.isCaminhoValido()) {
								if(v2.getDestino().getNome().equals(verticeDestino.getNome())) {//comparando se tem uma aresta do mesmo nome do destino
									cam.setCaminhoValido(true);
									cam.somaTotalEP(v2.getespaco_tempo());
									cam.setletrasDoCaminho(v2.getDestino().getNome());
									cam.setQtdParada(cam.getLetrasDoCaminho().size());
									listaCaminho.add(cam);
								}else {
									cam.somaTotalEP(v2.getespaco_tempo());
									cam.setletrasDoCaminho(v2.getDestino().getNome());
									UniversoVertice verticeAuxiliar3 = v2.getDestino();
									
									for(Aresta v3:verticeAuxiliar3.getRotas()) {//terceiro nó
										if(cam.getQtdParada() == 3 || !cam.isCaminhoValido()) {
											if(v3.getDestino().getNome().equals(verticeDestino.getNome())) {
												cam.setCaminhoValido(true);
												cam.somaTotalEP(v3.getespaco_tempo());
												cam.setletrasDoCaminho(v3.getDestino().getNome());
												cam.setQtdParada(cam.getLetrasDoCaminho().size());
												listaCaminho.add(cam);
											}else {
												cam.somaTotalEP(v3.getespaco_tempo());
												cam.setletrasDoCaminho(v3.getDestino().getNome());
												UniversoVertice verticeAuxiliar4 = v3.getDestino();
												
												for(Aresta v4:verticeAuxiliar4.getRotas()) {//correndo até a ultima possibilidade de nó(quarto nó)
													if(cam.getQtdParada() == 3 || !cam.isCaminhoValido()) {
														if(v4.getDestino().getNome().equals(verticeDestino.getNome())) {
															cam.setCaminhoValido(true);
															cam.somaTotalEP(v4.getespaco_tempo());
															cam.setletrasDoCaminho(v4.getDestino().getNome());
															cam.setQtdParada(cam.getLetrasDoCaminho().size());
															listaCaminho.add(cam);
														}else {
															cam.somaTotalEP(v4.getespaco_tempo());
															cam.setletrasDoCaminho(v4.getDestino().getNome());
															UniversoVertice verticeAuxiliar5 = v4.getDestino();																						
																		
															for(Aresta v5:verticeAuxiliar5.getRotas()) {//correndo até a ultima possibilidade de nó(quarto nó)
																if(cam.getQtdParada() == 3 || !cam.isCaminhoValido()) {
																	if(v5.getDestino().getNome().equals(verticeDestino.getNome())) {
																		cam.setCaminhoValido(true);
																		cam.somaTotalEP(v5.getespaco_tempo());
																		cam.setletrasDoCaminho(v5.getDestino().getNome());
																		cam.setQtdParada(cam.getLetrasDoCaminho().size());
																		listaCaminho.add(cam);														}
																}else {
																	cam.somaTotalEP(v4.getespaco_tempo());
																	cam.setletrasDoCaminho(v4.getDestino().getNome());
																}
															}
														}						
													}
												}
											}
										}
									}
								}
							}
						}	
					}		
				}
			}
	}
	}

