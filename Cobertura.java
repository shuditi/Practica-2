/**
 * Pràctica 2 - Curs 2026-27
 * Classe Cobertura
 */
public class Cobertura {
	private String operador;
	private String tipusXarxa;
	private int velocitat;
	private int satelits;;
	private int precisio;
	private String activitat;
	private int codiPostal;
	private String nomMunicipi;

	/**
	 * Constructor complet per instanciar un nou registre de cobertura.
	 * @param operador Nom de la companyia o operador de telecomunicacions.
	 * @param netType Tipus de xarxa mòbil.
	 * @param speed Velocitat de connexió mesurada.
	 * @param satellites Nombre de satèl·lits connectats en el moment de la mesura.
	 * @param precision Precisió de la ubicació obtinguda.
	 * @param activitat Activitat que s'estava realitzant.
	 * @param codiPostal Codi postal on s'ha pres la mesura.
	 * @param nom Nom del municipi de la mesura.
	 */
	public Cobertura(String operador, String netType, int speed, int satellites,
			int precision, String activitat, int codiPostal, String nom) {
		this.operador = operador;
		this.tipusXarxa = netType;
		this.velocitat = speed;
		this.satelits = satellites;
		this.precisio = precision;
		this.activitat = activitat;
		this.codiPostal = codiPostal;
		this.nomMunicipi = nom;
	}

	/**
	 * Mètode toString que retorna una representació textual detallada amb totes les dades del registre de cobertura.
	 * @return Cadena de caràcters formatada amb cada atribut i el seu valor corresponent.
	 */
	@Override
	public String toString() {
		String aux = "\n\tOperador:" + operador + "\n\tXarxa:" + tipusXarxa + "\n\tVelocitat:" +
				velocitat + "\n\tSatèl.lits:" + satelits + "\n\tPrecisió:" + precisio + "\n\tActivitat:" +
				activitat + "\n\tCodi Postal:" + codiPostal + "\n\tMunicipi:" + nomMunicipi;
		return aux;
	}


	/**
	 * Mètode que crea i retorna una còpia exacta de la instància actual de Cobertura.
	 * @return Un nou objecte amb els mateixos valors d'atributs que l'actual.
	 */
	public Cobertura copia() {
		Cobertura duplicat = new Cobertura(operador, tipusXarxa, velocitat, satelits,
				precisio, activitat, codiPostal, nomMunicipi);
		return duplicat;
	}

	/**
	 * Getter per a obtenir el nom de la companyia que opera la xarxa.
	 * @return el nom de l'operador.
	 */
	public String getOperador() {
		return operador;
	}

	/**
	 * Getter per a obtenir el tipus de xarxa de mòbil. (Bytes)
	 * @return tipus de xarxa.
	 */
	public String getTipusXarxa() {
		return tipusXarxa;
	}

	/**
	 * Getter per a obtenir la velocitat estimada de l'origen.
	 * @return velocitat de la xarxa.
	 */
	public int getVelocitat() {
		return velocitat;
	}

	/**
	 * Getter per a obtenir el nombre de satèl·lits GPS
	 * @return el nombre de satèl·lis.
	 */
	public int getSatelits() {
		return satelits;
	}

	/**
	 * Getter per a obtenir l'exactitud del proveïdor
	 * @return exactitud del proveïdor.
	 */
	public int getPrecisio() {
		return precisio;
	}

	/**
	 * Getter per a obtenir l'activitat més probable que l'usuari està fent: STILL o TILTING
	 * @return STILL o TILTING.
	 */
	public String getActivitat() {
		return activitat;
	}

	/**
	 * Getter per a obtenir el codi postal del municipi que es troba.
	 * @return codi postal del municipi.
	 */
	public int getCodiPostal() {
		return codiPostal;
	}

	/**
	 * Getter per a obtenir el nom del municipi que es troba.
	 * @return nom del municipi.
	 */
	public String getNomMunicipi() {
		return nomMunicipi;
	}

	/**
	 * Calcula el factor d'eficiència d'aquest punt de cobertura.
	 * S'obté multiplicant la velocitat per la precisió i dividint pel nombre de satèl·lits.
	 * Si el nombre de satèl·lits és 0, el factor d'eficiència és 0.
	 * @return El valor enter del factor d'eficiència.
	 */
	public int factorEficiencia() {
		if (this.satelits == 0) {
			return 0;
		}
		return (this.velocitat * this.precisio) / this.satelits;
	}
	
}
