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
	 * @variable_name objetos
	 * @type ObjetosSync
	 */
	ObjetosSync objetos = new ObjetosSync();
	
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
	public void Cruzar(String vehiculo) {
		synchronized (objetos) {
			if(vehiculo.startsWith("B")) {

				while(objetos.isPuenteAbajo()) {
					System.out.println(vehiculo + " ha intentado cruzar pero el puente está bajado");
					
					try {
						objetos.wait();
					} catch (InterruptedException e) {
						System.out.println("Error. Se ha interrumpido el estado de espera de " +  vehiculo);
						//e.printStackTrace();
					}					
				}

				System.out.println(">>" + vehiculo + " está cruzando el puente");				
				objetos.setBarcosCruzando(objetos.getBarcosCruzando() + 1);
				objetos.setAvisos(objetos.getAvisos() - 1);
				
			} else {	
				if (objetos.getAvisos() != 0) {
					try {
						objetos.wait();
					} catch (InterruptedException e) {
						System.out.println("Error. Se ha interrumpido el estado de espera de " +  vehiculo);
						//e.printStackTrace();
					}
				}
				if (!objetos.isPuenteAbajo())  {					
					System.out.println(vehiculo + " ha intentado cruzar pero el puente está subido");
					
					while(!objetos.isPuenteAbajo()) {
						try {
							objetos.wait();
						} catch (InterruptedException e) {
							System.out.println("Error. Se ha interrumpido el estado de espera de " +  vehiculo);
							//e.printStackTrace();
						}												
					}
				}
				System.out.println(">>" + vehiculo + " está cruzando el puente");
				objetos.setCochesCruzando(objetos.getCochesCruzando() + 1);					
			}
		}
	}
	
	/**
	 * Método que informa de cuando los vehículos han salido del cruce
	 * @name SalirDeCruce
	 * @param vehiculo 
	 */
	public void SalirDeCruce(String vehiculo) {
		synchronized (objetos) {
			System.out.println("<<" + vehiculo + " ha salido del cruce");
			
			if(vehiculo.startsWith("B")) {
				objetos.setBarcosCruzando(objetos.getBarcosCruzando() - 1);	
				
				if(objetos.getBarcosCruzando() == 0 && objetos.getAvisos() == 0) {
					objetos.setPuenteAbajo(true);
					System.out.println("///------ SE HA BAJADO EL PUENTE ------///");
				} else {
					try {
						objetos.wait();
					} catch (InterruptedException e) {
						System.out.println("Error. Se ha interrumpido el estado de espera de " +  vehiculo);
						//e.printStackTrace();
					}
				}
			} else {
				objetos.setCochesCruzando(objetos.getCochesCruzando() - 1);	
				
				if(objetos.getCochesCruzando() != 0) {
					try {
						objetos.wait();
					} catch (InterruptedException e) {
						System.out.println("Error. Se ha interrumpido el estado de espera de " +  vehiculo);
						//e.printStackTrace();
					}
				}
				
				LevantarPuente();
			}

			objetos.notifyAll();
		}
	}
	
	/**
	 * Método que utilizan los barcos para avisar al puente de mando que se están acercando
	 * @name Avisar
	 * @param vehiculo 
	 */
	public void Avisar(String vehiculo) {
		
		synchronized (objetos) {
			System.out.println("~~" + vehiculo + " avisa al puente de mando");
			objetos.setAvisos(objetos.getAvisos() + 1);	
		}
	}
	
	/**
	 * Método para levantar el puente para que pasen los barcos
	 * @name LevantarPuente 
	 */
	public void LevantarPuente() {
		synchronized (objetos) {
			if(objetos.isPuenteAbajo() && objetos.getCochesCruzando() == 0 && objetos.getAvisos() != 0) {
				System.out.println("///------ SE HA LEVANTADO EL PUENTE ------///");
				objetos.setPuenteAbajo(false);
			} 	
		}
	}
	
	/**
	 * Getter del booleano puenteAbajo
	 * @name isPuenteAbajo
	 * @return puenteAbajo 
	 */
	public boolean isPuenteAbajo() {
		return objetos.isPuenteAbajo();
	}
}
