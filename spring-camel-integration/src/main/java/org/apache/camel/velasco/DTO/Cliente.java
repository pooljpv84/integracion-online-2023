package org.apache.camel.velasco.DTO;
public class Cliente {

    private int codigo;
    private int identificacion;
    private String nombre;
    private int canal;

    public Cliente() {
    }

    public Cliente(int codigo, int identificacion, String nombre, int canal) {
        this.codigo = codigo;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.canal = canal;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCanal() {
        return canal;
    }
    public void setCanal(int canal) {
        this.canal = canal;
    }
    @Override
    public String toString(){
        return "Cliente : " + codigo + " " + identificacion + " " + nombre + " " + canal;
    }

}
