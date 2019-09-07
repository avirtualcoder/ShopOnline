package cn.fosu.javabean;//”≥…‰¿‡∞¸

public class SP_car_info {
		private String sp_img;
		private String sp_info;
		private String old_price;
		private String new_price;
		private String number;
		private String username;
		public String getSp_img() {
			return sp_img;
		}
		public void setSp_img(String sp_img) {
			this.sp_img = sp_img;
		}
		public String getSp_info() {
			return sp_info;
		}
		public void setSp_info(String sp_info) {
			this.sp_info = sp_info;
		}
		public String getOld_price() {
			return old_price;
		}
		public void setOld_price(String old_price) {
			this.old_price = old_price;
		}
		public String getNew_price() {
			return new_price;
		}
		public void setNew_price(String new_price) {
			this.new_price = new_price;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		@Override
		public String toString() {
			return "SP_car_info [sp_img=" + sp_img + ", sp_info=" + sp_info
					+ ", old_price=" + old_price + ", new_price=" + new_price
					+ ", number=" + number + ", username=" + username + "]";
		}
} 
