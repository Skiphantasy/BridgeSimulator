/**
 * @author Tania
 * @date 26 oct. 2018
 * @version 1.0
 * @description 
 * 
 */
package peval1;

/**
 * Class Barco
 */
public class Barco implements Runnable{
	Rio rio;
	Thread t;
	/**
	 * Class Barco Constructor
	 */
	public Barco(int i, Rio rio) {
		t = new Thread(this);
		this.rio = rio;
		t.setName("Barco " + i);
	}

	/**
	 * Method
	 * @name run 
	 * @overriden @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		long time = Math.round(((Math.random() * 2) + 3));
		
		/*try {
			Thread.sleep(Math.round(((Math.random() * 100))));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		//System.out.println(t.getName() + "se aproxima");
		rio.Avisar(t.getName());
		while(rio.isPuenteAbajo()) {
			rio.LevantarPuente();				
		}
		rio.Cruzar(t.getName());
		/*try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		rio.SalirDeCruce(t.getName());
	}

}
