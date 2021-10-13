package Modelo;

import java.util.List;

public class Validacao {

    private String Mensagem;
    private Integer ID;
    private Float Valor;

    public void validarDados(List<String> dadosCarro) {
        this.Mensagem = "";
        this.validarID(dadosCarro.get(0));
        this.validarFabricante(dadosCarro.get(1));
        this.validarModelo(dadosCarro.get(2));
        this.validarCor(dadosCarro.get(3));

        if (dadosCarro.get(4).length() != 4) {
            this.Mensagem += "Ano inválido, digitar em formato | AAAA |. \n";
        }
        this.validarValor(dadosCarro.get(5));
    }

    public void validarID(String numeroId) {
        this.Mensagem = "";
        try {
            this.ID = Integer.parseInt(numeroId);
        } catch (Exception e) {
            this.Mensagem += "ID inválido \n";
        }
    }

    public void validarFabricante(String fabricante) {
        if (fabricante.length() < 3 || fabricante.length() > 30) {
            this.Mensagem += "Fabricante deve ter entre 3 a 30 caracteres \n";
        } else {
            this.Mensagem = "";
        }
    }

    public void validarModelo(String modelo) {
        if (modelo.length() < 3 || modelo.length() > 20) {
            this.Mensagem += "Modelo deve ter entre 3 a 30 caracteres \n";
        } else {
            this.Mensagem = "";
        }
    }

    public void validarCor(String cor) {
        if (cor.length() < 3 || cor.length() > 20) {
            this.Mensagem += "Cor deve ter entre 3 a 15 caracteres \n";
        } else {
            this.Mensagem = "";
        }
    }

    public void validarValor(String numeroValor) {
        try {
            this.Valor = Float.parseFloat(numeroValor);
        } catch (Exception e) {
            this.Mensagem += "Valor inválido \n";
        }
    }

    public String getMensagem() {
        return Mensagem;
    }

    public Integer getId() {
        return ID;
    }

    public Float getValor() {
        return Valor;
    }

}
