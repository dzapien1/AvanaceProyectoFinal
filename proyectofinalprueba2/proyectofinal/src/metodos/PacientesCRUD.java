package metodos;

import entidades.Paciente;

import java.io.*;
import java.util.ArrayList;

public class PacientesCRUD {

    public void agregarPaciente(Paciente p){
        //1) leer lista desde el archivo
        try{
            FileInputStream leer =
                    new FileInputStream("D:\\Programas JAVA\\ProyectoFinal\\basedatos\\pacientes.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            ArrayList<Paciente> lista = (ArrayList<Paciente>) o;

            //2) Agregar alumno a la lista
            lista.add(p);
            lectorObjetos.close();
            leer.close();

            //3) Escribir lista al archivo
            FileOutputStream escribir =
                    new FileOutputStream("D:\\Programas JAVA\\ProyectoFinal\\basedatos\\pacientes.txt");
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);
            escritorObjetos.flush();

            escritorObjetos.close();
            escribir.close();

        }catch(FileNotFoundException e){
            System.out.println("Error al leer el archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Paciente getInfoPacientePorCuenta(String cuenta){
        //leer el archivo y traerse la lista de alumnos
        FileInputStream leer;
        try {
             leer = new FileInputStream("D:\\Programas JAVA\\ProyectoFinal\\basedatos\\pacientes.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object miLista = miStream2.readObject();
            ArrayList<Paciente> listaPacientes = (ArrayList<Paciente>) miLista;
            Paciente k;
            for(int i=0; i<listaPacientes.size();i++)
            {
                k = listaPacientes.get(i);
                if(cuenta.equals(k.getCuenta()))
                {
                    leer.close();
                   return k;
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            leer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void actualizarPaciente(){

    }

    public void eliminarPaciente(){

    }
}