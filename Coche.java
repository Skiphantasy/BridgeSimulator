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
	Rio rio;
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
		//System.out.println(t.getName() + " se aproxima");
		rio.Cruzar(t.getName());
		/*try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		rio.SalirDeCruce(t.getName());					
	}

}
