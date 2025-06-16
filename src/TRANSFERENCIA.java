import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TRANSFERENCIA extends JDialog
{
   static private PLACA  Placa;
   static private DATA   DTtransferencia;
   static private CPF    Vendedor;
   static private CPF    Comprador;

   private final JLabel lblPlaca;
   private final JLabel lblTransferencia;
   private final JLabel lblVendedor;
   private final JLabel lblComprador;

   private final JTextField txtPlaca;
   private final JTextField txtTransferencia;
   private final JTextField txtVendedor;
   private final JTextField txtComprador;

   private final JButton btnSalvar;
   private final JButton btnCancelar;

   private boolean BotãoSalvar;
   private String  CPFretorno;

   public TRANSFERENCIA( JFrame owner , String placa , String vendedor )
   {
      super( owner , "Transferência" , true );
      setLayout( new GridLayout( 5 , 2 , 10 , 10 ) );
      BotãoSalvar = false;

      txtPlaca         = new JTextField(  7 );
      txtTransferencia = new JTextField( 10 );
      txtVendedor      = new JTextField( 14 );
      txtComprador     = new JTextField( 14 );

      lblPlaca         = new JLabel( "   Placa:"                 );
      lblTransferencia = new JLabel( "   Data da Transferencia:" );
      lblVendedor      = new JLabel( "   CPF do vendedor:"       );
      lblComprador     = new JLabel( "   CPF do comprador:"      );

      txtPlaca.setToolTipText(         "Placa do Veículo"                          );
      txtTransferencia.setToolTipText( "Digite a Data da Transferência do Veículo" );
      txtVendedor.setToolTipText(      "CPF do vendedor do Veículo"                );
      txtComprador.setToolTipText(     "Digite o CPF do comprador do Veículo"      );

      lblPlaca.setFont(         new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtPlaca.setFont(         new Font( "Arial" , Font.BOLD               , 16 ) );
      lblTransferencia.setFont( new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtTransferencia.setFont( new Font( "Arial" , Font.BOLD               , 16 ) );
      lblVendedor.setFont(      new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtVendedor.setFont(      new Font( "Arial" , Font.BOLD               , 16 ) );
      lblComprador.setFont(     new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtComprador.setFont(     new Font( "Arial" , Font.BOLD               , 16 ) );

      btnSalvar   = new JButton( "Salva"   );
      btnCancelar = new JButton( "Cancela" );

      add( lblPlaca         );       add( txtPlaca         );
      add( lblTransferencia );       add( txtTransferencia );
      add( lblVendedor      );       add( txtVendedor   );
      add( lblComprador     );       add( txtComprador  );

      add( btnSalvar        );       add( btnCancelar      );

      HdlrTransferencia   hdlrTransferencia   = new HdlrTransferencia();
      HdlrTransferenciaFc hdlrTransferenciaFc = new HdlrTransferenciaFc();
      HdlrComprador       hdlrComprador       = new HdlrComprador();
      HdlrCompradorFc     hdlrCompradorFc     = new HdlrCompradorFc();

      HdlrSalvar          hdlrSalvar          = new HdlrSalvar();
      HdlrCancelar        hdlrCancelar        = new HdlrCancelar();

      txtTransferencia.addActionListener( hdlrTransferencia   );
      txtTransferencia.addFocusListener(  hdlrTransferenciaFc );
      txtComprador.addActionListener(     hdlrComprador    );
      txtComprador.addFocusListener(      hdlrCompradorFc  );

      btnSalvar.addActionListener(        hdlrSalvar          );
      btnCancelar.addActionListener(      hdlrCancelar        );

      PLACA Placa = new PLACA( placa );
      txtPlaca.setText( Placa.toString() );
      CPF CPFvendedor = new CPF( vendedor );
      txtVendedor.setText( CPFvendedor.toString() );

      txtPlaca.setEditable(          false );
      txtPlaca.setFocusable(         false );
      txtTransferencia.setEditable(  true  );
      txtTransferencia.setFocusable( true  );
      txtVendedor.setEditable(       false );
      txtVendedor.setFocusable(      false );
      txtComprador.setEditable(      true  );
      txtComprador.setFocusable(     true  );

      btnSalvar.setVisible(          true  );
      btnCancelar.setVisible(        true  );
   }
   private class HdlrTransferencia implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         if ( validaTransferencia( txtTransferencia.getText() ) )
            txtComprador.requestFocus();
      }
   }
   private class HdlrTransferenciaFc implements FocusListener
   {
      @Override
      public void focusGained( FocusEvent event ) {
      }
      @Override
      public void focusLost( FocusEvent event )
      {
//         if ( validaTransferencia( txtTransferencia.getText() ) )
//            txtComprador.requestFocus();
      }
   }
   private boolean validaTransferencia( String transferencia )
   {
      if ( transferencia.length() == 0 ) {
         JOptionPane.showMessageDialog( TRANSFERENCIA.this ,
                 "Informe a Data da Transferência!" , "Formato DDMMAAAA" ,
                 JOptionPane.WARNING_MESSAGE );
         txtTransferencia.requestFocus();
         return false;
      }
      if ( !DATA.DATAéValida( transferencia ) ) {
         JOptionPane.showMessageDialog( TRANSFERENCIA.this , "Data inválida!" ,
                 "Formato DDMMAAAA" , JOptionPane.ERROR_MESSAGE );
         txtTransferencia.requestFocus();
         return false;
      }
      DATA DTtransferencia = new DATA( transferencia );
      txtTransferencia.setText( DTtransferencia.toString() );
      return true;
   }
   private class HdlrComprador implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         if ( validaComprador( txtComprador.getText() ) )
            txtTransferencia.requestFocus();
      }
   }
   private class HdlrCompradorFc implements FocusListener
   {
      @Override
      public void focusGained( FocusEvent event )
      {
         txtComprador.setText( CPF.limpaCPF( txtComprador.getText() ) );
      }
      @Override
      public void focusLost( FocusEvent event )
      {
//         if ( validaComprador( txtComprador.getText() ) )
//            txtTransferencia.requestFocus();
      }
   }
   private boolean validaComprador( String comprador )
   {
      if ( comprador.length() == 0 ) {
         JOptionPane.showMessageDialog( TRANSFERENCIA.this ,
                 "Informe o CPF do Comprador!" , "Até 11 dígitos" ,
                 JOptionPane.WARNING_MESSAGE );
         txtComprador.requestFocus();
         return false;
      }
      if ( !CPF.CPFéValido( comprador ) ) {
         JOptionPane.showMessageDialog( TRANSFERENCIA.this , "CPF inválido!" ,
                 "Até 11 dígitos" , JOptionPane.ERROR_MESSAGE );
         txtComprador.requestFocus();
         return false;
      }
      CPF Vendedor = new CPF( CPF.limpaCPF( txtVendedor.getText() ) );
      int cpfVendedor = Vendedor.getCPF();
      CPF Comprador = new CPF( comprador );
      int cpfComprador = Comprador.getCPF();
      if ( cpfComprador == cpfVendedor ) {
         JOptionPane.showMessageDialog( TRANSFERENCIA.this ,
                 "Comprador deve ser diferente do Vendedor!" , "Comrador inválido!" ,
                 JOptionPane.ERROR_MESSAGE );
         txtComprador.requestFocus();
         return false;
      }
      txtComprador.setText( Comprador.toString() );
      return true;
   }
   private class HdlrSalvar implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         String transferencia = txtTransferencia.getText();
         if ( !validaTransferencia( transferencia ) ) return;

         String comprador = CPF.limpaCPF( txtComprador.getText() );
         if ( !validaComprador( comprador ) ) return;

         String Plc = PLACA.limpaPlaca( txtPlaca.getText() );
         byte[] plc = Plc.getBytes();
         plc[4] += 17;
         String placa = new String( plc );
         transferencia = DATA.reverteDATA( transferencia );
         String vendedor = CPF.limpaCPF( txtVendedor.getText() );

         final String Url      = "jdbc:mysql://127.0.0.1:3306/detran";
         final String User     = "root";
         final String PassWord = "mysql";

         Connection Conexão = null;
         Statement  Comando = null;
         String Sql = "INSERT INTO transferencia ( Placa , DTtransferencia , Comprador , Vendedor ) VALUES ( '"
                    + placa + "' , '" + transferencia + "' , " + comprador + " , " + vendedor + " );";

         try {
            Conexão = DriverManager.getConnection( Url , User , PassWord );
            Comando = Conexão.createStatement();
            if ( Comando.executeUpdate( Sql ) != 1 ) {
               JOptionPane.showMessageDialog( TRANSFERENCIA.this ,
                       "Número inválido de registros inseridos!" ,
                       "Erro de Banco de Dados" , JOptionPane.ERROR_MESSAGE );
               return;
            }

         } catch( Exception erro ) {
            JOptionPane.showMessageDialog( TRANSFERENCIA.this ,
                    erro , "Erro de Banco de Dados" , JOptionPane.ERROR_MESSAGE );
            return;

         } finally {
            try {
               if( Comando != null ) Comando.close();
               if( Conexão != null ) Conexão.close();

            } catch( Exception erro ) {
               JOptionPane.showMessageDialog( TRANSFERENCIA.this ,
                       erro , "Erro de Banco de Dados" , JOptionPane.ERROR_MESSAGE );
               return;
            }
         }

         Sql = "UPDATE veiculo SET Proprietario = " + comprador + " WHERE Placa = '" + placa + "';";

         try {
            Conexão = DriverManager.getConnection( Url , User , PassWord );
            Comando = Conexão.createStatement();
            if ( Comando.executeUpdate( Sql ) != 1 ) {
               JOptionPane.showMessageDialog( TRANSFERENCIA.this ,
                       "Número inválido de registros inseridos!" ,
                       "Erro de Banco de Dados" , JOptionPane.ERROR_MESSAGE );
               return;
            }

         } catch( Exception erro ) {
            JOptionPane.showMessageDialog( TRANSFERENCIA.this ,
                    erro , "Erro de Banco de Dados" , JOptionPane.ERROR_MESSAGE );
            return;

         } finally {
            try {
               if( Comando != null ) Comando.close();
               if( Conexão != null ) Conexão.close();

            } catch( Exception erro ) {
               JOptionPane.showMessageDialog( TRANSFERENCIA.this ,
                       erro , "Erro de Banco de Dados" , JOptionPane.ERROR_MESSAGE );
               return;
            }
         }

         BotãoSalvar = true;
         CPF Comprador = new CPF( comprador );
         CPFretorno  = Comprador.toString();
         dispose();
      }
   }
   private class HdlrCancelar implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         dispose();
      }
   }
   public boolean getBotãoSalvar()
   {
      return BotãoSalvar;
   }
   public String getCPFretorno()
   {
      return CPFretorno;
   }
}
