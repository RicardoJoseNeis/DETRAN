public class PLACA
{
   static private String  mercosul;
   static private String  antiga;
   static private boolean ehMercosul;

   public PLACA( String Placa )
   {
      byte[] placa = Placa.getBytes();
      this.ehMercosul = placa[4] > 60;

      if ( this.ehMercosul ) {
         this.mercosul = Placa;
         placa[4] -= 17;
      }
      else {
         this.antiga = Placa;
         placa[4] += 17;
      }
      String P = new String(placa);
      if ( this.ehMercosul ) this.antiga = P;
      else this.mercosul = P;
   }
   @Override
   public String toString()
   {
      if ( this.ehMercosul ) return this.mercosul;
      return this.antiga.substring(0,3) + "-" + this.antiga.substring(3);
   }
   public static boolean PLACAéValida( String Placa )
   {
      if ( Placa.length() != 7 ) return false;

      Placa = Placa.toUpperCase();
      byte[] placa = Placa.getBytes();

      for ( byte i = 0; i < 3; i++ )
         if ( placa[i] < 65 || placa[i] > 90 ) return false;

      if ( placa[3] < 48 || placa[3] > 57 ) return false;

      if ( placa[4] > 57 && placa[4] < 65 || placa[4] < 48 || placa[4] > 90 ) return false;

      for ( byte i = 5; i < placa.length; i++ )
         if ( placa[i] < 48 || placa[i] > 57 ) return false;

      return true;
   }
   public static String limpaPlaca( String placa )
   {
      char[] Placa = placa.toCharArray();
      char[] P = placa.toCharArray();

      byte j = 0;
      for ( byte i = 0; i < Placa.length; i++ )
         if ( Placa[i] != '-' )
            P[j++] = Placa[i];

      String p = String.copyValueOf( P , 0 , j );
      return p;
   }
   public String getMercosul()
   {
      return this.mercosul;
   }
   public boolean getEhMercosul()
   {
      return this.ehMercosul;
   }
}
