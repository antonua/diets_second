package net.dietsHelper.Diets.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.dietsHelper.Diets.models.Diet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Optional;

@Component
public class DietsServiceImpl implements DietsService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private static final ObjectMapper objectMapper =
            new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final String apiKEY = "&apiKey=a7bdb9a4ac6845f68b5027f6338215dc";




    @Override
    public Optional<Diet> findRandomRecipe(String typeName) {

        String str = webClientBuilder.build()
                .get()
                .uri("https://api.spoonacular.com/recipes/random?number=1&tags="+typeName + apiKEY)
                .retrieve()
                .bodyToMono(String.class)
                .block();


        try {

            Diet diet = objectMapper.readValue(str.substring(12), Diet.class);
            return Optional.ofNullable(diet);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public StringBuffer findByName(String dietName) {
        try {
            URL url = new URL("https://api.spoonacular.com/recipes/complexSearch?query="+dietName+"&number=2" + apiKEY);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            System.out.println(content);
            return content;

        }catch (Exception e){
            System.out.println("PROBLEM!!!");
            return null;
        }
    }


}
