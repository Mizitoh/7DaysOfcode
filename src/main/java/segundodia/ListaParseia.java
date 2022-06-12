package segundodia;

import java.util.ArrayList;
import java.util.List;

import org.json.*;

import desafioalura.setediasdecodigo.models.Filme;

public class ListaParseia {

	public List<Filme> getTodosOsDados(String jsonString) {
		
        List<Filme> filmes = new ArrayList<Filme>();
        
        try {
        	
            JSONObject obj = new JSONObject(jsonString);
            JSONArray jArray = obj.getJSONArray("items");


            for(int i=0; i<jArray.length(); i++){
            	Filme filme;
                JSONObject json_data = jArray.getJSONObject(i);
                String id = json_data.getString("id");
                String rank = json_data.getString("rank");
                String title = json_data.getString("title");
                String fullTitle = json_data.getString("fullTitle");
                String year = json_data.getString("year");
                String image = json_data.getString("image");
                String crew = json_data.getString("crew");
                String imDbRating = json_data.getString("imDbRating");
                String imDbRatingCount = json_data.getString("imDbRatingCount");
                filme = new Filme(id, rank, title, fullTitle, year, image, crew, imDbRating, imDbRatingCount);
                /*
                 * Feito antes com set
                 * 
                filme.setId(json_data.getString("id"));
                filme.setRank(json_data.getString("rank"));
                filme.setTitle(json_data.getString("title"));
                filme.setFullTitle(json_data.getString("fullTitle"));
                filme.setYear(json_data.getString("year"));
                filme.setImage(json_data.getString("image"));
                filme.setCrew(json_data.getString("crew"));
                filme.setImDbRating(json_data.getString("imDbRating"));
                filme.setImDbRatingCount(json_data.getString("imDbRatingCount"));
                */
                
                filmes.add(filme);
            }

        } catch (JSONException e) {
            System.out.println("Erro no parsing do JSON" + e);
        }
        return filmes;
    }
	
	public String parseString() throws Exception {
	CaptaJsonAPI json = new CaptaJsonAPI();
	String string = json.captaJson();
	return string;
	}
}
