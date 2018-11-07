/**
 * @author Tania
 * @date 26 oct. 2018
 * @version 1.0
 * @description 
 * 
 */
package peval1;

/**
 * Class Main
 */
public class Main {

	/**
	 * Method
	 * @name main
	 * @param args 
	 */
	public static void main(String[] args) {
		 Thread t;
		 Rio guadalmedina=new Rio();
		 for(int i=0;i<10;i++){
			t=new Thread(new Coche(i,guadalmedina));
			 t.start();
			 t=new Thread(new Barco(i,guadalmedina));
			 t.start();
		 }
	 }
}
