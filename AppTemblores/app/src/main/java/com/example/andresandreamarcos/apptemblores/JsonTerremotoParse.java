package com.example.andresandreamarcos.apptemblores;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrea on 30/3/16.
 */
public class JsonTerremotoParse {

    //implementar método que coordine el retorno de los objetos de tipo Terremoto y crear una instancia del JsonReader.
    public List<Terremoto> readJsonStream(InputStream is) throws IOException{
        //Nueva instancia
        JsonReader reader = new JsonReader(new InputStreamReader(is,"UTF-8"));
        try{
            //leer Array
            return  leerArrayTerremotos(reader);

        }finally {
            reader.close();
        }
    }

//funcion q recorre el array enviado desde el servidor.Recibe como parametro el lector Json

   public  List leerArrayTerremotos(JsonReader reader)throws  IOException{
        //lista temporal
        ArrayList terremotos = new ArrayList();
        //Apuntamos al primer elemento del array y luego
        try{
            reader.beginObject(); //Entro en el primer nivel del JSON
            while  (reader.hasNext()){
                //leer objeto
                terremotos.add(leerTerremoto(reader));
            }
            //liberamos la memoria cerrando el array
            reader.endArray();
        }catch(Exception e){
            System.out.println(e);
        }

        return terremotos;
    }


    public Terremoto leerTerremoto(JsonReader reader) throws IOException{
        Double mag = null;
        String place = null;
        Double coordinates = null;
        //apuntamos al primer elemento
        try{
//            reader.beginObject();
            while(reader.hasNext()){
                String name = reader.nextName();
                switch (name) {
                    case "mag":
                        mag = reader.nextDouble();
                        break;
                    case "place":
                        place = reader.nextString();
                        break;
                    case "coordinates":
                        coordinates = reader.nextDouble();
                        break;
                    default:
                        reader.skipValue();
                        break;
                }
            }
//            reader.endObject();
        }catch(Exception e){
            System.out.println(e);
        }

        return  new Terremoto(mag,place,coordinates);

    }

}
