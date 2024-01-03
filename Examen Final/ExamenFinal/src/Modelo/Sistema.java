package Modelo;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Excepciones.*;
import Persistencia.CandidatoPersistencia;
import Persistencia.CiudadanoPersistencia;
import Persistencia.SufragantePersistencia;
import Persistencia.VotosEspecialesPersistencia;
import Persistencia.ValidarEscrutinioPersistencia;

public class Sistema {
	private SufragantePersistencia sufragantePersistencia;
    private CiudadanoPersistencia ciudadanoPersistencia;
    private CandidatoPersistencia candidatoPersistencia;
    private VotosEspecialesPersistencia votosEspecialesPersistencia;
    private ValidarEscrutinioPersistencia validarEscrutinioPersistencia; 
    private List<Sufragante> padronVotantes;
    public List<Candidato> listaCandidatos;

    public Sistema() {
    	this.sufragantePersistencia = new SufragantePersistencia();
        this.ciudadanoPersistencia = new CiudadanoPersistencia();
        this.candidatoPersistencia = new CandidatoPersistencia();
        this.votosEspecialesPersistencia = new VotosEspecialesPersistencia();
        this.validarEscrutinioPersistencia = new ValidarEscrutinioPersistencia();
        this.padronVotantes = new ArrayList<>();
        this.listaCandidatos = new ArrayList<>();      
    }
    
    public String registrarVotante(Sufragante sufragante) {
        if (ciudadanoPersistencia.verificarDocumento(sufragante.getDU())) {       	
        	sufragantePersistencia.agregarSufragante(sufragante); // Agregar a la base de datos
            padronVotantes.add(sufragante); 
            return "Sufragante registrado exitosamente.";
        } else {       	
            return "Error: Ya hay un ciudadano registrado con ese número de documento.";
        }
    }

    public void registrarVotanteConsola() {
        Sufragante sufragante = Sufragante.registrarSufragante();
        if (sufragante != null) {
            if (ciudadanoPersistencia.verificarDocumento(sufragante.getDU())) {           	
            	padronVotantes.add(sufragante);
            	sufragantePersistencia.agregarSufragante(sufragante);
                System.out.println("Sufragante registrado exitosamente.");  
            } else {
            	System.out.println("Error: Ya hay un ciudadano registrado con ese número de documento.");           	             
            }
        }
    }
    
    public String registrarCandidato(Candidato candidato) {
        if (ciudadanoPersistencia.verificarDocumento(candidato.getDU())) {        	
        	candidatoPersistencia.agregarCandidato(candidato); // Agregar a la base de datos
            listaCandidatos.add(candidato); 
            return "Candidato registrado exitosamente."; 
        } else {
        	return "Error: Ya hay un ciudadano registrado con ese número de documento.";           
        }
    }
    
    public void registrarCandidatoConsola() {
    	Candidato candidato = Candidato.crearCandidato();
    	if (candidato != null) {
    	    if (ciudadanoPersistencia.verificarDocumento(candidato.getDU())) {
    	    	listaCandidatos.add(candidato);
    	        candidatoPersistencia.agregarCandidato(candidato);
    	        System.out.println("Candidato registrado exitosamente.");
    	    } else {
    	    	System.out.println("Error: Ya hay un ciudadano registrado con ese número de documento.");   	        
    	    }
    	} else {
    	}
    }
    
    public List<Sufragante> generarPadronVotantesOrdenado() {
        SufragantePersistencia sufragantePersistencia = new SufragantePersistencia();
        return sufragantePersistencia.obtenerTodosLosSufragantesOrdenados();
    }   
    
    public void imprimirPadronVotantesOrdenado() {
        List<Sufragante> padronOrdenado = generarPadronVotantesOrdenado();
        System.out.println("Padrón de sufragantes ordenado:");
        for (Sufragante votante : padronOrdenado) {
            System.out.println(votante.getApellido() + ", " + votante.getNombre() + " - " + votante.getEdad()+" años");
        }
    }
    
    public List<Candidato> generarListaCandidatosOrdenada() {
    	CandidatoPersistencia candidatoPersistencia = new CandidatoPersistencia();
    	return candidatoPersistencia.obtenerTodosLosCandidatosOrdenados();
    }
    
    public void imprimirListaCandidatosOrdenada() {
        List<Candidato> listaOrdenada = generarListaCandidatosOrdenada();
        System.out.println("Lista de candidatos ordenada: ");
        for (Candidato candidato : listaOrdenada) {
            System.out.println(candidato.getPartidoPolitico().getNombreCompleto() + ": " +
                               candidato.getApellido() + ", " + candidato.getNombre());
        }
    }
    
    public Sufragante buscarVotante(int dniVotante) {
        // Busca directamente en la base de datos
        Sufragante votante = sufragantePersistencia.buscarSufragantePorDni(dniVotante);
        
        // Si el votante es encontrado en la base de datos, lo devuelve
        // Si no, devuelve null
        return votante;
    }

    public Candidato buscarCandidatoPorDni(int dniCandidato) {
        // Busca directamente en la base de datos
        Candidato candidato = candidatoPersistencia.buscarPorDni(dniCandidato);
        // Si el candidato es encontrado en la base de datos, lo devuelve
        // Si no, devuelve null
        return candidato;
    }
    
    public void registrarVoto() throws ExcepcionVotanteNoEncontrado, ExcepcionVotanteReincidente {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese el DNI del votante: ");
            int dniVotante = scanner.nextInt();
            
            // Verificar si el DNI pertenece a un candidato
            Candidato candidato = buscarCandidatoPorDni(dniVotante);
            if (candidato != null) {
                throw ExcepcionVotanteNoEncontrado.votanteEsCandidato();
            }

            // Si no es un candidato, buscarlo como votante
            Sufragante votante = buscarVotante(dniVotante);
            if (votante == null) {
                throw ExcepcionVotanteNoEncontrado.votanteNoRegistrado();
            }

            // Si el sufragante ya emitió su voto            
            if (votante.haEmitidoVoto()) {
                throw ExcepcionVotanteReincidente.votoEmitido();                            
            }
            
            listaCandidatos = candidatoPersistencia.obtenerTodosLosCandidatosOrdenados();
            List<Candidato> candidatosOrdenados = new ArrayList<>(listaCandidatos);
            Collections.sort(candidatosOrdenados, Candidato.comparadorPorPartidoApellidoNombre());

            System.out.println("Ingrese la opción de voto: ");
            System.out.println("0. Votar en blanco");
            System.out.println("1. Impugnar voto");
            for (int i = 0; i < candidatosOrdenados.size(); i++) {
                Candidato c = candidatosOrdenados.get(i);
                System.out.println((i + 2) + ". " + c.getPartidoPolitico() + ": " + c.getApellido() + ", " + c.getNombre());
            }
            
            int opcionCandidato = scanner.nextInt();
            
            // Opción 0: Votar en blanco
            if (opcionCandidato == 0) {
                // Incrementar y registrar voto en blanco
                sufragantePersistencia.actualizarVotoEmitido(votante.getDU(), true);
                votosEspecialesPersistencia.incrementarVotosEnBlanco(); // Actualizar en la base de datos
                System.out.println("Voto en blanco registrado correctamente.");
                return;
            }

            // Opción 1: Impugnar el voto
            if (opcionCandidato == 1) {
                // Incrementar y registrar voto impugnado
                sufragantePersistencia.actualizarVotoEmitido(votante.getDU(), true);
                votosEspecialesPersistencia.incrementarVotosImpugnados(); // Actualizar en la base de datos
                System.out.println("Voto impugnado correctamente.");
                return;
            }
            
            // Opciones de voto para candidatos
            if (opcionCandidato >= 2 && opcionCandidato < (2 + candidatosOrdenados.size())) {
                Candidato candidatoSeleccionado = candidatosOrdenados.get(opcionCandidato - 2);
                // Verificar si candidatoSeleccionado es nulo
                if (candidatoSeleccionado == null) {
                    System.out.println("Error al seleccionar el candidato.");
                    return;
                }

                // Incrementar el contador de votos para el candidato seleccionado y actualizar en BD
                candidatoSeleccionado.incrementarCantidadVotos();
                candidatoPersistencia.actualizarCantidadVotos(candidatoSeleccionado.getDU()); // Actualizar en la base de datos

                // Marcar al votante como que ya ha votado y registrar el voto
                sufragantePersistencia.actualizarVotoEmitido(votante.getDU(), true);
                System.out.println("Voto registrado correctamente para " + candidatoSeleccionado.getNombre() + " " + 
                candidatoSeleccionado.getApellido() + " de " + candidatoSeleccionado.getPartidoPolitico());
            } else {
                System.out.println("Error: Opción no válida.");
            }
        
        } catch (ExcepcionVotanteNoEncontrado e) {
            System.out.println(e.getMessage());
        } catch (ExcepcionVotanteReincidente e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida.");
            scanner.nextLine();
        } finally {
            
        }
    }
  
    public void escrutinioProvisorio() {   	
    	
        // Ordenar candidatos por PartidoPolitico, apellido y nombre
    	listaCandidatos = candidatoPersistencia.obtenerTodosLosCandidatosOrdenados();

        // Mostrar el listado de candidatos con la cantidad de votos recibidos
        System.out.println("Escrutinio Provisorio:");
        for (Candidato candidato : listaCandidatos) {
            System.out.println(candidato.getPartidoPolitico() + ": " + candidato.getApellido()
            + " " + candidato.getNombre() +  " - Votos recibidos: " + candidato.getCantidadVotos());
        }

        // Mostrar la cantidad de votos en blanco y votos impugnados
        System.out.println("Votos en Blanco: " + votosEspecialesPersistencia.obtenerCantidadVotosEnBlanco());
        System.out.println("Votos Impugnados: " + votosEspecialesPersistencia.obtenerCantidadVotosImpugnados());
        
    }
    
    public boolean validarEscrutinio() {

        // Utilizar el nuevo método para validar el total de votos
        boolean esValido = validarEscrutinioPersistencia.validarTotalVotos();

        if (!esValido) {
            System.out.println("Hay una discrepancia en los votos emitidos.");
            return false;
        }
        
        int totalSufragantesQueVotaron = new SufragantePersistencia().contarSufragantesQueVotaron();
        int totalVotosEscrutados = new CandidatoPersistencia().sumarTotalVotos() 
        + new VotosEspecialesPersistencia().obtenerTotalVotosEspeciales();

        validarEscrutinioPersistencia.actualizarSufragantesQueVotaron();
        System.out.println("Cantidad de sufragantes que emitieron su voto: " + totalSufragantesQueVotaron);
        validarEscrutinioPersistencia.actualizarVotosEscrutados();
        System.out.println("Cantidad total de votos escrutados: " + totalVotosEscrutados);       
        System.out.println("La validación del escrutinio ha sido exitosa.");
        return true;
    }
    
    private List<Candidato> calcularTernaGanadores() {
        // Ordenar la lista de candidatos por cantidad de votos (de mayor a menor)
    	listaCandidatos = candidatoPersistencia.obtenerTodosLosCandidatosOrdenados();
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

        // Convertir el mapa a una lista de entradas y ordenarla
        List<Map.Entry<PartidoPolitico, Integer>> listaOrdenada = new ArrayList<>(votosPorPartido.entrySet());
        listaOrdenada.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Mostrar la cantidad de votos totales por partido, ordenados de mayor a menor
        System.out.println("Votos Totales por Partido:");
        for (Map.Entry<PartidoPolitico, Integer> entry : listaOrdenada) {
            System.out.println(entry.getKey().getNombreCompleto() + ": " + entry.getValue() + " votos");
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
}