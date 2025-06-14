import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class EMPLACAMENTO extends JDialog
{
   static private PLACA  Placa;
   static private DATA   DTemplacamento;

   private final JLabel lblPlaca;
   private final JLabel lblEmplacamento;

   private final JTextField txtPlaca;
   private final JTextField txtEmplacamento;

   private final JButton btnSalvar;
   private final JButton btnCancelar;

   private boolean BotãoSalvar;
   private String  PlcRetorno;
   private String  DTretorno;

   public EMPLACAMENTO( JFrame owner , String placa )
   {
      super( owner , "Emplacamento" , true );
      setLayout( new GridLayout( 3 , 2 , 10 , 10 ) );
      BotãoSalvar = false;

      txtPlaca        = new JTextField(  7 );
      txtEmplacamento = new JTextField( 10 );

      lblPlaca        = new JLabel( "   Placa:"                );
      lblEmplacamento = new JLabel( "   Data do Emplacamento:" );

      txtPlaca.setToolTipText(        "Placa do Veículo"                         );
      txtEmplacamento.setToolTipText( "Digite a Data do Emplacamento do Veículo" );

      lblPlaca.setFont(        new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtPlaca.setFont(        new Font( "Arial" , Font.BOLD               , 16 ) );
      lblEmplacamento.setFont( new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtEmplacamento.setFont( new Font( "Arial" , Font.BOLD               , 16 ) );

      btnSalvar   = new JButton( "Salva"   );
      btnCancelar = new JButton( "Cancela" );

      add( lblPlaca        );       add( txtPlaca        );
      add( lblEmplacamento );       add( txtEmplacamento );

      add( btnSalvar       );       add( btnCancelar     );

      HdlrEmplacamento   hdlrEmplacamento   = new HdlrEmplacamento();
      HdlrEmplacamentoFc hdlrEmplacamentoFc = new HdlrEmplacamentoFc();

      HdlrSalvar         hdlrSalvar         = new HdlrSalvar();
      HdlrCancelar       hdlrCancelar       = new HdlrCancelar();

      txtEmplacamento.addActionListener( hdlrEmplacamento   );
      txtEmplacamento.addFocusListener(  hdlrEmplacamentoFc );

      btnSalvar.addActionListener(       hdlrSalvar         );
      btnCancelar.addActionListener(     hdlrCancelar       );

      PLACA Placa = new PLACA( placa );
      txtPlaca.setText( Placa.toString() );

      txtPlaca.setEditable(   false );
      txtPlaca.setFocusable(  false );

      btnSalvar.setVisible(   true );
      btnCancelar.setVisible( true );
   }
   private class HdlrEmplacamento implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         validaEmplacamento( txtEmplacamento.getText() );
      }
   }
   private class HdlrEmplacamentoFc implements FocusListener
   {
      @Override
      public void focusGained( FocusEvent event ) {
      }
      @Override
      public void focusLost( FocusEvent event )
      {
//         validaEmplacamento( txtEmplacamento.getText() );
      }
   }
   private boolean validaEmplacamento( String emplacamento )
   {
      if ( emplacamento.length() == 0 ) {
         JOptionPane.showMessageDialog( EMPLACAMENTO.this ,
                 "Informe a Data do Emplacamento!" , "Formato DDMMAAAA" ,
                 JOptionPane.WARNING_MESSAGE );
         txtEmplacamento.requestFocus();
         return false;
      }
      if ( !DATA.DATAéValida( emplacamento ) ) {
         JOptionPane.showMessageDialog( EMPLACAMENTO.this , "Data inválida!" ,
                 "Formato DDMMAAAA" , JOptionPane.ERROR_MESSAGE );
         txtEmplacamento.requestFocus();
         return false;
      }
      DATA DTemplacamento = new DATA( emplacamento );
      txtEmplacamento.setText( DTemplacamento.toString() );
      return true;
   }
   private class HdlrSalvar implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         String emplacamento = txtEmplacamento.getText();
         if ( !validaEmplacamento( emplacamento ) ) return;

         String Plc = PLACA.limpaPlaca( txtPlaca.getText() );
         byte[] plc = Plc.getBytes();
         plc[4] += 17;
         String P = new String( plc );

         BotãoSalvar = true;
         PlcRetorno  = P;
         DTretorno   = emplacamento;
//-------------------------------------------------------------
//       Atualizar o Banco de Dados: UPDATE emplacamento
         JOptionPane.showMessageDialog( EMPLACAMENTO.this , "Emplacando Veículo..." ,
                 "Rotina de Emplacamento" , JOptionPane.INFORMATION_MESSAGE );
//-------------------------------------------------------------
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
   public String getPlcRetorno()
   {
      return PlcRetorno;
   }
   public String getDTretorno()
   {
      return DTretorno;
   }
}
