package tranfConInterBlock;

public class Cuenta {

	private double saldo;
	private String cuenta_banc;
	private int ingresos=0, retiros=0;
	
	//CONSTRUCTORES
	public Cuenta(float saldo, String cuenta_banc) {
		this.saldo = saldo;
		this.cuenta_banc = cuenta_banc;
	}

	//GETTERS Y SETTERS
	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public int getIngresos() {
		return ingresos;
	}


	public void setIngresos(int ingresos) {
		this.ingresos = ingresos;
	}


	public int getRetiros() {
		return retiros;
	}


	public void setRetiros(int retiros) {
		this.retiros = retiros;
	}
	
	public String getCuenta_banc() {
		return cuenta_banc;
	}

	public void setCuenta_banc(String cuenta_banc) {
		this.cuenta_banc = cuenta_banc;
	}


	//METODOS
	
	
	public void Ingresar (int cantidad) {
		this.saldo+=cantidad;
		this.ingresos++;
	}


	
	public void Retirar (int cantidad) throws Exception{
		
		if (saldo-cantidad<0) {
			throw new Exception("La cuenta no debe quedarse debajo de 0€.");
		}

		if (cantidad>saldo) {
			throw new Exception("La cantidad deseada a retirar no puede superar su saldo actual de "+saldo);
		}

		if (cantidad<this.saldo && this.saldo-cantidad>0){
			this.saldo-=cantidad;
			this.retiros++;
		}
	}
	
	
	public String toString() {
		String s="";
		s+=("Usted tiene "+this.saldo+"€ en la cuenta\n");
		s+=("Ha realizado "+this.ingresos+" ingresos\n");
		s+=("Ha realizado "+this.retiros+" retiros\n");
		return s;
	}
	
}
/*
*
*
*
*Desarrollar un programa que modele una cuenta bancaria que tiene los
siguientes atributos, que deben ser de acceso privado:
	-Saldo, de tipo float.	
	-Número de ingresos con valor inicial cero, de tipo int.
	-Número de retiros con valor inicial cero, de tipo int.
	-Tasa anual (porcentaje), de tipo float.
	-Comisión mensual con valor inicial cero, de tipo float.
	
	
*La clase Cuenta tiene un constructor que inicializa los atributos saldo
y tasa anual con valores pasados como parámetros. La clase Cuenta tiene
los siguientes métodos:
	-Al ingresar una cantidad de dinero en la cuenta actualizando su saldo.
	-Retirar una cantidad de dinero en la cuenta actualizando su saldo. El valor a retirar no debe superar el saldo.
	-Calcular el interés mensual de la cuenta y actualiza el saldo correspondiente.
	-Extracto mensual: actualiza el saldo restándole la comisión mensual y calculando el interés mensual correspondiente 
	(invoca el método anterior).
	-Imprimir: muestra en pantalla los valores de los atributos.

*/