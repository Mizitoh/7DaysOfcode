package quintoEsextodia;

import setimodia.CarregaUrl;

public enum OpcaoAPI {

	FILMES_250_URL1 {
		@Override
		public String parseString() {
			try {
				return url = new CarregaUrl(0).parseString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	},
	FILMES_250_URL2 {
		@Override
		public String parseString() {
			try {
				return url = new CarregaUrl(1).parseString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	};

	public abstract String parseString();

	public String url = null;
}
