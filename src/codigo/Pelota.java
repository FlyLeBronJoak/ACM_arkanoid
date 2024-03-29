package codigo;

/*
 * Autor: Joaquin Sierra
 * la clase es la que vamos a utilizar
 * para el juego de Arkanoid
 * Tiene dos constructores
 */
import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Pelota extends GOval{

	double xVelocidad = 1; // velocidad de la bola en el eje X
	double yVelocidad = -1; // velocidad de la bola en el eje Y


	/**
	 * Este es el constructor b�sico, que es dientico
	 * al de la clase GOval
	 * @param _ancho
	 * @param _alto
	 */

	public Pelota(double _ancho, double _alto){
		super(_ancho, _alto);

	}

	/**
	 * Este es el constructor que permite
	 * pasar el color como par�metro
	 * @param _ancho
	 * @param _color
	 */
	public Pelota(double _ancho, Color _color){
		super(_ancho, _ancho);
		if(_ancho<=0){
			this.setSize(1, 1);

		}

		this.setFillColor(_color);
		this.setFilled(true);

	}


	/**
	 * Se encarga de mover a la pelota y chequear si ha habido colisi�n
	 * 
	 */
	public void muevete(Arkanoid _arkanoid){
		//chequea si ha chocado con las paredes izquierda o derecha.
		if (this.getX() + this.getWidth() >= _arkanoid.getWidth() || this.getX() <0){
			xVelocidad *=-1;
		}
		//chequea si ha chocado con el techo.
		if (this.getY() <0){
			yVelocidad *=-1;
		}
		if(chequeaColision(getX(), getY(), _arkanoid)){ //chequeo la esquina sup izq
			if(chequeaColision(getX()+ getWidth(), getY(), _arkanoid)){//sup der
				if(chequeaColision(getX()+ getWidth(), getY()+getHeight(), _arkanoid)){	//inf izq
					if(chequeaColision(getX()+ getWidth(), getY()+getHeight(), _arkanoid)){ //inf der

					}
				}
			}
		}
		//chequeColisionConBarra( _arkanoid);
		//voy a crear un metodo chequea colision
		//que sirva para comprobar los choques entre la bola y los ladrillo
		//y la bola y el cursor
		move(xVelocidad, yVelocidad);

	}

	private boolean chequeaColision(double posX, double posY, Arkanoid _arkanoid){
		boolean noHaChocado =  true;
		GObject auxiliar;
		auxiliar = _arkanoid.getElementAt(posX, posY);

		if (auxiliar instanceof Ladrillo){
			if (auxiliar.getY()==posY || auxiliar.getY()+auxiliar.getHeight()==posY)
				yVelocidad *= -1;
			else if(auxiliar.getX()==posX || auxiliar.getX()+auxiliar.getWidth()==posX)
				xVelocidad*=-1;
			_arkanoid.remove(auxiliar);
			noHaChocado = false;

		}
		else if (auxiliar instanceof Barra){
			yVelocidad *=-1;
			noHaChocado = false;
		}
		return noHaChocado;
	}

	//private void chequeColisionConBarra(Arkanoid _arkanoid){
	//chequea las esquinas interiores de la pelota
	//para ver si hay una barra.
	//if (_arkanoid.getElementAt(getX(), getY()+ getHeight()) == _arkanoid.barra1){
	//yVelocidad *= -1;

	//else if (_arkanoid.getElementAt(getX() + getWidth(), getY() + getHeight()) == _arkanoid.barra1){
	//yVelocidad *= -1;
}














































