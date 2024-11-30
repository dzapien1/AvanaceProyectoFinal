import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame{
    private JPanel miPanel;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancelar;


    public login() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //hardcodear
                String password = String.valueOf(txtPassword.getPassword());
                if(txtUsuario.getText().equals("admin") && password.equals("1234") ){
                    //Bienvenida
                    dispose();
                    String[] tipoUsuario={"admin"};
                    ventanaPacientes.main(tipoUsuario);
                    //JOptionPane.showMessageDialog(miPanel,"Bienvenido admin");
                }else if(txtUsuario.getText().equals("usuario") && password.equals("4567")) {
                    //si es usuario
                    JOptionPane.showMessageDialog(miPanel,"Bienvenido usuario");

                }else{
                    //usuario o contraseña invalidas
                    JOptionPane.showMessageDialog(miPanel,"Usuario o contraseña incorectos","Login",JOptionPane.ERROR_MESSAGE);

                }
            }
        });
    }

    public static void main(String[] args) {
        login vLogin = new login();
        vLogin.setContentPane(vLogin.miPanel);
        vLogin.setSize(300,300);
        vLogin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vLogin.setVisible(true);

    }
}



