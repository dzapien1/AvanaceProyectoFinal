import entidades.Paciente;
import metodos.PacientesCRUD;

public class prueba {

    public static void main(String[] args) {
        PacientesCRUD pacCRUD = new PacientesCRUD();
        Paciente resultado = pacCRUD.getInfoPacientePorCuenta("0000");
        if(resultado==null)
        {
            System.out.println("No se encuentra esa cuenta");
        }else{
            System.out.println(resultado.getNombre());
            System.out.println(resultado.getApellidoPat());
            System.out.println(resultado.getEdad());
        }

    }
}