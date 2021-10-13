package Modelo;

public class Carro
{
    
    private int ID;
    private String Fabricante;
    private String Modelo;
    private String Cor;
    private int AnoFabricao;
    private float Valor;

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getFabricante()
    {
        return Fabricante;
    }

    public void setFabricante(String fabricante)
    {
        this.Fabricante = fabricante;
    }

    public String getModelo()
    {
        
        return Modelo;
    }

    public void setModelo(String modelo)
    {
        this.Modelo = modelo;
    }

    public String getCor()
    {
        return Cor;
    }

    public void setCor(String cor)
    {
        this.Cor = cor;
    }

    public int getAnoFabricao()
    {
        return AnoFabricao;
    }

    public void setAnoFabricao(int anoFabricao)
    {
        this.AnoFabricao = anoFabricao;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }



    
    
    
    
}
