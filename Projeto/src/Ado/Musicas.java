package ado;

public final class Musicas {

    private String Nome;
    private String Artista;
    private float tempo;

    public Musicas(String Nome, String Artista,float Tempo) {
        this.setNome(Nome);
        this.setArtista(Artista);
        this.setTempo(Tempo);
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public String getNome() {
        return Nome;
    }

    public String getArtista() {
        return Artista;
    }

    public float getTempo() {
        return tempo;
    }

}
