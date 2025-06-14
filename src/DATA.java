public class DATA
{
   static private short ano;
   static private byte  mes;
   static private byte  dia;

   public DATA( String Data )
   {
      byte[] data = Data.getBytes();
      int[][] tabAux = { { 0 , 0 , 0 } , { 2 , 4 , data.length } };
      int indAux = 0;

      for ( byte i = 0; i < data.length; i++ ) {
         data[i] -= 48;
         if ( data[i] < 0 ) {
            tabAux[1][indAux++] = i;
            if ( indAux == tabAux[1].length ) break;
         }
      }
      indAux = 0;
      for ( byte i = 0; i < data.length; i++ ) {
         if ( i == tabAux[1][indAux] ) {
            indAux++;
            if ( data[i] < 0 ) continue;
         }
         tabAux[0][indAux] = tabAux[0][indAux] * 10 + data[i];
      }

      this.ano = (short) tabAux[0][2];
      this.mes = (byte)  tabAux[0][1];
      this.dia = (byte)  tabAux[0][0];
   }
   @Override
   public String toString()
   {
      String A = String.format( "%d" , this.ano );
      String M = String.format( "%d" , this.mes );
      String D = String.format( "%d" , this.dia );

      return D + "/" + M + "/" + A;
   }
   public static boolean DATAéValida( String Data )
   {
      int[] diasMes = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
      int dia = 0;
      int mes = 0;
      int ano = 0;

      if ( Data.length() < 4 || Data.length() > 10 ) return false;

      byte[] data = Data.getBytes();
      int[][] tabAux = { { 0 , 0 , 0 } , { 2 , 4 , data.length } };
      int indAux = 0;

      for ( byte i = 0; i < data.length; i++ ) {
         if ( data[i] < 47 || data[i] > 57 ) return false;

         if ( data[i] == 47 ) {
            tabAux[1][indAux++] = i;
            if ( indAux == tabAux[1].length ) break;
         }
      }
      if ( indAux == 1 ) return false;

      indAux = 0;
      for ( byte i = 0; i < data.length; i++ ) {
         data[i] -= 48;

         if ( i == tabAux[1][indAux] ) {
            indAux++;
            if ( data[i] < 0 ) continue;
         }
         tabAux[0][indAux] = tabAux[0][indAux] * 10 + data[i];
      }

      dia = tabAux[0][0];
      mes = tabAux[0][1];
      ano = tabAux[0][2];

      if ( mes < 1 || mes > 12 || dia < 1 ) return false;

      if ( dia <= diasMes[mes] ) return true;

      if ( mes != 2 || dia > 29 ) return false;

      if ( ano % 400 == 0 ) return true;

      if ( ano % 100 == 0 ) return false;

      if ( ano % 4 == 0 ) return true;

      return false;
   }
}
