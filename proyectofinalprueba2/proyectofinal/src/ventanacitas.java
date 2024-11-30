import entidades.Paciente;
import metodos.PacientesCRUD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ventanacitas extends JFrame {
    private JPanel miPanel;
    private JComboBox cmbPaciente;
    private JComboBox cmbDoctor;
    private JTextField txtFecha;
    private JTextArea txtObserv;
    private JButton btnIngresar;
    private JButton button2;
    private JButton button3;
    private JTextField txtPaciente;
    private JComboBox cmbDia;
    private JComboBox cmbMes;
    private JComboBox cmbAnio;
    ArrayList<Paciente> lista;

    public boolean validaFecha(String fecha){
        SimpleDateFormat formatoFecha =
                new SimpleDateFormat("dd/MM/yyyy");
        try {
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }


    }


    //método constructor
    public ventanacitas(){
        //conectarme al archivo y extraer la lista
        try {
            FileInputStream leer =
                    new FileInputStream("D:\\Programas JAVA\\ProyectoFinal\\basedatos\\pacientes.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            lista = (ArrayList<Paciente>) o;

            for(Paciente p: lista)
            {
                cmbPaciente.addItem(  p.getCuenta() ) ;
                lectorObjetos.close();
                leer.close();}

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cmbPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacientesCRUD crud=new PacientesCRUD();
                String cue = cmbPaciente.getSelectedItem().toString();
                String nombreCompleto;
                Paciente p = crud.getInfoPacientePorCuenta(cue);
                nombreCompleto = p.getNombre() + " " + p.getApellidoPat();
                txtPaciente.setText(nombreCompleto);
            }
        });
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = cmbDia.getSelectedItem().toString() + "/" + cmbMes.getSelectedItem().toString() + "/" + cmbAnio.getSelectedItem().toString() ;

                boolean resultado = validaFecha(fecha);
                if(resultado)
                {
                    JOptionPane.showMessageDialog(miPanel,"todo ok con la fecha");
                }
                else {
                    JOptionPane.showMessageDialog(miPanel,"Error en la fecha");
                }
            }
        });
    }

    public static void main(String[] args) {
        ventanacitas t = new ventanacitas();
        t.setContentPane(t.miPanel);
        t.setSize(500,500);
        t.setTitle("Tutorías");
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setVisible(true);

    }

}