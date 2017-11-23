package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

/*
 * Autor:Joaquin Sierra
 * 
 * El Arkanoid pero orientado a objetos
 */
import acm.graphics.*;
public class Arkanoid extends acm.program.GraphicsProgram{

	Pelota pelota1 = new Pelota(20, Color.GREEN);
	Barra barra1 = new Barra(60, 15, Color.RED);
	int anchoLadrillo = 35;
	int altoLadrillo = 15;
    int espacioMenu = 200;
	//el sistema del marcador
	int puntuacion = 0;
	//GLabel marcador = new GLabel ("0");
	Marcador marcador = new Marcador(20, 40);

	public void init(){
		addMouseListeners();
		setSize(400, 600);
		GRect lateral = new GRect(3, getHeight());
		lateral.setFilled(true);
		add(lateral, getWidth()- espacioMenu - lateral.getWidth()- pelota1.getWidth(),0);

		add(pelota1, 0, getHeight()*0.60 - pelota1.getHeight());
		
		add(barra1, 0, getHeight()*0.80);	
		//cajaMarcador.setFilled(true);
		//cajaMarcador.setFillColor(Color.ORANGE);

	}

	public void run(){
		dibujaNivel01();
		marcador.dibuja(this);
		add(marcador.texto, 0, 20);
		while (true){
			pelota1.muevete(this);
			
			pause(2);
		}
		
	}
	public void mouseMoved (MouseEvent evento){
		barra1.mueveBarra(evento.getX(), getWidth());
	}

	private void dibujaNivel01(){
		for (int j=0; j<14; j++){
			for(int i=j; i < 14; i++){
				Ladrillo miLadrillo = new Ladrillo(anchoLadrillo*i - anchoLadrillo*j/2, altoLadrillo*j + altoLadrillo, anchoLadrillo, altoLadrillo, Color.PINK);
				add(miLadrillo);
				pause(7);
			}

		}
	}








}




