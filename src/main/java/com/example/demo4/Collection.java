package com.example.demo4;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;

public class Collection implements Aggregate //Интерфейс - заявление, что где-то реализуются методы
{
    private String filetop;
    private Image bi;

    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }
    public Collection(String filetop)
    {
        this.filetop=filetop;
    }
    private class ImageIterator implements Iterator
    {

        private int current=0;
      //  private int currentbegin=5;

      //  private Image bend=new Image("file:"+filetop+(current+1)+".png");
       // private Image bbegin=new Image("file:"+filetop+(currentbegin-1)+".png");



        @Override
        public boolean hasNext()
        {
            String filename="file:"+filetop+current+".png";
            //System.out.println("filetop+current= "+filetop+current);
          //  System.out.println(filename);
            File file=new File(filetop+current+".png");
            if (file.exists())
            {
                bi=new Image(filename);
                return true;
            }
            else
            {
               // System.out.println("else");
                return false;
            }
            //String filename="file:"+filetop+(current+1)+".png";


        }


        @Override
        public Object next() {
            current++;
           if ((current>=5) ||(this.hasNext()==false))
           {
              System.out.println("Сброс!");
               current=1;
             //  bi=bend;
               hasNext();
           }
            return bi;
        }

        @Override
        public Object preview() {
            current--;
            if ((current<=0) || (this.hasNext()==false))
            {
                System.out.println("Сброс!");
                current=4;
               // bi=bbegin;
                hasNext();
            }
            return bi;
        }
    }

}
