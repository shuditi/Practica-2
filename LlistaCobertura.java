/**
 * Pràctica 2 - Curs 2026-27
 * Classe LlistaCobertura
 */
public class LlistaCobertura {
    private Cobertura[] llista;
    private int numElements;

    // MÈTODES BÀSICS

    /**
     * Constructor que inicialitza la llista amb una capacitat màxima especificada.
     * @param capacitat Capacitat màxima de la llista.
     */
    public LlistaCobertura(int capacitat) {
        this.llista = new Cobertura[capacitat];
        this.numElements = 0;
    }

    /**
     * Retorna el nombre d'elements actualment emmagatzemats a la llista.
     * @return Nombre d'elements.
     */
    public int getNumElements() {
        return this.numElements;
    }

    /**
     * Consulta l'element situat en una posició específica.
     * @param posicio Posició de l'element a consultar.
     * @return La instància de Cobertura a la posició indicada, o null si la posició no és vàlida.
     */
    public Cobertura getElement(int posicio) {
        if (posicio >= 0 && posicio < this.numElements) {
            return this.llista[posicio];
        }
        return null;
    }

    /**
     * Representació textual de tota la llista de punts de cobertura.
     * @return Cadena de caràcters amb el contingut de la llista.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LlistaCobertura (Total: ").append(this.numElements).append(" elements):\n");
        for (int i = 0; i < this.numElements; i++) {
            sb.append("[").append(i).append("]").append(this.llista[i].toString()).append("\n");
        }
        return sb.toString();
    }

    // MÈTODES ADDICIONALS

    /**
     * 1. Afegeix una nova instància de Cobertura al final de la llista.
     * @param c Instància de Cobertura a afegir.
     * @return true si s'ha pogut afegir, false si la llista és plena o l'element és null.
     */
    public boolean afegir(Cobertura c) {
        if (c != null && this.numElements < this.llista.length) {
            this.llista[this.numElements] = c;
            this.numElements++;
            return true;
        }
        return false;
    }

    /**
     * 2. Compta quants punts de cobertura tenen una velocitat superior a 100.
     * @return Nombre de punts amb velocitat > 100.
     */
    public int comptaVelocitatSuperior100() {
        int comptador = 0;
        for (int i = 0; i < this.numElements; i++) {
            if (this.llista[i].getVelocitat() > 100) {
                comptador++;
            }
        }
        return comptador;
    }

    /**
     * 3. Consulta les dades de la instància que té menys precisió.
     * En cas d'empat retorna la primera trobada.
     * @return La instància amb menor precisió o null si la llista és buida.
     */
    public Cobertura consultarMenysPrecisio() {
        if (this.numElements == 0) {
            return null;
        }
        Cobertura minPrecisio = this.llista[0];
        for (int i = 1; i < this.numElements; i++) {
            if (this.llista[i].getPrecisio() < minPrecisio.getPrecisio()) {
                minPrecisio = this.llista[i];
            }
        }
        return minPrecisio;
    }

    /**
     * 4. Retorna un duplicat de la instància amb xarxa 4G, amb l'activitat indicada (TILTING o STILL)
     * i amb un nombre de satèl·lits superior al llindar indicat.
     * @param activitat   Activitat desitjada (TILTING o STILL).
     * @param minSatelits Llindar mínim de satèl·lits.
     * @return Un duplicat de la instància coincident trobada, o null si no n'hi ha cap.
     */
    public Cobertura trobarDuplicat4G(String activitat, int minSatelits) {
        for (int i = 0; i < this.numElements; i++) {
            Cobertura actual = this.llista[i];
            if (actual.getTipusXarxa().equalsIgnoreCase("4G") &&
                    actual.getActivitat().equalsIgnoreCase(activitat) &&
                    actual.getSatelits() > minSatelits) {
                return actual.copia();
            }
        }
        return null;
    }

    /**
     * 5. Compta quants punts de cobertura tenen un factor d'eficiència per sobre d'un valor x.
     * @param x Llindar del factor d'eficiència.
     * @return Nombre de punts amb factor d'eficiència estrictament superior a x.
     */
    public int comptaEficienciaSuperiorA(int x) {
        int comptador = 0;
        for (int i = 0; i < this.numElements; i++) {
            if (this.llista[i].factorEficiencia() > x) {
                comptador++;
            }
        }
        return comptador;
    }

    /**
     * 6. Consulta les dades d'un municipi i en retorna els punts en una nova LlistaCobertura.
     * @param nomMunicipi Nom del municipi a filtrar.
     * @return Una nova instància de LlistaCobertura amb els punts del municipi.
     */
    public LlistaCobertura consultarPerMunicipi(String nomMunicipi) {
        LlistaCobertura resultat = new LlistaCobertura(this.numElements);
        for (int i = 0; i < this.numElements; i++) {
            if (this.llista[i].getNomMunicipi().equalsIgnoreCase(nomMunicipi)) {
                resultat.afegir(this.llista[i]);
            }
        }
        return resultat;
    }

    /**
     * 7. Consulta les dades de cobertura d'un operador i les retorna en una nova LlistaCobertura.
     * @param operador Nom de l'operador a filtrar.
     * @return Una nova instància de LlistaCobertura amb els punts de l'operador.
     */
    public LlistaCobertura consultarPerOperador(String operador) {
        LlistaCobertura resultat = new LlistaCobertura(this.numElements);
        for (int i = 0; i < this.numElements; i++) {
            if (this.llista[i].getOperador().equalsIgnoreCase(operador)) {
                resultat.afegir(this.llista[i]);
            }
        }
        return resultat;
    }

    /**
     * 8. Elimina tots els punts de cobertura que tenen un cert codi postal, compactant la taula per no deixar
     * posicions buides entremig.
     * @param codiPostal Codi postal dels registres a eliminar.
     */
    public void eliminarPerCodiPostal(int codiPostal) {
        int i = 0;
        while (i < this.numElements) {
            if (this.llista[i].getCodiPostal() == codiPostal) {
                // Desplacem els elements per compactar
                for (int j = i; j < this.numElements - 1; j++) {
                    this.llista[j] = this.llista[j + 1];
                }
                this.llista[this.numElements - 1] = null; // Per a eliminar la seqüència que sobra
                this.numElements--;
            } else {
                i++;
            }
        }
    }
}
