package Network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.swing.SwingWorker;

import data.Article;
import manager.DataManager;
import parser.Parser;
import util.Constants;

public class AdidasNetwork {

	public void startRequest(List<Article> a_list, int l_id){
		for (Article a : a_list) {
			NetworkRequest nr;
			if (l_id == 0) {
				nr = new NetworkRequest(a.getArt_webLink_de(), a, Constants.language[l_id]);
				nr.execute();
			}
			if (l_id == 1) {
				nr = new NetworkRequest(a.getArt_webLink_uk(), a, Constants.language[l_id]);
				nr.execute();
			}
			if (l_id == 2) {
				nr = new NetworkRequest(a.getArt_webLink_es(), a, Constants.language[l_id]);
				nr.execute();
			}
			if (l_id == 3) {
				nr = new NetworkRequest(a.getArt_webLink_fr(), a, Constants.language[l_id]);
				nr.execute();
			}
		}
	}
	
	private static class NetworkRequest extends SwingWorker<Void, String> {

		private String targetURL;
		HttpURLConnection connection = null;
		Article a;
		String language;

		public NetworkRequest(String targetURL, Article a,String language) {
			super();
			this.targetURL = targetURL;
			this.language = language;
			this.a = a;
		}

		@Override
		protected Void doInBackground() throws Exception {
			// TODO Auto-generated method stub
			try {

				URL url = new URL(targetURL);
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

				connection.setRequestProperty("Content-Language", "en-US");

				connection.setUseCaches(false);
				connection.setDoOutput(true);

				// Send request
				DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.close();

				// Get Response
				// InputStream is = connection.getInputStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
				StringBuilder response = new StringBuilder();

				String line;
				while ((line = rd.readLine()) != null) {
					response.append(line);
					response.append('\r');
				}
				rd.close();

				Parser.parseString_Adidas(response.toString(), a, language);
			} catch (FileNotFoundException e) {
				DataManager.updateTableContent(a, false);
			} finally {
				if (connection != null) {
					connection.disconnect();
				}
			}
			return null;
		}
	}
}
