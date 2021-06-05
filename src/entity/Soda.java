package entity;

public class Soda {

		private int sodaId;
	    private String sodaName;
	    private String sodaQuantity;
	    private Double sodaPrice;
	
	    public Soda(int sodaId, String sodaName, String sodaQuantity, Double sodaPrice) {
	        this.setSodaId(sodaId);
	        this.setSodaName(sodaName);
	        this.setSodaQuantity(sodaQuantity);
	        this.setSodaPrice(sodaPrice);
	    }

		public int getSodaId() {
			return sodaId;
		}

		public void setSodaId(int sodaId) {
			this.sodaId = sodaId;
		}

		public String getSodaName() {
			return sodaName;
		}

		public void setSodaName(String sodaName) {
			this.sodaName = sodaName;
		}

		public String getSodaQuantity() {
			return sodaQuantity;
		}

		public void setSodaQuantity(String sodaQuantity) {
			this.sodaQuantity = sodaQuantity;
		}

		public Double getSodaPrice() {
			return sodaPrice;
		}

		public void setSodaPrice(Double sodaPrice) {
			this.sodaPrice = sodaPrice;
		}
}
