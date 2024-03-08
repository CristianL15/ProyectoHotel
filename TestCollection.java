package com.example;
import java.awt.Color;
import java.util.*;

public class TestCollection{    
      final String colores[]={"Rojo","Verde","Azul","Violeta"};
      
      public TestCollection(){
          final List<String> lista = new ArrayList<String>();

          lista.add(Color.MAGENTA.toString());

          for(int i = 0; i < colores.length; i++){
              lista.add(colores[i]);
          }

          lista.add(Color.CYAN.toString());
          System.out.println("\n\nArraylist:");
          for(int i=0; i < lista.size();i++){
              System.out.println(lista.get(i)+"");
          }

          System.out.println("\n\nArraylist despues de eliminar:");
          eliminarObjetosString(lista);

      }
  
      private void eliminarObjetosString(Collection<String> collection){
            Iterator<String> iterador = collection.iterator();
            while(iterador.hasNext()){
                  if(iterador.next()instanceof String)
                        iterador.remove();
            }
            System.out.println(collection);
      }
}