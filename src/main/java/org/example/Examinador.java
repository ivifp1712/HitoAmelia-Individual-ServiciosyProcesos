package org.example;

import java.util.ArrayList;

public class Examinador implements Runnable {
    private Thread hilo;
    BufferExamenes buffer;

    public Thread getHilo() {
        return hilo;
    }

    public Examinador(String alumno, BufferExamenes generador) {
        this.hilo = new Thread(this, alumno);
        this.buffer = generador;
        hilo.start();

    }

    @Override
    public void run() {
        String codigoExamen = this.buffer.consumirExamen();
        if (codigoExamen != null) {
            ArrayList<String> respuestas = new ArrayList<>();
            respuestas.add("A");
            respuestas.add("B");
            respuestas.add("C");
            respuestas.add("D");
            respuestas.add("-");
            for (int i = 1; i < 11; i++) {
                System.out.println(codigoExamen +";"+this.hilo.getName()+";Pregunta "+i+";"+respuestas.get((int) (Math.random() * 5)));
            }
        }
        else {
            System.out.println("Agotado tiempo de espera y " +
                    "no hay más exámenes");
        }
    }
}
