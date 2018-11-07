/**
 * @author Tania
 * @date 26 oct. 2018
 * @version 1.0
 * @description 
 * 
 */

package peval1;


/**
 * Class Rio
 */
public class Rio {
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
	 * Class Rio Constructor
	 */
	public Rio() {
	}
	
	/**
	 * Método que permite o no a los vehiculos cruzar el puente
	 * @name Cruzar
	 * @param vehiculo 
	 */
	public synchronized void Cruzar(String vehiculo) {
		
		if(vehiculo.startsWith("B")) {
			if (puenteAbajo) {
				System.out.println(vehiculo + " ha intentado cruzar pero el puente está bajado");
				while(puenteAbajo) {
					try {
						wait();
					} catch (InterruptedException e) {
						System.out.println("Error. Se ha interrumpido el estado de espera de " +  vehiculo);
						e.printStackTrace();
					}					
				}
			} else {
				System.out.println(vehiculo + " está cruzando el puente");				
				barcosCruzando++;
				avisos--;
			}
		} else {	
			if (avisos != 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Error. Se ha interrumpido el estado de espera de " +  vehiculo);
					e.printStackTrace();
				}
			}
			 if (!puenteAbajo)  {					
					System.out.println(vehiculo + " ha intentado cruzar pero el puente está subido");
					
					while(!puenteAbajo) {
						try {
							wait();
						} catch (InterruptedException e) {
							System.out.println("Error. Se ha interrumpido el estado de espera de " +  vehiculo);
							e.printStackTrace();
						}												
					}
				}
				System.out.println(vehiculo + " está cruzando el puente");
				cochesCruzando++;		
		}
	}
	
	/**
	 * Método que informa de cuando los vehículos han salido del cruce
	 * @name SalirDeCruce
	 * @param vehiculo 
	 */
	public synchronized void SalirDeCruce(String vehiculo) {
		System.out.println(vehiculo + " ha salido del cruce");
		if(vehiculo.startsWith("B")) {
			barcosCruzando--;
			if(barcosCruzando == 0 && avisos == 0) {
				puenteAbajo = true;
				System.out.println("--- SE HA BAJADO EL PUENTE ---");
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Error. Se ha interrumpido el estado de espera de " +  vehiculo);
					e.printStackTrace();
				}
			}
		} else {
			cochesCruzando--;
			
			if(cochesCruzando != 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Error. Se ha interrumpido el estado de espera de " +  vehiculo);
					e.printStackTrace();
				}
			}
		}

		notifyAll();
	}
	
	/**
	 * Método que utilizan los barcos para avisar al puente de mando que se están acercando
	 * @name Avisar
	 * @param vehiculo 
	 */
	public void Avisar(String vehiculo) {
		System.out.println(vehiculo + " avisa al puente de mando");
		avisos++;
	}
	
	/**
	 * Método para levantar el puente para que pasen los barcos
	 * @name LevantarPuente 
	 */
	public synchronized void LevantarPuente() {
		if(puenteAbajo && cochesCruzando == 0) {
			System.out.println("--- SE HA LEVANTADO EL PUENTE ---");
			puenteAbajo = false;
		} 
	}
	
	/**
	 * Getter del booleano puenteAbajo
	 * @name isPuenteAbajo
	 * @return puenteAbajo 
	 */
	public boolean isPuenteAbajo() {
		return puenteAbajo;
	}

	/**
	 * Setter del booleano puenteAbajo
	 * @name setPuenteAbajo
	 * @param puenteAbajo 
	 */
	public void setPuenteAbajo(boolean puenteAbajo) {
		this.puenteAbajo = puenteAbajo;
	}

}
