package com.example.andresandreamarcos.apptemblores;

import android.util.JsonReader;
import android.util.JsonToken;

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

<<<<<<< HEAD
    /*public List leerArrayTerremotos(JsonReader reader) throws IOException{
=======
   public  List leerArrayTerremotos(JsonReader reader)throws  IOException{
        //lista temporal
>>>>>>> origin/JsonTerremotoParse
        ArrayList terremotos = new ArrayList();
        double x, y, mag;
        String place;

        reader.beginObject(); //El objeto entero
        while(reader.hasNext()){
            if(reader.nextName() == "features"){
                reader.beginArray(); //Array de features
                while(reader.hasNext()){ //Cada uno de los elementos del array feature
                    reader.beginObject(); //Feature
                    while(reader.hasNext()){ //Leo dentro de la feature
                        if(reader.nextName() == "properties"){
                            reader.beginObject(); //Feature>Properties
                            while(reader.hasNext()){
                                switch(reader.nextName()){
                                    case "mag":
                                        //Recoger en la variable el contenido de mag
                                        mag = reader.nextDouble();
                                        break;
                                    case "place":
                                        //Recoger en la variable el contenido de place
                                        place = reader.nextString();
                                        break;
                                    default:
                                        reader.skipValue();
                                        break;
                                }
                            }
                            reader.endObject(); //Feature>Properties
                        }
                        else{
                            reader.skipValue();
                        }
                        if(reader.nextName() == "geometry"){
                            reader.beginObject(); //Feature>Geometry
                            while(reader.hasNext()){
                                if(reader.nextName() == "coordinates"){
                                    reader.beginArray(); //Array de coordinates
                                    x = reader.nextDouble();
                                    y = reader.nextDouble();
                                    reader.endArray(); //Array de coordinates
                                }
                                else{
                                    reader.skipValue();
                                }
                            }
                            reader.endObject(); //Feature>Geometry
                        }
                        else{
                            reader.skipValue();
                        }
                    }
                    reader.endObject(); //Feature
                }
                reader.endArray(); //Array de features
            }
            else{
                reader.skipValue();
            }
        }
        reader.endObject(); //El objeto entero
        return terremotos;
    }*/

    public List leerArrayTerremotos(JsonReader reader) throws IOException{
        ArrayList terremotos = new ArrayList();
        String place = "";
        double mag = 0;

        reader.beginObject(); //El objeto entero
        while(reader.hasNext()){
            if(reader.nextName().equals("features") && !(reader.peek() == JsonToken.NULL)){ //Entro en el array features
                reader.beginArray();
                while(reader.hasNext()){ //Cada una de las features
                    reader.beginObject();
                    //busco properties
                    while(reader.hasNext()){
                        if(reader.nextName().equals("properties") && !(reader.peek() == JsonToken.NULL)) {
                            reader.beginObject(); //Entro en las properties
                            while (reader.hasNext()) {
                                switch (reader.nextName()) {
                                    case "mag":
                                        mag = reader.nextDouble();
                                        break;
                                    case "place":
                                        place = reader.nextString();
                                        break;
                                    default:
                                        reader.skipValue();
                                }
                            }
                            reader.endObject();
                        }
                        /*if(reader.nextName().equals("geometry") && !(reader.peek() == JsonToken.NULL)){
                            System.out.println("AYYYYLMAOOOO");
                        }*/
                        else{
                            reader.skipValue();
                        }
                    }
                    reader.endObject();
                    terremotos.add(new Terremoto(mag, place, 0,0));
                }
                reader.endArray();

            }
            else reader.skipValue();
        }
        reader.endObject(); //El objeto entero
        return terremotos;
    }
}
