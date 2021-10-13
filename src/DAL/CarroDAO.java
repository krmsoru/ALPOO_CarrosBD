package DAL;

import Modelo.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO
{

    private String mensagem;
    Conexao conexao = new Conexao();

    public void CadastrarCarro(Carro carro)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            if (conexao.getMensagem().equals(""))
            {
                String comSql = "Insert into Carros (fabricante, modelo, cor, ano_fabricacao, valor)"
                        + "values(?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(comSql);
                stmt.setString(1, carro.getFabricante());
                stmt.setString(2, carro.getModelo());
                stmt.setString(3, carro.getCor());
                stmt.setInt(4, carro.getAnoFabricao());
                stmt.setDouble(5, carro.getValor());
                stmt.execute();
                conexao.desconectar();
                this.mensagem = "Veículo cadastrado com sucesso!";
            }
            else
            {
                this.mensagem = conexao.getMensagem();
            }
        }
        catch (Exception e)
        {
//            this.mensagem = e.getMessage();
            this.mensagem = "Erro de gravação no BD";
        }
    }

    public void EditarCarro(Carro carro)
    {

        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            if (conexao.getMensagem().equals(""))
            {
                String comSql = "Update Carros "
                        + "set fabricante = ?, "
                        + "modelo = ?, "
                        + "cor = ?, "
                        + "ano_fabricacao = ?, "
                        + "valor = ? "
                        + "where id = ?";
                PreparedStatement stmt = con.prepareStatement(comSql);
                stmt.setString(1, carro.getFabricante());
                stmt.setString(2, carro.getModelo());
                stmt.setString(3, carro.getCor());
                stmt.setInt(4, carro.getAnoFabricao());
                stmt.setDouble(5, carro.getValor());
                stmt.setInt(6, carro.getID());
                stmt.execute();
                conexao.desconectar();
                this.mensagem = "Veículo editado com sucesso!";
            }
            else
            {
                this.mensagem = conexao.getMensagem();
            }
        }
        catch (Exception e)
        {
//            this.mensagem = e.getMessage();
            System.out.println(e);
            this.mensagem = "Erro de gravação no BD";
        }
    }

    public void ExcluirCarro(Carro carro)
    {
        this.mensagem = "";
        try
        {
            carro = this.PesquisarCarroID(carro);
            if (carro.getFabricante() == null || carro.getFabricante().equals(""))
            {
                this.mensagem = "Não existe este veículo nos registros.";
            }
            else
            {
                Connection con = conexao.conectar();
                if (conexao.getMensagem().equals(""))
                {
                    String comSql = "delete from Carros where id = ?";
                    PreparedStatement stmt = con.prepareStatement(comSql);
                    stmt.setInt(1, carro.getID());
                    stmt.execute();
                    conexao.desconectar();
                    this.mensagem = "Veículo excluido com sucesso!";

                }
                else
                {
                    this.mensagem = conexao.getMensagem();
                }
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
//            this.mensagem = e.getMessage();
            this.mensagem = "Erro de gravação no BD";
        }
    }

    public Carro PesquisarCarroID(Carro carro)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            if (conexao.getMensagem().equals(""))
            {
                String comSql = "select * from Carros where id = ?";
                PreparedStatement stmt = con.prepareStatement(comSql);
                stmt.setInt(1, carro.getID());
                ResultSet resultSet = stmt.executeQuery();                      
                if (resultSet.next())                                           
                {
                    carro.setFabricante(resultSet.getString("fabricante"));
                    carro.setModelo(resultSet.getString("modelo"));
                    carro.setCor(resultSet.getString("cor"));
                    carro.setAnoFabricao(resultSet.getInt("ano_fabricacao"));
                    carro.setValor(resultSet.getFloat("valor"));
                }
                else
                {
                    this.mensagem = "Não existe este ID nos registros.";
                }
                conexao.desconectar();
            }
            else
            {
                this.mensagem = conexao.getMensagem();
            }

        }
        catch (Exception e)
        {
            this.mensagem = "erro de leitura no BD";                            
            //this.mensagem = e.getMessage();                                   
        }
        return carro;
    }

    public List<Carro> PesquisarCarroFabricante(Carro carro)
    {
        this.mensagem = "";
        List<Carro> listaCarros = new ArrayList<>();
        try
        {
            Connection con = conexao.conectar();
            if (conexao.getMensagem().equals(""))
            {
                String comSql = "select * from carros where fabricante like ?";
                PreparedStatement stmt = con.prepareStatement(comSql);
                stmt.setString(1, carro.getFabricante() + "%");
                ResultSet resultset = stmt.executeQuery();
                while (resultset.next())
                {
                    Carro carroLista = new Carro();
                    carroLista.setID(resultset.getInt("id"));
                    carroLista.setFabricante(resultset.getString("fabricante"));
                    carroLista.setModelo(resultset.getString("modelo"));
                    carroLista.setCor(resultset.getString("cor"));
                    carroLista.setAnoFabricao(resultset.getInt("ano_fabricacao"));
                    carroLista.setValor(resultset.getFloat("valor"));
                    listaCarros.add(carroLista);
                }
                conexao.desconectar();           
            }
            else
            {
                this.mensagem = conexao.getMensagem();
            }
        }
        catch (Exception e)
        {
//            this.mensagem = e.getMessage();
            this.mensagem = "Erro de leitura no BD";
        }
        return listaCarros;
    }

    public List<Carro> PesquisarCarroModelo(Carro carro)
    {
        this.mensagem = "";
        List<Carro> listaCarros = new ArrayList<>();
        try
        {
            Connection con = conexao.conectar();
            if (conexao.getMensagem().equals(""))
            {
                String comSql = "select * from carros where modelo like ?";
                PreparedStatement stmt = con.prepareStatement(comSql);
                stmt.setString(1, carro.getModelo() + "%");
                ResultSet resultset = stmt.executeQuery();
                
                while (resultset.next())
                {
                    Carro cl = new Carro();
                    cl.setID(resultset.getInt("id"));
                    cl.setFabricante(resultset.getString("fabricante"));
                    cl.setModelo(resultset.getString("modelo"));
                    cl.setCor(resultset.getString("cor"));
                    cl.setAnoFabricao(resultset.getInt("ano_fabricacao"));
                    cl.setValor(resultset.getFloat("valor"));
                    listaCarros.add(cl);
                }
                
                conexao.desconectar();
            }
            else
            {
                this.mensagem = conexao.getMensagem();
            }
        }
        catch (Exception e)
        {
//            this.mensagem = e.getMessage();
            this.mensagem = "Erro de leitura no BD";
        }
        return listaCarros;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }

}
