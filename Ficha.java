/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoavance;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Ficha {

    ArrayList ficha = new ArrayList<Cliente>();

    public void menu() {

        do {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 si quiere agregar una ficha"
                        + "\n" + "Digite 2 si quiere buscar una ficha"
                        + "\n" + "Digite 3 si quiere mostrar las fichas"
                        + "\n" + "Digite 4 si quiere eliminar una ficha"
                        + "\n" + "Digite 5 si quiere Salir"));

                switch (opcion) {
                    case 1:
                        String nombreCliente = JOptionPane.showInputDialog(null, "ingrese el Nombre del cliente");
                        String telefonoCliente = JOptionPane.showInputDialog(null, "ingrese el telefono del cliente");
                        String direccion = JOptionPane.showInputDialog(null, "ingrese la direccion del cliente");
                        String nombreMascota = JOptionPane.showInputDialog(null, "ingrese el nombre de la mascota");
                        String edadMascota = JOptionPane.showInputDialog(null, "ingrese la edad de la mascota");
                        String especie = JOptionPane.showInputDialog(null, "ingrese la especie de la mascota");
                        String raza = JOptionPane.showInputDialog(null, "ingrese la raza de la mascota");

                        agregarFicha(nombreCliente, telefonoCliente, direccion, nombreMascota, edadMascota, especie, raza);
                        break;
                    case 2:

                        String cliente = nombreCliente();
                        String mascota = nombreMascota();
                        if (buscarFicha(cliente, mascota) == true) {
                            fichaSeleccionada(cliente, mascota);
                        } else {
                            JOptionPane.showMessageDialog(null, "la ficha de cliente no a sido detectada");
                        }

                    case 3:

                        if (ficha.size() > 0) {
                            String mensaje = generarMensaje();

                            mostrarFicha(mensaje);
                        } else {
                            JOptionPane.showMessageDialog(null, "no ahi ninguna ficha disponible");
                        }

                        break;
                    case 4:
                        String clientes = nombreCliente();

                        String mascotas = nombreMascota();

                        remove(clientes, mascotas);
                        break;
                    case 5:
                        System.exit(1);

                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "ERROR!");

            }
        } while (true);

    }

    public void agregarFicha(String nombreCliente, String telefonoCliente, String direccion, String nombreMascota, String especie, String edadMascota, String raza) {// agrega una ficha en el arraylist
        Cliente aux = new Cliente(nombreCliente, telefonoCliente, direccion, nombreMascota, especie, edadMascota, raza);
        ficha.add(aux);

    }

    public void fichaSeleccionada(String cliente, String mascota) {//detecta la ficha seleccionada en buscar y envia de respuesta la ficha seleccionada

        for (int i = 0; i < ficha.size(); i++) {
            Cliente aux = (Cliente) ficha.get(i);
            if (aux.nombreCliente.equals(cliente) || aux.nombreMascota.equals(mascota)) {
                Cliente r = (Cliente) ficha.get(i);
                String mensaje1 = "";
                mensaje1 += "Nombre de cliente: " + r.nombreCliente + "   ";
                mensaje1 += "Telefono: " + r.telefonoCliente + "   ";
                mensaje1 += "Direccion: " + r.direccion + "   ";
                mensaje1 += "Nombre de mascota: " + r.nombreMascota + "  ";
                mensaje1 += "edad de mascota: " + r.edadMascota + " año ";
                mensaje1 += "especie= " + r.especie + "    ";
                mensaje1 += "raza: " + r.raza + "   ";

                JOptionPane.showMessageDialog(null, mensaje1);

            }
        }
    }

    private String generarMensaje() {//genera un mensaje  con los datos de la ficha
        String mensaje = "ficha de clientes" + "\n";

        for (int i = 0; i < ficha.size(); i++) {
            Cliente aux = (Cliente) ficha.get(i);
            mensaje += "Nombre de cliente: " + aux.nombreCliente + "   ";
            mensaje += "Telefono: " + aux.telefonoCliente + "   ";
            mensaje += "Direccion: " + aux.direccion + "   ";
            mensaje += "Nombre de mascota: " + aux.nombreMascota + "  ";
            mensaje += "edad de mascota: " + aux.edadMascota + " año ";
            mensaje += "especie= " + aux.especie + "    ";
            mensaje += "raza: " + aux.raza + "   ";

        }

        return mensaje;
    }

    public void mostrarFicha(String mensaje) {//muestra todas las fichas registradas
        JOptionPane.showMessageDialog(null, mensaje);

    }

    private int indice(String clientes, String mascotas) {//guarda la posicion del elemento buscado 
        int pos = 0;
        for (int i = 0; i < ficha.size(); i++) {

            Cliente aux = (Cliente) ficha.get(i);
            if (aux.nombreCliente.equals(clientes) || aux.nombreMascota.equals(mascotas)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public String nombreCliente() {//le asigna el nombre al cliente
        String cliente = JOptionPane.showInputDialog(null, "ingrese el nombre del cliente que desea buscar");
        return cliente;
    }

    public String nombreMascota() {//le asigna el nombre a la mascota
        String mascota = JOptionPane.showInputDialog(null, "ingrese el nombre de la mascota que desea buscar");
        return mascota;
    }

    public void remove(String clientes, String mascotas) {//llama al metodo buscarficha y elimina la ficha seleccioanda
        if (buscarFicha(clientes, mascotas) == true) {
            ficha.remove(indice(clientes, mascotas));
        }
    }

    private boolean buscarFicha(String cliente, String mascota) {//busca una ficha y devuelve una true o un false para saber si fue encontrado o no
        for (int i = 0; i < ficha.size(); i++) {
            Cliente aux = (Cliente) ficha.get(i);
            if (aux.nombreCliente.equals(cliente) || aux.nombreMascota.equals(mascota)) {
                return true;
            }
        }
        return false;
    }

}
