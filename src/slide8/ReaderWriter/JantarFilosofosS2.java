package slide8.ReaderWriter;

public class JantarFilosofosS2
{
   public static void main (String[] args)
   {
      Mesa mesa = new Mesa ();
      for (int filosofo = 0; filosofo < 5; filosofo++)
      {
         new FilosofosS2(("Filosofo_" + filosofo), mesa, filosofo).start();
      }
   }
}
