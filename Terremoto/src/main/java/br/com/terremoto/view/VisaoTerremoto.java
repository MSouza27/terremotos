package br.com.terremoto.view;

import br.com.terremoto.model.Terremoto;
import java.util.List;

public class VisaoTerremoto {
    public void exibirTerremotos(List<Terremoto> terremotos) {
        if (terremotos.isEmpty()) {
            System.out.println("Nenhum terremoto encontrado");
        } else {
            for (Terremoto terremoto : terremotos) {
                System.out.println(terremoto);
            }
        }
    }
}
