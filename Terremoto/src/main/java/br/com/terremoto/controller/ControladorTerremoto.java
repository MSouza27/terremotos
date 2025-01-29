package br.com.terremoto.controller;

import br.com.terremoto.model.Terremoto;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ControladorTerremoto {

    public List<Terremoto> buscarDadosTerremotos(String paisFiltro) {
        List<Terremoto> terremotos = new ArrayList<>();
        try {
            String url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";
            HttpURLConnection conexao = (HttpURLConnection) new URL(url).openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String linha;
            StringBuilder conteudo = new StringBuilder();
            while ((linha = leitor.readLine()) != null) {
                conteudo.append(linha);
            }
            leitor.close();
            conexao.disconnect();

            JSONObject respostaJson = new JSONObject(conteudo.toString());
            JSONArray eventos = respostaJson.getJSONArray("features");

            for (int i = 0; i < eventos.length(); i++) {
                JSONObject evento = eventos.getJSONObject(i);
                JSONObject propriedades = evento.getJSONObject("properties");
                JSONObject geometria = evento.getJSONObject("geometry");
                JSONArray coordenadas = geometria.getJSONArray("coordinates");

                String local = propriedades.getString("place");
                double magnitude = propriedades.getDouble("mag");
                long tempo = propriedades.getLong("time");
                double longitude = coordenadas.getDouble(0);
                double latitude = coordenadas.getDouble(1);

                if (paisFiltro.isEmpty() || local.toLowerCase().contains(paisFiltro.toLowerCase())) {
                    terremotos.add(new Terremoto(local, magnitude, new Date(tempo), latitude, longitude));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terremotos;
    }

    public void gerarMapaHTML(List<Terremoto> terremotos, String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html>\n<head>\n");
            writer.write("    <title>Mapa de Terremotos</title>\n");
            writer.write("    <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.7.1/dist/leaflet.css\" />\n");
            writer.write("    <script src=\"https://unpkg.com/leaflet@1.7.1/dist/leaflet.js\"></script>\n");
            writer.write("    <style>#map { height: 600px; }</style>\n");
            writer.write("</head>\n<body>\n");
            writer.write("    <div id=\"map\"></div>\n");
            writer.write("    <script>\n");
            writer.write("        var map = L.map('map').setView([0, 0], 2);\n");
            writer.write("        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', { attribution: '&copy; OpenStreetMap contributors' }).addTo(map);\n");
            writer.write("        var terremotos = [\n");
            for (Terremoto terremoto : terremotos) {
                writer.write("            { lat: " + terremoto.getLatitude() + ", lng: " + terremoto.getLongitude() + ", local: '" + terremoto.getLocal() + "', magnitude: " + terremoto.getMagnitude() + " },\n");
            }
            writer.write("        ];\n");
            writer.write("        terremotos.forEach(function(t) {\n");
            writer.write("            L.marker([t.lat, t.lng]).bindPopup('<b>' + t.local + '</b><br>Magnitude: ' + t.magnitude).addTo(map);\n");
            writer.write("        });\n");
            writer.write("    </script>\n</body>\n</html>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do país para filtrar os terremotos (ou deixe em branco para todos): ");
        String paisFiltro = scanner.nextLine();

        ControladorTerremoto controlador = new ControladorTerremoto();
        List<Terremoto> terremotos = controlador.buscarDadosTerremotos(paisFiltro);

        if (terremotos.isEmpty()) {
            System.out.println("Nenhum terremoto encontrado para o país: " + paisFiltro);
        } else {
            System.out.println("Foram encontrados " + terremotos.size() + " terremotos.");
            String caminhoArquivo = "mapa_terremotos.html";
            controlador.gerarMapaHTML(terremotos, caminhoArquivo);
            try {
                java.awt.Desktop.getDesktop().browse(new java.io.File(caminhoArquivo).toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}


