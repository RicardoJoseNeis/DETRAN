public class CPF
{
   private static int cpf;
   private static byte ctr;

   public CPF( String Cpf )
   {
      byte[] cpfBytes = Cpf.getBytes();
      int limCpf = cpfBytes.length - 2;

      long cpf = 0;
      for ( int i = 0; i < limCpf; i++ ) {
         cpfBytes[i] -= 48;
         cpf = cpf * 10 + cpfBytes[i];
      }

      long ctr = 0;
      for ( int i = limCpf; i < cpfBytes.length; i++ ) {
         cpfBytes[i] -= 48;
         ctr = ctr * 10 + cpfBytes[i];
      }

      this.cpf = (int)  cpf;
      this.ctr = (byte) ctr;
   }
   @Override
   public String toString()
   {
      int cpf = this.cpf + 1000000000;
      String C = String.format( "%,d" , cpf ).substring( 2 , 13 );

      int ctr = this.ctr + 100;
      String D = String.format( "%d" , ctr ).substring( 1 , 3 );

      return C + "-" + D;
   }
   public static boolean CPFéValido( String Cpf )
   {
      if ( Cpf.length() < 3 || Cpf.length() > 11 ) return false;

      byte[] cpfBytes = Cpf.getBytes();
      int limCpf = cpfBytes.length - 2;

      long cpf = 0;
      for ( int i = 0; i < limCpf; i++ ) {
         if ( cpfBytes[i] < 48 || cpfBytes[i] > 57 ) return false;
         cpfBytes[i] -= 48;
         cpf = cpf * 10 + cpfBytes[i];
      }

      long ctr = 0;
      for ( int i = limCpf; i < cpfBytes.length; i++ ) {
         if ( cpfBytes[i] < 48 || cpfBytes[i] > 57 ) return false;
         cpfBytes[i] -= 48;
         ctr = ctr * 10 + cpfBytes[i];
      }

      if ( cpf == 0 ) return false;

      cpf = cpf + 1000000000;
      String C = String.format( "%d" , cpf );
      byte[] c = C.getBytes();
      for ( byte i = 0; i < c.length; i++ ) c[i] -= 48;

      int v1 = 0;
      int v2 = 0;
      for ( int i = c.length - 1; i > 0; i-- ) {
         v1 += c[i] * i;
         v2 += c[i] * (i - 1);
      }
      v1 = v1 % 11 % 10;
      v2 += v1 * 9;
      v2 = v2 % 11 % 10;

      long controle = v1 * 10 + v2;
      if ( ctr != controle ) return false;

      return true;
   }
   public static String limpaCPF( String cpf )
   {
      char[] Cpf = cpf.toCharArray();
      char[] P = cpf.toCharArray();

      byte j = 0;
      for ( byte i = 0; i < Cpf.length; i++ )
         if ( Cpf[i] != '.' && Cpf[i] != '-' )
            P[j++] = Cpf[i];

      String p = String.copyValueOf( P , 0 , j );
      return p;
   }
   public int getCPF()
   {
      return this.cpf;
   }
}
