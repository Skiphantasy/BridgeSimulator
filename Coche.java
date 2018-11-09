/**
 * @author Tania
 * @date 26 oct. 2018
 * @version 1.0
 * @description 
 * 
 */

package peval1;


/**
 * Class Coche
 */
public class Coche implements Runnable{
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
	 * Class Coche Constructor
	 */
	public Coche(int i, Rio rio) {
		t = new Thread(this);
		this.rio = rio;
		t.setName("Coche " + i);
			
	}

	/**
	 * Método que ejecuta el hilo
	 * @name run 
	 * @overriden @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {			
		rio.Cruzar(t.getName());
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		rio.SalirDeCruce(t.getName());
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
