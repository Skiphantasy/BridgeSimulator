/**
 * @author Tania
 * @date 26 oct. 2018
 * @version 1.0
 * 
 */
package peval1;


/**
 * Class Barco
 */
public class Barco implements Runnable{
	/**
	 * @variable_name rio
	 * @type Rio
	 */
	Rio rio;
	/**
	 * @variable_name t
	 * @type Thread
	 */
	Thread t;
	

	/**
	 * Class Barco Constructor
	 * @param i
	 * @param rio
	 */
	public Barco(int i, Rio rio) {
		t = new Thread(this);
		this.rio = rio;
		t.setName("Barco " + i);
	}

	/**
	 * Método que ejecuta el hilo
	 * @name run 
	 * @overriden @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {			
		rio.Avisar(t.getName());		
		rio.LevantarPuente();				
		rio.Cruzar(t.getName());
		rio.SalirDeCruce(t.getName());
	}

}
