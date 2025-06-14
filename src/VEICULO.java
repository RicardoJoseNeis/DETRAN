import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class VEICULO extends JFrame
{
   static private PLACA  Placa;
   static private DATA   DTemplacamento;
   static private String Marca;
   static private String Modelo;
   static private short  Ano;
   static private String Cor;
   static private CPF    Proprietario;

   private final JLabel lblPlaca;
   private final JLabel lblEmplacamento;
   private final JLabel lblMarca;
   private final JLabel lblModelo;
   private final JLabel lblAno;
   private final JLabel lblCor;
   private final JLabel lblProprietario;

   private final JTextField txtPlaca;
   private final JTextField txtEmplacamento;
   private final JTextField txtMarca;
   private final JTextField txtModelo;
   private final JTextField txtAno;
   private final JTextField txtCor;
   private final JTextField txtProprietario;

   private final JButton btnSalvar;
   private final JButton btnExcluir;
   private final JButton btnEmplacar;
   private final JButton btnTransferir;

   static protected String  placaAnterior = "@@@@@@@";
   static protected boolean placaNova     = false;

   public VEICULO()
   {
      super( "Veículo" );
      setLayout( new GridLayout( 9 , 2 , 10 , 10 ) );

      txtPlaca        = new JTextField(  7 );
      txtEmplacamento = new JTextField( 10 );
      txtMarca        = new JTextField( 25 );
      txtModelo       = new JTextField( 35 );
      txtAno          = new JTextField(  4 );
      txtCor          = new JTextField( 15 );
      txtProprietario = new JTextField( 14 );

      lblPlaca        = new JLabel( "   Placa:"                );
      lblEmplacamento = new JLabel( "   Data do Emplacamento:" );
      lblMarca        = new JLabel( "   Marca:"                );
      lblModelo       = new JLabel( "   Modelo:"               );
      lblAno          = new JLabel( "   Ano:"                  );
      lblCor          = new JLabel( "   Cor:"                  );
      lblProprietario = new JLabel( "   Proprietário:"         );

      txtPlaca.setToolTipText(        "Digite a Placa do Veículo"                );
      txtEmplacamento.setToolTipText( "Digite a Data do Emplacamento do Veículo" );
      txtMarca.setToolTipText(        "Digite a Marca do Veículo"                );
      txtModelo.setToolTipText(       "Digite o Modelo do Veículo"               );
      txtAno.setToolTipText(          "Digite o Ano de Fabricação"               );
      txtCor.setToolTipText(          "Digite a Cor do Veículo"                  );
      txtProprietario.setToolTipText( "Digite o CPF do Proprietário do Veículo"  );

      lblPlaca.setFont(        new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtPlaca.setFont(        new Font( "Arial" , Font.BOLD               , 16 ) );
      lblEmplacamento.setFont( new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtEmplacamento.setFont( new Font( "Arial" , Font.BOLD               , 16 ) );
      lblMarca.setFont(        new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtMarca.setFont(        new Font( "Arial" , Font.BOLD               , 16 ) );
      lblModelo.setFont(       new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtModelo.setFont(       new Font( "Arial" , Font.BOLD               , 16 ) );
      lblAno.setFont(          new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtAno.setFont(          new Font( "Arial" , Font.BOLD               , 16 ) );
      lblCor.setFont(          new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtCor.setFont(          new Font( "Arial" , Font.BOLD               , 16 ) );
      lblProprietario.setFont( new Font( "Arial" , Font.BOLD + Font.ITALIC , 16 ) );
      txtProprietario.setFont( new Font( "Arial" , Font.BOLD               , 16 ) );

      btnSalvar     = new JButton( "Salva"     );
      btnExcluir    = new JButton( "Exclui"    );
      btnEmplacar   = new JButton( "Emplaca"   );
      btnTransferir = new JButton( "Transfere" );

      add( lblPlaca        );       add( txtPlaca        );
      add( lblEmplacamento );       add( txtEmplacamento );
      add( lblMarca        );       add( txtMarca        );
      add( lblModelo       );       add( txtModelo       );
      add( lblAno          );       add( txtAno          );
      add( lblCor          );       add( txtCor          );
      add( lblProprietario );       add( txtProprietario );

      add( btnSalvar       );       add( btnExcluir      );
      add( btnEmplacar     );       add( btnTransferir   );

      HdlrPlaca          hdlrPlaca          = new HdlrPlaca();
      HdlrEmplacamento   hdlrEmplacamento   = new HdlrEmplacamento();
      HdlrMarca          hdlrMarca          = new HdlrMarca();
      HdlrModelo         hdlrModelo         = new HdlrModelo();
      HdlrAno            hdlrAno            = new HdlrAno();
      HdlrCor            hdlrCor            = new HdlrCor();
      HdlrProprietario   hdlrProprietario   = new HdlrProprietario();

      HdlrPlacaFc        hdlrPlacaFc        = new HdlrPlacaFc();
      HdlrEmplacamentoFc hdlrEmplacamentoFc = new HdlrEmplacamentoFc();
      HdlrMarcaFc        hdlrMarcaFc        = new HdlrMarcaFc();
      HdlrModeloFc       hdlrModeloFc       = new HdlrModeloFc();
      HdlrAnoFc          hdlrAnoFc          = new HdlrAnoFc();
      HdlrCorFc          hdlrCorFc          = new HdlrCorFc();
      HdlrProprietarioFc hdlrProprietarioFc = new HdlrProprietarioFc();

      HdlrSalvar         hdlrSalvar         = new HdlrSalvar();
      HdlrExcluir        hdlrExcluir        = new HdlrExcluir();
      HdlrEmplacar       hdlrEmplacar       = new HdlrEmplacar();
      HdlrTransferir     hdlrTransferir     = new HdlrTransferir();

      txtPlaca.addActionListener(        hdlrPlaca          );
      txtEmplacamento.addActionListener( hdlrEmplacamento   );
      txtMarca.addActionListener(        hdlrMarca          );
      txtModelo.addActionListener(       hdlrModelo         );
      txtAno.addActionListener(          hdlrAno            );
      txtCor.addActionListener(          hdlrCor            );
      txtProprietario.addActionListener( hdlrProprietario   );

      txtPlaca.addFocusListener(         hdlrPlacaFc        );
      txtEmplacamento.addFocusListener(  hdlrEmplacamentoFc );
      txtMarca.addFocusListener(         hdlrMarcaFc        );
      txtModelo.addFocusListener(        hdlrModeloFc       );
      txtAno.addFocusListener(           hdlrAnoFc          );
      txtCor.addFocusListener(           hdlrCorFc          );
      txtProprietario.addFocusListener(  hdlrProprietarioFc );

      btnSalvar.addActionListener(       hdlrSalvar         );
      btnExcluir.addActionListener(      hdlrExcluir        );
      btnEmplacar.addActionListener(     hdlrEmplacar       );
      btnTransferir.addActionListener(   hdlrTransferir     );

      btnSalvar.setVisible(     false );
      btnExcluir.setVisible(    false );
      btnEmplacar.setVisible(   false );
      btnTransferir.setVisible( false );
   }
   private class HdlrPlaca implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         if ( validaPlaca( PLACA.limpaPlaca( txtPlaca.getText() ) ) )
            txtEmplacamento.requestFocus();
      }
   }
   private class HdlrPlacaFc implements FocusListener
   {
      @Override
      public void focusGained( FocusEvent event )
      {
         txtPlaca.setText( PLACA.limpaPlaca( txtPlaca.getText() ) );
      }
      @Override
      public void focusLost( FocusEvent event )
      {
//         if ( validaPlaca( PLACA.limpaPlaca( txtPlaca.getText() ) ) )
//            txtEmplacamento.requestFocus();
      }
   }
   private boolean validaPlaca( String placa )
   {
      if ( placa.length() == 0 ) {
         JOptionPane.showMessageDialog( VEICULO.this , "Informe a Placa!" ,
                 "Formato AAA9X99" , JOptionPane.WARNING_MESSAGE );
         txtPlaca.requestFocus();
         return false;
      }
      if ( !PLACA.PLACAéValida( placa ) ) {
         txtProprietario.setEditable(  true );
         txtProprietario.setFocusable( true );
         btnSalvar.setVisible(     false );
         btnExcluir.setVisible(    false );
         btnTransferir.setVisible( false );
         btnEmplacar.setVisible(   false );
         placaAnterior = "@@@@@@@";
         placaNova     = false;
         JOptionPane.showMessageDialog( VEICULO.this , "Placa inválida!" ,
                 "Formato AAA9X99" , JOptionPane.ERROR_MESSAGE );
         txtPlaca.requestFocus();
         return false;
      }
      placa = placa.toUpperCase();
      PLACA Placa = new PLACA( placa );
      txtPlaca.setText( Placa.toString() );
//-------------------------------------------------------------
//    Acessar Banco de Dados: SELECT PLACA = Placa
//      String VeiculoExiste = JOptionPane.showInputDialog("Veículo já existe?");
      String VeiculoExiste = "sim";

      if ( VeiculoExiste.equals( "sim" ) ) {

         if ( Placa.getEhMercosul() ) {
            DATA DTemplacamento = new DATA( "16/06/2025" );
            txtEmplacamento.setText( DTemplacamento.toString() );
            btnEmplacar.setVisible( false );
         }
         else {
            txtEmplacamento.setText( "" );
            btnEmplacar.setVisible( true );
         }

         txtMarca.setText(  "MARCA DO VEÍCULO"  );
         txtModelo.setText( "MODELO DO VEÍCULO" );
         txtAno.setText(    "2020"              );
         txtCor.setText(    "COR DO VEÍCULO"    );
         CPF Proprietario = new CPF( "191" );
         txtProprietario.setText( Proprietario.toString() );
//-------------------------------------------------------------
         txtEmplacamento.setEditable(  false );
         txtEmplacamento.setFocusable( false );
         txtProprietario.setEditable(  false );
         txtProprietario.setFocusable( false );
         btnExcluir.setVisible(        true  );
         btnTransferir.setVisible(     true  );
         placaNova = false;
         txtMarca.requestFocus();
      }
      else {
         if ( Placa.getEhMercosul() ) {
            txtEmplacamento.setEditable(  true );
            txtEmplacamento.setFocusable( true );
            txtEmplacamento.requestFocus();
         }
         else {
            txtEmplacamento.setText( "" );
            txtEmplacamento.setEditable(  false );
            txtEmplacamento.setFocusable( false );
            txtMarca.requestFocus();
         }

         txtProprietario.setEditable(  true  );
         txtProprietario.setFocusable( true  );
         btnExcluir.setVisible(        false );
         btnTransferir.setVisible(     false );
         btnEmplacar.setVisible(       false );
         placaNova = true;
      }

      placaAnterior = placa;
      btnSalvar.setVisible( true );
      return true;
   }
   private class HdlrEmplacamento implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         if ( validaEmplacamento( txtEmplacamento.getText() ) ) txtMarca.requestFocus();
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
//         if ( validaEmplacamento( txtEmplacamento.getText() ) ) txtMarca.requestFocus();
      }
   }
   private boolean validaEmplacamento( String emplacamento )
   {
      if ( emplacamento.length() == 0 ) {
         JOptionPane.showMessageDialog( VEICULO.this , "Informe a Data do Emplacamento!" ,
                 "Formato DDMMAAAA" , JOptionPane.WARNING_MESSAGE );
         txtEmplacamento.requestFocus();
         return false;
      }
      if ( !DATA.DATAéValida( emplacamento ) ) {
         JOptionPane.showMessageDialog( VEICULO.this , "Data inválida!" ,
                 "Formato DDMMAAAA" , JOptionPane.ERROR_MESSAGE );
         txtEmplacamento.requestFocus();
         return false;
      }
      DATA DTemplacamento = new DATA( emplacamento );
      txtEmplacamento.setText( DTemplacamento.toString() );
      return true;
   }
   private class HdlrMarca implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         if ( validaMarca( txtMarca.getText() ) ) txtModelo.requestFocus();
      }
   }
   private class HdlrMarcaFc implements FocusListener
   {
      @Override
      public void focusGained( FocusEvent event ) {
      }
      @Override
      public void focusLost( FocusEvent event )
      {
//         if ( validaMarca( txtMarca.getText() ) ) txtModelo.requestFocus();
      }
   }
   private boolean validaMarca( String marca )
   {
      if ( marca.length() == 0 ) {
         JOptionPane.showMessageDialog( VEICULO.this , "Informe a Marca!" ,
                 "Até 25 caracteres" , JOptionPane.WARNING_MESSAGE );
         txtMarca.requestFocus();
         return false;
      }
      if ( marca.length() > 25 ) {
         JOptionPane.showMessageDialog( VEICULO.this , "Marca inválida!" ,
                 "Até 25 caracteres" , JOptionPane.ERROR_MESSAGE );
         txtMarca.requestFocus();
         return false;
      }
      marca = marca.toUpperCase();
      txtMarca.setText( marca.toString() );
      return true;
   }
   private class HdlrModelo implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         if ( validaModelo( txtModelo.getText() ) ) txtAno.requestFocus();
      }
   }
   private class HdlrModeloFc implements FocusListener
   {
      @Override
      public void focusGained( FocusEvent event ) {
      }
      @Override
      public void focusLost( FocusEvent event )
      {
//         if ( validaModelo( txtModelo.getText() ) ) txtAno.requestFocus();
      }
   }
   private boolean validaModelo( String modelo )
   {
      if ( modelo.length() > 35 ) {
         JOptionPane.showMessageDialog( VEICULO.this , "Modelo inválido!" ,
                 "Até 35 caracteres" , JOptionPane.ERROR_MESSAGE );
         txtModelo.requestFocus();
         return false;
      }
      modelo = modelo.toUpperCase();
      txtModelo.setText( modelo.toString() );
      return true;
   }
   private class HdlrAno implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         if ( validaAno( txtAno.getText() ) ) txtCor.requestFocus();
      }
   }
   private class HdlrAnoFc implements FocusListener
   {
      @Override
      public void focusGained( FocusEvent event ) {
      }
      @Override
      public void focusLost( FocusEvent event )
      {
//         if ( validaAno( txtAno.getText() ) ) txtCor.requestFocus();
      }
   }
   private boolean validaAno( String ano )
   {
      if ( ano.length() > 4 ) {
         JOptionPane.showMessageDialog( VEICULO.this , "Ano inválido!" ,
                 "Até 4 dígitos" , JOptionPane.ERROR_MESSAGE );
         txtAno.requestFocus();
         return false;
      }
      byte[] Ano = ano.getBytes();
      for ( byte i = 0; i < Ano.length; i++ )
         if ( Ano[i] < 48 || Ano[i] > 57 ) {
            JOptionPane.showMessageDialog( VEICULO.this , "Ano inválido!" ,
                    "Até 4 dígitos" , JOptionPane.ERROR_MESSAGE );
            txtAno.requestFocus();
            return false;
         }
      txtAno.setText( ano.toString() );
      return true;
   }
   private class HdlrCor implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         if ( validaCor( txtCor.getText() ) )
            if ( placaNova ) txtProprietario.requestFocus();
            else txtPlaca.requestFocus();
      }
   }
   private class HdlrCorFc implements FocusListener
   {
      @Override
      public void focusGained( FocusEvent event ) {
      }
      @Override
      public void focusLost( FocusEvent event )
      {
//         if ( validaCor( txtCor.getText() ) )
//            if ( placaNova ) txtProprietario.requestFocus();
//            else txtPlaca.requestFocus();
      }
   }
   private boolean validaCor( String cor )
   {
      if ( cor.length() > 15 ) {
         JOptionPane.showMessageDialog( VEICULO.this , "Cor inválida!" ,
                 "Até 15 caracteres" , JOptionPane.ERROR_MESSAGE );
         txtCor.requestFocus();
         return false;
      }
      cor = cor.toUpperCase();
      txtCor.setText( cor.toString() );
      return true;
   }
   private class HdlrProprietario implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         if ( validaProprietario( txtProprietario.getText() ) ) txtPlaca.requestFocus();
      }
   }
   private class HdlrProprietarioFc implements FocusListener
   {
      @Override
      public void focusGained( FocusEvent event )
      {
         txtProprietario.setText( CPF.limpaCPF( txtProprietario.getText() ) );
      }
      @Override
      public void focusLost( FocusEvent event )
      {
//         if ( validaProprietario( txtProprietario.getText() ) ) txtPlaca.requestFocus();
      }
   }
   private boolean validaProprietario( String proprietario )
   {
      if ( proprietario.length() == 0 ) {
         JOptionPane.showMessageDialog( VEICULO.this , "Informe o CPF do Proprietário!" ,
                 "Até 11 dígitos" , JOptionPane.WARNING_MESSAGE );
         txtProprietario.requestFocus();
         return false;
      }
      if ( !CPF.CPFéValido( proprietario ) ) {
         JOptionPane.showMessageDialog( VEICULO.this , "CPF inválido!" ,
                 "Até 11 dígitos" , JOptionPane.ERROR_MESSAGE );
         txtProprietario.requestFocus();
         return false;
      }
      CPF Proprietario = new CPF( proprietario );
      txtProprietario.setText( Proprietario.toString() );
      return true;
   }
   private class HdlrSalvar implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         String placa = PLACA.limpaPlaca( txtPlaca.getText() );
         if ( !validaPlaca( placa ) || !placa.equals( placaAnterior ) ) return;

         PLACA Placa = new PLACA( placa );
         if ( Placa.getEhMercosul() ) {
            String emplacamento = txtEmplacamento.getText();
            if ( !validaEmplacamento( emplacamento ) ) return;
         }

         String marca = txtMarca.getText();
         if ( !validaMarca( marca ) ) return;

         String modelo = txtModelo.getText();
         if ( !validaModelo( modelo ) ) return;

         String ano = txtAno.getText();
         if ( !validaAno( ano ) ) return;

         String cor = txtCor.getText();
         if ( !validaCor( cor ) ) return;

         String proprietario = CPF.limpaCPF( txtProprietario.getText() );
         if ( !validaProprietario( proprietario ) ) return;

//-------------------------------------------------------------
//       Atualizar o Banco de Dados:
//         if ( placaNova ) INSERT
//            placaAnterior = placa;
//            placaNova     = false;
//         else UPDATE
         JOptionPane.showMessageDialog( VEICULO.this , "Salvando Veículo..." ,
                 "Rotina de Salvamento" , JOptionPane.INFORMATION_MESSAGE );
//-------------------------------------------------------------
      }
   }
   private class HdlrExcluir implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         String placa = PLACA.limpaPlaca( txtPlaca.getText() );
         if ( placaNova || !placa.equals( placaAnterior ) || !validaPlaca( placa ) )
            return;

//-------------------------------------------------------------
//       Atualizar o Banco de Dados: DELETE
         JOptionPane.showMessageDialog( VEICULO.this , "Excluindo Veículo..." ,
                 "Rotina de Exclusão" , JOptionPane.INFORMATION_MESSAGE );
//-------------------------------------------------------------
      }
   }
   private class HdlrEmplacar implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         String placa = PLACA.limpaPlaca( txtPlaca.getText() );
         if ( placaNova || !placa.equals( placaAnterior ) || !validaPlaca( placa ) )
            return;

         EMPLACAMENTO Emplacamento = new EMPLACAMENTO( VEICULO.this , placa );
         Emplacamento.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
         Emplacamento.setSize( 425 , 145 );
         Emplacamento.setVisible( true );
         txtPlaca.requestFocus();

         if ( Emplacamento.getBotãoSalvar() ) {
            PLACA plc = new PLACA( Emplacamento.getPlcRetorno() );
            txtPlaca.setText( plc.toString() );
            DATA emplacamento = new DATA( Emplacamento.getDTretorno() );
            txtEmplacamento.setText( emplacamento.toString() );
            btnEmplacar.setVisible( !plc.getEhMercosul() );
            placaAnterior = plc.toString();
         }
      }
   }
   private class HdlrTransferir implements ActionListener
   {
      @Override
      public void actionPerformed( ActionEvent event )
      {
         String placa    = PLACA.limpaPlaca( txtPlaca.getText() );
         String vendedor = CPF.limpaCPF( txtProprietario.getText() );
         if ( placaNova || !placa.equals( placaAnterior ) ||
                 !validaPlaca( placa ) || !validaProprietario( vendedor ) )
            return;

         TRANSFERENCIA Transferencia = new TRANSFERENCIA( VEICULO.this , placa , vendedor );
         Transferencia.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
         Transferencia.setSize( 425 , 222 );
         Transferencia.setVisible( true );
         txtPlaca.requestFocus();

         if ( Transferencia.getBotãoSalvar() )
            txtProprietario.setText( Transferencia.getCPFretorno() );
      }
   }
}
