import entidades.Paciente;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();

            Paciente p1 = new Paciente();
            p1.setCuenta("0000");
            p1.setNombre("Pedro");
            p1.setApellidoPat("Jimenez");
            p1.setApellidoMat("Perez");
            p1.setEdad(19);

            Paciente p2 = new Paciente();
            p2.setCuenta("0001");
            p2.setNombre("Ana");
            p2.setApellidoPat("Gutierrez");
            p2.setApellidoMat("Sanchez");
            p2.setEdad(18);

            Paciente p3 = new Paciente();
            p3.setCuenta("0002");
            p3.setNombre("Juan");
            p3.setApellidoPat("Lopez");
            p3.setApellidoMat("Pedroza");
            p3.setEdad(21);

            listaPacientes.add(p1);
            listaPacientes.add(p2);
            listaPacientes.add(p3);

            FileOutputStream escribir = new FileOutputStream("D:\\Programas JAVA\\ProyectoFinal\\basedatos\\pacientes.txt");
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(listaPacientes);
            miStream.flush();
            miStream.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}