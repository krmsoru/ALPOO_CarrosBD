package DAL;

import Modelo.Carro;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class CarroDAO {

    private String mensagem;
    Conexao conexao = new Conexao();
    Session session = HibernateUtil.getSessionFactory().openSession();

    public void CadastrarCarro(Carro carro) {
        this.mensagem = "";
        try {
            session.beginTransaction();
            session.save(carro);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Veículo cadastrado com sucesso!";
        } catch (Exception e) {
            this.mensagem = "Erro de gravação no BD";
        }
    }

    public void EditarCarro(Carro carro) {
        this.mensagem = "";
        try {
            session.beginTransaction();
            session.saveOrUpdate(carro);
            session.getTransaction();
            session.close();
            this.mensagem = "Veículo editado com sucesso!";

        } catch (Exception e) {
            this.mensagem = "Erro de gravação no BD";
        }
    }

    public void ExcluirCarro(Carro carro) {
        this.mensagem = "";
        try {
            session.beginTransaction();
            session.delete(carro);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Veículo excluido com sucesso!";
        } catch (Exception e) {
            this.mensagem = "Erro de gravação no BD";
        }
    }

    public Carro PesquisarCarroID(Carro carro) {
        this.mensagem = "";
        try {
            Query q = session.createQuery("From Carro c where c.id = :id");
            q.setParameter("id", carro.getId());
            carro = (Carro) q.list().get(0);
        } catch (Exception e) {
            this.mensagem = "erro de leitura no BD";
        }
        return carro;
    }

    public List<Carro> PesquisarCarroFabricante(Carro carro) {
        this.mensagem = "";
        List<Carro> listaCarros = new ArrayList<>();
        try {
            Query q = session.createQuery("from Carro c where c.fabricante like :fabricante");
            q.setParameter("fabricante", carro.getFabricante() + "%");
            listaCarros = (List<Carro>) q.list();
        } catch (Exception e) {
            this.mensagem = "Erro de leitura no BD";
        }
        return listaCarros;
    }

    public List<Carro> PesquisarCarroModelo(Carro carro) {
        this.mensagem = "";
        List<Carro> listaCarros = new ArrayList<>();
        try {
            Query q = session.createQuery("from Carro c where c.modelo like :modelo");
            q.setParameter("modelo", carro.getModelo() + "%");
            listaCarros = (List<Carro>) q.list();
        } catch (Exception e) {
            this.mensagem = "Erro de leitura no BD";
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
