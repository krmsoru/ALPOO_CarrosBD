package Modelo;

import DAL.CarroDAO;
import java.util.ArrayList;
import java.util.List;

public class Controle {

    public String mensagem;

    public void CadastrarCarros(List<String> dadosCarro) {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarDados(dadosCarro);
        if (validacao.getMensagem().equals("")) {
            Carro carro = new Carro();
            carro.setId(validacao.getId());
            carro.setFabricante(dadosCarro.get(1).toUpperCase());
            carro.setModelo(dadosCarro.get(2).toUpperCase());
            carro.setCor(dadosCarro.get(3).toUpperCase());
            carro.setAnoFabricacao(Integer.parseInt(dadosCarro.get(4)));
            carro.setValor(validacao.getValor());
            CarroDAO carroDAO = new CarroDAO();
            carroDAO.CadastrarCarro(carro);
            this.mensagem = carroDAO.getMensagem();
        } else {
            this.mensagem = validacao.getMensagem();
        }
    }

    public void EditarCarros(List<String> dadosCarro) {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarDados(dadosCarro);
        if (validacao.getMensagem().equals("")) {
            Carro carro = new Carro();
            carro.setId(validacao.getId());
            carro.setFabricante(dadosCarro.get(1).toUpperCase());
            carro.setModelo(dadosCarro.get(2).toUpperCase());
            carro.setCor(dadosCarro.get(3).toUpperCase());
            carro.setAnoFabricacao(Integer.parseInt(dadosCarro.get(4)));
            carro.setValor(validacao.getValor());
            CarroDAO carroDAO = new CarroDAO();
            carroDAO.EditarCarro(carro);
            this.mensagem = carroDAO.getMensagem();
        } else {
            this.mensagem = validacao.getMensagem();
        }

    }

    public void ExcluirCarro(String numeroId) {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarID(numeroId);
        Carro carro = new Carro();
        if (validacao.getMensagem().equals("")) {
            CarroDAO carroDAO = new CarroDAO();
            carro.setId(validacao.getId());
            carroDAO.ExcluirCarro(carro);
            this.mensagem = carroDAO.getMensagem();
        } else {
            this.mensagem = validacao.getMensagem();
        }
    }

    public Carro PesquisarCarroID(String numeroId) {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarID(numeroId);
        Carro pessoa = new Carro();
        if (validacao.getMensagem().equals("")) {
            pessoa.setId(validacao.getId());
            CarroDAO pessoaDAO = new CarroDAO();
            pessoa = pessoaDAO.PesquisarCarroID(pessoa);
            this.mensagem = pessoaDAO.getMensagem();
        } else {
            this.mensagem = validacao.getMensagem();
        }
        return pessoa;
    }

    public List<Carro> PesquisarCarroFabricante(String nomeFabricante) {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarFabricante(nomeFabricante);
        Carro carro = new Carro();
        List<Carro> listaCarros = new ArrayList<>();
        if (validacao.getMensagem().equals("")) {
            carro.setFabricante(nomeFabricante.toUpperCase());
            CarroDAO carroDAO = new CarroDAO();
            listaCarros = carroDAO.PesquisarCarroFabricante(carro);
            this.mensagem = carroDAO.getMensagem();
        } else {
            this.mensagem = validacao.getMensagem();
        }
        return listaCarros;
    }

    public List<Carro> PesquisarCarroModelo(String nomeModelo) {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarModelo(nomeModelo);
        Carro carro = new Carro();
        List<Carro> listaCarros = new ArrayList<>();
        if (validacao.getMensagem().equals("")) {
            carro.setModelo(nomeModelo.toUpperCase());
            CarroDAO carroDAO = new CarroDAO();
            listaCarros = carroDAO.PesquisarCarroModelo(carro);
            this.mensagem = carroDAO.getMensagem();
        } else {
            this.mensagem = validacao.getMensagem();
        }
        return listaCarros;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
