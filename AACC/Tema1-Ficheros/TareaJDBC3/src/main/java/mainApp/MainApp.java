package mainApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import Utils.Film;
import conexion.Conexion;

public class MainApp {

	private static final String SELECT_PELICULAS = "SELECT * FROM film";
			
	public static void main(String[] args) {
		try (Connection connect = Conexion.conectar()) {
			PreparedStatement st1 = connect.prepareStatement(SELECT_PELICULAS);
			
			List<Film> listaPeliculas = new ArrayList<>();
			
		
			ResultSet rs = st1.executeQuery();
			
			while(rs.next()) {
			int film_id = rs.getInt(1);
			String title = rs.getString(2);
			String description = rs.getString(3);
			int release_year = rs.getInt(4);
			int language_id = rs.getInt(5);
			int original_language_id = rs.getInt(6);
			int rental_duration = rs.getInt(7);
			double rental_rate = rs.getDouble(8);
			int length = rs.getInt(9);
			double replacement_cost = rs.getDouble(10);
			String rating = rs.getString(11);
			String special_features = rs.getString(12);
			Timestamp last_update = rs.getTimestamp(13);
			
			Film pelicula = new Film(film_id,title, description,release_year, language_id, original_language_id, rental_duration, rental_rate,
					length, replacement_cost, rating, special_features, last_update);
			
			listaPeliculas.add(pelicula);
			}
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}