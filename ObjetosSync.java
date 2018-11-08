/**
 * @author Tania
 * @date 26 Oct. 2018
 * @version 1.0
 * @description 
 * 
 */
package peval1;

/**
 * Class ObjetosSync
 */
public class ObjetosSync {
	/**
	 * @variable_name puenteAbajo
	 * @type boolean
	 */
	private boolean puenteAbajo = true;
	/**
	 * @variable_name avisos
	 * @type int
	 */
	private int avisos = 0;
	/**
	 * @variable_name barcosCruzando
	 * @type int
	 */
	private int barcosCruzando = 0;
	/**
	 * @variable_name cochesCruzando
	 * @type int
	 */
	private int cochesCruzando = 0;
	
	/**
	 * Class ObjetosSync Constructor
	 */
	public ObjetosSync() {
	}

	/**
	 * Getter de booleano puenteAbajo
	 * @name isPuenteAbajo
	 * @return 
	 */
	public boolean isPuenteAbajo() {
		return puenteAbajo;
	}

	/**
	 * Setter de boolean puenteAbajo
	 * @name setPuenteAbajo
	 * @param puenteAbajo 
	 */
	public void setPuenteAbajo(boolean puenteAbajo) {
		this.puenteAbajo = puenteAbajo;
	}

	/**
	 * Getter de int avisos
	 * @name getAvisos
	 * @return 
	 */
	public int getAvisos() {
		return avisos;
	}

	/**
	 * Setter de int avisos
	 * @name setAvisos
	 * @param avisos 
	 */
	public void setAvisos(int avisos) {
		this.avisos = avisos;
	}

	/**
	 * Getter de int barcosCruzando
	 * @name getBarcosCruzando
	 * @return barcosCruzando
	 */
	public int getBarcosCruzando() {
		return barcosCruzando;
	}

	/**
	 * Setter de int barcosCruzando
	 * @name setBarcosCruzando
	 * @param barcosCruzando 
	 */
	public void setBarcosCruzando(int barcosCruzando) {
		this.barcosCruzando = barcosCruzando;
	}

	/**
	 * Getter de int cochesCruzando
	 * @name getCochesCruzando
	 * @return cochesCruzando
	 */
	public int getCochesCruzando() {
		return cochesCruzando;
	}

	/**
	 * Setter de int cochesCruzando
	 * @name setCochesCruzando
	 * @param cochesCruzando 
	 */
	public void setCochesCruzando(int cochesCruzando) {
		this.cochesCruzando = cochesCruzando;
	}
	
	

}
