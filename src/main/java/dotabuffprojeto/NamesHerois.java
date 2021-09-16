package dotabuffprojeto;

public class NamesHerois {
     private String nome;

     public NamesHerois(String allHerois) {
         setNome(allHerois);
     }


     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
