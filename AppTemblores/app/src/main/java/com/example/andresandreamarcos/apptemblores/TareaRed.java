package com.example.andresandreamarcos.apptemblores;

import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by widemos on 28/3/15.
 */
public class TareaRed extends AsyncTask<String, Void, List<Terremoto>> {

    // Leer el feed RSS de elpais.com y devolver una lista de objetos Noticia, usando el parser

    @Override
    protected List<Terremoto> doInBackground(String... params) {

        List<Terremoto> lista = null;

        try {
            URL url = new URL(params[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setInstanceFollowRedirects(true);

            InputStream is = conn.getInputStream();

            if (is != null) {
                JsonTerremotoParse p = new JsonTerremotoParse();
                lista = p.readJsonStream(is);
                is.close();
                conn.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
