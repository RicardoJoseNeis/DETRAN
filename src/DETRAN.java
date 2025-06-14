import javax.swing.JFrame;

public class DETRAN
{
   public static void main(String[] args)
   {
      VEICULO Veiculo = new VEICULO();
      Veiculo.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      Veiculo.setSize( 600 , 375 );
      Veiculo.setVisible( true );
   }
}
