import entidades.Paciente;
import metodos.PacientesCRUD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaPacientes extends JFrame {
    private JPanel miPanel;
    private JTextField txtCuenta;
    private JTextField txtNombre;
    private JTextField txtApPaterno;
    private JTextField txtApMaterno;
    private JTextField txtEdad;
    private JButton btnBuscar;
    private JButton btnAgregar;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JComboBox comboBox1;

    public ventanaPacientes() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacientesCRUD crud = new PacientesCRUD();
                String cuenta = txtCuenta.getText();
                Paciente p = crud.getInfoPacientePorCuenta(cuenta);
                if(p == null){
                    int respuesta = JOptionPane.showConfirmDialog(miPanel,"No se encuentra información del paciente con cuenta " + cuenta + ". ¿Desea ingresarlo?","Pacientes",JOptionPane.YES_NO_OPTION);
                    if(respuesta == 0){
                        //sí quiere dar de alta el alumno inexistente
                        btnAgregar.setEnabled(true);
                        txtNombre.requestFocus();
                    }else if(respuesta == 1) {
                        //no quiere dar de alta
                        //limpiar formulario
                        //invocamos metodo para limpiar
                    }

                }
                else{
                    //se encontro el alumno
                    txtNombre.setText( p.getNombre() );
                    txtApPaterno.setText( p.getApellidoPat() );
                    txtApMaterno.setText(p.getApellidoMat());
                    txtEdad.setText( String.valueOf( p.getEdad() ) );
                    btnGuardar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                }
            }
        });
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //instanciar objeto de la clase Alumno
                Paciente miPaciente = new Paciente();
                miPaciente.setCuenta( txtCuenta.getText() );
                miPaciente.setNombre( txtNombre.getText() );
                miPaciente.setApellidoPat(txtApPaterno.getText());
                miPaciente.setApellidoMat(txtApMaterno.getText());
                miPaciente.setEdad( Integer.parseInt( txtEdad.getText() ) );

                //invocar metodo de agregarAlumno
                PacientesCRUD crud = new PacientesCRUD();
                crud.agregarPaciente(miPaciente);
            }
        });
    }

    public static void main(String[] args) {
        ventanaPacientes v = new ventanaPacientes();
        v.setContentPane(v.miPanel);
        v.setSize(500,500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}