package br.com.terremoto;

import br.com.terremoto.controller.ControladorTerremoto;
import br.com.terremoto.model.Terremoto;
import br.com.terremoto.view.VisaoTerremoto;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ControladorTerremoto controlador = new ControladorTerremoto();
        VisaoTerremoto visao = new VisaoTerremoto();

        // Solicitar o país ao usuário
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do país para filtrar os terremotos:");
        String pais = scanner.nextLine();

        // Buscar dados dos terremotos filtrados pelo país
        List<Terremoto> terremotos = controlador.buscarDadosTerremotos(pais);

        // Exibir os terremotos no console
        visao.exibirTerremotos(terremotos);

        // Gerar o arquivo HTML do mapa
        String caminhoArquivo = "mapa_terremotos.html";
        controlador.gerarMapaHTML(terremotos, caminhoArquivo);

        // Abrir o arquivo HTML no navegador
        try {
            File arquivoHTML = new File(caminhoArquivo);
            java.awt.Desktop.getDesktop().browse(arquivoHTML.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

