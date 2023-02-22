package Models;

import java.time.LocalDate;

public class Movimentacao {

    private int id;
    private int tipo;
    private int categoria;
    private LocalDate data;
    private int valor;

    private boolean pago;

    private String descricao;

    public Movimentacao (int tipo, int categoria, LocalDate data, int valor, int id) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.id = id;
    }

    public Movimentacao (int tipo, int categoria, LocalDate data, int valor, boolean pago) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.pago = pago;
    }
    public Movimentacao (int tipo, int categoria, LocalDate data, int valor, String descricao, boolean pago, int id) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.data = data;
        this.pago = pago;
        this.descricao = descricao;
        this.valor = valor;
        this.id = id;
    }

    public Movimentacao (int tipo) {
        this.tipo = tipo;;
    }

    public Movimentacao (int tipo, int categoria, LocalDate data, int valor, String descricao, boolean pago) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.data = data;
        this.pago = pago;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Movimentacao (int tipo, int categoria, LocalDate data, int valor, String descricao) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.data = data;
        this.pago = pago;
        this.descricao = descricao;
        this.valor = valor;
    }


    public void setValor(int valor) {
        valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setCategoria(int categoria) {
        categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setData(LocalDate data) {
        data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void setTipo(int tipo) {
        tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setDescricao(String descricao) {
        descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setPago(boolean pago) {
        pago = pago;
    }

    public boolean isPago() {
        return pago;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
