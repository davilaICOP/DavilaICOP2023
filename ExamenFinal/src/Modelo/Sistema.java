package Modelo;

import Excepciones.ExcepcionVotanteNoEncontrado;
import Excepciones.ExcepcionVotanteReincidente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema {
    private List<Sufragante> padronVotantes;
    private List<Candidato> listaCandidatos;
    private int votosEmitidos;
    private int votosEnBlanco;
    private int votosImpugnados;

    public Sistema() {
        this.padronVotantes = new ArrayList<>();
        this.listaCandidatos = new ArrayList<>();
        this.votosEmitidos = 0;
        this.votosEnBlanco = 0;
        this.votosImpugnados = 0;
    }

    public void registrarVotante(Sufragante votante) throws ExcepcionVotanteReincidente {
        if (padronVotantes.contains(votante)) {
            throw new ExcepcionVotanteReincidente("El sufragante ya ha emitido su voto.");
        }
        padronVotantes.add(votante);
    }

    public void registrarCandidato(Candidato candidato) {
        listaCandidatos.add(candidato);
    }

    public List<Sufragante> generarPadronVotantesOrdenado() {
        List<Sufragante> padronOrdenado = new ArrayList<>(padronVotantes);
        Collections.sort(padronOrdenado, Ciudadano.comparadorPorApellidoNombreEdad);
        return padronOrdenado;
    }

    public List<Candidato> generarListaCandidatosOrdenada() {
        // Crear un mapa para agrupar candidatos por partido político
        Map<PartidoPolitico, List<Candidato>> candidatosPorPartido = new HashMap<>();

        // Agrupar candidatos por partido político
        for (Candidato candidato : listaCandidatos) {
            candidatosPorPartido
                    .computeIfAbsent(candidato.getPartidoPolitico(), k -> new ArrayList<>())
                    .add(candidato);
        }

        // Ordenar la lista de candidatos por partido político
        List<Candidato> listaOrdenada = new ArrayList<>();
        for (PartidoPolitico partido : PartidoPolitico.values()) {
            List<Candidato> candidatosDelPartido = candidatosPorPartido.get(partido);
            if (candidatosDelPartido != null) {
                // Ordenar los candidatos del partido por algún criterio (puedes ajustar según tus necesidades)
                candidatosDelPartido.sort(Comparator.comparing(Candidato::getApellido));
                listaOrdenada.addAll(candidatosDelPartido);
            }
        }

        return listaOrdenada;
    }
    
    public Sufragante buscarVotante(String dniVotante) {
        for (Sufragante votante : padronVotantes) {
            if (votante.getDU().equals(dniVotante)) {
                return votante;
            }
        }
        return null; // Devuelve null si el votante no está en el padrón
    }

    public Candidato buscarCandidatoPorDni(String dniCandidato) {
        for (Candidato candidato : listaCandidatos) {
            if (candidato.getDU().equals(dniCandidato)) {
                return candidato;
            }
        }
        return null; // Devuelve null si el candidato no está en la lista
    }

    
    public void votarEnBlanco(String dniVotante) throws ExcepcionVotanteNoEncontrado, ExcepcionVotanteReincidente {
        Sufragante votante = buscarVotante(dniVotante);
        if (votante == null) {
            throw new ExcepcionVotanteNoEncontrado("Votante no encontrado.");
        }
        if (votante.haEmitidoVoto()) {
            throw new ExcepcionVotanteReincidente("El votante ya ha emitido su voto.");
        }

        // Marcar al votante como que ha votado
        votante.setEmitioVoto(true);
        votosEnBlanco++;

    }

    public void impugnarVoto(String dniVotante) throws ExcepcionVotanteNoEncontrado, ExcepcionVotanteReincidente {
        Sufragante votante = buscarVotante(dniVotante);
        if (votante == null) {
            throw new ExcepcionVotanteNoEncontrado("Votante no encontrado.");
        }
        if (votante.haEmitidoVoto()) {
            throw new ExcepcionVotanteReincidente("El votante ya ha emitido su voto.");
        }

        // Marcar al votante como que ha votado y su voto ha sido impugnado
        votante.setEmitioVoto(true);
        votante.setVotoImpugnado(true);
        votosImpugnados++;

    }


    public void votar(String dniVotante, String dniCandidato) throws ExcepcionVotanteNoEncontrado, ExcepcionVotanteReincidente {
        Sufragante votante = buscarVotante(dniVotante);
        if (votante == null) {
            throw new ExcepcionVotanteNoEncontrado("Votante no encontrado.");
        }
        if (votante.haEmitidoVoto()) {
            throw new ExcepcionVotanteReincidente("El votante ya ha emitido su voto.");
        }

        Candidato candidato = buscarCandidatoPorDni(dniCandidato);
        if (candidato != null) {
            if (candidato.getDU().equals(dniVotante)) {
                throw new ExcepcionVotanteReincidente("El votante ya es candidato y no puede votarse a sí mismo.");
            }
            candidato.incrementarCantidadVotos();
            votante.setEmitioVoto(true);
            votosEmitidos++; // Incrementar la cantidad de votos emitidos            
        } else {
            throw new ExcepcionVotanteNoEncontrado("Candidato no encontrado.");
        }
    }

    public void escrutinioProvisorio() {
        // Mostrar el listado de candidatos con la cantidad de votos recibidos
        System.out.println("Escrutinio Provisorio:");
        for (Candidato candidato : listaCandidatos) {
            System.out.println("Candidato: " + candidato.getNombre() + " " + candidato.getApellido() +
                    " - Votos recibidos: " + candidato.getCantidadVotos());
        }

        // Mostrar la cantidad de votos en blanco y votos impugnados
        System.out.println("Votos en Blanco: " + votosEnBlanco);
        System.out.println("Votos Impugnados: " + votosImpugnados);
    }
    
    public void validarEscrutinio() {
        int votosTotales = votosEmitidos + votosEnBlanco + votosImpugnados;
        int sufragantesRegistrados = padronVotantes.size();

        if (votosTotales != sufragantesRegistrados) {
            throw new RuntimeException("Error en el escrutinio: la cantidad de votos emitidos no coincide con la sumatoria de votos escrutados.");
        }
    }
    
    public void emitirEscrutinioDefinitivoYTernaGanadores() {

        // Calcular la terna de ganadores
        List<Candidato> ternaGanadores = calcularTernaGanadores();

        // Mostrar la terna de ganadores
        System.out.println("Terna de Ganadores:");
        for (int i = 0; i < Math.min(ternaGanadores.size(), 3); i++) {
            Candidato candidato = ternaGanadores.get(i);
            System.out.println((i + 1) + ". " + candidato.getNombre() + " " + candidato.getApellido() +
                    " - Votos recibidos: " + candidato.getCantidadVotos());
        }

        // Mostrar la cantidad de votos totales por partido
        mostrarVotosTotalesPorPartido();
    }
    
    private List<Candidato> calcularTernaGanadores() {
        // Ordenar la lista de candidatos por cantidad de votos (de mayor a menor)
        List<Candidato> listaOrdenada = new ArrayList<>(listaCandidatos);
        listaOrdenada.sort(Collections.reverseOrder(Comparator.comparingInt(Candidato::getCantidadVotos)));

        // Tomar los primeros tres candidatos (la terna)
        return listaOrdenada.subList(0, Math.min(listaOrdenada.size(), 3));
    }
    
    private void mostrarVotosTotalesPorPartido() {
        Map<PartidoPolitico, Integer> votosPorPartido = new HashMap<>();

        // Calcular la cantidad total de votos por partido
        for (Candidato candidato : listaCandidatos) {
            PartidoPolitico partido = candidato.getPartidoPolitico();
            votosPorPartido.put(partido, votosPorPartido.getOrDefault(partido, 0) + candidato.getCantidadVotos());
        }

        // Mostrar la cantidad de votos totales por partido
        System.out.println("Votos Totales por Partido:");
        for (Map.Entry<PartidoPolitico, Integer> entry : votosPorPartido.entrySet()) {
            System.out.println(entry.getKey().getNombreCompleto() + ": " + entry.getValue() + " votos");
        }
    }

}
