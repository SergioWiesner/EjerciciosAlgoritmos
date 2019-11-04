/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

/**
 *
 * @author webdev
 */
public class Figuras {

    public int id, ancho, alto, beneficio;

    public Figuras(int idin, int anchoin, int altoin, int beneficioin) {
        this.id = idin;
        this.ancho = anchoin;
        this.alto = altoin;
        this.beneficio = beneficioin;
    }

    public int getId() {
        return this.id;
    }

    public int getAncho() {
        return this.ancho;
    }

    public int getAlto() {
        return this.alto;
    }

    public int getBeneficio() {
        return this.beneficio;
    }
    
    public double getBeneficioUnitario() {
        return this.beneficio/(this.ancho*this.alto);
    }
    
    public int getAreaTotalFigura() {
        return (this.ancho*this.alto);
    }


}
