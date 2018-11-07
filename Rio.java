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
	private boolean puenteAbajo = true;
	private boolean haAvisado = false;
	private int avisos = 0;
	private int barcosCruzando = 0;
	private int cochesCruzando = 0;
	
	/**
	 * Class Rio Constructor
	 */
	public Rio() {
	}
	
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
				while(haAvisado) {
					try {
						wait();
					} catch (InterruptedException e) {
						System.out.println("Error. Se ha interrumpido el estado de espera de " +  vehiculo);
						e.printStackTrace();
					}
				} 
				if (!puenteAbajo) {					
					System.out.println(vehiculo + " ha intentado cruzar pero el puente está subido");
					
					while(!puenteAbajo) {
						//Thread.sleep(2000);
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
	
	public synchronized void SalirDeCruce(String vehiculo) {
		System.out.println(vehiculo + " ha salido del cruce");
		if(vehiculo.startsWith("B")) {
			barcosCruzando--;
			if(barcosCruzando == 0 && avisos == 0) {
				puenteAbajo = true;
				System.out.println("--- SE HA BAJADO EL PUENTE ---");
			}
		} else {
			cochesCruzando--;
		}
		notifyAll();
	}
	
	public void Avisar(String vehiculo) {
		System.out.println(vehiculo + " avisa al puente de mando");
		haAvisado = true;
		avisos++;
	}
	
	public synchronized void LevantarPuente() {
		if(puenteAbajo && cochesCruzando == 0) {
			System.out.println("--- SE HA LEVANTADO EL PUENTE ---");
			puenteAbajo = false;
			haAvisado = false;
		} 
	}
	
	public boolean isPuenteAbajo() {
		return puenteAbajo;
	}

	public void setPuenteAbajo(boolean puenteAbajo) {
		this.puenteAbajo = puenteAbajo;
	}

}
