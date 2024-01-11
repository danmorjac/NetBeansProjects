/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entitats;

/**
 *
 * @author jesusmtimoneda
 */
public class LLoguerBean {

    public LLoguerBean() {
    }
    private String nom;
    private String dies;
    private String edat;
    private String pagament;
    private String especificacions;

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the dies
     */
    public String getDies() {
        return dies;
    }

    /**
     * @param dies the dies to set
     */
    public void setDies(String dies) {
        this.dies = dies;
    }

    /**
     * @return the edat
     */
    public String getEdat() {
        return edat;
    }

    /**
     * @param edat the edat to set
     */
    public void setEdat(String edat) {
        this.edat = edat;
    }

    /**
     * @return the pagament
     */
    public String getPagament() {
        return pagament;
    }

    /**
     * @param pagament the pagament to set
     */
    public void setPagament(String pagament) {
        this.pagament = pagament;
    }

    /**
     * @return the especificacions
     */
    public String getEspecificacions() {
        return especificacions;
    }

    /**
     * @param especificacions the especificacions to set
     */
    public void setEspecificacions(String especificacions) {
        this.especificacions = especificacions;
    }

    
}
